package APIs.POJO_Models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Album_Response {

    @JsonProperty("userId")
    private int userId;

    @JsonProperty("id")
    private int id;

    @JsonProperty("title")
    private String title;


    public Album_Response() {}

    public Album_Response(int userId, int id, String title) {
        this.userId = userId;
        this.id = id;
        this.title = title;
    }


    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
}
