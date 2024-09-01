package ICT_Team2.ITS_Back_End_main.service.commentService;

import ICT_Team2.ITS_Back_End_main.domain.Issue;
import ICT_Team2.ITS_Back_End_main.domain.Member;
import ICT_Team2.ITS_Back_End_main.web.dto.CommentRequestDTO;
import ICT_Team2.ITS_Back_End_main.web.dto.CommentResponseDTO;

public interface CommentCommandService {
  public CommentResponseDTO.ResponseDto createComment(CommentRequestDTO.CreateDto createDto, Member member, Issue issue);
  CommentResponseDTO.ResponseDto updateComment(Long commentId, CommentRequestDTO.UpdateRequestDto updateDto);
  void deleteComment(Long commentId);
}