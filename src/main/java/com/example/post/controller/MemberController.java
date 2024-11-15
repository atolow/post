package com.example.post.controller;


import com.example.post.Common.Const;
import com.example.post.Service.MemberService;
import com.example.post.dto.MemberResponseDto;
import com.example.post.dto.SignRequestMemberDto;
import com.example.post.dto.SignResponseMemberDto;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
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
    public ResponseEntity<SignResponseMemberDto> signUp (
            @RequestBody SignRequestMemberDto requestMemberDto){
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

    @PostMapping("/login")
    public ResponseEntity<MemberResponseDto>login(
            @RequestBody SignRequestMemberDto requestMemberDto,
            HttpServletRequest request
    ) {

        MemberResponseDto responseDto = memberService.login(requestMemberDto.getPassword(),requestMemberDto.getEmail());
        Long userId = responseDto.getId();

        // 실패시 예외처리
        if (userId == null) {
            return null;
        }

        HttpSession session = request.getSession();

        // 회원 정보 조회
        MemberResponseDto loginUser = memberService.findById(userId);

        // Session에 로그인 회원 정보를 저장한다.
        session.setAttribute(Const.LOGIN_USER, loginUser);

        // 로그인 성공시 리다이렉트
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }

    @PostMapping("/logout")
    public void logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if(session != null) {
            session.invalidate(); // 해당 세션(데이터)을 삭제한다.
        }
    }
}