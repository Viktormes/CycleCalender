package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import io.quarkus.test.junit.QuarkusTest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.dto.AddCalenderEventDTO;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;

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
