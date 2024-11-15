package com.example.post.Service;

import com.example.post.Repository.MemberRepository;
import com.example.post.dto.MemberResponseDto;
import com.example.post.dto.SignResponseMemberDto;
import com.example.post.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public SignResponseMemberDto signUp(String username, String password, String email) {
        Member member = new Member(username, password, email);

        Member savedMember = memberRepository.save(member);

        return new SignResponseMemberDto(savedMember.getId(),savedMember.getUsername(), savedMember.getPassword(), savedMember.getEmail());
    }
    public List<MemberResponseDto> findAll(){
        return memberRepository.findAll()
                .stream()
                .map(MemberResponseDto::toDto)
                .toList();
    }
    public MemberResponseDto findById(Long id){
        Optional<Member> optionMember = memberRepository.findById(id);
        if (optionMember.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        Member findMember = optionMember.get();
        return new MemberResponseDto(findMember.getId(), findMember.getUsername(), findMember.getEmail());
    }
    public MemberResponseDto login(String password, String email) {
        Member optionMember = memberRepository.findMemberByEmailOrElseThrow(email);
        if(!optionMember.getEmail().equals(email) || !optionMember.getPassword().equals(password)){
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }
        return new MemberResponseDto(optionMember.getId(), optionMember.getUsername(), optionMember.getEmail());

    }

    public void delete(Long id){
        Member findBoard = memberRepository.findByIdOrElseThrow(id);

        memberRepository.delete(findBoard);
    }

}
