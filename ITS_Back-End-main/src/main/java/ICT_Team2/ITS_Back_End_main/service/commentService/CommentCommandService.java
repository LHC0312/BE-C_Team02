package ICT_Team2.ITS_Back_End_main.service.commentService;

import ICT_Team2.ITS_Back_End_main.domain.Member;
import ICT_Team2.ITS_Back_End_main.web.dto.CommentRequestDTO;
import ICT_Team2.ITS_Back_End_main.web.dto.CommentResponseDTO;

public interface CommentCommandService {
  CommentResponseDTO.ResponseDto createComment(CommentRequestDTO.CreateDto createDto, Member member);
  CommentResponseDTO.ResponseDto updateComment(Long commentId, CommentRequestDTO.UpdateRequestDto updateDto);
  void deleteComment(Long commentId);
}