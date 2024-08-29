package ICT_Team2.ITS_Back_End_main.converter;

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

        return IssueResponseDTO.IssueResponseDto.builder()
                .id(issue.getId())
                .title(issue.getTitle())
                .description(issue.getDescription())
                .priority(issue.getPriority().toString())
                .status(issue.getStatus().toString())
                .reporter( MemberConverter.toUserDTO(issue.getReporter()) )
                .reportedDate(issue.getReportedDate())
                .fixer( MemberConverter.toUserDTO(issue.getFixer()) )
                .assignee( MemberConverter.toUserDTO(issue.getFixer()) )
                .projectId(issue.getProject().getId())
                .build();
    }

    public static List<IssueResponseDTO.IssueResponseDto> toResultDTO(List<Issue> issues) {
        return issues.stream()
                .map(IssueConverter::toResultDTO)
                .collect(Collectors.toList());
    }

    public static Issue toIssue(IssueRequestDTO.IssueCreateDTO request, Project project) {

        return Issue.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .project(project)
                .category(request.getCategory())
                .priority(Priority.BLOCKER)
                .status(Status.NEW)
                .build();
    }
}
