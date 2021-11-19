## 引入相关jar

```xml

<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-validation</artifactId>
</dependency>
```

> 注意：新版的spring-boot-starter-web包里面已经不包含hibernate-validator包了

## hibernate的校验模式

### 普通模式（默认是这个模式）

普通模式(会校验完所有的属性，然后返回所有的验证失败信息)

### 快速失败返回模式

快速失败返回模式(只要有一个验证失败，则返回)

```
ValidatorFactory validatorFactory = Validation.byProvider(HibernateValidator.class)
        .configure()
        .failFast( true )
        .buildValidatorFactory();
Validator validator = validatorFactory.getValidator();
```

## 注解

### 对象增加验证注解

```java
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class User {

    @NotNull
    private Integer id;

    @NotBlank(message = "用户名不能为空")
    private String username;

    @Email(message = "邮箱格式错误")
    private String email;

    @NotBlank(message = "手机号不能为空")
    private String elephone;

    private Date birthday;
}
```

还可以用正则表达式

@Pattern(regexp="^[0-9]{4}-[0-9]{2}-[0-9]{2}$",message="出生日期格式不正确")

## 对象级联校验

对象内部包含另一个对象作为属性，属性上加@Valid，可以验证作为属性的对象内部的验证

```java

@Data
public class User1 {

    @NotNull
    private Integer id;

    @Length(min = 5, max = 10, message = "长度在5-10之间")
    private String name;

    @Valid
    @NotNull // 必须加该注解才行
    private User2 user2;

}
```

## 指定分组验证

利用分组，可以指定字段进行校验，在一些特殊场景可以用到，例如：新增时不需要校验主键id是否为空，但修改时必须校验主键id不为空

```java

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
```

**注意：要用的注解逻辑一定要单独加上groups配置**

## 指定验证顺序

指定组的验证顺序，前面组验证不通过的，后面组不进行验证

```java

@GroupSequence({GroupA.class, GroupB.class, Default.class})
public interface GroupOrder {
}
```

## 自定义验证器

### 创建注解

```java

@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = MyValidator.class) // 指定
@Documented
public @interface EqualsZhao {

    String message() default "";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String value();
}
```


### 创建验证器

```java
public class MyValidator implements ConstraintValidator<EqualsZhao, String> {
    private String val;

    @Override
    public void initialize(EqualsZhao constraintAnnotation) {
        this.val = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }
        if (val == null) {
            return false;
        }
        return value.equals(val);
    }
}
```


## 常用注解

- @Null   被注释的元素必须为 null     
- @NotNull    被注释的元素必须不为 null     
- @AssertTrue     被注释的元素必须为 true     
- @AssertFalse    被注释的元素必须为 false     
- @Min(value)     被注释的元素必须是一个数字，其值必须大于等于指定的最小值     
- @Max(value)     被注释的元素必须是一个数字，其值必须小于等于指定的最大值     
- @DecimalMin(value)  被注释的元素必须是一个数字，其值必须大于等于指定的最小值     
- @DecimalMax(value)  被注释的元素必须是一个数字，其值必须小于等于指定的最大值     
- @Size(max=, min=)   被注释的元素的大小必须在指定的范围内     
- @Digits (integer, fraction)     被注释的元素必须是一个数字，其值必须在可接受的范围内     
- @Past   被注释的元素必须是一个过去的日期     
- @Future     被注释的元素必须是一个将来的日期     
- @Pattern(regex=,flag=)  被注释的元素必须符合指定的正则表达式     
- Hibernate Validator 附加的 constraint     
- @NotBlank(message =)   验证字符串非null，且长度必须大于0     
- @Email  被注释的元素必须是电子邮箱地址     
- @Length(min=,max=)  被注释的字符串的大小必须在指定的范围内     
- @NotEmpty   被注释的字符串的必须非空     
- @Range(min=,max=,message=)  被注释的元素必须在合适的范围内

---

参考文章：

https://www.cnblogs.com/mr-yang-localhost/p/7812038.html

http://docs.jboss.org/hibernate/validator/4.2/reference/zh-CN/html_single/#validator-gettingstarted