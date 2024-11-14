package com.example.boardproj.dto;

import com.example.boardproj.entity.Board;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BoardImgDTO {


    public Long ino;

    private String imgPath;

    private String imgName;

    //uuid사용시
    private String newImgName;

    private BoardDTO boardDTO;   // pk값으로 객체를 가져와서 담을 객체타입으로 작성하여 참조한다.

}
