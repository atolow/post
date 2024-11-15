package com.example.post.controller;


import com.example.post.Service.MemberService;
import com.example.post.dto.MemberResponseDto;
import com.example.post.dto.SignRequestMemberDto;
import com.example.post.dto.SignResponseMemberDto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/signup")
    public ResponseEntity<SignResponseMemberDto> signUp (@RequestBody SignRequestMemberDto requestMemberDto){
        SignResponseMemberDto signResponseMemberDto=
                memberService.signUp(
                requestMemberDto.getUsername(),
                requestMemberDto.getPassword(),
                requestMemberDto.getEmail()
        );
        return new ResponseEntity<>(signResponseMemberDto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<MemberResponseDto>> findAll(){
        List<MemberResponseDto> memberResponseDtoList = memberService.findAll();

        return new ResponseEntity<>(memberResponseDtoList, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<MemberResponseDto> findById(@PathVariable(value = "id") Long id){
        MemberResponseDto memberResponseDto = memberService.findById(id);

        return new ResponseEntity<>(memberResponseDto, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        memberService.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}