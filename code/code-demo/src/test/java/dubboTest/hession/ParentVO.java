package dubboTest.hession;

import java.io.Serializable;
import java.util.Date;

/**
 */
public class ParentVO implements Serializable {

    private Long id;

    private String name;

    private Integer age;

    private Date birthday;

    // get set

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
