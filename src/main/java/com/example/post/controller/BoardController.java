package com.example.post.controller;

import com.example.post.Service.BoardService;
import com.example.post.dto.BoardResponseDto;
import com.example.post.dto.BoardWithUsernameResponseDto;
import com.example.post.dto.CreateBoardRequestDto;
import com.example.post.dto.UpdateTitleOrContentsRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/boards")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;


    @PostMapping
    public ResponseEntity<BoardResponseDto> save(@RequestBody CreateBoardRequestDto requestDto) {

        BoardResponseDto boardResponseDto =
                boardService.save(
                        requestDto.getTitle(),
                        requestDto.getContents(),
                        requestDto.getUsername()
                );

        return new ResponseEntity<>(boardResponseDto, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<BoardResponseDto>> findAll() {

        List<BoardResponseDto> boardResponseDtoList = boardService.findAll();

        return new ResponseEntity<>(boardResponseDtoList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BoardWithUsernameResponseDto> findById(@PathVariable Long id) {

        BoardWithUsernameResponseDto boardWithAgeResponseDto = boardService.findById(id);

        return new ResponseEntity<>(boardWithAgeResponseDto, HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> updateTitleOrContents(
            @PathVariable(value = "id") Long id,
            @RequestBody UpdateTitleOrContentsRequestDto requestDto) {

        boardService.updateTitleOrContents(id, requestDto.getOldTitle(),requestDto.getNewTitle(),requestDto.getOldContents(), requestDto.getNewContents());

        return new ResponseEntity<>(HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        boardService.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}