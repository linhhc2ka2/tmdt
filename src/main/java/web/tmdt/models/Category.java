package web.tmdt.models;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;

@Entity
@Table(name = "categories")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Category {
    @Id
    @Column(name = "Categoryid")
    private Integer categoryId;

    @Column(name = "Name")
    private String name;

    @Column(name = "Description")
    private String description;

    @JsonIgnore
    @OneToMany(mappedBy = "category")
    List<Product> product;
}
