package com.restapi.test;

import com.restapi.steps.DummySteps;
import com.restapi.testbase.TestBase;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class DummyTest extends TestBase {
    static String name = "RvR";
    static String age = "25";
    static String salary = "2000";
    static int id;
    @Steps
    DummySteps dummySteps;

    // get employee
    @Title("get employee data")
    @Test
    public void test001() {
        dummySteps.getEmployee().log().all().statusCode(200);
    }

    // create employee
    @Title("creating new user")
    @Test
    public void test002() {
        ValidatableResponse response = dummySteps.createEmployeeById(name, age, salary).log().all().statusCode(200);
        id = response.log().all().extract().path("data.id");
        System.out.println(id);

    }
    @Title("check user has been added or not by id")
    @Test
    public void test003() {

        dummySteps.getEmployeeById(id).log().all().statusCode(200);
    }
    @Title("Update user")
    @Test
    public void test004() {
        name = name + "_updated";
        dummySteps.updateEmployeeById(name, age, salary).log().all().statusCode(200);
    }
    @Title("Delete user")
    @Test
    public void test005(){
        dummySteps.deleteById().log().all().statusCode(204);
    }
}
