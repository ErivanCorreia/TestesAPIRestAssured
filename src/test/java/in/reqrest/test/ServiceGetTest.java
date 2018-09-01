package in.reqrest.test;

import org.junit.Test;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class ServiceGetTest extends BaseTest {
	
	@Test
	public void quandoApiUserStatusSucessoGet() {
		given()
		.when()
		.get("/api/users/2")
		.then()
		.contentType(ContentType.JSON)
		.statusCode(200);
	}
	
	@Test
	public void quandoApiUserStatusSucessoDelayedGet() {
		given()
		.when()
		.get("/api/users?delay=3")
		.then()
		.contentType(ContentType.JSON)
		.statusCode(200)
		.log()
		.all();
	}
	
	@Test
	public void quandoApiUserPrintReturnGet() {
		Response response = given()
				.when()
				.get("/api/users/2");
		
		System.out.println(response.body().asString()); 			
	}
	
	@Test
	public void quandoApiUserStatusNotFoundGet() {
		given()
		.when()
		.get("/api/users/23")
		.then()
		.contentType(ContentType.JSON)
		.statusCode(404);
	}
	
	@Test
	public void quandoApiUserListStatusGet() {
		given()
		.when()
		.get("/api/unknown")
		.then()
		.contentType(ContentType.JSON)
		.statusCode(200)
		.log()
		.all();	
	}
	
	@Test
	public void quandoApiUserListPageStatusGet() {
		given()
		.relaxedHTTPSValidation()
		.param("page", 2)
		.when()
		.get("/api/users/")
		.then()
		.contentType(ContentType.JSON)
		.statusCode(200);	
	}


	
	@Test
	public void quandoApiUserStatusSucessoPost() {
		String body = "{" + 
						"\"name\": \"morpheus\",\r\n" + 
						"\"job\": \"leader\"\r\n" + 
				      "}";
		
		given()
		.contentType(ContentType.JSON)
		.body(body)
		.when()
		.post("/api/users")
		.then()
		.statusCode(201);
	}	
	
	@Test
	public void quandoUserStatusLoginSucessoPost() {
		String body = "{\"email\": \"peter@klaven\",\"password\": \"cityslicka\"}";
		
		given()
		.contentType(ContentType.JSON)
		.body(body)
		.when()
		.post("/api/login")
		.then()
		.statusCode(200)
		.log()
		.all();
	}
	
	@Test
	public void quandoUserStatuLoginSemSucessoPost() {
		String body = "{\"email\": \"peter@klaven\"}";
		
		given()
		.contentType(ContentType.JSON)
		.body(body)
		.when()
		.post("/api/login")
		.then()
		.statusCode(400)
		.log()
		.all();
	}
	
	@Test
	public void quandoApiUserStatusSucessoPut() {
		given()
		.contentType(ContentType.JSON)
		.body("{\"name\": \"morpheus\"," + " \"job\": \"zion resident\"}")
		.when()
		.put("/api/users/2")
		.then()
		.statusCode(200)
		.log()
		.all();
	}
	
	@Test
	public void quandoApiUserStatusPatch() {
		String body = "{\"name\": \"morpheus\",\"job\": \"zion resident\"}";
		
		given()
		.contentType(ContentType.JSON)
		.body(body)
		.when()
		.patch("/api/users/2")
		.then()
		.statusCode(200)
		.log()
		.all();
	}
	
	@Test
	public void quandoApiUserStatusDelete() {
		given()
		.when()
		.delete("/api/users/2")
		.then()
		.statusCode(204);
	}

}
