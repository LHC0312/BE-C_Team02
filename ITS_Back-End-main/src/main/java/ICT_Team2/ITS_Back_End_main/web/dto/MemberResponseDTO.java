package ICT_Team2.ITS_Back_End_main.web.dto;

import ICT_Team2.ITS_Back_End_main.domain.enums.Role;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

public class MemberResponseDTO {
    @Getter
    @SuperBuilder
    public static class ResponseDTO{
        long id;
        String signId;
        String name;
        Role role;
        Boolean isDeleted;
    }
}
