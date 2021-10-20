package com.nero.uploadfile.controller;

import com.nero.uploadfile.domain.UploadInfo;
import com.nero.uploadfile.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author NeRo Claudius
 * @version 1.0.0
 * @date 19/10/2021 下午6:24
 * @company https://nero-cx.ltd
 */
@RestController
@RequestMapping("/log")
public class LogController {

    @Autowired
    private LogService logService;

    @GetMapping("/get/{uuid}")
    public Map<String, Object> getInfo(@PathVariable("uuid") String uuid){
        UploadInfo info = logService.getInfo(uuid);
        Map<String, Object> map = new HashMap<>();
        if(info == null){
            map.put("code", 401);
            map.put("msg", "该文件不存在");
            map.put("file", null);
            return map;
        }
        map.put("code", 1);
        map.put("msg", "success");
        map.put("file", info);
        return map;
    }

    @GetMapping("/download/{name}")
    public void download(@PathVariable("name") String name, HttpServletResponse response){
        try {
            logService.logDownload(name, response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @PostMapping("/upload")
    public Map<String, Object> logUpload(@RequestParam("file")MultipartFile file){
        HashMap<String, Object> map = new HashMap<>();
        String uuid = null;
        try {
            uuid = logService.logUpload(file);
            map.put("code", 1);
        } catch (IOException e) {
            map.put("code", 401);
            e.printStackTrace();
        }
        map.put("uuid", uuid);
        return map;
    }

}
