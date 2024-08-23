package ICT_Team2.ITS_Back_End_main.web.dto;

public class IssueResponseDTO {
<<<<<<< HEAD

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class IssueResponseDto {
        Long id;
        String title;
        String description;
        String priority;
        String status;
        MemberResponseDTO reporter;
        LocalDate reportedDate;
        MemberResponseDTO fixer;
        MemberResponseDTO assignee;
        Long projectId;
        String category;
        List<CommentResponseDTO> comments;
        @JsonProperty(value = "isDeleted")
        boolean isDeleted;
    }


    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class IssueRecommandDto {

        IssueResponseDto issueResponseDto;
        Long score;

        @JsonProperty(value = "isDeleted")
        boolean isDeleted;
    }
=======
>>>>>>> 8146e61ea944e080fbdeaf825f8c0674470a7e53
}

