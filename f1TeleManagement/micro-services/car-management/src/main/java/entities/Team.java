package entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Data
@Table(name = "teams")
@NoArgsConstructor
@AllArgsConstructor
public class Team {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    @Size(min = 4, max = 50, message = "Car name must be between 4 and 50 characters")
    private String name;

    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL)
    private List<Car> cars;

    @Column(name = "creation_date", nullable = false, updatable = false)
    private Timestamp creation_date;

    @Column(name = "last_update", nullable = false)
    private Timestamp last_update;

    @PrePersist
    public void prePersist() {
        this.creation_date = new Timestamp(System.currentTimeMillis());
        this.last_update = new Timestamp(System.currentTimeMillis());
    }

    @PreUpdate
    public void preUpdate() {
        this.last_update = new Timestamp(System.currentTimeMillis());
    }


}
