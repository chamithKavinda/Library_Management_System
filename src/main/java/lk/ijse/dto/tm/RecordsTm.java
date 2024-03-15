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
    private String id;
    private String email;
    private String returnDate ;
    private String BorrowDateTime;






}
