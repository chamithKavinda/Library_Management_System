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

    @ManyToOne
    @JoinColumn(name = "book_id",nullable = false)
    private Books id;

    @ManyToOne
    @JoinColumn(name = "user_email",nullable = false)
    private User email;

    @Column(name = "return_date")
    private String returnDate ;

    @CreationTimestamp
    @Column(name = "borrow_date_time")
    private Timestamp BorrowDateTime;


    public Records(String returnDate, Books id, User email) {
        this.returnDate = returnDate;
        this.id = id;
        this.email = email;
    }
}
