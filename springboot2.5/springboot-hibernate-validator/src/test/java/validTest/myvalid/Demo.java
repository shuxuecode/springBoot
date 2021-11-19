package validTest.myvalid;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @date 2021/11/19
 */
@Data
public class Demo {

    @NotNull
    @EqualsZhao(value = "zhao", message = "必须等于")
    private String name;

}
