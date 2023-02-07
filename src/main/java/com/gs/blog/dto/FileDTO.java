package com.gs.blog.dto;

import com.gs.blog.common.CommonDTO;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class FileDTO extends CommonDTO {
    private int fileNo;
    private String filePath;
    private String fileName;
    private String filePhysicalName;
    private String fileExten;
    private long fileSize;
    private String useYn;
}
