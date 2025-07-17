package PetStore.tests.crud;

import PetStore.endpoints.APIConstants;
import PetStore.tests.base.BaseTest;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.RestAssured;
import org.testng.ITestContext;
import org.testng.annotations.Test;

public class UpdatePetTest extends BaseTest {

    @Owner("Viral Dhakan")
    @Description("Verify Update pet successfully")
    @Test(groups = "Crud")
    public void testUpdatePet(ITestContext iTestContext) throws JsonProcessingException {

       int setId = Integer.parseInt((String) iTestContext.getAttribute("id"));

        requestSpecification.basePath(APIConstants.Update_Pet_URL);

        response = RestAssured
                .given().spec(requestSpecification)
                .when()
                .body(payloadManager.updatePayload(setId))
                .put();

        validatableResponse = response.then().log().body();
        validatableResponse.statusCode(200);

        System.out.println("Set Id :- " + setId);

    }
}
