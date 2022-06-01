package newssite.service;

import newssite.entity.User;
import newssite.payload.ApiResponse;
import newssite.payload.RegisterDto;
import newssite.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    UserRepository userRepository;

    public ApiResponse registerUser(RegisterDto registerDto) {
        boolean existsByUsername = userRepository.existsByUsername(registerDto.getUsername());

        if (existsByUsername){
            return new ApiResponse(
                    String.format("This username : %s is  already taken", registerDto.getUsername())
                    , false);
        }

        User user = new User(
                registerDto.getFullName(),
                 null,

        )


        return null;
    }
}
