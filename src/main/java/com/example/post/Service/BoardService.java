package com.example.post.Service;

import com.example.post.Repository.BoardRepository;
import com.example.post.Repository.MemberRepository;
import com.example.post.dto.BoardResponseDto;
import com.example.post.dto.BoardWithUsernameResponseDto;
import com.example.post.entity.Board;
import com.example.post.entity.Member;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final MemberRepository memberRepository;
    private final BoardRepository boardRepository;

    public BoardResponseDto save(String title, String contents, String username) {

        Member findmember = memberRepository.findMemberByUsernameOrElseThrow(username);

        Board board = new Board(title, contents, username);
        board.setMember(findmember);

        Board savedBoard = boardRepository.save(board);

        return new BoardResponseDto(savedBoard.getId(), savedBoard.getTitle(), savedBoard.getContents(),savedBoard.getUsername());
    }
    public List<BoardResponseDto> findAll() {
        return boardRepository.findAll()
                .stream()
                .map(BoardResponseDto::toDto)
                .toList();
    }
    public BoardWithUsernameResponseDto findById(Long id) {
        Board findBoard = boardRepository.findByIdOrElseThrow(id);

        return new BoardWithUsernameResponseDto(findBoard.getId(),findBoard.getTitle(), findBoard.getContents(), findBoard.getUsername());
    }
    @Transactional
    public void updateTitleOrContents(Long id, String oldTitle, String newTitle,String oldContents, String newContents) {

        Board findboard = boardRepository.findByIdOrElseThrow(id);


        findboard.updateTitleOrContents(newTitle,newContents);
    }
    public void delete(Long id) {

        Board findBoard = boardRepository.findByIdOrElseThrow(id);

        boardRepository.delete(findBoard);
    }
}