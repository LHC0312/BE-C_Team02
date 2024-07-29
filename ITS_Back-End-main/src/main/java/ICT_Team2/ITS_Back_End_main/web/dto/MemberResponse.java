package ICT_Team2.ITS_Back_End_main.web.dto;
import ICT_Team2.ITS_Back_End_main.domain.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class MemberResponse {

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MemberResponseDTO {
        long id;
        String signId;
        String name;
        Role role;
        Boolean isDeleted;
    }

    @Getter
    @Builder
    @AllArgsConstructor
    public static class MemberFindExceptionResponseDTO {
        // 추가 필드가 필요하면 여기에 추가
    }
}

