package ICT_Team2.ITS_Back_End_main.web.dto;

<<<<<<< HEAD
import ICT_Team2.ITS_Back_End_main.domain.enums.Status;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ICT_Team2.ITS_Back_End_main.domain.enums.Role;

import java.time.LocalDate;

public class MemberRequestDTO {
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UserDto{
        private Long id;
        private String signId;
        private String password;
        private String name;
        private LocalDate inactiveDate;
        private boolean isDeleted;
        private Role role;
        private Status status;

    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UserDeleteDto {
        private Long id;
        private Status status;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UserRoleUpdateDto {
        private Long id;
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
        private Long id;
        private String signId;
        private String password;
        private String name;
        private Role role;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CreatedAdminDto {
        private String signId;
        private String password;
        private String name;
        private Role role;
    }
=======
public class MemberRequestDTO {
>>>>>>> 8146e61ea944e080fbdeaf825f8c0674470a7e53
}
