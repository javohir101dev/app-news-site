package newssite.payload;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterDto {

    @NotNull(message = "FullName cannot be null")
    private String fullName;

    @NotNull(message = "Username cannot be null")
    private String username;

     @NotNull(message = "Password cannot be null")
    private String password;

     @NotNull(message = "PrePassword cannot be null")
    private String prePassword;

}
