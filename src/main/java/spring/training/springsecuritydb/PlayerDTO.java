package spring.training.springsecuritydb;

import com.sun.istack.NotNull;
import lombok.Data;

@Data
public class PlayerDTO {

    @NotNull
    private String email;

    @NotNull
    private String password;
    private String matchingPassword;
}
