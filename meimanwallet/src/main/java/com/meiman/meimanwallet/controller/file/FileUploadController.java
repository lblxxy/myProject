package com.meiman.meimanwallet.controller.file;

import com.meiman.meimanwallet.utils.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
/**
 * 文件上传工具
 * @author zeng_
 */
@RestController
@RequestMapping("/file")
public class FileUploadController {

    /**
     * 文件上传
     * @param file 文件
     * @return 上传结果
     */
    @PostMapping("/upload")
    @ResponseBody
    public RpcClientResult upload(@RequestParam("file") MultipartFile file) {
        //验证文件是否存在，避免空文件
        if (file.isEmpty()) {
            return RpcClientResult.getFailed();
        }
        //获取原始的文件名
        String originalFilename = file.getOriginalFilename();
        //验证文件是否存在，避免空文件
        if(StringUtils.isBlank(originalFilename)){
            return RpcClientResult.getFailed();
        }
        //当前的时间戳
        long ctime = TimeService.currentTimeMillis();
        //用当前时间的毫秒数加五位随机数字当作新的文件名
        String fileName = ctime+ StringUtils.getRandomString(5)+originalFilename.substring(originalFilename.lastIndexOf("."));
        //获取配置的上传路径，同时获取时间戳的前五位，即代表一天，每天的图片分开存
        String filePath = PropertiesUtils.readProperty("file.path") +LongUtils.div(ctime,100000000);
        File dest = new File(filePath +"/"+ fileName);
        //如果文件夹不存在，直接创建
        if(!dest.getParentFile().exists()){
            boolean issuccess = dest.getParentFile().mkdirs();
            if(!issuccess){
                //文件夹创建失败，提示系统错误
                return RpcClientResult.getFailed();
            }
        }
        try {
            //保存文件
            file.transferTo(dest.getAbsoluteFile());
            return RpcClientResult.getSuccess();
        } catch (IOException e) {
            e.printStackTrace();
            //异常，直接返回上传失败，提示系统错误
            return RpcClientResult.getFailed();
        }
    }
}
