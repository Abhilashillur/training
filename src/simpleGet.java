import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class simpleGet 
{
	@Test
	
		public void simplegetendpoint()
		{
			//RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";
		RestAssured.baseURI="https://apistg.np.covapp.io/person/v3/persons";
			RequestSpecification httprequest=RestAssured.given();
			httprequest.accept("application/vnd.com.covisint.platform.person.v1+json");
			httprequest.contentType("application/vnd.com.covisint.platform.person.v1+json");
			httprequest.header("Authorization","Bearer 2|tse48uTHuOJUqEsBW6Iwhz0iitNC");
			httprequest.param("username","USER-1947428860");
			Response response=httprequest.request(Method.GET);
			String responsebody=response.getBody().asString();
			System.out.println(responsebody);
			JsonPath jsonpathevaluator=response.jsonPath();
			String CUID=jsonpathevaluator.getString("status");
			System.out.println(CUID);
			//System.out.println(response.getBody().asString().contains("B4W8J882"));
			int statuscode=response.getStatusCode();
			Assert.assertEquals(statuscode, 200);
		}
	

}
