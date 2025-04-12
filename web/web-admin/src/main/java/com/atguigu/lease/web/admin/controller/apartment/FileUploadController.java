package com.atguigu.lease.web.admin.controller.apartment;

import com.atguigu.lease.common.result.Result;
import com.atguigu.lease.web.admin.service.FileService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Tag(name = "File Management")
@RequestMapping("/admin/file")
@RestController
public class FileUploadController {

    @Autowired
    private FileService fileService;

    /**
     * @param file the file to be uploaded, MultipartFile is a class
     *             that Spring framework provides to handle most upload files
     * @return URL of the uploaded file
     */
    @Operation(summary = "Upload File")
    @PostMapping("upload")
    public Result<String> upload(@RequestParam MultipartFile file) {
        String url = fileService.upload(file);
        System.err.println(file.getOriginalFilename());
        return Result.ok(url);
    }

}
