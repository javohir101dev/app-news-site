package newssite.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import newssite.entity.enums.Huquq;
import newssite.entity.template.AbstractEntity;

import javax.persistence.*;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Lavozim extends AbstractEntity {

    private String name; //ADMIN, USER, OTHER

    @ElementCollection
    private List<Huquq> huquqList;



}
