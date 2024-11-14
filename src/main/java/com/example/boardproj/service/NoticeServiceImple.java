/*
package com.example.boardproj.service;


import com.example.boardproj.dto.BoardDTO;
import com.example.boardproj.dto.NoticeDTO;
import com.example.boardproj.dto.PageRequestDTO;
import com.example.boardproj.dto.PageResponseDTO;
import com.example.boardproj.entity.Notice;
import com.example.boardproj.repository.BoardRepository;
import com.example.boardproj.repository.NoticeRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@Log4j2
@RequiredArgsConstructor
@Transactional
public class NoticeServiceImple implements NoticeService {
    private final NoticeRepository noticeRepository;

    private ModelMapper modelMapper = new ModelMapper();

    private FileService fileService = new FileService();
    private final NoticeImgService noticeImgService;



    @Override
    public void register(NoticeDTO noticeDTO) {
        log.info("등록 서비스 들어온값 : " + noticeDTO);
        // 글을 컨트롤러로부터 받아서 entity변환해서 저장한다.

        Notice notice =
        modelMapper.map(noticeDTO, Notice.class);

        noticeRepository.save(notice);
    }

    @Override
    public void register(NoticeDTO noticeDTO, MultipartFile multipartFile) {

        log.info("등록 서비스 들어온값 : " + noticeDTO);
        log.info("등록 서비스 들어온값 : " + multipartFile);

        Notice notice =
                modelMapper.map(noticeDTO, Notice.class);

        log.info("저장전에 noticeDTO를 notice로 변경한 " + notice);

        notice =
                noticeRepository.save(notice);
        log.info("저장후에 결과를 가지고 있는 notice" + notice);


        if(multipartFile != null && !multipartFile.isEmpty()){
            noticeImgService.noticeImgregister(notice.getNno(), multipartFile);
        }
    }

    @Override
    public NoticeDTO read(Long nno) {
        return null;
    }

    @Override
    public List<NoticeDTO> list() {
        return null;
    }

    @Override
    public PageResponseDTO<NoticeDTO> pagelist(PageRequestDTO pageRequestDTO) {
        return null;
    }

    @Override
    public PageResponseDTO<NoticeDTO> pageListsearchdsl(PageRequestDTO pageRequestDTO) {
        return null;
    }

    @Override
    public void update(NoticeDTO noticeDTO) {

    }

    @Override
    public void del(Long nno) {

    }

}
*/
