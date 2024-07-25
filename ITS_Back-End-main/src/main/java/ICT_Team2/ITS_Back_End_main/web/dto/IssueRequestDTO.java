package ICT_Team2.ITS_Back_End_main.web.dto;

import lombok.Getter;

public class IssueRequestDTO {
    @Getter
    public static class IssueAssignRequestDto{
        Long issueId;
        Long assigneeId;
    }

    @Getter
    public static class IssueCreateRequestDto {
        String title;
        String description;
        String projectId;
        String category;
    }

    @Getter
    public static class IssueDeleteRequestDto{
        Long id;
    }

    @Getter
    public static class StatusUpdateDto{
        Long issueId;
        String description;
        String status;
        String priority;
        String category;
    }

    @Getter
    public static class IssueUpdateRequestDto{
        Long issueId;
        String description;
        String status;
        String priorit;
        String category;
    }

    @Getter
    public static class IssueStatusUpdateRequestDto{
        Long issueId;
        String status;
    }

}
