package PetStore.tests.integration;

import PetStore.actions.AssertActions;
import PetStore.endpoints.APIConstants;
import PetStore.payload.PetDetails;
import PetStore.tests.base.BaseTest;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.ITestContext;
import org.testng.annotations.Test;

public class IntegrationTest extends BaseTest {

    @Owner("Viral Dhakan")
    @Description("Verify a create pet successfully")
    @Test(groups = "Integration")
    public void testCreatePet(ITestContext iTestContext) throws JsonProcessingException {

        if (requestSpecification == null) {
            System.out.println("Request Specification is null");
        } else {
            requestSpecification.basePath(APIConstants.Create_Pet_URL);

            response = RestAssured
                    .given().spec(requestSpecification)
                    .when()
                    .body(payloadManager.createPayload())
                    .post();

            validatableResponse = response.then().log().all();
            validatableResponse.statusCode(200);

            jsonPath = JsonPath.from(response.asString());
            String setId = jsonPath.getString("id");
            iTestContext.setAttribute("id", jsonPath.getString("id"));

            System.out.println("Set ID :- " + setId);
        }
    }

    @Owner("Viral Dhakan")
    @Description("Verify a update pet successfully")
    @Test(groups = "Integration", dependsOnMethods = "testCreatePet")
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
        System.out.println("Set ID :- " + setId);

        PetDetails updatePetDetail = response.as(PetDetails.class);

        AssertActions assertActions1 = new AssertActions();

        assertActions1.verifyStatusCode(response);
        assertActions1.verifyResponseBody(String.valueOf(updatePetDetail.getId()), String.valueOf(setId), "Verify pet ID matches");
        assertActions1.verifyResponseBody(updatePetDetail.getName(), "Golden", "Verify a pet name is Golden");
        assertActions1.verifyResponseBody(updatePetDetail.getCategory().getName(), "Golden Retriever", "Verify a category is Golden Retriver");


        assertActions1.verifyResponseBody(updatePetDetail.getTags().get(0).getName(), "Family", "Verify a first tag is Family");
        assertActions1.verifyResponseBody(updatePetDetail.getTags().get(1).getName(), "loyal", "Verify a second tag is loyal");

        assertActions1.verifyResponseBody(updatePetDetail.getPhotoUrls().get(0), "http://petstore.com/photos/bruno5.jpg", "Verify a first photo ");
        assertActions1.verifyResponseBody(updatePetDetail.getPhotoUrls().get(1), "http://petstore.com/photos/bruno4.jpg", "Verify a first photo ");

    }

    @Owner("Viral Dhakan")
    @Description("Verify a delete pet successfully")
    @Test(groups = "Integration", dependsOnMethods = "testUpdatePet")
    public void testDeletePet(ITestContext iTestContext) {

        int setID = Integer.parseInt((String) iTestContext.getAttribute("id"));

        requestSpecification.basePath(APIConstants.Delete_Pet_URL + "/" + setID);

        response = RestAssured
                .given().spec(requestSpecification)
                .when()
                .delete();

        validatableResponse = response.then().log().body();
        validatableResponse.statusCode(200);

        System.out.println("Deleted Set ID:- " + setID);


    }
}
