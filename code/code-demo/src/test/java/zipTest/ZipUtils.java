package zipTest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * 压缩工具类
 * todo
 */
public class ZipUtils {

    private static final Logger log = LoggerFactory.getLogger(ZipUtils.class);

    public static void main(String[] args) {
    }

    /**
     * 将存放在sourceFilePath目录下的源文件，打包成fileName名称的zip文件，并存放到zipFilePath路径下
     *
     * @param sourceFilePath 待压缩的文件路径
     * @param zipFilePath    压缩后存放路径
     * @param fileName       压缩后文件的名称
     * @return
     */
    public static boolean folderToZip(String sourceFilePath, String zipFilePath, String fileName) {
        boolean flag = false;
        File sourceFile = new File(sourceFilePath);
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        FileOutputStream fos = null;
        ZipOutputStream zos = null;

        if (sourceFile.exists() == false) {
            log.info("待压缩的文件目录：" + sourceFilePath + "不存在.");
            return false;
        } else {
            try {
                File zipFile = new File(zipFilePath + "/" + fileName + ".zip");
                if (zipFile.exists()) {
                    log.info(zipFilePath + "目录下存在名字为:" + fileName + ".zip" + "打包文件.");
                    return false;
                } else {
                    File[] sourceFiles = sourceFile.listFiles();
                    if (null == sourceFiles || sourceFiles.length < 1) {
                        log.error("待压缩的文件目录：" + sourceFilePath + "里面不存在文件，无需压缩.");
                        return false;
                    } else {
                        try {
                            fos = new FileOutputStream(zipFile);
                        } catch (FileNotFoundException e) {
//                            e.printStackTrace();
                            log.error(e.getMessage());
                        } finally {
                            if (null != fos) {
                                fos.close();
                            }
                        }
                        try {
                            zos = new ZipOutputStream(new BufferedOutputStream(fos));
                        } catch (Exception e) {
//                            e.printStackTrace();
                            log.error(e.getMessage());
                        } finally {
                            if (null != zos) {
//                                zos.close();
                            }
                        }
                        byte[] bufs = new byte[1024 * 10];
                        for (int i = 0; i < sourceFiles.length; i++) {
                            // 创建ZIP实体，并添加进压缩包
                            ZipEntry zipEntry = new ZipEntry(sourceFiles[i].getName());
                            zos.putNextEntry(zipEntry);
                            // 读取待压缩的文件并写进压缩包里
                            try {
                                fis = new FileInputStream(sourceFiles[i]);
                            } catch (FileNotFoundException e) {
//                                e.printStackTrace();
                                log.error(e.getMessage());
                            } finally {
                                if (null != fis) {
                                    fis.close();
                                }
                            }
                            try {
                                bis = new BufferedInputStream(fis, 1024 * 10);
                            } catch (Exception e) {
//                                e.printStackTrace();
                                log.error(e.getMessage());
                            } finally {
                                if (null != bis) {
                                    bis.close();
                                }
                            }
                            int read = 0;
                            while ((read = bis.read(bufs, 0, 1024 * 10)) != -1) {
                                zos.write(bufs, 0, read);
                            }
                        }
                        flag = true;
                    }
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            } finally {
                // 关闭流
                try {
                    if (null != bis) {
                        bis.close();
                    }
                    if (null != zos) {
                        zos.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return flag;
    }

    /**
     * 将sourceFilePath文件，打包成fileName名称的zip文件，并存放到zipFilePath路径下
     *
     * @param sourceFilePath 待压缩的文件路径
     * @param zipFilePath    压缩后存放路径
     * @param fileName       压缩后文件的名称
     * @return
     */
    public static boolean fileToZip(String sourceFilePath, String zipFilePath, String fileName) {
        boolean flag = false;
        File sourceFile = new File(sourceFilePath);
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        FileOutputStream fos = null;
        ZipOutputStream zos = null;
        if (sourceFile.exists() == false) {
            log.info("待压缩的文件：" + sourceFilePath + "不存在.");
            return false;
        } else {
            try {
                File zipFile = new File(zipFilePath + "/" + fileName + ".zip");
                if (zipFile.exists()) {
                    log.info(zipFilePath + "目录下存在名字为:" + fileName + ".zip" + "打包文件.");
                    return false;
                } else {
                    try {
                        fos = new FileOutputStream(zipFile);
                    } catch (FileNotFoundException e) {
//                        e.printStackTrace();
                        log.error(e.getMessage());
                    } finally {
                        if (null != fos) {
                            fos.close();
                        }
                    }
                    try {
                        zos = new ZipOutputStream(new BufferedOutputStream(fos));
                    } catch (Exception e) {
//                        e.printStackTrace();
                        log.error(e.getMessage());
                    } finally {
                        if (null != zos) {
                            zos.close();
                        }
                    }
                    byte[] bufs = new byte[1024 * 10];
                    // 创建ZIP实体，并添加进压缩包
                    ZipEntry zipEntry = new ZipEntry(sourceFile.getName());
                    if (zos != null) {
                        zos.putNextEntry(zipEntry);
                    }
                    // 读取待压缩的文件并写进压缩包里
                    try {
                        fis = new FileInputStream(sourceFile);
                    } catch (FileNotFoundException e) {
//                        e.printStackTrace();
                        log.error(e.getMessage());
                    } finally {
                        if (null != fis) {
                            fis.close();
                        }
                    }
                    try {
                        bis = new BufferedInputStream(fis, 1024 * 10);
                    } catch (Exception e) {
//                        e.printStackTrace();
                        log.error(e.getMessage());
                    } finally {
                        if (null != bis) {
                            bis.close();
                        }
                    }
                    int read = 0;
                    if (bis != null) {
                        while ((read = bis.read(bufs, 0, 1024 * 10)) != -1) {
                            if (zos != null) {
                                zos.write(bufs, 0, read);
                            }
                        }
                    }
                    flag = true;
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            } finally {
                // 关闭流
                try {
                    if (null != bis) {
                        bis.close();
                    }
                    if (null != zos) {
                        zos.close();
                    }
                } catch (IOException e) {
//                    e.printStackTrace();
                    log.error(e.getMessage());
                }
            }
        }
        return flag;
    }

    /**
     * 将流的内容打包成fileName名称的zip文件，并存放到zipFilePath路径下
     *
     * @param streamfilename 待压缩的文件路径
     * @param zipFilePath    压缩后存放路径
     * @param fileName       压缩后文件的名称
     * @return
     */
    public static boolean streamToZip(InputStream fis, String streamfilename, String zipFilePath, String fileName) {
        boolean flag = false;
        BufferedInputStream bis = null;
        FileOutputStream fos = null;
        ZipOutputStream zos = null;
        try {
            File zipFile = new File(zipFilePath + "/" + fileName + ".zip");
            if (zipFile.exists()) {
                log.info(zipFilePath + "目录下存在名字为:" + fileName + ".zip" + "打包文件.");
                return false;
            } else {
                try {
                    fos = new FileOutputStream(zipFile);
                } catch (FileNotFoundException e) {
//                    e.printStackTrace();
                    log.error(e.getMessage());
                } finally {
                    if (null != fos) {
                        fos.close();
                    }
                }
                try {
                    zos = new ZipOutputStream(new BufferedOutputStream(fos));
                } catch (Exception e) {
//                    e.printStackTrace();
                    log.error(e.getMessage());
                } finally {
                    if (null != zos) {
                        zos.close();
                    }
                }
                byte[] bufs = new byte[1024 * 10];
                // 创建ZIP实体，并添加进压缩包
                ZipEntry zipEntry = new ZipEntry(streamfilename);
                if (zos != null) {
                    zos.putNextEntry(zipEntry);
                }
                // 读取待压缩的文件并写进压缩包里
                bis = new BufferedInputStream(fis, 1024 * 10);
                int read = 0;
                while ((read = bis.read(bufs, 0, 1024 * 10)) != -1) {
                    if (zos != null) {
                        zos.write(bufs, 0, read);
                    }
                }
                flag = true;
            }
            if (zos != null) {
                zos.close();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            // 关闭流
            try {
                if (null != bis) {
                    bis.close();
                }
                if (null != zos) {
                    zos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return flag;
    }

    /**
     * 将流转成zip文件输出
     *
     * @param inputstream    文件流
     * @param streamfilename 流文件的名称
     * @param fileName       zip包的名称
     * @param response
     * @return
     */
    public static boolean streamToZipStream(InputStream inputstream, String streamfilename, String fileName,
                                            HttpServletResponse response) {
        boolean flag = false;
        BufferedInputStream bis = null;
        FileOutputStream fos = null;
        ZipOutputStream zos = null;
        OutputStream out = null;
        try {
            out = response.getOutputStream();
            response.reset();
            response.setHeader("Content-Disposition",
                    "attachment;filename=" + new String(fileName.getBytes("GB2312"), "ISO-8859-1"));
            response.setContentType("application/octet-stream; charset=utf-8");
            response.setCharacterEncoding("UTF-8");
            zos = new ZipOutputStream(out);
            byte[] bufs = new byte[1024 * 10];
            // 创建ZIP实体，并添加进压缩包
            ZipEntry zipEntry = new ZipEntry(streamfilename);
            zos.putNextEntry(zipEntry);
            // 读取待压缩的文件并写进压缩包里
            bis = new BufferedInputStream(inputstream, 1024 * 10);
            int read = 0;
            while ((read = bis.read(bufs, 0, 1024 * 10)) != -1) {
                zos.write(bufs, 0, read);
            }
            flag = true;
            zos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            // 关闭流
            try {
                if (null != bis) {
                    bis.close();
                }
                if (null != zos) {
                    zos.close();
                }
                if (null != out) {
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return flag;
    }

}
