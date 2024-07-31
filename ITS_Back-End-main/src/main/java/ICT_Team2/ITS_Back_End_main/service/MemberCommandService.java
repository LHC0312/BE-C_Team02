package ICT_Team2.ITS_Back_End_main.service;

import ICT_Team2.ITS_Back_End_main.web.dto.MemberRequestDTO;
import ICT_Team2.ITS_Back_End_main.web.dto.MemberResponse;

public interface MemberCommandService {
    MemberResponse.MemberResponseDTO signUp(MemberRequestDTO.SignUpDTO signUpDto);
    MemberResponse.MemberResponseDTO signIn(MemberRequestDTO.SignInDTO signInDto);
    MemberResponse.MemberResponseDTO updateRole(MemberRequestDTO.RoleUpdateDTO roleUpdateDto);
    MemberResponse.MemberResponseDTO deleteMember(MemberRequestDTO.UserDeleteDTO deleteDto);
    MemberResponse.MemberResponseDTO createdAdmin(MemberRequestDTO.CreatedAdminDTO createdAdminDTO);  // 추가된 메서드
}

