package ICT_Team2.ITS_Back_End_main.web.dto;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class CommentResponseDTO {
  @Getter
  @Setter
  @NoArgsConstructor
  @AllArgsConstructor
  @Builder

  public static class ResponseDto {
    private Long id;
    private Long issueId;
    private Long writerId;
    private String context;
    private LocalDateTime createdAt;
    private LocalDateTime inactiveDate;
    private Boolean isDeleted;
    private LocalDateTime updatedAt;
  }
}