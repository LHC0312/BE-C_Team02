package ICT_Team2.ITS_Back_End_main.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ICT_Team2.ITS_Back_End_main.domain.enums.Role;

public class MemberRequestDTO {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class DeleteDto {
        private Long id;  // HEAD에서 Long 타입으로 유지
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RoleUpdateDto {
        private Long id;  // HEAD에서 Long 타입으로 유지
        private Role role;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SignInDto {
        private String signId;
        private String password;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SignUpDto {
        private String signId;
        private String password;
        private String name;
        private Role role;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CreatedAdmin {
        private String signId;
        private String password;
        private String name;
        private Role role;
    }
}

