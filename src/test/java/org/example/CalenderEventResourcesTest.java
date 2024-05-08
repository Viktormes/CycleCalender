package org.example;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;


import static io.restassured.RestAssured.given;

@QuarkusTest
public class CalenderEventResourcesTest {


    @Nested
    class CalenderEventsTest {

        @Test
        void testGetCalenderEvent() {
            given()
                    .when().get("/calender-events")
                    .then()
                    .statusCode(200);
        }
    }
}
