/*
package com.example.boardproj.controller;


import com.example.boardproj.dto.*;
import com.example.boardproj.entity.Board;
import com.example.boardproj.service.NoticeImgService;
import com.example.boardproj.service.NoticeService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.internal.bytebuddy.asm.Advice;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.List;

@Controller
@RequiredArgsConstructor
@Log4j2
@RequestMapping("/notice")
public class NoticeController {

    private final NoticeService noticeService;
    private final NoticeImgService noticeImgService;

    //등록보기 페이지
    @GetMapping("/register")
    public String registerGet(BoardDTO boardDTO) {

        return "notice/register";
    }

    //글을 디비에 등록하느 포스트
    @PostMapping("register")
    public String registerPost(@Valid NoticeDTO noticeDTO, BindingResult bindingResult, MultipartFile multipartFile) {


        log.info("컨트롤러로 들어온값 : " + noticeDTO);
        log.info("컨트롤러로 들어온값 : " + multipartFile.getOriginalFilename());

        if (bindingResult.hasErrors()) {
            log.info("유효성 검사나 문제가 있다 아래 로그는 모든 문제를 출력해준다.");
            log.info(bindingResult.getAllErrors());



            return "notice/register";
        }
        
        // 파일 업로드 추가
        noticeService.register(noticeDTO,multipartFile);

        return "redirect:/notice/list";
    }

    */
/*@GetMapping("/read")
    public String read(Long nno, Model model, PageRequestDTO pageRequestDTO) {
        log.info("컨트롤러 읽기로 들어온 게시글번호 : " + nno);
        log.info("컨트롤러 읽기로 들어온 게시글번호 : " + pageRequestDTO);


        if (nno == null || nno.equals("")){
            log.info("들어온 nno가 이상함");

            return "redirect:/notice/list";
        }

        NoticeDTO noticeDTO = new NoticeDTO();
        try {
            // 본문 데이터 // 아직 단방향중
            // 양방향 아님


            noticeDTO = noticeService.read(nno);


            List<NoticeImgDTO> noticeImgDTOList
                    = noticeImgService.noticeImgread(nno);

            log.info("컨트롤러에서 서비스 read() 불러온값 : ");
            log.info(noticeDTO);

            model.addAttribute("noticeDTO", noticeDTO);
            model.addAttribute("noticeImgDTOList",noticeImgDTOList);
        }   catch (EntityNotFoundException e) {
            log.info("nno로 값을 찾지 못함");
            log.info("pk값이 nno인 데이터가 없음");

            return "redirect:/notice/list";
        }

        return "notice/read";
    }*//*


    @GetMapping("/list")
    public String list(Model model, PageRequestDTO pageRequestDTO) {

        log.info(pageRequestDTO);


        PageResponseDTO<NoticeDTO> pageResponseDTO =
                noticeService.pageListsearchdsl(pageRequestDTO);


        model.addAttribute("pageResponseDTO", pageRequestDTO);

        return "notice/list";
    }

    */
/*@GetMapping("/update")
    public String updata(Long nno, Model model, PageRequestDTO pageRequestDTO) {
        
        if (nno == null || nno.equals("")) {
            log.info("들어온 nno가 이상함");

            return "redirect:/notice/list?"+pageRequestDTO.getLink();
        }

        NoticeDTO noticeDTO = null;


        try {

            noticeDTO = noticeService.read(nno);
            List<NoticeImgDTO> noticeImgDTOList
                    = noticeImgService.noticeImgread(nno);

            model.addAttribute("noticeDTO", noticeDTO);
            model.addAttribute("noticeImgDTOList",noticeImgDTOList);

        } catch (EntityNotFoundException e) {
            e.printStackTrace();
            log.info("pk로 검색한 값이 없음");
            return "redirect:/notice/list?"+pageRequestDTO.getLink();
        }


        return "notice/update";
    }*//*


    @PostMapping("/update")
    public String updatePost(@Valid NoticeDTO noticeDTO, BindingResult bindingResult , MultipartFile multipartFile
            , Long[] delino, PageRequestDTO pageRequestDTO, Model model){


        log.info("업데이트포스 " + noticeDTO);
        log.info("업데이트포스 " + pageRequestDTO);


        if(bindingResult.hasErrors()) {

            log.info("유효성검사 확인!!");
            log.info(bindingResult.getAllErrors()); // 유효성 내용 콘솔창에 출력


            return "notice/update";
        }


        try {
            noticeService.update(noticeDTO);
            if(multipartFile != null && !multipartFile.getOriginalFilename().equals("")){
                
                log.info("여기 사진이 있어요");
                log.info("업데이트포스" + multipartFile.getOriginalFilename());


                noticeImgService.noticeImgregister(noticeDTO.getNno(), multipartFile);
            }

            if(delino !=null && !delino[0].equals("")) {
                log.info("업데이트포스" + Arrays.toString(delino));
                
                // 사진삭제

                for (Long nino : delino) {
                    //noticeImgService.del(nino);
                }
            }
        } catch (EntityNotFoundException e) {

            return "redirect:/notice/list?"+pageRequestDTO.getLink();
        }

        return "redirect:/notice/list?"+pageRequestDTO.getLink();
    }

    @PostMapping("/del")
    public String del(Long nno){

        log.info(nno);

        noticeService.del(nno);

        return "redirect:/notice/list";
    }

}
*/
