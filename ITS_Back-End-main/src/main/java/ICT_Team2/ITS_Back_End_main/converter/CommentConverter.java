package ICT_Team2.ITS_Back_End_main.converter;

import ICT_Team2.ITS_Back_End_main.domain.Comment;
import ICT_Team2.ITS_Back_End_main.domain.Member;
import ICT_Team2.ITS_Back_End_main.domain.enums.Status;
import ICT_Team2.ITS_Back_End_main.web.dto.CommentRequestDTO;
import ICT_Team2.ITS_Back_End_main.web.dto.CommentResponseDTO;
import java.time.LocalDateTime;
import lombok.Getter;

@Getter

public class CommentConverter {

  // CreateDto -> 엔티티
  public static Comment toEntity(CommentRequestDTO.CreateDto createDto, Member member) {
    return Comment.builder()
        .context(createDto.getContext())
        .member(member) // Member 엔티티는 서비스에서 받기
        .status(Status.ACTIVE) // 기본 상태 = ACTIVE
        .createdAt(LocalDateTime.now())
        .build();
  }

  //UpdateRequestDto -> 엔티티
  public static Comment toEntity(CommentRequestDTO.UpdateRequestDto updateRequestDto, Comment existingComment) {
    existingComment.setContext(updateRequestDto.getContext());
    existingComment.setStatus(Status.ACTIVE);// 상태 유지 변경 ㄱㄴ
    return existingComment;
  }

  // 엔티티 -> 응답 dto
  public static CommentResponseDTO.ResponseDto toResponseDto(Comment comment) {
    return CommentResponseDTO.ResponseDto.builder()
        .id(comment.getId())
        .writerId(comment.getMember().getId()) // Member 엔티티에서 작성자 ID를 가져옴
        .context(comment.getContext())
        .isDeleted(comment.getStatus() == Status.INACTIVE) // 상태에 따라 삭제 여부 설정
        .build();
  }
}
