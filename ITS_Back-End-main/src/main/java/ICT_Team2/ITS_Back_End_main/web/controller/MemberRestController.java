package ICT_Team2.ITS_Back_End_main.web.controller;

import ICT_Team2.ITS_Back_End_main.apiPayLoad.ApiResponse;
import ICT_Team2.ITS_Back_End_main.web.dto.MemberRequestDTO;
import ICT_Team2.ITS_Back_End_main.web.dto.MemberResponse;
import ICT_Team2.ITS_Back_End_main.service.MemberCommandService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberRestController {

    private final MemberCommandService memberCommandService;

    @PostMapping("/update")
    public ApiResponse<MemberResponse.MemberResponseDTO> updateMemberRole(@RequestBody MemberRequestDTO.RoleUpdateDTO roleUpdateDto) {
        MemberResponse.MemberResponseDTO updatedMember = memberCommandService.updateRole(roleUpdateDto);
        return ApiResponse.onSuccess(updatedMember);
    }

    @DeleteMapping("/delete")
    public ApiResponse<Void> deleteMember(@RequestBody MemberRequestDTO.UserDeleteDTO deleteDto) {
        MemberResponse.MemberResponseDTO newMember = memberCommandService.deleteMember(deleteDto);
        return ApiResponse.onSuccess(null);
    }

    @PostMapping("/signUp")
    public ApiResponse<MemberResponse.MemberResponseDTO> signUpMember(@RequestBody MemberRequestDTO.SignUpDTO signUpDto) {
        MemberResponse.MemberResponseDTO newMember = memberCommandService.signUp(signUpDto);
        return ApiResponse.onSuccess(newMember);
    }

    @PostMapping("/createAdmin")
    public ApiResponse<MemberResponse.MemberResponseDTO> createAdmin(@RequestBody MemberRequestDTO.CreatedAdminDTO createdAdminDto) {
        MemberResponse.MemberResponseDTO newAdmin = memberCommandService.createdAdmin(createdAdminDto);
        return ApiResponse.onSuccess(newAdmin);
    }

    @PostMapping("/signIn")
    public ApiResponse<MemberResponse.MemberResponseDTO> signInMember(@RequestBody MemberRequestDTO.SignInDTO signInDto) {
        MemberResponse.MemberResponseDTO signedInMember = memberCommandService.signIn(signInDto);
        return ApiResponse.onSuccess(signedInMember);
    }
}

