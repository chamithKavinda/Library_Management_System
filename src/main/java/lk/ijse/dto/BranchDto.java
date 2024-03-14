package lk.ijse.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BranchDto {
    private String id;

    private String name;

    private String contact;

    private String city;
}
