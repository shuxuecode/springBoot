package zipTest;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import org.joda.time.DateTime;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @author zhaoshuxue3
 * @Date 2019/4/16 19:02
 **/
public class ZipTest {

    // 缓冲区大小
    private static final int BUFFER = 2048;
    // 字符集
    private static final String CHAR_SET = "GBK";

    public static void main(String[] args) throws Exception {
//        test();
//        test2();

        zip("D:/2/", "D:/2/", "test.zip");
    }

    public static List<String> getFileList(String sourceFilePath) {
        ArrayList<String> fileNameList = Lists.newArrayList();

//        String sourceFilePath = "D:/2/";
        File sourceFile = new File(sourceFilePath);

        if (!sourceFile.exists()) {
            System.out.println("目录不存在");
            return fileNameList;
        }

        File[] files = sourceFile.listFiles();
        if (files == null || files.length == 0) {
            System.out.println("目录下没有任何文件");
            return fileNameList;
        }

        for (File file : files) {
            System.out.println(file.getName());
            getFile(file, "", fileNameList);
        }

        System.out.println(JSON.toJSONString(fileNameList, true));
        return fileNameList;
    }

    public static void getFile(File file, String path, List<String> fileNameList) {
        String fileName = file.getName();
        if (file.isDirectory()) {
//            fileName;
            File[] files = file.listFiles();
            for (File subFile : files) {
                getFile(subFile, path + fileName + "/", fileNameList);
            }
        } else {
            fileNameList.add(path + fileName);
        }
    }


    public static void test() throws IOException {

        String rootPath = new File("").getAbsolutePath();
        String zipFile = rootPath + "/src/test/java/zipTest/" + "a.zip";
        String file1 = rootPath + "/src/test/java/zipTest/" + "1.txt";
        String file2 = rootPath + "/src/test/java/zipTest/" + "2.txt";

        System.out.println(new File("").getAbsolutePath());

        FileOutputStream fos = new FileOutputStream(new File(zipFile));
        ZipOutputStream zipOutputStream = new ZipOutputStream(fos);

        ZipEntry zipEntry = new ZipEntry(file1);
        zipOutputStream.putNextEntry(zipEntry);

        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(new File(file1)));

        int count = 0;
        byte[] bytes = new byte[BUFFER];
        while ((count = bis.read(bytes, 0, BUFFER)) != -1) {
            zipOutputStream.write(bytes, 0, count);
        }

        bis.close();
        zipOutputStream.closeEntry();

        // 冲刷输出流
        zipOutputStream.flush();
        // 关闭输出流
        zipOutputStream.close();
    }


    public static void test2() throws IOException {
        String rootPath = "D:/2/";
        // 目标
        ArrayList<String> files = Lists.newArrayList("1/1.txt", "2.txt", "3.txt");
        // 结果文件
        String zipFile = rootPath + "test.zip";

        ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(new File(zipFile)));
        BufferedInputStream bis = null;
        for (String file : files) {
            ZipEntry zipEntry = new ZipEntry(file);
            zipOutputStream.putNextEntry(zipEntry);

            bis = new BufferedInputStream(new FileInputStream(new File(rootPath + file)));

            int count = 0;
            byte[] bytes = new byte[BUFFER];
            while ((count = bis.read(bytes, 0, BUFFER)) != -1) {
                zipOutputStream.write(bytes, 0, count);
            }
        }

        bis.close();
        zipOutputStream.closeEntry();

        // 冲刷输出流
        zipOutputStream.flush();
        // 关闭输出流
        zipOutputStream.close();
    }


    public static void zip(String rootPath, String zipPath, String zipFileName) throws IOException {

        List<String> fileList = getFileList(rootPath);
        if (fileList == null || fileList.size() == 0) {
            return;
        }

        // 结果文件
        String zipFile = zipPath + zipFileName;

        ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(new File(zipFile)));
        BufferedInputStream bis = null;
        for (String file : fileList) {
            ZipEntry zipEntry = new ZipEntry(file);
            zipOutputStream.putNextEntry(zipEntry);

            bis = new BufferedInputStream(new FileInputStream(new File(rootPath + file)));

            int count = 0;
            byte[] bytes = new byte[BUFFER];
            while ((count = bis.read(bytes, 0, BUFFER)) != -1) {
                zipOutputStream.write(bytes, 0, count);
            }
        }

        bis.close();
        zipOutputStream.closeEntry();

        // 冲刷输出流
        zipOutputStream.flush();
        // 关闭输出流
        zipOutputStream.close();

        System.out.println("压缩完成");
    }
}
