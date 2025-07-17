package PetStore.tests.base;

import PetStore.actions.AssertActions;
import PetStore.endpoints.APIConstants;
import PetStore.modules.PayloadManager;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected RequestSpecification requestSpecification;
    protected Response response;
    protected ValidatableResponse validatableResponse;
    protected PayloadManager payloadManager;
    protected AssertActions assertActions;
    protected JsonPath jsonPath;

    @BeforeMethod(alwaysRun = true)
    public void setUpConfig(){
        System.out.println("Start !! ");

        payloadManager = new PayloadManager();
        assertActions = new AssertActions();

        requestSpecification = RestAssured
                .given()
                .baseUri(APIConstants.Base_URL)
                .contentType(ContentType.JSON);

    }

    @AfterMethod
    public  void tearDown(){
        System.out.println("End !!");
    }
}
