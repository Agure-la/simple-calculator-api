package org.acme;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;


@Path("/calculator")
public class Calc {

    //testing api
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String sayHello() {
        return "Hello, Quarkus Test Endpoint!";
    }

    @GET
    @Path("/add/{a}/{b}")
    public double add(@PathParam("a") double a, @PathParam("b") double b) {
        return a + b;
    }

    @GET
    @Path("/subtract/{a}/{b}")
    public double subtract(@PathParam("a") double a, @PathParam("b") double b) {
        return a - b;
    }

    @GET
    @Path("/multiply/{a}/{b}")
    public double multiply(@PathParam("a") double a, @PathParam("b") double b) {
        return a * b;
    }

    @GET
    @Path("/divide/{a}/{b}")
    public double divide(@PathParam("a") double a, @PathParam("b") double b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return a / b;
    }

    @GET
    @Path("/mod/{a}/{b}")
    public double mod(@PathParam("a") double a, @PathParam("b") double b) {
        return a % b;
    }

    //http://localhost:8080/calculator/divide/24/8
}
