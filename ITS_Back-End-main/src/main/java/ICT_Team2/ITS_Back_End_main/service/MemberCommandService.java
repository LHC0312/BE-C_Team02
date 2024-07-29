package ICT_Team2.ITS_Back_End_main.service;

import ICT_Team2.ITS_Back_End_main.web.dto.MemberRequestDTO;
import ICT_Team2.ITS_Back_End_main.web.dto.MemberResponse;

public interface MemberCommandService {
    MemberResponse.MemberResponseDTO signUp(MemberRequestDTO.SignUpDto signUpDto);
    MemberResponse.MemberResponseDTO signIn(MemberRequestDTO.SignInDto signInDto);
    MemberResponse.MemberResponseDTO updateRole(MemberRequestDTO.RoleUpdateDto roleUpdateDto);
    MemberResponse.MemberResponseDTO deleteMember(MemberRequestDTO.DeleteDto deleteDto);
    MemberResponse.MemberResponseDTO createdAdmin(MemberRequestDTO.CreatedAdmin createdAdminDTO);  // 추가된 메서드
}

