package ICT_Team2.ITS_Back_End_main.converter;

import ICT_Team2.ITS_Back_End_main.domain.Comment;
import ICT_Team2.ITS_Back_End_main.domain.Issue;
import ICT_Team2.ITS_Back_End_main.domain.Member;
import ICT_Team2.ITS_Back_End_main.domain.enums.Status;
import ICT_Team2.ITS_Back_End_main.web.dto.CommentRequestDTO;
import ICT_Team2.ITS_Back_End_main.web.dto.CommentResponseDTO;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import ICT_Team2.ITS_Back_End_main.web.dto.IssueResponseDTO;
import lombok.Getter;

@Getter

public class CommentConverter {

  // CreateDto -> 엔티티
  public static Comment toEntity(CommentRequestDTO.CreateDto createDto, Member member, Issue issue) {
    return Comment.builder()
        .content(createDto.getContent())
        .writer(member) // Member 엔티티는 서비스에서 받기
        .status(Status.ACTIVE) // 기본 상태 = ACTIVE
        .issue(issue)
        .build();
  }

  public static List<CommentResponseDTO.ResponseDto> toResponseDto(List<Comment> comments) {
    return comments.stream()
            .map(CommentConverter::toResponseDto)
            .collect(Collectors.toList());
  }

  //UpdateRequestDto -> 엔티티
  public static Comment toEntity(CommentRequestDTO.UpdateRequestDto updateRequestDto, Comment existingComment) {
    existingComment.setContent(updateRequestDto.getContent());
    existingComment.setStatus(Status.ACTIVE);// 상태 유지 변경 ㄱㄴ
    return existingComment;
  }

  // 엔티티 -> 응답 dto
  public static CommentResponseDTO.ResponseDto toResponseDto(Comment comment) {
    if (comment == null)
      return null;

    return CommentResponseDTO.ResponseDto.builder()
        .id(comment.getId())
        .writer( MemberConverter.toUserDTO(comment.getWriter()) ) // Member 엔티티에서 작성자 ID를 가져옴
        .content(comment.getContent())
        .build();
  }
}
