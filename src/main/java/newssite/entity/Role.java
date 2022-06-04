package newssite.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import newssite.entity.enums.Permission;
import newssite.entity.template.AbstractEntity;

import javax.persistence.*;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Role extends AbstractEntity {

    @Column(unique = true, nullable = false)
    private String name; //ADMIN, USER, OTHER

    @ElementCollection
    @Enumerated(EnumType.STRING)
    private List<Permission> permissionList;

    @Column(columnDefinition = "text")
    private String description;



}
