package ru.netology.service;

import static org.hamcrest.Matchers.equalTo;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;


public class postmanTest {
    @Test
    public void shouldPost(){
    // Given - When - Then
    // Предусловия
        String testString = "123 test me";
    given()
    .baseUri("https://postman-echo.com")
    .body(testString) // отправляемые данные (заголовки и query можно выставлять аналогично)
    // Выполняемые действия
    .when()
    .post("/post")
    // Проверки
    .then()
    .statusCode(200)

    .body("data", equalTo(testString))
    .header("args", equalTo(null)) //thing is, there is no header like that, so ofk it'll be null
    .header("content-length", greaterThanOrEqualTo("10"))
    .header("Content-Type", equalTo("application/json; charset=utf-8"))
    .body("url", equalTo("https://postman-echo.com/post"));
    }
}
