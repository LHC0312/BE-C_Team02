package ICT_Team2.ITS_Back_End_main.service;

import ICT_Team2.ITS_Back_End_main.web.dto.MemberRequestDTO;
import ICT_Team2.ITS_Back_End_main.web.dto.MemberResponseDTO;

public interface MemberCommandService {
    MemberResponseDTO.ResponseDTO signUp(MemberRequestDTO.SignUpDTO signUpDto);
    MemberResponseDTO.ResponseDTO signIn(MemberRequestDTO.SignInDTO signInDto);
    MemberResponseDTO.ResponseDTO updateRole(MemberRequestDTO.RoleUpdateDTO roleUpdateDto);
    MemberResponseDTO.ResponseDTO deleteMember(MemberRequestDTO.DeleteDTO deleteDto);
}