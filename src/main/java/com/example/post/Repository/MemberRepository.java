package com.example.post.Repository;

import com.example.post.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

public interface MemberRepository extends JpaRepository <Member, Long> {
    Optional<Member> findMemberByUsername(String username);

    default Member findMemberByUsernameOrElseThrow(String username){
        return findMemberByUsername(username).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));

    }

    default Member findByIdOrElseThrow(Long id) {
        return findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist id = " + id));
    }

    Optional<Member> findMemberByEmail(String email);

    default Member findMemberByEmailOrElseThrow(String email){
        return findMemberByEmail(email).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
