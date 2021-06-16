package Test202106;

import java.io.File;

/**
 * ClassName: Test20210616
 * Description:
 * date: 2021/6/16 20:05
 *
 * @author wt
 * @since JDK 1.8
 */
public class Test20210616 {
    /**
     * File 文件类
     * @param args
     */
    public static void main1(String[] args) {
        File file = new File("E:/images");
//        File[] files = file.listFiles();
//        for (File f:files) {
//            System.out.println(f);
//        }

        listAllFiles(file);
    }
    //递归打印目录中的所有文件
    private static void listAllFiles(File file) {
        if (file.isDirectory()) {
            //如果是目录，就把目录中包含的文件都罗列出来
            File[] files = file.listFiles();
            for (File f: files) {
                listAllFiles(f);
            }
        } else {
            //否则就打印文件的路径
            System.out.println(file);
        }
    }

    /**
     *
     */
}
