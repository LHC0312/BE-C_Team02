package ICT_Team2.ITS_Back_End_main.converter;

import ICT_Team2.ITS_Back_End_main.domain.User;
import ICT_Team2.ITS_Back_End_main.domain.mapping.Member;
import ICT_Team2.ITS_Back_End_main.web.dto.MemberRequestDTO;

public class UserConverter {
    public static MemberRequestDTO.SignInDto toSignInDTO(User user) {

        return MemberRequestDTO.SignInDto.builder()
                .signId(user.getSignId())
                .password(user.getPassword())
                .build();
    }

    public static MemberRequestDTO.RoleUpdateDto toRoleUpdateDTO(User user) {
        return MemberRequestDTO.RoleUpdateDto.builder()
                .role(member.getRole())
                .build();
    }

    public static MemberRequestDTO.SignUpDTO toSignUpDTO(User user){
        return MemberRequestDTO.SignUpDTO.builder()
                .signId(user.getSignId())
                .password(user.getPassword())
                .name(user.getName())
                .role(user.getRole())
                .build();
    }

    public static MemberRequestDTO.DeleteDTO toDeleteDTO(User user){
        return MemberRequestDTO.DeleteDTO.builder()
                .id(user.getId())
                .build();

    }

    public static MemberRequestDTO.CreatedAdminDTO toCreatedAdmin(User user){
        return MemberRequestDTO.CreatedAdmin.builder()
                .signId(user.getSignId())
                .password(user.getPassword())
                .name(user.getName())
                .role(user.getRole())
                .bulid();
    }

}

