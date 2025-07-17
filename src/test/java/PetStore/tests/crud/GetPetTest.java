package PetStore.tests.crud;

import PetStore.endpoints.APIConstants;
import PetStore.tests.base.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.RestAssured;
import org.testng.ITestContext;
import org.testng.annotations.Test;

public class GetPetTest extends BaseTest {

    @Owner("Viral Dhakan")
    @Description("Verify a Get pet successfully")
    @Test(groups = "Crud" , dependsOnMethods = "PetStore.tests.crud.createPet.testCreatePet")
    public void testGetPet(ITestContext iTestContext){

        int setId = Integer.parseInt((String) iTestContext.getAttribute("id"));

        requestSpecification.basePath(APIConstants.Get_Pet_URL  + "/"  + setId);

        response = RestAssured
                .given().spec(requestSpecification)
                .when()
                .get();

        validatableResponse = response.then().log().body();
        validatableResponse.statusCode(200);

        System.out.println("Set ID :- " + setId);


    }
}
