package ICT_Team2.ITS_Back_End_main.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ICT_Team2.ITS_Back_End_main.domain.enums.Role;

public class MemberResponseDTO {

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MemberResponseDto {
        private long id;
        private String signId;
        private String name;
        private Role role;
    }


}

