package com.gs.blog.service;

import com.gs.blog.dto.FileDTO;
import com.gs.blog.mapper.FileMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FileService {

    @Autowired
    private FileMapper fileMapper;

    public int fileUpload(FileDTO fileDTO){

        int fileNo = 0;

        try {
            fileMapper.fileUpload(fileDTO);
            fileNo = fileMapper.getFileNo();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return fileNo;
    }
}
