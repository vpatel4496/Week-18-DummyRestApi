package com.restapi.steps;

import com.restapi.constants.EndPoints;
import com.restapi.model.EmployeePojo;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class DummySteps {
    @Step
    public ValidatableResponse getEmployee(){
        return SerenityRest.given().log().all()
                .when()
                .get(EndPoints.GET_ALL_EMPLOYEE)
                .then().statusCode(200);
    }
    @Step
    public ValidatableResponse createEmployeeById(String name,String age,String salary){
        EmployeePojo employeePojo = new EmployeePojo();
        employeePojo.setName(name);
        employeePojo.setAge(age);
        employeePojo.setSalary(salary);
        return SerenityRest.given().log().all()
                .contentType("application/json")
                .body(employeePojo)
                .post(EndPoints.CREATE_EMPLOYEE).then();

    }
    @Step
    public ValidatableResponse getEmployeeById(int id){
        return SerenityRest.given().log().all()
                .pathParam("id",id)
                .when()
                .get(EndPoints.GET_EMPLOYEE_BY_ID).then().log().all().statusCode(200);
    }
    @Step
    public ValidatableResponse updateEmployeeById(String name,String age,String salary){
        EmployeePojo employeePojo = new EmployeePojo();
        employeePojo.setName(name);
        employeePojo.setAge(age);
        employeePojo.setSalary(salary);
        return SerenityRest.given().log().all()
                .contentType("application/json")
                .body(employeePojo)
                .put(EndPoints.UPDATE_EMPLOYEE_BY_ID).then();

    }
    @Step("delete user")
    public ValidatableResponse deleteById(){
        return SerenityRest.given().log().all()
                .when()
                .delete(EndPoints.DELETE_EMPLOYEE).then();
    }
}
