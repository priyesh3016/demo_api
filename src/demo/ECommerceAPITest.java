package demo;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import pojo.Detail;
import pojo.Login;
import pojo.LoginResponse;
import pojo.Orders;

public class ECommerceAPITest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//SSL
		RequestSpecification req = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
				.setContentType(ContentType.JSON).build();

		Login loginRequest = new Login();
		loginRequest.setUserEmail("jiochem@gmail.com");
		loginRequest.setUserPassword("Priyesh@123");

		// RequestSpecification reqLogin
		RequestSpecification reqLogin = given().spec(req).body(loginRequest);
		LoginResponse loginResponse = reqLogin.when().post("/api/ecom/auth/login").then().extract().response()
				.as(LoginResponse.class);

		System.out.println(loginResponse.getToken());
		String token = loginResponse.getToken();
		System.out.println(loginResponse.getUserId());
		String userId = loginResponse.getUserId();

		// Add Product
//step 1 :

		RequestSpecification addProductBaseReq = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
				.addHeader("authorization", token).build();

		RequestSpecification reqAddproduct = given().log().all().spec(addProductBaseReq).param("productName", "Laptop")
				.param("productAddedBy", userId).param("productCategory", "fashion")
				.param("productSubCategory", "shirts").param("productPrice", "11500")
				.param("productDescription", "Lenova").param("productFor", "men")
				.multiPart("productImage", new File("C:\\Users\\PRIYESH\\Downloads\\LAPTOP.jpeg"));

		String addProductResponse = reqAddproduct.when().post("/api/ecom/product/add-product").then().log().all()
				.extract().response().asString();

		JsonPath js = new JsonPath(addProductResponse);
		String productId = js.get("productId");

		// Create a Product --

		// Create Order
		RequestSpecification createOrderBaseReq = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
				.addHeader("authorization", token).setContentType(ContentType.JSON).build();
		Detail orderDetail = new Detail();
		orderDetail.setCountry("India");
		orderDetail.setProductOrderedId(productId);

		List<Detail> orderDetailList = new ArrayList<Detail>();
		orderDetailList.add(orderDetail);
		Orders orders = new Orders();
		orders.setOrders(orderDetailList);

		RequestSpecification createOrderReq = given().log().all().spec(createOrderBaseReq).body(orders);

		String responseAddOrder = createOrderReq.when().post("/api/ecom/order/create-order").then().log().all()
				.extract().response().asString();
		System.out.println(responseAddOrder);

		// Delete Product

		RequestSpecification deleteProdBaseReq = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
				.addHeader("authorization", token).setContentType(ContentType.JSON).build();

		RequestSpecification deleteProdReq = given().log().all().spec(deleteProdBaseReq).pathParam("productId",
				productId);

		String deleteProductResponse = deleteProdReq.when().delete("/api/ecom/product/delete-product/{productId}")
				.then().log().all().extract().response().asString();

		JsonPath js1 = new JsonPath(deleteProductResponse);

		Assert.assertEquals("Product Deleted Successfully", js1.get("message"));

	}

}
