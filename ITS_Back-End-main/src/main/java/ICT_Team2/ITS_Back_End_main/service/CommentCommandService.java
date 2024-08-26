package ICT_Team2.ITS_Back_End_main.service;

import ICT_Team2.ITS_Back_End_main.web.dto.CommentRequestDTO;

public interface CommentCommandService {
    void deleteComment(Long id, CommentRequestDTO.CommentDeleteDto deleteDto);
}
