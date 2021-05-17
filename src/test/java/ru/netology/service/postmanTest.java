package ru.netology.service;

import static org.hamcrest.Matchers.equalTo;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;


public class postmanTest {
    @Test
    public void shouldPost(){
    // Given - When - Then
    // Предусловия
    given()
    .baseUri("https://postman-echo.com")
    .body("123 test me") // отправляемые данные (заголовки и query можно выставлять аналогично)
    // Выполняемые действия
    .when()
    .post("/post")
    // Проверки
    .then()
    .statusCode(200)

    .body("data", equalTo("123"));
    }
}
