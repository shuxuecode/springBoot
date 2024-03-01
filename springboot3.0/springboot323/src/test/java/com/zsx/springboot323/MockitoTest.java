package com.zsx.springboot323;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @date 2024/3/1
 */
@SpringBootTest
public class MockitoTest {


    @Test
    void t1() {
        // 创建模拟对象
        List mockedList = Mockito.mock(List.class);
        // 配置模拟对象的行为，即当某个方法被调用时模拟对象的行为
        Mockito.when(mockedList.get(0)).thenReturn("first");
        // 对模拟对象进行测试
        System.out.println(mockedList.get(0));

        // 验证
        Mockito.verify(mockedList).get(0);

    }


}
