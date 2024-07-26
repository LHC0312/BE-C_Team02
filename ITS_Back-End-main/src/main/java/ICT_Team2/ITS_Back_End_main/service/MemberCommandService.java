package ICT_Team2.ITS_Back_End_main.service;

import ICT_Team2.ITS_Back_End_main.web.dto.MemberRequestDTO;
import ICT_Team2.ITS_Back_End_main.web.dto.MemberResponseDTO;

public interface MemberCommandService {
    MemberResponseDTO.ResponseDto signUp(MemberRequestDTO.SignUpDto signUpDto);
    MemberResponseDTO.ResponseDto signIn(MemberRequestDTO.SignInDto signInDto);
    MemberResponseDTO.ResponseDto updateRole(MemberRequestDTO.RoleUpdateDto roleUpdateDto);
    MemberResponseDTO.ResponseDto deleteMember(MemberRequestDTO.DeleteDTO deleteDto);
}
