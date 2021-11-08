import com.alibaba.fastjson.JSON;
import com.zsx.App;
import com.zsx.dao.UserDao;
import com.zsx.po.TUser;
import com.zsx.service.DemoService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @date 2021/11/8
 */
@SpringBootTest(classes = {App.class})
public class UnitTest {

    @Resource
    UserDao userDao;

    @Resource
    DemoService demoService;

    @Test void t2(){
        System.out.println(JSON.toJSONString(demoService.list()));
    }

    @Test void t1(){
        List<TUser> list = userDao.getAll();
        System.out.println(JSON.toJSONString(list));
    }
}
