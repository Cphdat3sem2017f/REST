package rest;

import entity.Person;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class RestPersonIntegrationTest
{
    
    public RestPersonIntegrationTest()
    {
    }
    
    @BeforeClass
    public static void setUpClass()
    {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8080;
        RestAssured.basePath = "/JPA_REST_JS";
        RestAssured.defaultParser = Parser.JSON;
    }
    
    @AfterClass
    public static void tearDownClass()
    {
    }
    
    @Before
    public void setUp()
    {
    }
    
    @After
    public void tearDown()
    {
    }

    @Test
    public void testGetPersons()
    {
        System.out.println("getPersons");
    }
    
    @Test
    public void serverIsRunning()
    {
        System.out.println("serverIsRunning");
        
        given().
        when().get().
        then().statusCode(200);
    }
    
    @Test
    public void postGetDeletePerson()
    {
        Person p = new Person("Kurt", "Wonnegut", 12344321);
        Person newPerson =
        given()
        .contentType(ContentType.JSON)
        .body(p)
        .when().post("/api/person")
        .as(Person.class);

        assertNotNull(newPerson.getId());
    
        given()
        .contentType(ContentType.JSON)
        .when().get("/api/person/" + newPerson.getId()).then()
        .body("id",notNullValue())
        .body("firstName", equalTo("Kurt"));
    
        given()
        .contentType(ContentType.JSON)
        .when().delete("/api/person/" + newPerson.getId()).then()
        .body("firstName", equalTo("Kurt"));
    }
}
