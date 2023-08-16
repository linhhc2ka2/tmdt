package web.tmdt.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;

@Entity
@Table(name = "roles")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Role implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Roleid")
    private Integer categoryId;

    @Column(name = "Name")
    private String name;

    @Column(name = "Createat")
    private Date createAt = new Date();

    @Column(name = "Updateat")
    private Date updateAt = new Date();

    @JsonIgnore
    @OneToMany(mappedBy = "role")
    List<RoleUser> roleUser;
}
