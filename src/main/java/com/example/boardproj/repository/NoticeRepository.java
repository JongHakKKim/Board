/*
package com.example.boardproj.repository;

import com.example.boardproj.entity.Board;
import com.example.boardproj.entity.Notice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface NoticeRepository extends JpaRepository<Notice, Long>{

    @Query("select b from Notice b where b.title like concat('%', :str, '%')")
    public Page<Notice> selectlikeTitle(String str, Pageable pageable);

    //내용으로 검색   // 쿼리메소드

    @Query("select b from Notice b where b.content like concat('%', :str, '%')")
    public Page<Notice> selectlikeContent(String str, Pageable pageable);

    //작성자 검색
    @Query("select b from Notice b where b.writer like concat('%', :str, '%')")
    public Page<Notice> selectlikeWriter(String str, Pageable pageable);

    @Query("select b from Notice b where b.title like concat('%', :str, '%') or b.content like concat('%', :str, '%')")
    public Page<Notice> titleOrCon(String str, Pageable pageable);

    @Query("select b from Notice b where b.content like concat('%', :str, '%') or b.writer like concat('%', :str, '%')")
    public Page<Notice> contentOrwriter(String str,  Pageable pageable);

    @Query("select b from Notice b where b.title like concat('%', :str, '%') or b.writer like concat('%', :str, '%')")
    public Page<Notice> titleOrwriter(String str, Pageable pageable);

    @Query("select b from Notice b where b.title like concat('%', :str, '%') or b.content like concat('%', :str, '%') or b.writer like concat('%', :str, '%')")
    public Page<Notice> titleOrConOrWr(String str, Pageable pageable);
}
*/
