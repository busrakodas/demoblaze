package stepdefinitions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pojos.Category;
import pojos.PetStatus;
import pojos.Pets;
import utilities.ConfigurationReader;


import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class PetsStepDefs {
    Response response;
    PetStatus [] pets;
    RequestSpecification spec;
    Pets newPet;
    Category newCategory;


    @Given("send the get request")
    public void sendTheGetRequest() {
        //RequestSpecification spec= new RequestSpecBuilder().setBaseUri(ConfigReader.getProperty("base_url")).build();
        //spec.pathParams("1","pet","2","findByStatus?status=available");
        //response=given().spec(spec).when().get("{1}/{2}");
        response =given().headers("Authorization","Bearer ",
                "Content-Type",
                ContentType.JSON,
                "Accept",
                ContentType.JSON).when().get("https://petstore.swagger.io/v2/pet/findByStatus?status=available");
    }

    @Then("validates actual result")
    public void validatesActualResult() {
        for (int i=0;i<pets.length;i++){
            assertTrue(pets[i].getStatus().equals("available"));
        }

    }

    @Then("status code should be {int}")
    public void statusCodeShouldBe(int statuscode) {
        response.then().statusCode(statuscode);
    }

    @And("deserialize response data to java")
    public void deserializeResponseDataToJava() throws JsonProcessingException {
        ObjectMapper objectMapper= new ObjectMapper();
        pets = objectMapper.readValue(response.asString(),PetStatus[].class);


    }

    @Given("set the necessary path params")
    public void setTheNecessaryPathParams() {
        //https://petstore.swagger.io/v2/pet
        spec= new RequestSpecBuilder().setBaseUri(ConfigurationReader.getProperty("base_url")).build();
        spec.pathParams("first","v2","second","pet");
    }

    @When("send the post request")
    public void sendThePostRequest() {
        response=given().spec(spec).contentType(ContentType.JSON).body(newPet).when().post("{first}/{second}");
    }

    @Then("validate that new pet added")
    public void validateThatNewPetAdded() {
        response.then().statusCode(200).body("id",equalTo(newPet.getId())
                ,"name",equalTo(newPet.getName())
                ,"category.id",equalTo(newPet.getCategory().getId())
                ,"category.name",equalTo(newPet.getCategory().getName())
                ,"status",equalTo(newPet.getStatus()));
    }


    @When("send the put request")
    public void sendThePutRequest() {
        response=given().spec(spec).contentType(ContentType.JSON).body(newPet).when().put("{first}/{second}");
        response.prettyPrint();
    }

    @Then("validate that the status is updated")
    public void validateThatTheStatusIsUpdated() {
        response.then().statusCode(200).body("id",equalTo(newPet.getId())
                ,"name",equalTo(newPet.getName())
                ,"category.id",equalTo(newPet.getCategory().getId())
                ,"category.name",equalTo(newPet.getCategory().getName())
                ,"status",equalTo("sold"));
    }

    @And("set the expected data {int}, {int}, {string}, {string}, {string}")
    public void setTheExpectedData(int id, int categoryId, String categoryName, String name, String status) {
        newCategory=new Category(categoryId, categoryName);
        newPet=new Pets(id,name,status,newCategory);
    }

    @Given("set the necessary path params for id {int}")
    public void setTheNecessaryPathParamsForId(int id) {
        //https://petstore.swagger.io/v2/pet/id
        spec= new RequestSpecBuilder().setBaseUri(ConfigurationReader.getProperty("base_url")).build();
        spec.pathParams("first","v2","second","pet", "third",id);
    }

    @When("send the delete request")
    public void sendTheDeleteRequest() {
        response=given().spec(spec).when().delete("{first}/{second}/{third}");
    }

    @Then("validate that the pet is deleted for id {string}")
    public void validateThatThePetIsDeletedForId(String id) {
//    {
//            "code": 200,
//                "type": "unknown",
//                "message": id
//        }
        response.then().statusCode(200).
                body("code",equalTo(200),"type",
                        equalTo("unknown"),"message",equalTo(id));
    }
}
