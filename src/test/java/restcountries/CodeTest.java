package restcountries;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class CodeTest {

    public static Object[][] countryCodesAndCapitals() {
        return new Object[][] {
                { "CMR", "Yaounde" },
                { "PHL", "Manila" },
                { "LTU", "Vilnius" }
        };
    }

    @ParameterizedTest
    @MethodSource("countryCodesAndCapitals")
    public void requestCountryName_checkCapitalCityInResponseBody(String code,String expectedCapitalCity) {
        given().
                pathParam("name", code).
        when().
                get("https://restcountries.com/v3.1/alpha/{code}").
        then().
                assertThat().
                body("[0].'capital'", equalTo(expectedCapitalCity));
    }

    @Test
    public void requestCameroonName_checkStatusCode_expectHttp200() {

        given().
        when().
                get("https://restcountries.com/v3.1/alpha/cmr").
        then().
                assertThat().
                statusCode(200);
    }

    @Test
    public void requestCameroonName_requestBody() {

        given().
        when().
                get("https://restcountries.com/v3.1/alpha/cmr").
        then().
                log().body();
    }
}
