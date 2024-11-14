package com.example.boardproj.entity;

import jakarta.persistence.*;

public class NoticeImg {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long nino;

    private String nimgPath;

    private String nimgName;

    //uuid사용시
    private String nnewImgName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nno")
    private Notice notice;   // pk값으로 객체를 가져와서 담을 객체타입으로 작성하여 참조한다.

}
