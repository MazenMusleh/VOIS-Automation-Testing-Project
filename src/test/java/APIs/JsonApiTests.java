package APIs;


import APIs.POJO_Models.Album_Response;
import APIs.POJO_Models.PostComment_Response;
import APIs.POJO_Models.Post_Payload_Response;
import APIs.POJO_Models.Todo_Response;
import APIs.Specifications.RequestSpec;
import Utilization.AssertionUtils;
import Utilization.ConfigManager;
import Utilization.FakerUtils;
import io.qameta.allure.Feature;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static io.restassured.RestAssured.given;

@Feature("Json Apis Tests")
public class JsonApiTests {

    private AssertionUtils assertionUtils;
    private int randomUserId;

    @BeforeClass
    public void setUp() {
        ConfigManager.init("configs","src/test/resources/configs.properties");
        assertionUtils = new AssertionUtils();
    }

    @Test(description = "Print comments for a random post")
    public void getRandomPostComments() {
        int randomPostId = new Random().nextInt(100) + 1;

        Response response = given()
                .spec(RequestSpec.requestSpec)
                .pathParam("postId", randomPostId)
                .when()
                .get(ConfigManager.getInstance().getProperty("configs","PostComment_Enpoint"))
                .then()
                .statusCode(200)
                .log().all()
                .extract().response();

        PostComment_Response[] ResponseArray = response.as(PostComment_Response[].class);
        List<PostComment_Response> ResponseList = Arrays.asList(ResponseArray);

        PostComment_Response randomPost = ResponseList.get(new Random().nextInt(ResponseList.size()));

        System.out.println("Random Comment for Post ID: " + randomPostId);
        System.out.println("--------------------------------------------");
        System.out.println("ID: " + randomPost.getId());
        System.out.println("Name: " + randomPost.getName());
        System.out.println("Email: " + randomPost.getEmail());
        System.out.println("Body:\n" + randomPost.getBody());
    }

    @Test(description = "Verify album titles for a random user do not exceed 300 chars")
    public void verifyAlbumTitleLength() {
       randomUserId = 5;

        Response response = given()
                .spec(RequestSpec.requestSpec)
                .queryParam("userId", randomUserId)
                .when()
                .get(ConfigManager.getInstance().getProperty("configs", "Albums_Endpoint"))
                .then()
                .statusCode(200)
                .log().all()
                .extract().response();

        Album_Response[] albumArray = response.as(Album_Response[].class);
        List<Album_Response> albumList = Arrays.asList(albumArray);

        Album_Response randomAlbum = albumList.get(new Random().nextInt(albumList.size()));

        assertionUtils.assertTrueHard(randomAlbum.getTitle().length() <= 300, "Album title exceeds 300 characters");

    }

    @Test(description = "Create a new post for a random user and verify mock response", dependsOnMethods = "verifyAlbumTitleLength" )
    public void createPostForUser() {
        Post_Payload_Response newPost = new Post_Payload_Response(randomUserId, FakerUtils.getRandomNumber(1,10) ,FakerUtils.getRandomUsername(),FakerUtils.getRandomSentence());

        Response response = given()
                .spec(RequestSpec.requestSpec)
                .body(newPost)
                .when()
                .post(ConfigManager.getInstance().getProperty("configs", "CreatePost_Endpoint"))
                .then()
                .statusCode(201)
                .log().all()
                .extract().response();


        Post_Payload_Response createdPost = response.as(Post_Payload_Response.class);

        assertionUtils.assertEqualsHard(String.valueOf(createdPost.getUserId()), String.valueOf(randomUserId), "User ID mismatch in response");
        assertionUtils.assertTrueHard(createdPost.getTitle() != null && !createdPost.getTitle().isEmpty(), "Title is empty");
        assertionUtils.assertTrueHard(createdPost.getBody() != null && !createdPost.getBody().isEmpty(), "Body is empty");

        System.out.println("Post created for User ID: " + randomUserId);
        System.out.println("--------------------------------------------");
        System.out.println("Post ID: " + createdPost.getId());
        System.out.println("Title: " + createdPost.getTitle());
        System.out.println("Body: " + createdPost.getBody());
    }

    @Test(description = "Print all incomplete todos for a specific user")
    public void printIncompleteTodos() {
        int specificUserId = new Random().nextInt(10) + 1;

        Response response = given()
                .spec(RequestSpec.requestSpec)
                .queryParam("userId", specificUserId)
                .when()
                .get(ConfigManager.getInstance().getProperty("configs", "Todos_Endpoint"))
                .then()
                .statusCode(200)
                .log().all()
                .extract().response();

        Todo_Response[] todosArray = response.as(Todo_Response[].class);
        List<Todo_Response> todosList = Arrays.asList(todosArray);

        List<Todo_Response> incompleteTodos = new ArrayList<>();
        for (Todo_Response todo : todosList) {
            if (!todo.isCompleted()) {
                incompleteTodos.add(todo);
            }
        }

        System.out.println("Incomplete Todos for User ID: " + specificUserId);
        System.out.println("--------------------------------------------");
        incompleteTodos.forEach(todo ->
                System.out.println("- " + todo.getTitle())
        );

        assertionUtils.assertTrueHard(!incompleteTodos.isEmpty(), "No incomplete todos found for user ID: " + specificUserId);
    }

}
