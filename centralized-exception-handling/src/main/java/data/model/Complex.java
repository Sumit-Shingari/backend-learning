package data.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "complex")
@Getter
@Setter
public class Complex {
 
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
     
    private String name;
     
    private String floors;
     
    private String yearBuild;
}
