package Tests;

import Models.PostPOJO;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import services.PostServices;

import java.util.Arrays;

public class postTest{
    PostServices postServiceObj = new PostServices(); ;
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void getPosts(){

        Response response = postServiceObj.getPosts().then()
                .log().all().extract().response();
        PostPOJO[] postObj = response.as(PostPOJO[].class);

        softAssert.assertEquals(response.statusCode(), 200, "Status code should be 200: OK");
        for (int i = 0; i < Arrays.asList(postObj).size(); i++) {
            softAssert.assertNotNull(String.valueOf(postObj[i].userId));
            softAssert.assertEquals(postObj[i].id, i+1);
            softAssert.assertNotNull(postObj[i].title);
            softAssert.assertNotNull(postObj[i].body);
        }
        softAssert.assertAll();
    }

    @Test
    public void getPostsByUserId(){
        Response response = postServiceObj.getPostsByUserId(1).then()
                .log().all().extract().response();
        PostPOJO postObj = response.as(PostPOJO.class);

        softAssert.assertEquals(response.statusCode(), 200, "Status code should be 200: OK");
            softAssert.assertEquals(postObj.userId, 1);
            softAssert.assertNotNull(String.valueOf(postObj.userId));
            softAssert.assertNotNull(postObj.title);
            softAssert.assertNotNull(postObj.body);
        softAssert.assertAll();

    }

    @Test
    public void updatePosts(){
        Response response = postServiceObj.updatePosts(2).then()
                .log().all().extract().response();
        PostPOJO postObj = response.as(PostPOJO.class);

        softAssert.assertEquals(response.statusCode(), 200, "Status code should be 200: OK");
        softAssert.assertNotNull(String.valueOf(postObj.userId));
        softAssert.assertEquals(postObj.id , 2);
        softAssert.assertNotNull(postObj.title);
        softAssert.assertNotNull(postObj.body);
        softAssert.assertAll();


    }

    @Test
    public void createPosts() {

        Response response = postServiceObj.createPosts(1).then()
                .log().all().extract().response();
        PostPOJO postObj = response.as(PostPOJO.class);

        softAssert.assertEquals(response.statusCode(), 201, "Status code should be 201: CREATED");
        softAssert.assertEquals(postObj.userId, 1);
        softAssert.assertNotNull(String.valueOf(postObj.id));
        softAssert.assertNotNull(postObj.title);
        softAssert.assertNotNull(postObj.body);
        softAssert.assertAll();
    }

    @Test
    public void deletePosts() {

        postServiceObj.deletePosts(1)
                .then().assertThat().statusCode(200);
    }




}





//package Tests;
//
//import io.restassured.specification.ResponseSpecification;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//import services.PostServices;
//
//import static io.restassured.RestAssured.expect;
//
//public class postTest {
//
//    ResponseSpecification res_Spec;
//    PostServices Obj = new PostServices();
//
//    @BeforeClass
//    public void specifications() {
//        res_Spec = expect().statusCode(200);
//
//    }
//    @Test
//    public void getPosts() {
//        Obj.getPosts()
//                .then().spec(res_Spec);
//    }
//
//    @Test
//    public void getPostsByUserId() {
//        Obj.getPostsByUserId(1)
//                .then().spec(res_Spec);
//    }
//    @Test
//    public void putPosts() {
//
//        Obj.putPosts(1)
//                .then().spec(res_Spec).extract().response();
//
//    }
//
//    @Test
//    public void createPosts() {
//        Obj.createPosts(1)
//                .then();
//
//    }
//
//    @Test
//    public void deletePosts() {
//        Obj.deletePosts(1)
//                .then().spec(res_Spec);
//
//
//    }
//
//
//
//
//}
