package com.zsx.springboot323;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

/**
 * @date 2024/3/1
 */
public class UnitTest {


    @Mock
    List mockedList;


    @BeforeEach
    public void before() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    void t1() {
        mockedList.add("one");
    }


}
