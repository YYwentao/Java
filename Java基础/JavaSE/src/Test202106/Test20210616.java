package Test202106;

import java.io.*;

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
     *  字节流
     *  带缓冲区的读和写，速度比不带缓冲区的读和写快，要引入 BufferedInputStream 和 BufferedOutputStream
     */
    public static void main(String[] args) throws IOException {
        //版本1 代码丑且发生异常不会close
        copyFile();
        //版本2 适用
        copyFile1();
    }


    private static void copyFile() throws IOException {
        //创建实例 BufferedInputStream 和 BufferedOutputStream
        FileInputStream fileInputStream = new FileInputStream("E:/images/image.jpg");
        FileOutputStream fileOutputStream = new FileOutputStream("E:/images/image1.jpg");
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
        byte[] buffer = new byte[1024];
        int length = -1;
        while((length = bufferedInputStream.read(buffer)) != -1) {
            bufferedOutputStream.write(buffer,0,length);
        }
        //此时涉及到四个流对象
        // 关闭后面两个就可以了
        bufferedInputStream.close();;
        bufferedOutputStream.close();
    }

    private static void copyFile1() {
        try {BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("E:/images/image.jpg"));
             BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("E:/images/image2.jpg"));
             byte[] buffer = new byte[1024];
             int length = -1;
             while((length = bufferedInputStream.read(buffer)) != -1) {
                 bufferedOutputStream.write(buffer,0,length);
             }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
