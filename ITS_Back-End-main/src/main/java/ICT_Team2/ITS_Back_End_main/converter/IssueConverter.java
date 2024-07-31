package ICT_Team2.ITS_Back_End_main.converter;//package ICT_Team2.ITS_Back_End_main.converter;

import ICT_Team2.ITS_Back_End_main.domain.Issue;
import ICT_Team2.ITS_Back_End_main.domain.User;
import ICT_Team2.ITS_Back_End_main.domain.enums.Status;
import ICT_Team2.ITS_Back_End_main.web.dto.IssueRequestDTO;
import ICT_Team2.ITS_Back_End_main.web.dto.IssueResponseDTO;

public class IssueConverter {
    public static IssueResponseDTO.IssueResponseDto toIssueResponeDto(Issue issue) {

        //reporter = Get
        return IssueResponseDTO.IssueResponseDto.builder()
                .title(issue.getTitle())
                .description(issue.getDescription())
                .priority(issue.getPriority().toString())
                //.status(issue.getStatus().toString())
                //.reporter(issue.getRepoter())
                .build();
    }

    public static Issue toIssue(IssueRequestDTO.IssueCreateRequestDto request) {


        return Issue.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .status(Status.NEW)
                .category(request.getCategory())
                .isDeleted(false)
                .build();
    }
}
