package demo;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import pojo.Login;
import pojo.LoginResponse;

import static io.restassured.RestAssured.given;

public class ECommerceAPITest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		 RequestSpecification  req =	new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com/").setContentType(ContentType.JSON)
		.build();
		
		Login loginRequest = new  Login();
		loginRequest.setUserEmail("jiochem@gmail.com");
		loginRequest.setUserPassword("Priyesh@123");
		
		//RequestSpecification  reqLogin
		
		// 
		
		RequestSpecification reqLogin = given().spec(req).body(loginRequest);
				reqLogin.when().post("/api/ecom/auth/login").then().extract().response().as(LoginResponse.class);
				
		
		
		
		
	}

}
