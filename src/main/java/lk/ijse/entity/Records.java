package lk.ijse.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "records")
public class Records {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id")
    private int t_id;

    @Column(name = "return_date")
    private String returnDate ;

    @CreationTimestamp
    @Column(name = "borrow_date_time")
    private Timestamp BorrowDateTime;

    @ManyToOne
    @JoinColumn(name = "book_id",nullable = false)
    private String id;

    @ManyToOne
    @JoinColumn(name = "user_email",nullable = false)
    private String email;

}
