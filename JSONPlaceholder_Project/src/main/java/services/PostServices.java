package services;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class PostServices {

    static String baseURL = "https://jsonplaceholder.typicode.com";
    static String basePath = "/posts";
    static RequestSpecification req_Spec;

    public  PostServices(){
        req_Spec= given().baseUri(baseURL).basePath(basePath);
    }

    public Response getPosts() {
        return given().spec(req_Spec)
                        .when().get();


    }
    public Response getPostsByUserId(int Id) {
        return given().spec(req_Spec).
                when().get(String.valueOf(Id));
    }

    public Response updatePosts(int Id) {
        return given().spec(req_Spec).contentType(ContentType.JSON).body("{\n" +
                "  \"id\": "+Id +",\n" +
                "  \"title\": \"foo\",\n" +
                "  \"body\": \"bar\",\n" +
                "  \"userId\": 1 \n" +
                "}").put(String.valueOf(Id));
    }

    public Response createPosts(int userId) {
        return given().spec(req_Spec).contentType(ContentType.JSON).body("{\n" +
                "  \"title\": \"foo\",\n" +
                "  \"body\": \"bar\",\n" +
                "  \"userId\": "+userId+" \n" +
                "}").when().post();
    }

    public Response deletePosts(int Id) {
        return given().spec(req_Spec).
                when().delete(String.valueOf(Id));
    }


}

