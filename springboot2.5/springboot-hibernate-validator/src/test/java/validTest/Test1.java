package validTest;

import org.hibernate.validator.HibernateValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import validTest.dto.User1;
import validTest.group.GroupA;
import validTest.group.GroupB;
import validTest.group.GroupOrder;
import validTest.group.UserGroup;
import validTest.myvalid.Demo;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

/**
 * @date 2021/11/19
 */
public class Test1 {


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

        User1 user1 = new User1();
        user1.setId(1);
        user1.setName("123456");

        Set<ConstraintViolation<User1>> validate = validator.validate(user1);
        System.out.println(validate.size());
        for (ConstraintViolation<User1> violation : validate) {
            System.out.println(violation.getMessage());
        }

    }


    @Test
    void t2() {
        UserGroup userGroup = new UserGroup();

        Set<ConstraintViolation<UserGroup>> validate = validator.validate(userGroup, GroupA.class, GroupB.class);
        System.out.println(validate.size());
        for (ConstraintViolation<UserGroup> violation : validate) {
            System.out.println(violation.getMessage());
        }
    }

    @Test
    void t3() {
        UserGroup userGroup = new UserGroup();
        userGroup.setId(1);

        Set<ConstraintViolation<UserGroup>> validate = validator.validate(userGroup, GroupOrder.class);
        System.out.println(validate.size());
        for (ConstraintViolation<UserGroup> violation : validate) {
            System.out.println(violation.getMessage());
        }
    }

    @Test
    void t4() {
        Demo demo = new Demo();
        demo.setName("z"); // 验证不通过
        demo.setName("zhao"); // 验证通过

        Set<ConstraintViolation<Demo>> validate = validator.validate(demo);
        System.out.println(validate.size());
        for (ConstraintViolation<Demo> violation : validate) {
            System.out.println(violation.getMessage());
        }
    }
}
