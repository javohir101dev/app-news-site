package newssite.payload;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginDto {

    @NotNull(message = "Username cannot be null")
    private String username;

     @NotNull(message = "Password cannot be null")
    private String password;
}
