package com.example.boardproj.repository.search;

import com.example.boardproj.entity.Board;

import org.hibernate.query.criteria.JpaSearchedCase;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardSearch {

    Page<Board> searchAll(String [] types, String keyword, Pageable pageable);

}
