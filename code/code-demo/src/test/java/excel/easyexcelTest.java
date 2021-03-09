package excel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.read.builder.ExcelReaderBuilder;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.alibaba.excel.write.ExcelBuilder;
import com.alibaba.excel.write.metadata.WriteSheet;

public class easyexcelTest {

    public static void main(String[] args) {


//        EasyExcel
//        ExcelReaderBuilder readerBuilder = EasyExcel.read();


//        EasyExcel.read("");


        ExcelWriter excelWriter = EasyExcel.write("test.xlsx").excelType(ExcelTypeEnum.XLSX).build();

        WriteSheet sheet = new WriteSheet();
        sheet.setSheetName("demo");

        excelWriter.write(null, sheet);

        excelWriter.finish();

    }
}
