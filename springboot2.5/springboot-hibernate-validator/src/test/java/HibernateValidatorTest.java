import com.zsx.demo.po.User;
import org.hibernate.validator.HibernateValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.validation.ValidationUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

/**
 * @date 2021/11/10
 */
public class HibernateValidatorTest {


    Validator validator;

    @BeforeEach
    public void before() {
        ValidatorFactory validatorFactory = Validation.byProvider(HibernateValidator.class)
                .configure()
                //.failFast(true)
                .buildValidatorFactory();
        validator = validatorFactory.getValidator();
    }

    @Test
    void t1() {
        User user = new User();

        Set<ConstraintViolation<User>> validateResult = validator.validate(user);

        for (ConstraintViolation<User> violation : validateResult) {
            System.out.println(violation.getMessage());
        }

    }


}
