package web.tmdt.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;

@Entity
@Table(name = "services")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Service implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Serviceid")
    private Integer serviceId;

    @Column(name = "Name")
    private String name;

    @Column(name = "Description")
    private String description;

    @JsonIgnore
    @OneToMany(mappedBy = "service")
    List<Product> product;
}
