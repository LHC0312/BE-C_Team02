package ICT_Team2.ITS_Back_End_main.converter;

import ICT_Team2.ITS_Back_End_main.domain.Member;
import ICT_Team2.ITS_Back_End_main.web.dto.MemberRequestDTO;
import ICT_Team2.ITS_Back_End_main.web.dto.MemberResponseDTO;

public class MemeberConverter {
    public static Member toUser(MemberRequestDTO.SignUpDto request){
        return Member.builder()
                .id(request.getId())
                .signId(request.getSignId())
                .password(request.getPassword())
                .name(request.getName())
                .role(request.getRole())
                .isDeleted(false)  // 관리자도 활성화 상태로 생성
                .build();
    }


    // MemberRequestDTO.UserRoleUpdateDto -> Member
    public static Member toUser(MemberRequestDTO.UserRoleUpdateDto request) {
        return Member.builder()
                .id(request.getId())
                .role(request.getRole())
                .build();
    }

    // MemberRequestDTO.UserDeleteDto -> Member
    public static Member toUser(MemberRequestDTO.UserDeleteDto request) {
        return Member.builder()
                .id(request.getId())
                .build();
    }

    // MemberRequestDTO.CreatedAdminDto -> Member
    public static Member toUser(MemberRequestDTO.CreatedAdminDto request) {
        return Member.builder()
                .signId(request.getSignId())
                .password(request.getPassword())
                .name(request.getName())
                .role(request.getRole())
                .isDeleted(false)  // 관리자도 활성화 상태로 생성
                .build();
    }

    public static Member toUser(MemberRequestDTO.SignInDto request){
        return Member.builder()
                .signId(request.getSignId())
                .password(request.getPassword())
                .build();
    }



    // Member -> MemberResponseDTO.MemberResponseDto (역할 업데이트용 DTO)
    public static MemberResponseDTO.MemberResponseDto toRoleUpdateDTO(Member member) {
        return MemberResponseDTO.MemberResponseDto.builder()
                .id(member.getId())
                .role(member.getRole())
                .build();
    }

    // Member -> MemberResponseDTO.MemberResponseDto (회원가입용 DTO)
    public static MemberResponseDTO.MemberResponseDto toSignUpDTO(Member member) {
        return MemberResponseDTO.MemberResponseDto.builder()
                .id(member.getId())
                .signId(member.getSignId())
                .name(member.getName())
                .role(member.getRole())
                .isDeleted(member.isDeleted())
                .build();
    }

    // Member -> MemberResponseDTO.MemberResponseDto (일반적인 사용자 정보 DTO 변환)
    public static MemberResponseDTO.MemberResponseDto toUserDTO(Member member) {
        return MemberResponseDTO.MemberResponseDto.builder()
                .id(member.getId())
                .signId(member.getSignId())
                .name(member.getName())
                .role(member.getRole())
                .isDeleted(member.isDeleted())
                .build();
    }
}


