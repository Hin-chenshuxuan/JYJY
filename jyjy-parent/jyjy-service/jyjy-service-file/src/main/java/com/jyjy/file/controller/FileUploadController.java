package com.jyjy.file.controller;

import entity.Result;
import entity.StatusCode;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(value = "/upload")
@CrossOrigin
public class FileUploadController {
    /**
     * 文件上传
     */
    /*
    @PostMapping
    public Result upload(@RequestParam(value = "file")MultipartFile file){
        try {
            //判断文件是否存在             
            if (file == null) {
                throw new RuntimeException("文件不存在");
            }
            //获取文件的完整名称
            String originalFilename = file.getOriginalFilename();
            if (StringUtils.isEmpty(originalFilename)) {
                throw new RuntimeException("文件不存在");
            }

            //封装文件信息
            FastDFSFile fastDFSFile = new FastDFSFile(
                    originalFilename, //文件名 1.jpg
                    file.getBytes(), //文件字节数组
                    StringUtils.getFilenameExtension(file.getOriginalFilename()) //获取文件扩展名
            );

            //调用FastDFSUtil工具类将文件传入FastDFS中
            String[] uploads = FastDFSUtil.upload(fastDFSFile);

            //拼接访问地址 http://192.168.211.132:8080/group1/M00/00/00/1.jpg
            //String url = "http://192.168.211.132:8080/"+uploads[0]+"/"+uploads[1];
            String url = FastDFSUtil.getTrackerInfo() + "/" + uploads[0] + "/" + uploads[1];
            return new Result(true, StatusCode.OK, "上传成功!", url);
        }catch (Exception e){
            return new Result(false,StatusCode.ERROR,"上传失败");
        }
    }
    */
    /**
     * 文件上传
     */
    @PostMapping
    public Result upload(@RequestParam(value = "file")MultipartFile file){

        try {
            String url = "";
            return new Result(true, StatusCode.OK, "上传成功!", url);
        }catch (Exception e){
            return new Result(false,StatusCode.ERROR,"上传失败");
        }
    }
}
