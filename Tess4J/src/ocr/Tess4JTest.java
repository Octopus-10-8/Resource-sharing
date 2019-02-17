package ocr;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import java.io.File;
import java.io.IOException;

/**
 * Tess4J图片识别工具类
 */
public class Tess4JTest {

    public static void main(String[] args) {

        test4JImages("F:\\JavaEE\\test","text.png");
    }

    /**
     *
     * @param projectPath  项目绝对地址
     * @param fileName     文件名称
     */
    public static void test4JImages(String projectPath, String fileName) {
        String path = projectPath;
        File file = new File(path + "\\" + fileName);
        ITesseract instance = new Tesseract();
        //获取项目根路径
        File directory = new File(path);
        String courseFile = null;
        try {
            courseFile = directory.getCanonicalPath();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //设置训练库的位置
        instance.setDatapath(courseFile + "\\tessdata");
        //设置语言
        instance.setLanguage("chi_sim");
        String result = null;
        try {
            long startTime = System.currentTimeMillis();
            result = instance.doOCR(file);
            long endTime = System.currentTimeMillis();
            System.out.println("识别耗时：" + (endTime - startTime) + " 毫秒");
        } catch (TesseractException e) {
            e.printStackTrace();
        }
        System.out.println("[识别结果]: ");
        System.out.println(result);
    }
}
