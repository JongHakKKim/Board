package com.example.boardproj.entity;

import com.example.boardproj.entity.base.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Reply extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reply_num")
    private Long rno;

    private String replyText;

    private String writer;      // 이것도 나중에 게시판도 나중에 회원을 참조하자

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bno")
    private Board board;        // pk 값으로 객체를 가져와서 담을 객체타입으로 작성하여 참조한다.



}
