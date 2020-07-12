import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.annotations.Test;

import files.ReUsableMethod;
import files.payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class StaticJson {
	@Test

	public void addBook() throws IOException

	{

		 RestAssured.baseURI = "http://216.10.245.166";

		 String resp = given().header("Content-Type","application/json").

				body(GenerateStringFormatResource("C:\\Users\\kantd\\Documents\\Ravi\\RestAPI-RestAssured\\Book.json"))

				.when()

				.post("/Library/Addbook.php")

				.then().log().all().assertThat().statusCode(200)

				.extract().response().asString();

		JsonPath js = ReUsableMethod.rawToJson(resp);

		String id = js.getString("ID");

		System.out.println(id);

	}

	public String GenerateStringFormatResource(String path) throws IOException
	{
		return new String(Files.readAllBytes(Paths.get(path)));
	}

}
