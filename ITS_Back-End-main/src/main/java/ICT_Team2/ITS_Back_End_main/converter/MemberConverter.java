package ICT_Team2.ITS_Back_End_main.converter;

import ICT_Team2.ITS_Back_End_main.domain.Issue;
import ICT_Team2.ITS_Back_End_main.domain.Member;
import ICT_Team2.ITS_Back_End_main.web.dto.IssueResponseDTO;
import ICT_Team2.ITS_Back_End_main.web.dto.MemberRequestDTO;
import ICT_Team2.ITS_Back_End_main.web.dto.MemberResponseDTO;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MemberConverter {
    public static Member toMember(MemberRequestDTO.SignUpDto request){
        return Member.builder()
                .signId(request.getSignId())
                .password(request.getPassword())
                .name(request.getName())
                .role(request.getRole())
                .isDeleted(false)  // 관리자도 활성화 상태로 생성
                .build();
    }


    // MemberRequestDTO.UserRoleUpdateDto -> Member
    public static Member toMember(MemberRequestDTO.MemberRoleUpdateDto request) {
        return Member.builder()
                .id(request.getId())
                .role(request.getRole())
                .build();
    }

    // MemberRequestDTO.UserDeleteDto -> Member
    public static Member toMember(MemberRequestDTO.MemberDeleteDto request) {
        return Member.builder()
                .id(request.getId())
                .build();
    }

    // MemberRequestDTO.CreatedAdminDto -> Member
    public static Member toMember(MemberRequestDTO.CreatedAdminDto request) {
        return Member.builder()
                .signId(request.getSignId())
                .password(request.getPassword())
                .name(request.getName())
                .role(request.getRole())
                .isDeleted(false)  // 관리자도 활성화 상태로 생성
                .build();
    }

    public static Member toMember(MemberRequestDTO.SignInDto request){
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
                .build();
    }

    // Member -> MemberResponseDTO.MemberResponseDto (일반적인 사용자 정보 DTO 변환)
    public static MemberResponseDTO.MemberResponseDto toUserDTO(Member member) {

        if (member == null) return null;

        return MemberResponseDTO.MemberResponseDto.builder()
                .id(member.getId())
                .signId(member.getSignId())
                .name(member.getName())
                .role(member.getRole())
                .build();
    }

    public static List<MemberResponseDTO.MemberResponseDto> toUserDTO(List<Member> members) {
        return members.stream()
                .map(MemberConverter::toUserDTO)
                .collect(Collectors.toList());
    }
}


