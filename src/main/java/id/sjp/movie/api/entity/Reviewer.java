package id.sjp.movie.api.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.*;


@Entity
@Table(schema = "public", name = "reviewer")
@Where(clause = "is_deleted = false")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Reviewer extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private Integer age;
}
