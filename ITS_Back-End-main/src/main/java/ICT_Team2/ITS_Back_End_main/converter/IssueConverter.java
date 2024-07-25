package ICT_Team2.ITS_Back_End_main.converter;//package ICT_Team2.ITS_Back_End_main.converter;

import ICT_Team2.ITS_Back_End_main.domain.Issue;
import ICT_Team2.ITS_Back_End_main.web.dto.IssueResponseDTO;

public class IssueConverter {
    public static IssueResponseDTO.IssueResponseDto toGetResultDTO(Issue issue) {

        //reporter = Get
        return IssueResponseDTO.IssueResponseDto.builder()
                .title(issue.getTitle())
                .description(issue.getDescription())
                .priority(issue.getPriority().toString())
                //.status(issue.getStatus().toString())
                //.reporter(issue.getRepoter())
                .build();
    }
}
