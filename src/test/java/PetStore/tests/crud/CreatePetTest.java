package PetStore.tests.crud;

import PetStore.endpoints.APIConstants;
import PetStore.tests.base.BaseTest;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.ITestContext;
import org.testng.annotations.Test;

public class CreatePetTest extends BaseTest {


    @Owner("Viral Dhakan")
    @Description("Verify a Create a Pet")
    @Test(groups = "Crud")
    public void testCreatePet(ITestContext iTestContext) throws JsonProcessingException {

        requestSpecification.basePath(APIConstants.Create_Pet_URL);

        response = RestAssured
                .given().spec(requestSpecification)
                .when()
                .body(payloadManager.createPayload())
                .put();

        validatableResponse =response.then().log().all();
        validatableResponse.statusCode(200);

        jsonPath = JsonPath.from(response.asString());
        int setId = Integer.parseInt(jsonPath.getString("id"));
        iTestContext.setAttribute("id",jsonPath.getString("id"));

        System.out.println("Set ID :- " + setId);


    }
}
