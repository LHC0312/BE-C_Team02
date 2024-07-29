package ICT_Team2.ITS_Back_End_main.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Data;

import ICT_Team2.ITS_Back_End_main.domain.enums.Role;

public class MemberRequestDTO {
    @Getter
    @Builder
    @Data
    public static class DeleteDTO {
        private Long id;
    }

    @Getter
    @Builder
    @Data
    public static class RoleUpdateDTO {
        private Long id;
        private Role role;
    }

    @Getter
    @Builder
    @Data
    public static class SignInDTO {
        private String signId;
        private String password;
    }

    @Getter
    @Builder
    @Data
    public static class SignUpDTO {
        private String signId;
        private String password;
        private String name;
        private Role role;
    }

    @Getter
    @Builder
    @Data
    public static class CreatedAdminDTO {
        private String signId;
        private String password;
        private String name;
        private Role role;
    }
}
