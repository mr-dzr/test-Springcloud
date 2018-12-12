package com.forezp.eurekaserver;

import com.util.ZipUtils;
import org.apache.commons.collections.CollectionUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipOutputStream;

/**
 * @description:
 * @Author: dzr
 * @date: 2018/12/6
 */
public class tets {


    public static void main(String[] args) throws Exception {
        try {
            // 生成的ZIP文件名为Demo.zip
            String strZipName = "E:/my_test_work/Demo.zip";//生成文件的目录及命令
            ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(strZipName));
            File newFile = new File(strZipName);
            List<File> files = new ArrayList<>();
            files.add(new File("E:/my_test_work/testParent"));

            if (CollectionUtils.isEmpty(files) == false) {
                for (int i = 0, size = files.size(); i < size; i++) {
                    ZipUtils.compress(files.get(i), zipOutputStream, "");
                    //加密
                    /*String str = ZipUtils.compressToBase64(files);
                    System.out.println("s:" + str);
                    //解密
                    ZipUtils.decodeToBase64(newFile, str);*/
                }
            }
            // 冲刷输出流
            zipOutputStream.flush();
            // 关闭输出流
            zipOutputStream.close();
            System.out.println("生成zip成功:" + strZipName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
