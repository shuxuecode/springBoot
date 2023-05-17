package com.zsx.springboot2711;

import com.github.liaochong.myexcel.core.DefaultExcelBuilder;
import com.github.liaochong.myexcel.core.DefaultStreamExcelBuilder;
import com.github.liaochong.myexcel.utils.FileExportUtil;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;

/**
 * @date 2023/5/16
 */
public class Test {


    @org.junit.jupiter.api.Test
    void t1() throws IOException {
//        DefaultStreamExcelBuilder<Map> builder = DefaultStreamExcelBuilder.of(Map.class)
//                .threadPool(Executors.newFixedThreadPool(10))
//                .capacity(10_000)
//                .start();

        List<Map> list = new ArrayList<>();

        HashMap<String, String> map = new HashMap<>();
        map.put("a", "1");
        map.put("b", "2");
        map.put("c", "3");

        list.add(map);

        Workbook workbook = DefaultExcelBuilder.of(Map.class)
                .build(list);

        FileExportUtil.export(workbook, new File("./test.xlsx"));

    }


}
