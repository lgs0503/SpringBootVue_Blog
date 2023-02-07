package com.gs.blog.mapper;

import com.gs.blog.dto.FileDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FileMapper {
    void fileUpload(FileDTO fileDTO);

    int getFileNo();
}
