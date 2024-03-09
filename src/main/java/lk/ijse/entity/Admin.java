package lk.ijse.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data

@Entity
@Table(name = "admin")
public class Admin {

    @Id
    @Column(name = "admin_id", length = 30)
    private String id;

    @Column(name = "admin_name")
    private String name;

    @Column(name = "admin_email")
    private String email;

    @Column(name = "admin_password")
    private String password;

}
