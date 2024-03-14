package lk.ijse.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@Data

@Entity
@Table(name = "branch")
public class Branch {
    @Id
    @Column(name = "branch_id",length = 30)
    private String id;

    @Column(name = "branch_name")
    private String name;

    @Column(name = "branch_contact")
    private String contact;

    @Column(name = "branch_city")
    private String city;
}
