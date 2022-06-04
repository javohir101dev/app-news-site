package newssite.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import newssite.entity.enums.Permission;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleDto {

    @NotBlank(message = "Name cannot be null or blank")  // checks not null and empty string also
    private String name;
    private String description;

    @NotEmpty(message = "permissionList cannot be null")
    private List<Permission> permissionList;
}
