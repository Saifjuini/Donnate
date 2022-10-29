package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="USERS")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID")
    private long id ;

    @Column(name="PASSWORD")
    private String password;
    @Column(name="FIRSTNAME")
    private String firstName ;
    @Column(name="LASTNAME")
    private String lastName ;
    @Column(name="EMAIL")
    private String email ;
    @Column(name="COUNTRY")
    private String country ;

    public User(long id) {
        this.id = id;
    }


}
