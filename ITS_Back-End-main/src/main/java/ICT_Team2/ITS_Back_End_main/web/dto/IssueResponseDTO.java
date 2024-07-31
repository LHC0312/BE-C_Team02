package ICT_Team2.ITS_Back_End_main.web.dto;

import lombok.Getter;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.List;


public class IssueResponseDTO {

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
}
