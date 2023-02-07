package com.gs.blog.controller;

import com.gs.blog.common.ResponseMessage;
import com.gs.blog.dto.FileDTO;
import com.gs.blog.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/file")
public class FileController {

    @Value("${spring.servlet.multipart.location}")
    private String uploadPath;

    @Autowired
    FileService fileService;

    @PostMapping
    public ResponseEntity fileUpload(MultipartFile file) throws IllegalStateException, IOException {
        ResponseMessage responseMessage = new ResponseMessage();

        if (!file.isEmpty()){
            long fileSize = file.getSize();
            String fileName = file.getOriginalFilename();
            int dot = fileName.lastIndexOf(".");
            String extension = fileName.substring(dot, fileName.length());
            fileName = fileName.substring(0, dot);
            String physicalFileName = UUID.randomUUID().toString();

            FileDTO fileDTO = new FileDTO();

            fileDTO.setFilePath(uploadPath);
            fileDTO.setFileName(fileName);
            fileDTO.setFilePhysicalName(physicalFileName);
            fileDTO.setFileExten(extension);
            fileDTO.setFileSize(fileSize);
            fileDTO.setCreateUser("admin");
            fileDTO.setUpdateUser("admin");

            int fileNo = fileService.fileUpload(fileDTO);

            file.transferTo(new File(physicalFileName));

            responseMessage.getMessage().setData(fileNo);
        }

        responseMessage.getMessage().setMessage("fileUpload Success");
        return responseMessage.getResponse();
    }
}
