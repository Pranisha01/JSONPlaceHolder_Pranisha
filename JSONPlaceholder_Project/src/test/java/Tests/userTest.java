package Tests;


import Models.UserPOJO;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import services.UserServices;

import java.util.Arrays;

public class userTest {
    UserServices userServiceObj = new UserServices();
    ;
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void getUsers() {

        Response response = userServiceObj.getUsers().then()
                .log().all().extract().response();
        UserPOJO[] userObj = response.as(UserPOJO[].class);

        softAssert.assertEquals(response.statusCode(), 200, "Status code should be 200: OK");
        for (int i = 0; i < Arrays.asList(userObj).size(); i++) {
            softAssert.assertEquals(userObj[i].id, i + 1);
            softAssert.assertNotNull(userObj[i].name);
            softAssert.assertNotNull(userObj[i].username);
            softAssert.assertNotNull(userObj[i].email);
            softAssert.assertNotNull(userObj[i].address);
            softAssert.assertNotNull(userObj[i].phone);
            softAssert.assertNotNull(userObj[i].website);
            softAssert.assertNotNull(userObj[i].company);

            softAssert.assertAll();
        }
    }
    @Test
    public void getUsersByUserId() {
        Response response = userServiceObj.getUsersByUserId(1)
                .then().log().all().extract().response();
        UserPOJO userObj = response.as(UserPOJO.class);

        softAssert.assertEquals(response.statusCode(), 200, "Status code should be 200: OK");
        softAssert.assertEquals(userObj.id, 1);
        softAssert.assertNotNull(userObj.name);
        softAssert.assertNotNull(userObj.username);
        softAssert.assertNotNull(userObj.email);
        softAssert.assertNotNull(userObj.address);
        softAssert.assertNotNull(userObj.phone);
        softAssert.assertNotNull(userObj.website);
        softAssert.assertNotNull(userObj.company);
        softAssert.assertAll();
    }

    @Test
    public  void updateUsers(){
        Response response = userServiceObj.updateUsers(1)
                .then().log().all().extract().response();
        UserPOJO userObj = response.as(UserPOJO.class);

        softAssert.assertEquals(response.statusCode(), 200, "Status code should be 200: OK");
        softAssert.assertEquals(userObj.id, 1);
        softAssert.assertEquals(userObj.name, "Dennis Reichert");
        softAssert.assertEquals(userObj.username, "demime_Rei");
        softAssert.assertEquals(userObj.email, "dennis.ran@random.com");
        softAssert.assertNotNull(userObj.address);
        softAssert.assertEquals(userObj.phone, "1-477-935-8478 x2243");
        softAssert.assertNotNull(userObj.website,"ola.org");
        softAssert.assertEquals(userObj.company.name, "Keebler LLC");
        softAssert.assertEquals(userObj.company.catchPhrase, "Synchronised fault-tolerant solution");
        softAssert.assertAll();

    }

    @Test
    public  void createUsers() {
        Response response = userServiceObj.createUsers()
                .then().log().all().extract().response();
        UserPOJO userObj = response.as(UserPOJO.class);

        softAssert.assertEquals(response.statusCode(), 201, "Status code should be 201: OK");
        softAssert.assertNotNull(String.valueOf(userObj.id));
        softAssert.assertEquals(userObj.name, "John Graham");
        softAssert.assertEquals(userObj.username, "john_Graham");
        softAssert.assertEquals(userObj.email, "john.graham@random.com");
        softAssert.assertNotNull(userObj.address);
        softAssert.assertEquals(userObj.phone, "0987654321");
        softAssert.assertNotNull(userObj.website);
        softAssert.assertEquals(userObj.company.name, "Vodafone");
        softAssert.assertEquals(userObj.company.catchPhrase, "e-enable strategic applications");
        softAssert.assertAll();

    }
    @Test
    public void deleteUsers() {
        userServiceObj.deleteUsers(1)
                .then();
    }




}










////    @Test
////    public void getUserAlbums() {
////        Obj.getUserAlbums()
////                .then();
////    }
////
////    @Test
////    public void getUserTodos() {
////        Obj.getUserTodos()
////                .then();
////    }
////
////    @Test
////    public void getUserPosts() {
////        Obj.getUserPosts()
////                .then();
////    }
////
////}
