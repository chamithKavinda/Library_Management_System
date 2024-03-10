package lk.ijse.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
@Table(name = "user")
public class User {

    @Column(name = "user_name")
    private String name;

    @Id
    @Column(name = "user_email" , length = 30)
    private String email;

    @Column(name = "user_password")
    private String password;
}
