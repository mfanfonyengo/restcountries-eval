package restcountries;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class NameTest {

    public static Object[][] countryNamesAndCapitals() {
        return new Object[][] {
                { "cameroon", "Yaounde" },
                { "philippines", "Manila" },
                { "lithuania", "Vilnius" }
        };
    }

    @ParameterizedTest
    @MethodSource("countryNamesAndCapitals")
    public void requestCountryName_checkCapitalCityInResponseBody(String name,String expectedCapitalCity) {
        given().
                pathParam("name", name).
        when().
                get("https://restcountries.com/v3.1/name/{name}").
        then().
                assertThat().
                body("[0].'capital'", equalTo(expectedCapitalCity));
    }

    @Test
    public void requestCameroonName_checkStatusCode_expectHttp200() {

        given().
        when().
                get("https://restcountries.com/v3.1/name/cameroon").
        then().
                assertThat().
                statusCode(200);
    }

    @Test
    public void requestCameroonName_requestBody() {

        given().
        when().
                get("https://restcountries.com/v3.1/name/cameroon").
        then().
                log().body();
    }

}
