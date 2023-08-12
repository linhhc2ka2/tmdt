package web.tmdt.models;

import java.io.Serializable;

import javax.persistence.*;

import lombok.*;

@Entity
@Table(name = "banners")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Banner implements Serializable {
    @Id
    @Column(name = "Bannerid")
    private Integer bannerId;

    @Column(name = "Image")
    private String image;

    @ManyToOne
    @JoinColumn(name = "Userid")
    User user;
}
