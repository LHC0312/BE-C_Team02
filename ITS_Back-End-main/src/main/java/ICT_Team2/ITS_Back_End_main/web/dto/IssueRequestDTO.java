package ICT_Team2.ITS_Back_End_main.web.dto;

import lombok.Getter;

public class IssueRequestDTO {
    @Getter
    public static class IssueAssignRequestDTO {
        Long issueId;
        Long assigneeId;
    }

    @Getter
    public static class IssueCreateDTO {
        String title;
        String description;
        Long projectId;
        String category;
    }

    @Getter
    public static class IssueDeleteRequestDTO {
        Long issueId;
    }

    @Getter
    public static class StatusUpdateDTO {
        Long issueId;
        String description;
        String status;
        String priority;
        String category;
    }

    @Getter
    public static class IssueUpdateRequestDTO {
        Long issueId;
        String description;
        String status;
        String priority;
        String category;
    }

    @Getter
    public static class IssueStatusUpdateRequestDTO {
        Long issueId;
        String status;
    }

}
