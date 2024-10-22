package ICT_Team2.ITS_Back_End_main.service.commentService;

import ICT_Team2.ITS_Back_End_main.apiPayLoad.exception.CommentNotFoundException;
import ICT_Team2.ITS_Back_End_main.converter.CommentConverter;
import ICT_Team2.ITS_Back_End_main.domain.Comment;
import ICT_Team2.ITS_Back_End_main.domain.Issue;
import ICT_Team2.ITS_Back_End_main.repository.CommentRepository;
import ICT_Team2.ITS_Back_End_main.repository.IssueRepository;
import ICT_Team2.ITS_Back_End_main.web.dto.CommentResponseDTO;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentQueryServiceImpl implements CommentQueryService {

  private final CommentRepository commentRepository;
  private final IssueRepository issueRepository;

  @Override
  public CommentResponseDTO.ResponseDto getCommentById(Long commentId) {
    Comment comment = commentRepository.findById(commentId)
        .orElseThrow(() -> new CommentNotFoundException("Comment not found with id " + commentId));
    return CommentConverter.toResponseDto(comment);
  }

  @Override
  public List<Comment> getCommentsByIssueId(Long issueId) {
    Issue issue = issueRepository.findById(issueId)
            .orElseThrow(() -> new CommentNotFoundException("Comment not found with id ")); // Issue 객체 조회

    return commentRepository.findByIssue(issue)
            .orElseThrow(() -> new CommentNotFoundException("Comment not found with id "));
  }
}
