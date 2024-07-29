package ICT_Team2.ITS_Back_End_main.web.controller;

import ICT_Team2.ITS_Back_End_main.apiPayLoad.ApiResponse;
import ICT_Team2.ITS_Back_End_main.converter.UserConverter;
import ICT_Team2.ITS_Back_End_main.service.MemberCommandService;
import ICT_Team2.ITS_Back_End_main.web.dto.MemberResponse;
import ICT_Team2.ITS_Back_End_main.web.dto.MemberRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import static org.hibernate.criterion.Projections.id;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberRestController {
    private final MemberCommandService memberCommandService;

    @PostMapping("/update")
    public ApiResponse<MemberResponse.MemberResponseDTO> MemberRoleUpdateAPI(@RequestBody MemberRequestDTO.RoleUpdateDTO roleUpdateDTO) {
        MemberResponse.MemberResponseDTO updatedMember = memberCommandService.updateRole(roleUpdateDTO);
        return ApiResponse.onSuccess(updatedMember);
    }

    @DeleteMapping("/delete")
    public ApiResponse<Void> MemberDeleteAPI(@RequestBody MemberRequestDTO.DeleteDTO deleteDTO) {
        memberCommandService.deleteMember(deleteDTO.getId());
        return ApiResponse.onSuccess(null);
    }

    @PostMapping("/signUp")
    public ApiResponse<MemberResponse.MemberResponseDTO> MemberSignUpAPI(@RequestBody MemberRequestDTO.SignUpDTO signUpDTO) {
        MemberResponse.MemberResponseDTO newMember = memberCommandService.signUp(signUpDTO);
        return ApiResponse.onSuccess(newMember);
    }

    @PostMapping("/createAdmin")
    public ApiResponse<MemberResponse.MemberResponseDTO> MemberCreateAdminAPI(@RequestBody MemberRequestDTO.CreatedAdminDTO createdAdminDTO) {
        MemberResponse.MemberResponseDTO newAdmin = memberCommandService.createdAdmin(createdAdminDTO);
        return ApiResponse.onSuccess(newAdmin);
    }

    @PostMapping("/signIn")
    public ApiResponse<MemberResponse.MemberResponseDTO> MemberSignInAPI(@RequestBody MemberRequestDTO.SignInDTO signInDTO) {
        MemberResponse.MemberResponseDTO signedInMember = memberCommandService.signIn(signInDTO);
        return ApiResponse.onSuccess(signedInMember);
    }
}
