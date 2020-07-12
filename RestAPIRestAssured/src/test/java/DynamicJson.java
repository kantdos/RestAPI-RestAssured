import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import files.ReUsableMethod;
import files.payload;
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class DynamicJson {

	@Test(dataProvider="Booksdata")

	public void addBook(String aisle, String isbn)

	{

		 RestAssured.baseURI = "http://216.10.245.166";

		 String resp = given().header("Content-Type","application/json").

				body(payload.AddBook(aisle,isbn))

				.when()

				.post("/Library/Addbook.php")

				.then().log().all().assertThat().statusCode(200)

				.extract().response().asString();

		JsonPath js = ReUsableMethod.rawToJson(resp);

		String id = js.getString("ID");

		System.out.println(id);

	}

	@DataProvider(name="Booksdata")
	public Object[][] getData()
	{
		return new Object[][] {{"ijn","12"},{"uhb","34"},{"ygv","56"}};
		 
	}
}