package PetStore.tests.crud;

import PetStore.endpoints.APIConstants;
import PetStore.tests.base.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.RestAssured;
import org.testng.ITestContext;
import org.testng.annotations.Test;

public class DeletePetTest extends BaseTest {

    @Owner("Viral Dhakan")
    @Description("Verify a delete pet successfully")
    @Test(groups = "Crud")
    public void testDeletePet(ITestContext iTestContext) {

        int setID = Integer.parseInt((String) iTestContext.getAttribute("id"));

        requestSpecification.basePath(APIConstants.Delete_Pet_URL + "/" + setID);

        response = RestAssured
                .given().spec(requestSpecification)
                .when()
                .delete();

        validatableResponse = response.then().log().body();
        validatableResponse.statusCode(200);

        System.out.println("Set Id :- " + setID);

    }
}
