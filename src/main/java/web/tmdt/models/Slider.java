package web.tmdt.models;

import java.io.Serializable;

import javax.persistence.*;

import lombok.*;

@Entity
@Table(name = "slides")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Slider implements Serializable {
    @Id
    @Column(name = "Slideid")
    private Integer bannerId;

    @Column(name = "Image")
    private String image;

    @ManyToOne
    @JoinColumn(name = "Userid")
    User user;
}