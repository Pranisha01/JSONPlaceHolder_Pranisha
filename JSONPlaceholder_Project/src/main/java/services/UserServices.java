package services;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class UserServices {

    static String baseURL = "https://jsonplaceholder.typicode.com";
    static String basePath = "/users";
    static RequestSpecification req_Spec;

    public UserServices() {
        req_Spec = given().baseUri(baseURL).basePath(basePath);
    }

    public Response getUsers() {
        return given().spec(req_Spec).
                when().get();
    }

    public Response getUsersByUserId(int Id) {
        return given().spec(req_Spec).
                when().get(String.valueOf(Id));
    }

    public Response updateUsers(int Id) {
        return given().spec(req_Spec).contentType(ContentType.JSON).body("{\n" +
                "    \"id\": " + Id + ",\n" +
                "    \"name\": \"Dennis Reichert\",\n" +
                "    \"username\": \"demime_Rei\",\n" +
                "    \"email\": \"dennis.ran@random.com\",\n" +
                "    \"address\": {\n" +
                "        \"street\": \"Dayna Turnpike\",\n" +
                "        \"suite\": \"Suite 550\",\n" +
                "        \"city\": \"Howemouth\",\n" +
                "        \"zipcode\": \"12343-8756\",\n" +
                "        \"geo\": {\n" +
                "            \"lat\": \"-71.4231\",\n" +
                "            \"lng\": \"71.7478\"\n" +
                "        }\n" +
                "    },\n" +
                "    \"phone\": \"1-477-935-8478 x2243\",\n" +
                "    \"website\": \"hildegard.org\",\n" +
                "    \"company\": {\n" +
                "        \"name\": \"Keebler LLC\",\n" +
                "        \"catchPhrase\": \"Synchronised fault-tolerant solution\",\n" +
                "        \"bs\": \"e-enable innovative applications\"\n" +
                "    }\n" +
                "}").when().put(String.valueOf(Id));
    }

    public Response createUsers() {
        return given().spec(req_Spec).contentType(ContentType.JSON).body("""
                        {
                            "name": "John Graham",
                            "username": "john_Graham",
                            "email": "john.graham@random.com",
                            "address": {
                                "street": "Douglas Extension",
                                "suite": "Suite 847",
                                "city": "Germany",
                                "zipcode": "59590-415",
                                "geo": {
                                    "lat": "-73.9876",
                                    "lng": "86.8375"
                                }
                            },
                            "phone": "0987654321",
                            "website": "ramiro.info",
                            "company": {
                                "name": "Vodafone",
                                "catchPhrase": "e-enable strategic applications",
                                "bs": "transition cutting-edge web services"
                            }
                        }""").when().post();
    }

    public Response deleteUsers(int Id) {
        return given().spec(req_Spec).
                when().delete(String.valueOf(Id));
    }



}







//public Response getUserAlbums(int Id) {
//    return given().spec(req_Spec)
//            .when().get(Id + "/albums");
//}
//
//public Response getUserTodos(int Id) {
//
//    return given().spec(req_Spec)
//            .when().get(Id + "/todos");
//}
//
//public Response getUserPosts(int Id) {
//
//    return given().spec(req_Spec)
//            .when().get(Id + "/posts");
//}
//
//
//
