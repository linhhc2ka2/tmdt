package web.tmdt.models;

import java.io.Serializable;

import javax.persistence.*;

import lombok.*;

@Entity
@Table(name = "roleuser")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RoleUser implements Serializable {
    @Id
    @Column(name = "Roleuserid")
    private Integer roleUserId;

    @ManyToOne
    @JoinColumn(name = "Roleid")
    Role role;

    @ManyToOne
    @JoinColumn(name = "Userid")
    User user;
}
