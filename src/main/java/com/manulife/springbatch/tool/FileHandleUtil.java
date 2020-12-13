package com.manulife.springbatch.tool;


import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.system.ApplicationHome;
import org.springframework.util.ResourceUtils;

import java.io.*;

public class FileHandleUtil {


    /** 绝对路径 **/
    private static String absolutePath = "";

    /** 静态目录 **/
    private static String staticDir = "/static";

    /** 文件存放的目录 **/
    private static String fileDir = "/upload/";

    private static final Logger logger =  LogManager.getLogger(FileHandleUtil.class);
    public static void init() {
        FileHandleUtil.createDirIfNotExists();
    }

    /**
     * 上传单个文件
     * 最后文件存放路径为：static/upload/image/test.jpg
     * 文件访问路径为：http://127.0.0.1:8080/upload/image/test.jpg
     * 该方法返回值为：/upload/image/test.jpg
     * @param inputStream 文件流
     * @param path 文件路径，如：image/
     * @param filename 文件名，如：test.jpg
     * @return 成功：上传后的文件访问路径，失败返回：null
     */
    public static String upload(InputStream inputStream, String path, String filename) {
        //第一次会创建文件夹
        createDirIfNotExists();

        String resultPath = fileDir + path + filename;

        //存文件
        File uploadFile = new File(absolutePath, staticDir + resultPath);
        try {
            FileUtils.copyInputStreamToFile(inputStream, uploadFile);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        return resultPath;
    }

    /***
     * 返回路径
     * @return
     */
    public static  String getPath()
    {
        return absolutePath+staticDir+fileDir;
    }
    /**
     * 创建文件夹路径
     */
    private static void createDirIfNotExists() {
        if (!absolutePath.isEmpty()) {return;}

        //获取跟目录
        File file = null;
        try {
//            file = new File(h.getSource().getParentFile().toString());
            file=new ApplicationHome(FileHandleUtil.class).getDir();
        } catch (Exception e) {
            throw new RuntimeException("获取根目录失败，无法创建上传目录！");
        }
        if(!file.exists()) {
            file = new File("");
        }

        absolutePath = file.getAbsolutePath();

        File upload = new File(absolutePath, staticDir + fileDir);
        if(!upload.exists()) {
            upload.mkdirs();
        }
        logger.info("文件夹路径:{}",upload.getPath());
    }

    /**
     * 删除文件
     * @param path 文件访问的路径upload开始 如： /upload/image/test.jpg
     * @return true 删除成功； false 删除失败
     */
    public static boolean delete(String path) {
        File file = new File(absolutePath, staticDir + path);
        if (file.exists()) {
            return file.delete();
        }
        return false;
    }

/*    // SpringBoot读取Linux服务器某路径下文件    public String messageToRouted() {
    File file = null;
            try {
        file = ResourceUtils.getFile("/home/admin/logs/test/routed.txt");
        // 获取文件输入流
        InputStream inputStream = new FileInputStream(file);
        List<String> fileList = IOUtils.readLines(inputStream);
        log.info("fileList:{}", fileList);
        fileList.forEach(rd -> {
            RoutedPO routedPO = new RoutedPO();
            routedPO.setFulfillmentOrderName(rd.trim());
            routedPO.setRoutedTo("test");
            // 通知分单结果
            routedService.notifyRoutedResult(routedPO, OfcRoutedOperate.INSERT);
        });
    } catch (FileNotFoundException e) {
        log.info("文件不存在！");
        return "文件不存在！";
    } catch (IOException e) {
        log.info("文件读取异常！");
        return "文件读取异常！";
    }
        return "success!";
}*/

    public static InputStream  getImage(String path) throws FileNotFoundException {
        File file = ResourceUtils.getFile(absolutePath+staticDir+fileDir+path);
        InputStream inputStream = new FileInputStream(file);
        return  inputStream;
    }
}
