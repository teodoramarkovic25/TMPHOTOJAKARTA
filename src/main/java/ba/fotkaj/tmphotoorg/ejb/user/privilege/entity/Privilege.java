package ba.fotkaj.tmphotoorg.ejb.user.privilege.entity;

import ba.fotkaj.tmphotoorg.ejb.user.entity.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "privilege")
public class Privilege implements Serializable {


    public static final Integer CLIENT_PRIVILEGE_ID = 1;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;


    @Size(max = 45)
    @Basic(optional = false)
    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "privilege")
    private List<User> userList;

    public Privilege() {
    }

    public Privilege(Integer id, String name, List<User> userList) {
        this.id = id;
        this.name = name;
        this.userList = userList;
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

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Privilege privilege = (Privilege) o;

        return id.equals(privilege.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return name + "[" + id + "]";
    }
}
