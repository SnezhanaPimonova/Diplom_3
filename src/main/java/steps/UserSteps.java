package steps;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import user.User;
import user.UserCredentials;

import static io.restassured.RestAssured.given;

public class UserSteps extends RestClient {

    public static final String CREATE_USER_API = "api/auth/register";
    public static final String LOGIN_USER_API = "api/auth/login";
    public static final String DELETE_USER_API = "api/auth/user";

    @Step("Регистрация пользователя")
    public ValidatableResponse createUser(User user) {
        return given()
                .spec(getBaseSpec())
                .and()
                .body(user)
                .when()
                .post(CREATE_USER_API)
                .then();
    }

    @Step("Логин пользователя")
    public static ValidatableResponse loginUser(UserCredentials userCredentials) {
        return given()
                .spec(getBaseSpec())
                .and()
                .body(userCredentials)
                .when()
                .post(LOGIN_USER_API)
                .then();
    }

    @Step("Удаление пользователя")
    public static ValidatableResponse deleteUser(String accessToken) {
        return given()
                .spec(getBaseSpec())
                .headers("Authorization", accessToken)
                .when()
                .delete(DELETE_USER_API)
                .then();
    }


}
