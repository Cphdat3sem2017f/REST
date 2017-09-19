package rest;

import entity.Person;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import static io.restassured.RestAssured.given;
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
        System.out.println("postGetDeletePerson");

        //POST
        Person postedPerson = new Person("Kurt", "Wonnegut", 12344321);
        Person newPerson
                = given()
                        .contentType(ContentType.JSON)
                        .body(postedPerson)
                        .when().post("/api/person")
                        .as(Person.class);
        assertNotNull(newPerson.getId());

        //GET
        Person gottenPerson = given()
                .contentType(ContentType.JSON)
                .when().get("/api/person/" + newPerson.getId()).as(Person.class);
        assertNotNull(gottenPerson.getId());
        assertEquals("Kurt", gottenPerson.getFirstName());

        //DELETE
        Person deletedPerson = given()
                .contentType(ContentType.JSON)
                .when().delete("/api/person/" + newPerson.getId()).as(Person.class);
        assertEquals("Kurt", deletedPerson.getFirstName());
    }
}
