package ICT_Team2.ITS_Back_End_main.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class IssueRequestDTO {
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class IssueAssignRequestDto {
        Long issueId;
        Long assigneeId;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class IssueCreateDto {
        String title;
        String description;
        String projectId;
        String category;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class IssueDeleteRequestDto {
        Long id;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class StatusUpdateDto {
        Long issueId;
        String description;
        String status;
        String priority;
        String category;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class IssueUpdateRequestDto {
        Long issueId;
        String description;
        String status;
        String priority;
        String category;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class IssueStatusUpdateRequestDto {
        Long issueId;
        String status;
    }


}
