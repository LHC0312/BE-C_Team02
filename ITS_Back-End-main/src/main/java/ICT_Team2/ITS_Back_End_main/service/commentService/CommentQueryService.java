package ICT_Team2.ITS_Back_End_main.service.commentService;

import ICT_Team2.ITS_Back_End_main.domain.Comment;
import ICT_Team2.ITS_Back_End_main.web.dto.CommentResponseDTO;
import ICT_Team2.ITS_Back_End_main.web.dto.CommentResponseDTO.ResponseDto;
import java.util.List;

public interface CommentQueryService {
  CommentResponseDTO.ResponseDto getCommentById(Long commentId);
  public List<Comment> getCommentsByIssueId(Long issueId);
}