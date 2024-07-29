package ICT_Team2.ITS_Back_End_main.converter;

import ICT_Team2.ITS_Back_End_main.domain.Issue;
import ICT_Team2.ITS_Back_End_main.web.dto.IssueResponseDTO;
import java.util.List;
import java.util.stream.Collectors;

public class IssueConverter {
    public static IssueResponseDTO.IssueResponseDto toGetResultDTO(Issue issue) {
        return IssueResponseDTO.IssueResponseDto.builder()
                    // 내용 입력
                .build();
    }

    public static List<IssueResponseDTO.IssueResponseDto> toGetResultDTO(List<Issue> issues) {
        return issues.stream()
                .map(IssueConverter::toGetResultDTO)
                .collect(Collectors.toList());
    }
}
