package lk.ijse.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BooksDto {
    private String id;

    private String title;

    private String author;

    private String genre;

    private String status;
}
