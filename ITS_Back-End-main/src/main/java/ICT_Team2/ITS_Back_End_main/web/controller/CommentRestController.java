package ICT_Team2.ITS_Back_End_main.web.controller;

import ICT_Team2.ITS_Back_End_main.apiPayLoad.ApiResponse;
import ICT_Team2.ITS_Back_End_main.service.CommentCommandService;
import ICT_Team2.ITS_Back_End_main.web.dto.CommentRequestDTO;
import ICT_Team2.ITS_Back_End_main.web.dto.CommentResponseDTO;
import ICT_Team2.ITS_Back_End_main.web.dto.CommentResponseDTO.ResponseDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/*
@RestController
@RequestMapping("/comment")
@RequiredArgsConstructor
public class CommentRestController {

  private final CommentCommandService commentService;

  @PostMapping
  public ResponseEntity<ApiResponse<CommentResponseDTO.ResponseDto>> createComment(@RequestBody CommentRequestDTO.CommentCreateDto createDto) {
    CommentResponseDTO.ResponseDto responseDto = commentService.createComment(createDto);
    return ResponseEntity.ok(ApiResponse.onSuccess(responseDto));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<ApiResponse<Void>> deleteComment(@PathVariable Long id, @RequestBody CommentRequestDTO.CommentDeleteDto deleteDto) {
    commentService.deleteComment(id, deleteDto);
    return ResponseEntity.ok(ApiResponse.onSuccess(null));
  }

  @PutMapping("/{id}")
  public ResponseEntity<ApiResponse<CommentResponseDTO.ResponseDto>> updateComment(@PathVariable Long id, @RequestBody CommentRequestDTO.CommentUpdateRequestDto updateRequestDto) {
    CommentResponseDTO.ResponseDto responseDto = commentService.updateComment(id, updateRequestDto);
    return ResponseEntity.ok(ApiResponse.onSuccess(responseDto));
  }

  @GetMapping("/{id}")
  public ResponseEntity<ApiResponse<CommentResponseDTO.ResponseDto>> getComment(@PathVariable Long id) {
    CommentResponseDTO.ResponseDto responseDto = commentService.getComment(id);
    return ResponseEntity.ok(ApiResponse.onSuccess(responseDto));
  }

  @GetMapping
  public ResponseEntity<ApiResponse<List<ResponseDto>>> getAllComments() {
    List<CommentResponseDTO.ResponseDto> responseDtos = commentService.getAllComments();
    return ResponseEntity.ok(ApiResponse.onSuccess(responseDtos));
  }
}*/

