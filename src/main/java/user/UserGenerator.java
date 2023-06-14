package user;

import org.apache.commons.lang3.RandomStringUtils;

public class UserGenerator {
    String name = RandomStringUtils.randomAlphabetic(7);
    String email = RandomStringUtils.randomAlphabetic(7) + "@mail.ru";
    String password = RandomStringUtils.randomAlphabetic(7);

    public User getRandomUser() {
        return new User(name, email, password);
    }

    public User getRandomUserWithIncorrectPassword() {
        return new User(name, email, RandomStringUtils.randomAlphabetic(5));
    }
}
