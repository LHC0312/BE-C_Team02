package ICT_Team2.ITS_Back_End_main.web.dto;

public class CommentRequestDTO {
<<<<<<< HEAD
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
=======
>>>>>>> 8146e61ea944e080fbdeaf825f8c0674470a7e53
}
