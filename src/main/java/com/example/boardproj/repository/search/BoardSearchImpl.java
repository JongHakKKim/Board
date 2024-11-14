package com.example.boardproj.repository.search;

import com.example.boardproj.entity.Board;

import com.example.boardproj.entity.QBoard;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.JPQLQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.time.LocalDate;
import java.util.List;

public class BoardSearchImpl extends QuerydslRepositorySupport implements BoardSearch {

    public BoardSearchImpl() {

        super(Board.class);
    }


    @Override
    public Page<Board> searchAll(String[] types, String keyword, Pageable pageable) {

        QBoard board = QBoard.board;    // q 도메인 객체 entity를 Qboard로 바꾼것
        JPQLQuery<Board> query = from(board);

        System.out.println(query);
        System.out.println("-----------------------------");
        // types에 있는 값을 검색하는데 있을 때 없을 때

        BooleanBuilder booleanBuilder = new BooleanBuilder();


        if (types != null && types.length > 0 && keyword != null) {
            for (String str : types) {
//                if(str.equals("t"))
                switch (str) {

                    case "t":
                        booleanBuilder.or(board.title.contains(keyword));
                        break;
                    case "c":
                        booleanBuilder.or(board.content.contains(keyword));
                        break;
                    case "w":
                        booleanBuilder.or(board.writer.contains(keyword));
                        break;
                    case "f":
                        booleanBuilder.and(board.regdate.after(LocalDate.now()));
                        break;
                }//switch문
                // 만약에 tc가 들어왔다면 where문 이후 title like %키워드% or content like %키워드%}


            }// for 문
            //


        }// if 문까지
        query.where(booleanBuilder);
        System.out.println(query);
        System.out.println("------------------------------------");

        query.where((board.bno.gt(0L)));    // select * from board //   // board.bno > 0
        System.out.println(query);
        System.out.println("------------------------------------");

        //페이징
        this.getQuerydsl().applyPagination(pageable, query);
        //데이터 List<T>
        List<Board> boardList = query.fetch();

        // 총게시물 수  row수
        long count =
                query.fetchCount();

        //return
        return new PageImpl<>(boardList, pageable, count);


    }

}

