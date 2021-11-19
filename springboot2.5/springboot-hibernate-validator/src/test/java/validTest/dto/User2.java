package validTest.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/**
 * @date 2021/11/19
 */
@Data
public class User2 {

    @NotNull
    private Integer id;

    @Length(min = 5, max = 10, message = "长度在5-10之间")
    private String name;

}
