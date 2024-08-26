package ICT_Team2.ITS_Back_End_main.web.controller;

import ICT_Team2.ITS_Back_End_main.apiPayLoad.ApiResponse;
import ICT_Team2.ITS_Back_End_main.domain.Member;
import ICT_Team2.ITS_Back_End_main.service.commentService.CommentCommandService;
import ICT_Team2.ITS_Back_End_main.service.commentService.CommentQueryService;
import ICT_Team2.ITS_Back_End_main.web.dto.CommentRequestDTO;
import ICT_Team2.ITS_Back_End_main.web.dto.CommentResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comment")
@RequiredArgsConstructor
public class CommentRestController {

  private final CommentQueryService commentQueryService;
  private final CommentCommandService commentCommandService;

  //댓글 생성
  public ApiResponse<CommentResponseDTO.ResponseDto> createComment(@RequestBody CommentRequestDTO.CreateDto createDto, @RequestParam Long userId) {
    Member member = new Member(userId); // User는 서비스에서 찾아서 처리해야 함
    CommentResponseDTO.ResponseDto responseDto = commentCommandService.createComment(createDto, member);
    return ApiResponse.onSuccess(responseDto);
  }

  //댓글 수정
  @PutMapping("/{commentId}")
  public ApiResponse<CommentResponseDTO.ResponseDto> updateComment(@PathVariable Long commentId, @RequestBody CommentRequestDTO.UpdateRequestDto updateDto) {
    CommentResponseDTO.ResponseDto responseDto = commentCommandService.updateComment(commentId, updateDto);
    return ApiResponse.onSuccess(responseDto);
  }

  // 댓글 삭제 (상태를 INACTIVE로 변경)
  @DeleteMapping("/{commentId}")
  public ApiResponse<Void> deleteComment(@PathVariable Long commentId) {
    commentCommandService.deleteComment(commentId);
    return ApiResponse.onSuccess(null);
  }


}
