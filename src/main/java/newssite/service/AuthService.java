package newssite.service;

import newssite.ResourceNotFoundException;
import newssite.entity.User;
import newssite.payload.ApiResponse;
import newssite.payload.RegisterDto;
import newssite.repo.RoleRepository;
import newssite.repo.UserRepository;
import newssite.utils.AppConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    public ApiResponse registerUser(RegisterDto registerDto) {
        if (!registerDto.getPassword().equals(registerDto.getPrePassword())) {
            return new ApiResponse(
                    String.format("Password: %s is not mismatch to %s",
                            registerDto.getPassword(), registerDto.getPrePassword())
                    , false);
        }

        boolean existsByUsername = userRepository.existsByUsername(registerDto.getUsername());
        if (existsByUsername) {
            return new ApiResponse(
                    String.format("This username : %s is  already taken", registerDto.getUsername())
                    , false);
        }

        User user = new User(
                registerDto.getFullName(),
                registerDto.getUsername(),
                passwordEncoder.encode(registerDto.getPassword()),
                roleRepository.findByName(AppConstants.USER).orElseThrow(
                        () -> new ResourceNotFoundException("Lavozim", "Name", AppConstants.USER)),
                true
        );
        userRepository.save(user);
        return new ApiResponse("You have been registered successfully", true);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optionalUser = userRepository.findByUsername(username);
        return optionalUser.orElseThrow(
                () -> new UsernameNotFoundException(
                        String.format("User with username %s is not found", username)
                )
        );
    }
}
