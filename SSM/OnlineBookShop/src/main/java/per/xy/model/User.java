package per.xy.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@ToString
public class User {
    private Long userId;

    private String userName;

    private String userPwd;

    private Integer userType;
}