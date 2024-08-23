package ICT_Team2.ITS_Back_End_main.web.dto;

<<<<<<< HEAD
import ICT_Team2.ITS_Back_End_main.domain.Issue;
import ICT_Team2.ITS_Back_End_main.domain.mapping.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

public class ProjectResponseDTO {
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ProjectResponseDto{
        private Long id;
        private String name;
        private List<Member> members;
        private List<Issue> issues;
        private Long leaderId;
        private boolean isDeleted;
    }
=======
public class ProjectResponseDTO {
>>>>>>> 8146e61ea944e080fbdeaf825f8c0674470a7e53
}
