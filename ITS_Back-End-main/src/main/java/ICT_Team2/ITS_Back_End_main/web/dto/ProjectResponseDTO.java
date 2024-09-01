package ICT_Team2.ITS_Back_End_main.web.dto;

import ICT_Team2.ITS_Back_End_main.domain.Issue;
import ICT_Team2.ITS_Back_End_main.domain.Member;
import lombok.*;
import org.springframework.stereotype.Service;

import java.security.PrivateKey;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Getter
@Setter
public class ProjectResponseDTO {

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ProjectResponeDto {
        private Long id;
        private String name;
        private List<MemberResponseDTO.MemberResponseDto> members;
        private List<IssueResponseDTO.IssueResponseDto> issues;

    }
}
