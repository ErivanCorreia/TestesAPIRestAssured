package in.reqrest.test;


import static io.restassured.RestAssured.*;

import org.junit.Before;

public class BaseTest {

	@Before
	public void testUriAntes() {
		baseURI = "https://reqres.in/";
	}
	
}
