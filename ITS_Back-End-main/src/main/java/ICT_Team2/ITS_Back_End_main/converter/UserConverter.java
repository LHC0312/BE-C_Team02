package ICT_Team2.ITS_Back_End_main.converter;

import ICT_Team2.ITS_Back_End_main.domain.User;
import ICT_Team2.ITS_Back_End_main.domain.mapping.Member;
import ICT_Team2.ITS_Back_End_main.web.dto.MemberRequestDTO;
import ICT_Team2.ITS_Back_End_main.web.dto.MemberResponseDTO;

public class UserConverter {
    public static User toUser(MemberRequestDTO.SignUpDto request){
        return User.builder()
                .id(request.getId())
                .signId(request.getSignId())
                .password(request.getPassword())
                .name(request.getName())
                .role(request.getRole())
                .isDeleted(false)  // 관리자도 활성화 상태로 생성
                .build();
    }


    // MemberRequestDTO.UserRoleUpdateDto -> User
    public static User toUser(MemberRequestDTO.UserRoleUpdateDto request) {
        return User.builder()
                .id(request.getId())
                .role(request.getRole())
                .build();
    }

    // MemberRequestDTO.UserDeleteDto -> User
    public static User toUser(MemberRequestDTO.UserDeleteDto request) {
        return User.builder()
                .id(request.getId())
                .build();
    }

    // MemberRequestDTO.CreatedAdminDto -> User
    public static User toUser(MemberRequestDTO.CreatedAdminDto request) {
        return User.builder()
                .signId(request.getSignId())
                .password(request.getPassword())
                .name(request.getName())
                .role(request.getRole())
                .isDeleted(false)  // 관리자도 활성화 상태로 생성
                .build();
    }

    public static User toUser(MemberRequestDTO.SignInDto request){
        return User.builder()
                .signId(request.getSignId())
                .password(request.getPassword())
                .build();
    }



    // User -> MemberResponseDTO.MemberResponseDto (역할 업데이트용 DTO)
    public static MemberResponseDTO.MemberResponseDto toRoleUpdateDTO(User user) {
        return MemberResponseDTO.MemberResponseDto.builder()
                .id(user.getId())
                .role(user.getRole())
                .build();
    }

    // User -> MemberResponseDTO.MemberResponseDto (회원가입용 DTO)
    public static MemberResponseDTO.MemberResponseDto toSignUpDTO(User user) {
        return MemberResponseDTO.MemberResponseDto.builder()
                .id(user.getId())
                .signId(user.getSignId())
                .name(user.getName())
                .role(user.getRole())
                .isDeleted(user.isDeleted())
                .build();
    }

    // User -> MemberResponseDTO.MemberResponseDto (일반적인 사용자 정보 DTO 변환)
    public static MemberResponseDTO.MemberResponseDto toUserDTO(User user) {
        return MemberResponseDTO.MemberResponseDto.builder()
                .id(user.getId())
                .signId(user.getSignId())
                .name(user.getName())
                .role(user.getRole())
                .isDeleted(user.isDeleted())
                .build();
    }
}


