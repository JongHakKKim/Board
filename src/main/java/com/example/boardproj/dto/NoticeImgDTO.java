package com.example.boardproj.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class NoticeImgDTO {


    public Long nino;

    private String nimgPath;

    private String nimgName;

    //uuid사용시
    private String nnewImgName;

    private NoticeDTO noticeDTO;   // pk값으로 객체를 가져와서 담을 객체타입으로 작성하여 참조한다.

}
