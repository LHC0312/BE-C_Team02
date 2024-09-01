package ICT_Team2.ITS_Back_End_main.web.controller;

import ICT_Team2.ITS_Back_End_main.converter.CommentConverter;
import ICT_Team2.ITS_Back_End_main.domain.Comment;
import ICT_Team2.ITS_Back_End_main.domain.Issue;
import ICT_Team2.ITS_Back_End_main.service.issueService.IssueQueryService;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.http.ResponseEntity;
import ICT_Team2.ITS_Back_End_main.domain.Member;
import ICT_Team2.ITS_Back_End_main.service.commentService.CommentCommandService;
import ICT_Team2.ITS_Back_End_main.service.commentService.CommentQueryService;
import ICT_Team2.ITS_Back_End_main.service.memberService.MemberQueryService;
import ICT_Team2.ITS_Back_End_main.web.dto.CommentRequestDTO;
import ICT_Team2.ITS_Back_End_main.web.dto.CommentResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/comment")
@RequiredArgsConstructor
public class CommentRestController {

  private final CommentQueryService commentQueryService;
  private final CommentCommandService commentCommandService;
  private final MemberQueryService memberQueryService;
  private final IssueQueryService issueQueryService;

  //댓글 생성
  @PostMapping("/create")
  public ResponseEntity<CommentResponseDTO.ResponseDto> createComment(@RequestHeader Long id,
                                                                      @RequestBody CommentRequestDTO.CreateDto createDto) {
    Member member = memberQueryService.findByMemberId(id); // User는 서비스에서 찾아서 처리해야 함
    Issue issue = issueQueryService.getIssueById(createDto.getIssueId());
    CommentResponseDTO.ResponseDto responseDto = commentCommandService.createComment(createDto, member, issue);
    return ResponseEntity.ok(responseDto);
  }

  //댓글 수정
  @PutMapping("/{commentId}")
  public ResponseEntity<CommentResponseDTO.ResponseDto> updateComment(@PathVariable Long commentId, @RequestBody CommentRequestDTO.UpdateRequestDto updateDto) {
    CommentResponseDTO.ResponseDto responseDto = commentCommandService.updateComment(commentId, updateDto);
    return ResponseEntity.ok(responseDto);
  }

  // 댓글 삭제 (상태를 INACTIVE로 변경)
  @DeleteMapping("/{commentId}")
  public ResponseEntity<Void> deleteComment(@PathVariable Long commentId) {
    commentCommandService.deleteComment(commentId);
    return ResponseEntity.ok(null);
  }

  @GetMapping("")
  public ResponseEntity<List<CommentResponseDTO.ResponseDto>> getCommentByIssue(@RequestParam Long issueId) {
    List<Comment> commentList = commentQueryService.getCommentsByIssueId(issueId);
    return ResponseEntity.ok(CommentConverter.toResponseDto(commentList));
  }
}
