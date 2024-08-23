package ICT_Team2.ITS_Back_End_main.web.dto;

<<<<<<< HEAD
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
        private String password;
        private String name;
        private Role role;
        private Boolean isDeleted;
    }

=======
public class MemberResponseDTO {
>>>>>>> 8146e61ea944e080fbdeaf825f8c0674470a7e53
}

