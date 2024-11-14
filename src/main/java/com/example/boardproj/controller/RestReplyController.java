package com.example.boardproj.controller;

import com.example.boardproj.dto.PageRequestDTO;
import com.example.boardproj.dto.PageResponseDTO;
import com.example.boardproj.dto.ReplyDTO;
import com.example.boardproj.service.ReplyService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.StringTokenizer;

@RestController
@RequiredArgsConstructor
@Log4j2
@RequestMapping("/reply")
public class RestReplyController {

    private final ReplyService replyService;

    @PostMapping("/register")
    public ResponseEntity replyregiset(@Valid ReplyDTO replyDTO, BindingResult bindingResult){

        log.info("댓글 들어온 값 : " + replyDTO);

        if(bindingResult.hasErrors()){
            log.info("에러가 있습니다.");
            log.info("에러가 있습니다.");
            log.info("에러가 있습니다.");
            log.info("에러가 있습니다.");
            log.info("에러가 있습니다.");
            log.info("에러가 있습니다.");
            log.info(bindingResult.getAllErrors());
            log.info(bindingResult.getAllErrors());

            List<ObjectError> objectErrors = bindingResult.getAllErrors();
            log.info("--------------------------------");
            objectErrors.forEach(objectError -> log.info(objectError.getDefaultMessage()));


            List<FieldError> fieldError =
            bindingResult.getFieldErrors();
            log.info("--------------------------------");
            fieldError.forEach(a -> log.info(a.getDefaultMessage()));





            return new ResponseEntity<String>(fieldError.get(0).getDefaultMessage(), HttpStatus.OK);
        }


        if (replyDTO.getBno()==null || replyDTO.getBno().equals("")){

            return new ResponseEntity<String>("댓글 값이 들어오지 않음", HttpStatus.BAD_REQUEST);
        }
        //댓글 저장
        try {
            log.info("저장 되고있나요");
            replyService.register(replyDTO);

        }catch (EntityNotFoundException e){
            return new ResponseEntity<String>("해당 글에는 댓글이 없습니다.", HttpStatus.BAD_REQUEST);
        }


        return new ResponseEntity<String>("저장 되었습니다.", HttpStatus.OK);

    }

    @GetMapping("/list")
    public ResponseEntity list(Long bno, PageRequestDTO pageRequestDTO){


        log.info("댓글 리스트" + bno);
        log.info(pageRequestDTO);


        if (bno==null || bno.equals("")){

            return new ResponseEntity<String>("요청 값을 확인해주세요", HttpStatus.BAD_REQUEST);
        }

        PageResponseDTO<ReplyDTO> responseDTO =
                replyService.pageList(pageRequestDTO, bno);

        log.info(responseDTO);

        return new ResponseEntity<PageResponseDTO<ReplyDTO>>(responseDTO, HttpStatus.OK);


    }

    @GetMapping("/read/{rno}")
    public ResponseEntity read(@PathVariable("rno") Long rno){


        ReplyDTO replyDTO =
                replyService.read(rno);

        return new ResponseEntity<ReplyDTO>(replyDTO, HttpStatus.OK);

    }

    @PostMapping("/update")
    public ResponseEntity update(ReplyDTO replyDTO){

        log.info(replyDTO);
        log.info(replyDTO);
        log.info(replyDTO);
        try {
            replyService.update(replyDTO);
        }catch (EntityNotFoundException e){

            return new ResponseEntity<String>("댓글 못찾음", HttpStatus.BAD_REQUEST);

        }


        return new ResponseEntity<String>("수정됨", HttpStatus.OK);


    }

    @PostMapping("/delete/{rno}")
    public ResponseEntity delete(@PathVariable("rno") Long rno){

        log.info(rno);
        log.info(rno);
        log.info(rno);

        replyService.remove(rno);

        return new ResponseEntity<String>("삭제됨", HttpStatus.OK);

    }




}
