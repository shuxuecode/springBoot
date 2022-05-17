package unittest;

import com.example.springboot270.dto.UserDto;
import com.example.springboot270.entity.User;
import com.example.springboot270.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

/**
 * @author
 * @date 2022/5/17
 */
public class UnitTest {

    @Test
    void t1() {

        User user = new User();
        user.setId(10);
        user.setName("test");

        UserMapper mapper = Mappers.getMapper(UserMapper.class);

        UserDto userDto = mapper.userToUserDto(user);
        System.out.println(userDto);

    }
}
