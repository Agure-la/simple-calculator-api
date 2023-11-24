package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;

@QuarkusTest
public class TestCalc {

    //Simple Api test for calculator


    @Test
    public void testHelloEndpoint() {
        given()
                .when().get("/calculator").prettyPeek()
                .then()
                .statusCode(200)
                .body(is("Hello, Quarkus Test Endpoint!"));
    }

    @Test
    public void testAddEndpoint() {
        given()
                .when().get("/calculator/add/2/3").prettyPeek()
                .then()
                .statusCode(200)
                .body(is("5.0"));
    }

    @Test
    public void testSubtractEndpoint() {
        given()
                .when().get("/calculator/subtract/5/2").prettyPeek()
                .then()
                .statusCode(200)
                .body(is("3.0"));
    }

    @Test
    public void testMultiplyEndpoint() {
        given()
                .when().get("/calculator/multiply/2/4").prettyPeek()
                .then()
                .statusCode(200)
                .body(is("8.0"));
    }

    @Test
    public void testDivideEndpoint() {
        given()
                .when().get("/calculator/divide/6/2").prettyPeek()
                .then()
                .statusCode(200)
                .body(is("3.0"));
    }

    @Test
    public void testDivideByZeroEndpoint() {
        given()
                .when().get("/calculator/divide/6/0").prettyPeek()
                .then()
                .statusCode(500)
                .body(containsString("Cannot divide by zero"));
    }

    @Test
    public void testModEndpoint(){
        given()
                .when().get("/calculator/mod/24/20").prettyPeek()
                .then()
                .statusCode(200)
                .body(is("4.0"));
    }
}
