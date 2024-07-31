package ICT_Team2.ITS_Back_End_main.converter;

import ICT_Team2.ITS_Back_End_main.domain.User;
import ICT_Team2.ITS_Back_End_main.web.dto.MemberRequestDTO;
import ICT_Team2.ITS_Back_End_main.web.dto.MemberResponse;

public class UserConverter {

    public static MemberRequestDTO.SignInDTO toSignInDTO(User user) {
        return MemberRequestDTO.SignInDTO.builder()
                .signId(user.getSignId())
                .password(user.getPassword())
                .build();
    }

    public static MemberRequestDTO.RoleUpdateDTO toRoleUpdateDTO(User user) {
        return MemberRequestDTO.RoleUpdateDTO.builder()
                .id(user.getId())  // ID가 필요할 수 있습니다.
                .role(user.getRole())
                .build();
    }

    public static MemberRequestDTO.SignUpDTO toSignUpDTO(User user) {
        return MemberRequestDTO.SignUpDTO.builder()
                .signId(user.getSignId())
                .password(user.getPassword())
                .name(user.getName())
                .role(user.getRole())
                .build();
    }

    public static MemberRequestDTO.UserDeleteDTO toDeleteDTO(User user) {
        return MemberRequestDTO.UserDeleteDTO.builder()
                .id(user.getId())
                .build();
    }

    public static MemberRequestDTO.CreatedAdminDTO toCreatedAdmin(User user) {
        return MemberRequestDTO.CreatedAdminDTO.builder()
                .signId(user.getSignId())
                .password(user.getPassword())
                .name(user.getName())
                .role(user.getRole())
                .build();
    }

    public static MemberResponse.MemberFindExceptionResponseDTO toMemberFindResponseDTO() {
        return MemberResponse.MemberFindExceptionResponseDTO.builder()
                .build();
    }
}

