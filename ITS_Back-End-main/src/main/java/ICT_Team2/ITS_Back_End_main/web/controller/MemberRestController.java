package ICT_Team2.ITS_Back_End_main.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberRestController {
    @GetMapping("/update")
    public ApiResponse<MemberResponse.ResponseDTO> MemberRoleUpdateAPI(){
        return ApiResponse.onSuccess(UserConverter.toRoleUpdateDTO());
    }
    @GetMapping("/delete")
    public ApiResponse<MemberResponse.ResponseDTO> MemberDeleteAPI(){
        return ApiResponse.onSuccess(UserConverter.toDeleteDTO());
    }
    public ApiResponse
    @GetMapping("/signUp")
    public ApiResponse<MemberResponse.ResponseDTO> MemberSignUpAPI(){

        return ApiResponse.onSuccess(UserConverter.toSignUpDTO());
    }
    @GetMapping("/createAdmin")
    public ApiResponse<MemberResponse.ResponseDTO> MemberCreateAdminAPI(){
        return ApiResponse.onSuccess(UserConverter.toCreateAdminDTO());
    }

    @GetMapping("/signIn")
    public ApiResponse<MemberResponse.ResponseDTO> MemberSignInAPI(){
        return ApiResponse.onSuccess(UserConverter.toSignInDTO());
    }

    @GetMapping("/exception")
    public ApiResponse<MemResponse.MemberExceptionDTO> exceptionAPI(){
        return null;
    }

}
