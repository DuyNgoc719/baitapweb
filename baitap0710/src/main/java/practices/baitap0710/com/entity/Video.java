package practices.baitap0710.com.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table
@Data
public class Video {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;
    private String description;
    private String author;

    @ManyToOne
    @JoinColumn(name ="category_id")
    private Category category;
}
