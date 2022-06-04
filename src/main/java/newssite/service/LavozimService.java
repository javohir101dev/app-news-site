package newssite.service;

import newssite.entity.Role;
import newssite.payload.ApiResponse;
import newssite.payload.RoleDto;
import newssite.repo.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LavozimService {
    @Autowired
    RoleRepository roleRepository;

    public ApiResponse addlavozim(RoleDto roleDto) {
        boolean existsByName = roleRepository.existsByName(roleDto.getName());
        if (existsByName){
            return new ApiResponse(String
                    .format("Role with name %s is already exists", roleDto.getName()), false);
        }
        Role role = new Role(roleDto.getName(), roleDto.getPermissionList(), roleDto.getDescription());
        roleRepository.save(role);
        return new ApiResponse(
                "Role is saved", true);
    }
}
