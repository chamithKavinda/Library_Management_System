package lk.ijse.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RecordsDto {
    private int t_id;
    private String returnDate ;
    private Timestamp BorrowDateTime;

    private String id;

    private String email;
}
