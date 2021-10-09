package dubboTest.hession;

import java.io.Serializable;
import java.util.Date;

/**
 *
 */
public class ChildrenVO extends ParentVO implements Serializable {

    private Long childId;

    private String name;

    private Date birthday;

    // get set

    public Long getChildId() {
        return childId;
    }

    public void setChildId(Long childId) {
        this.childId = childId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
