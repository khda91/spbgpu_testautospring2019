package com.epam.spbgpu.test.auto.lesson5;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

public class MantisApiTest {

    @Test
    public void getUserInfoTest() {
        given()
                .baseUri("http://localhost:80/mantisbt/api/rest")
                .header(new Header("Authorization", "2Ld2NvUCTZSRszWnw0O7U_Q-AC7f8JOT"))
        .when()
                .get("/users/me")
        .then()
                .statusCode(200)
                .and()
                .body("name", equalTo("api_user"))
                .body("real_name", is("api user"));
    }

    @Test
    public void getUserInfoObjectTest() {
        User user = given()
                .baseUri("http://localhost:80/mantisbt/api/rest")
                .header(new Header("Authorization", "2Ld2NvUCTZSRszWnw0O7U_Q-AC7f8JOT"))
                .when()
                .get("/users/me").as(User.class);

        System.out.println(user);
        assertThat(user.getName(), equalTo("api_user"));
        assertThat(user.getRealName(), equalTo("api user"));
    }

    @Test
    public void createUserTest() {
        Response authorization = given()
                .baseUri("http://localhost:80/mantisbt/api/rest")
                .header(new Header("Authorization", "2Ld2NvUCTZSRszWnw0O7U_Q-AC7f8JOT"))
                .contentType(ContentType.JSON)
                .body("{\"username\":\"username4\",\"email\":\"email@eamil.com\",\"password\":\"passwd\",\"enabled\":true,\"real_name\":\"real name\",\"access_level\": {\"name\":\"updater\"},\"protected\":false}")
                .when()
                .post("/users/");

        authorization.then()
                .statusCode(201)
                .and()
                .statusLine(containsString("User created with id"));
    }

    @Test
    public void createUserObjectTest() {
        Response authorization = given()
                .baseUri("http://localhost:80/mantisbt/api/rest")
                .header(new Header("Authorization", "2Ld2NvUCTZSRszWnw0O7U_Q-AC7f8JOT"))
                .contentType(ContentType.JSON)
                .body("{\"username\":\"username4\",\"email\":\"email@eamil.com\",\"password\":\"passwd\",\"enabled\":true,\"real_name\":\"real name\",\"access_level\": {\"name\":\"updater\"},\"protected\":false}")
                .when()
                .post("/users/");

        authorization.then()
                .statusCode(201)
                .and()
                .statusLine(containsString("User created with id"));
    }
}
