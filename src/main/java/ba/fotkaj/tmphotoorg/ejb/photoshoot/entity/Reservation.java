package ba.fotkaj.tmphotoorg.ejb.photoshoot.entity;

import ba.fotkaj.tmphotoorg.ejb.user.entity.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.util.Date;
@Entity
@Table(name = "reservatons")
@NamedQueries({

        @NamedQuery(name = "Reservation.findByUserCreator", query = "SELECT c FROM Reservation c WHERE c.userCreator=: userCreator")
}
)
public class Reservation implements Serializable {


    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "name")
    private String name;


    @Basic(optional = false)
    @NotNull
    @Column(name = "service_date")
    @Temporal(TemporalType.DATE)
    private Date reservationDate;

@JoinColumn(name = "user_id", referencedColumnName = "id")
@ManyToOne(optional = false)
    private User userCreator;



    public Reservation() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(Date reservationDate) {
        this.reservationDate = reservationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Reservation that = (Reservation) o;

        return id != null ? id.equals(that.id) : that.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
