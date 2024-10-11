package practices.baitap0710.com.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String description;

}
