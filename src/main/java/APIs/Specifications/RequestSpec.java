package APIs.Specifications;

import Utilization.ConfigManager;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class RequestSpec {

    public static final RequestSpecification requestSpec;

    static {
        try {
            ConfigManager.init("configs","src/test/resources/configs.properties");
        } catch (Exception e) {
            throw new RuntimeException("Failed to initialize ConfigManager", e);
        }

        requestSpec = new RequestSpecBuilder()
                .setBaseUri(ConfigManager.getInstance().getProperty("configs","JsonAPIsBaseURL"))
                .setContentType("application/json")
                .build();
    }
}
