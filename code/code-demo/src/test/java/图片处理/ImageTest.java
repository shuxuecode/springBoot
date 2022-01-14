package 图片处理;

import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @date 2022/1/13
 */
public class ImageTest {


    @Test
    void t1() throws IOException {

        File file = new File("/tmp/tmpData/1.png");

        System.out.println(file.exists());

        BufferedImage image1 = getBufferedImage("/tmp/tmpData/1.png");
        BufferedImage image2 = getBufferedImage("/tmp/tmpData/2.png");

        BufferedImage image3 = mergeImage(image1, image2, true);

        saveBufferedImage(image3, "/tmp/tmpData/3.png");

        BufferedImage image4 = mergeImage(image1, image2, false);

        saveBufferedImage(image4, "/tmp/tmpData/4.png");


    }

    /**
     * 将图片转化为 BufferedImage 对象
     *
     * @param filePath
     * @return
     * @throws IOException
     */
    public static BufferedImage getBufferedImage(String filePath) throws IOException {
        File file = new File(filePath);
        return ImageIO.read(file);
    }

    /**
     * 保存图片
     *
     * @param bufferedImage
     * @param filePath
     */
    public static void saveBufferedImage(BufferedImage bufferedImage, String filePath) {

        try {
            File file = new File(filePath);
            if (!file.exists()) {
                file.createNewFile();
            }
            //String fileName = filePath.substring(filePath.lastIndexOf(File.separator) + 1, filePath.lastIndexOf(".")); 这个不对
            String fileName = filePath.substring(filePath.lastIndexOf(".") + 1);
            ImageIO.write(bufferedImage, fileName, file);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 待合并的两张图必须满足这样的前提，如果水平方向合并，则高度必须相等；如果是垂直方向合并，宽度必须相等。
     * mergeImage方法不做判断，自己判断。
     *
     * @param img1         待合并的第一张图
     * @param img2         带合并的第二张图
     * @param isHorizontal 为true时表示水平方向合并，为false时表示垂直方向合并
     * @return 返回合并后的BufferedImage对象
     * @throws IOException
     */
    public static BufferedImage mergeImage(BufferedImage img1, BufferedImage img2, boolean isHorizontal) throws IOException {
        int w1 = img1.getWidth();
        int h1 = img1.getHeight();
        int w2 = img2.getWidth();
        int h2 = img2.getHeight();

        // 从图片中读取RGB
        int[] ImageArrayOne = new int[w1 * h1];
        ImageArrayOne = img1.getRGB(0, 0, w1, h1, ImageArrayOne, 0, w1); // 逐行扫描图像中各个像素的RGB到数组中
        int[] ImageArrayTwo = new int[w2 * h2];
        ImageArrayTwo = img2.getRGB(0, 0, w2, h2, ImageArrayTwo, 0, w2);

        // 生成新图片
        BufferedImage DestImage = null;
        if (isHorizontal) { // 水平方向合并
            DestImage = new BufferedImage(w1 + w2, h1, BufferedImage.TYPE_INT_RGB);
            DestImage.setRGB(0, 0, w1, h1, ImageArrayOne, 0, w1); // 设置上半部分或左半部分的RGB
            DestImage.setRGB(w1, 0, w2, h2, ImageArrayTwo, 0, w2);
        } else { // 垂直方向合并
            DestImage = new BufferedImage(w1, h1 + h2, BufferedImage.TYPE_INT_RGB);
            DestImage.setRGB(0, 0, w1, h1, ImageArrayOne, 0, w1); // 设置上半部分或左半部分的RGB
            DestImage.setRGB(0, h1, w2, h2, ImageArrayTwo, 0, w2); // 设置下半部分的RGB
        }

        return DestImage;
    }

}
