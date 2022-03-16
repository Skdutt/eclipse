package TrelloTesting;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class Trello {
	
	public static String baseurl = "https://api.trello.com";
	public static String bid;
	
	@Test (priority = 0)
	public void createBoard() {
		RestAssured.baseURI = baseurl;
		//given()
		Response response =given()
		.queryParam("name","shreya")
		.queryParam("key","1befbefda32b87f839e4a62a08ab29eb")
		.queryParam("token","c7e57c6b6bb9b7b4eb4183a833312713607b41b269be653dc7978ad5d0274f52")
		.header("Content-Type","application/json")
		//Response response = baseurl.given("/1/boards/");
		
		.when()
		.post("/1/boards/")
		
		.then()
		.assertThat().statusCode(200).contentType(ContentType.JSON)
		.extract().response();
		
		//Response response = baseurl.given("/1/boards/");
		//for response
		String jsoneresponse =response.asString();
		JsonPath js = new JsonPath(jsoneresponse);
		System.out.println(jsoneresponse);
		System.out.println("we are in create");
		bid =js.get("id");
		System.out.println(bid);
		
	}	
	
	@Test (priority = 1)
	public void deleteBoard() {
		RestAssured.baseURI = baseurl;
		//given()
		Response response =given()
		.queryParam("name","shreya")
		.queryParam("key","1befbefda32b87f839e4a62a08ab29eb")
		.queryParam("token","c7e57c6b6bb9b7b4eb4183a833312713607b41b269be653dc7978ad5d0274f52")
		.header("Content-Type","application/json")
		//Response response = baseurl.given("/1/boards/");
		
		.when()
		.delete("/1/boards/"+bid) 
		
		.then()
		.assertThat().statusCode(200).contentType(ContentType.JSON)
		.extract().response();
		
		//Response response = baseurl.given("/1/boards/");
		//for response
		String jsoneresponse =response.asString();
		JsonPath js = new JsonPath(jsoneresponse);
		System.out.println(jsoneresponse);
		System.out.println("we are in delete");
	}	
	
	}