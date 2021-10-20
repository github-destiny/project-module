package com.nero.uploadfile;

import java.io.*;
import java.util.UUID;

/**
 * @author NeRo Claudius
 * @version 1.0.0
 * @date 19/10/2021 下午6:50
 * @company https://nero-cx.ltd
 */
public class Demo {

    private void download(String name) throws IOException {
        File file = new File("D:\\test\\" + name);
        FileInputStream fis = new FileInputStream(file);
        BufferedInputStream bis = new BufferedInputStream(fis);
        OutputStream os = new FileOutputStream("D:\\test\\a.log");
        byte[] data = new byte[1024];
        int i = bis.read(data);
        while(i != -1){
            os.write(data, 0, i);
            i = bis.read(data);
        }
        if(bis != null){
            bis.close();
        }
        if(fis != null){
            fis.close();
        }
        os.flush();
        if(os != null){
            os.close();
        }
    }

    public static void main(String[] args) {
        File file = new File("D\\test\\jsoup.pdf");

    }

}
