package com.bl.myproject.controller.fileUpload;

import com.bl.myproject.constant.EntityConstant;
import com.bl.myproject.util.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @author bl
 * @date 2019/5/30
 */
@RestController
@RequestMapping("/file")
public class FileUploadController {

    @PostMapping("/upLoad")
    @ResponseBody
    public ResponseResult upLoad(@RequestParam("file") MultipartFile file){
        //验证文件是否存在，避免空文件
        if(file.isEmpty()){
            return ResponseResult.getFailed();
        }
        //获取原始的文件名
        String originalFilename = file.getOriginalFilename();
        if(StringUtil.isBlank(originalFilename)){
            return ResponseResult.getFailed();
        }
        //当前时间戳
        long now = TimeUtil.currentTimeMillis();
        //用当前时间的毫秒数加五位随机数字当作新的文件名
        String fileName = now+StringUtil.getRandomString(EntityConstant.FIVE)+originalFilename.substring(originalFilename.lastIndexOf("."));
        //获取配置上的上传路径，同时获得时间戳的前五位，即代表一天，每天的图片分开存
        String filePath = LongUtil.div(now,100000000)+"/"+fileName;
        File fileUpload = new File(PropertiesUtil.readProperty("file.path") + filePath);
        //如果不存在就创建
        if(!fileUpload.getParentFile().exists()){
            boolean success = fileUpload.getParentFile().mkdirs();
            if(!success){
                //文件创建失败，提示系统错误
                return ResponseResult.getFailed();
            }
        }
        try {
            //保存文件
            file.transferTo(fileUpload.getAbsoluteFile());
            ResponseResult result = ResponseResult.getSuccess();
            result.setData(filePath);
            return result;
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseResult.getFailed();
        }

    }
}
