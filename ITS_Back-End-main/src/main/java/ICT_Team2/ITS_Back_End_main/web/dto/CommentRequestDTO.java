package ICT_Team2.ITS_Back_End_main.web.dto;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class CommentRequestDTO {
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class CreateDto {
        private Long issueId;
        private Long writerId;
        private String context;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class DeleteDto {
        private Long id;
        private Long writerId;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class UpdateRequestDto {
        private Long id;
        private Long writerId;
        private String context;
        private LocalDateTime inactiveDate;
        private Boolean isDeleted;
    }
}
