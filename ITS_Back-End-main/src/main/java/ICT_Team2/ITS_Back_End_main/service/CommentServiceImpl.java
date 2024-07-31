package ICT_Team2.ITS_Back_End_main.service;

import ICT_Team2.ITS_Back_End_main.web.dto.CommentRequestDTO;
import ICT_Team2.ITS_Back_End_main.web.dto.CommentResponseDTO;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.ObjectUtils.Null;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

  //private final CommentRepository commentRepository; // Assume you have a JPA repository for Comment

  @Override
  public CommentResponseDTO.ResponseDto createComment(CommentRequestDTO.CreateDto createDto) {
    // 비즈니스 로직 구현
    // 엔티티를 저장하고, 저장된 엔티티를 ResponseDto로 변환
    return null;
  }

  @Override
  public void deleteComment(Long id, CommentRequestDTO.DeleteDto deleteDto) {
    // 비즈니스 로직 구현
    // 엔티티를 삭제

  }

  @Override
  public CommentResponseDTO.ResponseDto updateComment(Long id, CommentRequestDTO.UpdateRequestDto updateRequestDto) {
    // 비즈니스 로직 구현
    // 엔티티를 업데이트하고, 업데이트된 엔티티를 ResponseDto로 변환
    return null;
  }

  @Override
  public CommentResponseDTO.ResponseDto getComment(Long id) {
    // 비즈니스 로직 구현
    // ID에 해당하는 엔티티를 조회하고 ResponseDto로 변환
    return null;
  }

  @Override
  public List<CommentResponseDTO.ResponseDto> getAllComments() {
    // 비즈니스 로직 구현
    // 모든 엔티티를 조회하고 ResponseDto 리스트로 변환
    return null;
  }
}
