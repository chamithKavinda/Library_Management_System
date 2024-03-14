package lk.ijse.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data

@Entity
@Table(name = "books")
public class Books {
    @Id
    @Column(name = "book_id" ,length = 30)
    private String id;

    @Column(name = "title")
    private String title;

    @Column(name = "author")
    private String author;

    @Column(name = "genre")
    private String genre;

    @Column(name = "status")
    private String status;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "id")
    private List<Records> bookTransactions = new ArrayList<>();

    public Books(String id, String title, String author, String genre, String status) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.status = status;
    }
}
