package org.example.springsecurity.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentDTO {
    private int cnum;
    private String userid;
    private String content;
    @JsonFormat(shape = JsonFormat.Shape.STRING,
    pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
    private Date regdate;
    private int bnum;

}
