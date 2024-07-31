package ICT_Team2.ITS_Back_End_main.service;

import ICT_Team2.ITS_Back_End_main.web.dto.CommentRequestDTO;
import ICT_Team2.ITS_Back_End_main.web.dto.CommentResponseDTO;
import java.util.List;

public interface CommentService {

  CommentResponseDTO.ResponseDto createComment(CommentRequestDTO.CreateDto createDto);
  void deleteComment(Long id, CommentRequestDTO.DeleteDto deleteDto);
  CommentResponseDTO.ResponseDto updateComment(Long id, CommentRequestDTO.UpdateRequestDto updateRequestDto);
  CommentResponseDTO.ResponseDto getComment(Long id);
  List<CommentResponseDTO.ResponseDto> getAllComments();
}
