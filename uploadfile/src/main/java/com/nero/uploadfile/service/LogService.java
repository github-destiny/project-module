package com.nero.uploadfile.service;

import com.nero.uploadfile.domain.UploadInfo;
import com.nero.uploadfile.mapper.LogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author NeRo Claudius
 * @version 1.0.0
 * @date 19/10/2021 下午5:03
 * @company https://nero-cx.ltd
 */
@Service
public class LogService {

    @Autowired
    private LogMapper logMapper;

    public UploadInfo getInfo(String uuid){
        UploadInfo uploadInfo = logMapper.getUploadInfo(uuid);
        return uploadInfo;
    }

    /**
     * 文件上传
     */
    public String logUpload(MultipartFile file) throws IOException {
        UploadInfo info = new UploadInfo();
        // 判断文件是否上传成功
        if(file == null || file.isEmpty()){
            throw new IOException("文件上传失败!");
        }
        // 日期
        String date = new SimpleDateFormat("yyyyMMdd").format(new Date());
        String fullDate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
        // uuid
        String uuid = UUID.randomUUID().toString().substring(0, 8);
        String path = "D:\\test" + File.separator + date;
        File dir = new File(path);
        if(!dir.exists() || !dir.isDirectory()){
            dir.mkdirs();
        }
        // 获取文件大小
        long size = file.getSize();
        // 获取文件名称
        String name = file.getOriginalFilename();
        // 获取文件后缀
        String suffix = name.substring(name.lastIndexOf('.') + 1);
        // 文件存储路径
        path = path + File.separator + uuid + "." + suffix;
        // 校验文件是否存在
        File uploadFile = new File(path);
        if(uploadFile.exists()){
            throw new IOException("上传的文件已存在");
        }
        // 文件传输
        try {
            file.transferTo(uploadFile);
            // 传输成功，将数据保存在数据库中
            info.setOriginName(name);
            info.setUuid(uuid);
            info.setPath(path);
            info.setTime(fullDate);
            info.setSize(size);
            info.setType(suffix);
            int i = logMapper.insertInfo(info);
            if(i != 1){
                throw new RuntimeException("信息录入数据库失败!");
            }
        } catch (IOException e) {
            System.out.println("文件上传失败!");
        }
        return uuid;
    }

    /**
     * 文件下载
     * @param name
     * @param response
     * @throws IOException
     */
    public void logDownload(String name, HttpServletResponse response) throws IOException {
        File file = new File("D:/test" + File.separator + name);
        if(!file.exists()){
            throw new RuntimeException("文件不存在");
        }
        response.setContentType("application/force-download");
        response.addHeader("Content-Disposition", "attachment;fileName=" + name);
        byte[] buffer = new byte[1024];
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        try {
            fis = new FileInputStream(file);
            bis = new BufferedInputStream(fis);
            OutputStream os = response.getOutputStream();
            int i = bis.read(buffer);
            while(i != -1){
                os.write(buffer, 0, i);
                i = bis.read(buffer);
            }
            os.flush();
            os.close();
        } finally {
            if(bis != null){
                bis.close();
            }
            if(fis != null){
                fis.close();
            }
        }
    }

}
