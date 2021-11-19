package validTest.group;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.groups.Default;

/**
 * @date 2021/11/19
 */
@Data
public class UserGroup {

    @NotNull(groups = {GroupA.class})
    @Range(min = 1, max = 99, message = "在1-99之间", groups = {GroupA.class})
    private Integer id;

    @NotBlank(groups = {GroupB.class})
    @Length(min = 1, max = 5, message = "必须大于1小于5", groups = {GroupB.class})
    private String name;


    @NotBlank(groups = {Default.class})
    private String pwd;

}
