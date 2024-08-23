package ICT_Team2.ITS_Back_End_main.web.dto;

import lombok.*;

import java.time.LocalDateTime;

public class CommentRequestDTO {
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class CommentCreateDto {
        private Long issueId;
        private Long writerId;
        private String context;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class CommentDeleteDto {
        private Long id;
        private Long writerId;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class CommentUpdateRequestDto {
        private Long id;
        private Long writerId;
        private String context;
        private LocalDateTime inactiveDate;
        private Boolean isDeleted;
    }

}
