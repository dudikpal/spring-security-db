package spring.training.springsecuritydb;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncoderTest {

    @Test
    void testEncode() {
        System.out.println(new BCryptPasswordEncoder().encode("pass2"));
    }

}
