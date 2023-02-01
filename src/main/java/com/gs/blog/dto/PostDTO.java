package com.gs.blog.dto;

import com.gs.blog.common.CommonDTO;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PostDTO extends CommonDTO {
    private int boardIdx;
    private int postIdx;
    private String title;
    private String content;
    private int viewCnt;
    private String deleted;
    private int fileNo;

    private int startIndex;
    private int endIndex;
}
