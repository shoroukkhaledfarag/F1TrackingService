package entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.sql.Timestamp;

@Entity
@Data
@Table(name = "cars")
@NoArgsConstructor
@AllArgsConstructor
public class Car {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    @Size(min = 4, max = 50, message = "Car name must be between 4 and 50 characters")
    private String name;

    @Column(name = "car_number", nullable = false)
    private Integer carNumber;

    @Column(name = "season", nullable = false)
    private Integer season;

    @Column(name = "creation_date", nullable = false, updatable = false)
    private Timestamp creation_date;

    @Column(name = "last_maintenance", nullable = false)
    private Timestamp last_maintenance;

    @Column(name = "last_upgrade", nullable = false)
    private Timestamp last_upgrade;

    @Column(name = "last_update", nullable = false)
    private Timestamp last_update;

    @ManyToOne
    @JoinColumn(name = "team_id", referencedColumnName = "id")
    private Team team;


    @PrePersist
    public void prePersist() {
        this.creation_date = new Timestamp(System.currentTimeMillis());
        this.last_maintenance = new Timestamp(System.currentTimeMillis());
        this.last_upgrade = new Timestamp(System.currentTimeMillis());
        this.last_update = new Timestamp(System.currentTimeMillis());
    }

    @PreUpdate
    public void preUpdate() {
        this.last_update = new Timestamp(System.currentTimeMillis());
    }



}
