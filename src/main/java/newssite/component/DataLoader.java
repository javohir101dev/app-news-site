package newssite.component;

import newssite.entity.Role;
import newssite.entity.User;
import newssite.repo.RoleRepository;
import newssite.repo.UserRepository;
import newssite.utils.AppConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;

import static newssite.entity.enums.Permission.*;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Value("${spring.sql.init.mode}")
    private String runModeType;

    @Override
    public void run(String... args) throws Exception {

        if (runModeType.equals("always")){

            Role adminRole = new Role(
                    AppConstants.ADMIN,
                    Arrays.asList(values()),
                    "Admin is owner of system"
            );

            Role userRole = new Role(
                    AppConstants.USER,
                    Arrays.asList(
                            ADD_COMMENT,
                            EDIT_COMMENT,
                            DELETE_MY_COMMENT
                    ),
                    "Simple client"
            );
            roleRepository.save(adminRole);
            roleRepository.save(userRole);

            userRepository.save(new User(
                    "Admin",
                    "admin",
                    passwordEncoder.encode("123"),
                    adminRole,
                    true
            ));

            userRepository.save(new User(
                    "User",
                    "user",
                    passwordEncoder.encode("123"),
                    userRole,
                    true
            ));
        }

    }
}
