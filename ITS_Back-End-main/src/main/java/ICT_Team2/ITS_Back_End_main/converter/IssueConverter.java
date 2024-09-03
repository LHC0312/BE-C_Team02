package ICT_Team2.ITS_Back_End_main.converter;

import ICT_Team2.ITS_Back_End_main.domain.Comment;
import ICT_Team2.ITS_Back_End_main.domain.Issue;
import ICT_Team2.ITS_Back_End_main.domain.Member;
import ICT_Team2.ITS_Back_End_main.domain.Project;
import ICT_Team2.ITS_Back_End_main.domain.enums.Priority;
import ICT_Team2.ITS_Back_End_main.domain.enums.Status;
import ICT_Team2.ITS_Back_End_main.web.dto.IssueRequestDTO;
import ICT_Team2.ITS_Back_End_main.web.dto.IssueResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

public class IssueConverter {

    public static IssueResponseDTO.IssueResponseDto toResultDTO(Issue issue) {
        if (issue == null) return null;

        return IssueResponseDTO.IssueResponseDto.builder()
                .id(issue.getId())
                .title(issue.getTitle())
                .description(issue.getDescription())
                .priority(issue.getPriority().toString())
                .status(issue.getStatus().toString())
                .reporter( MemberConverter.toUserDTO(issue.getReporter()) )
                .comments( CommentConverter.toResponseDto(issue.getCommentList()) )
                .assignee( MemberConverter.toUserDTO(issue.getAssignee()) )
                .reportedDate(issue.getReportedDate())
                .fixer( MemberConverter.toUserDTO(issue.getFixer()) )
                .projectId(issue.getProject().getId())
                .build();
    }

    public static List<IssueResponseDTO.IssueResponseDto> toResultDTO(List<Issue> issues) {
        if (issues == null) return null;
        return issues.stream()
                .map(IssueConverter::toResultDTO)
                .collect(Collectors.toList());
    }

    public static Issue toIssue(IssueRequestDTO.IssueCreateDTO request, Project project, Member reporter) {

        return Issue.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .project(project)
                .reporter(reporter)
                .category(request.getCategory())
                .priority(Priority.MAJOR)
                .status(Status.NEW)
                .build();
    }

    public static IssueResponseDTO.IssueRecommandDto toRecommendDTO(Issue issue) {
        return IssueResponseDTO.IssueRecommandDto.builder()
                .issueResponseDto(toResultDTO(issue))
                .score(issue.getScore())
                .build();
    }

    public static List<IssueResponseDTO.IssueRecommandDto> toRecommendDTO(List<Issue> issues) {
        return issues.stream()
                .map(IssueConverter::toRecommendDTO)
                .collect(Collectors.toList());
    }
}
