package validTest.group;

import javax.validation.GroupSequence;
import javax.validation.groups.Default;

/**
 * 验证顺序
 *
 * @date 2021/11/19
 */
@GroupSequence({GroupA.class, GroupB.class, Default.class})
public interface GroupOrder {
}
