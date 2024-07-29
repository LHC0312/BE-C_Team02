package ICT_Team2.ITS_Back_End_main.converter;

import ICT_Team2.ITS_Back_End_main.domain.User;
import ICT_Team2.ITS_Back_End_main.web.dto.MemberRequestDTO;
import ICT_Team2.ITS_Back_End_main.web.dto.MemberResponse;

public class UserConverter {

    public static MemberRequestDTO.SignInDto toSignInDTO(User user) {
        return MemberRequestDTO.SignInDto.builder()
                .signId(user.getSignId())
                .password(user.getPassword())
                .build();
    }

    public static MemberRequestDTO.RoleUpdateDto toRoleUpdateDTO(User user) {
        return MemberRequestDTO.RoleUpdateDto.builder()
                .id(user.getId())  // ID가 필요할 수 있습니다.
                .role(user.getRole())
                .build();
    }

    public static MemberRequestDTO.SignUpDto toSignUpDTO(User user) {
        return MemberRequestDTO.SignUpDto.builder()
                .signId(user.getSignId())
                .password(user.getPassword())
                .name(user.getName())
                .role(user.getRole())
                .build();
    }

    public static MemberRequestDTO.DeleteDto toDeleteDTO(User user) {
        return MemberRequestDTO.DeleteDto.builder()
                .id(user.getId())
                .build();
    }

    public static MemberRequestDTO.CreatedAdmin toCreatedAdmin(User user) {
        return MemberRequestDTO.CreatedAdmin.builder()
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

