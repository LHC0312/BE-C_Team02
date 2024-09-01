package ICT_Team2.ITS_Back_End_main.service.commentService;

import ICT_Team2.ITS_Back_End_main.converter.CommentConverter;
import ICT_Team2.ITS_Back_End_main.domain.Comment;
import ICT_Team2.ITS_Back_End_main.domain.Issue;
import ICT_Team2.ITS_Back_End_main.domain.Member;
import ICT_Team2.ITS_Back_End_main.domain.enums.Status;
import ICT_Team2.ITS_Back_End_main.repository.CommentRepository;
import ICT_Team2.ITS_Back_End_main.web.dto.CommentRequestDTO;
import ICT_Team2.ITS_Back_End_main.web.dto.CommentResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentCommandServiceImpl implements CommentCommandService {

  private final CommentRepository commentRepository;

  //생성
  @Override
  public CommentResponseDTO.ResponseDto createComment(CommentRequestDTO.CreateDto createDto, Member member, Issue issue) {
    //Member commentUser = userRepository.findById(member.getId()).orElseThrow(() -> new UserNotFoundException("Member not found with id " + member.getId()));
    Comment comment = CommentConverter.toEntity(createDto, member, issue);
    Comment savedComment = commentRepository.save(comment);
    return CommentConverter.toResponseDto(savedComment);
  }

  //업데이트 -> 예외처리 아직 못해서 간단하게 구현
  @Override
  public CommentResponseDTO.ResponseDto updateComment(Long commentId, CommentRequestDTO.UpdateRequestDto updateDto) {
    Comment existingComment = commentRepository.findById(commentId).orElse(null);

    if (existingComment != null) {
      existingComment.setContent(updateDto.getContent());
      Comment updatedComment = commentRepository.save(existingComment);
      return CommentConverter.toResponseDto(updatedComment);
    }
    return null; // 댓글이 없으면 null 반환
  }

  //삭제 -> 예외처리 아직 안 함
  @Override
  public void deleteComment(Long commentId) {
    Comment existingComment = commentRepository.findById(commentId).orElse(null);
    if (existingComment != null) {
      existingComment.setStatus(Status.INACTIVE);
      commentRepository.save(existingComment);
    }
  }
}
