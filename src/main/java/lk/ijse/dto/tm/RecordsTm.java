package lk.ijse.dto.tm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RecordsTm {
    private int t_id;
    private String returnDate ;
    private Timestamp BorrowDateTime;

    private String id;

    private String email;
}
