package ICT_Team2.ITS_Back_End_main.web.dto;

import ICT_Team2.ITS_Back_End_main.domain.mapping.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

public class ProjectRequestDTO {
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ProjectCreateDto{
        private String name;
        private List<Long> memberIds;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MemberAddDto{
        private Long addMemberId;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MemberRemoveDto{
        private Long removeMemberId;
    }
}
