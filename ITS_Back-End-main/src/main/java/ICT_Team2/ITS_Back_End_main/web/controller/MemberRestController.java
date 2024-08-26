package ICT_Team2.ITS_Back_End_main.web.controller;

import ICT_Team2.ITS_Back_End_main.apiPayLoad.ApiResponse;
import ICT_Team2.ITS_Back_End_main.converter.MemeberConverter;
import ICT_Team2.ITS_Back_End_main.domain.Member;
import ICT_Team2.ITS_Back_End_main.service.memberService.MemberQueryService;
import ICT_Team2.ITS_Back_End_main.web.dto.MemberRequestDTO;
import ICT_Team2.ITS_Back_End_main.web.dto.MemberResponseDTO;
import ICT_Team2.ITS_Back_End_main.service.memberService.MemberCommandService;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/projectMembership")
@RequiredArgsConstructor
public class MemberRestController {

    private final MemberCommandService memberCommandService;
    private final MemberQueryService memberQueryService;

    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",description = "OK"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "Bad Request",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "401", description = "Unauthorized",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "500", description = "Internal Server Error",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "503", description = "Service Unavailable",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @PutMapping("/account/update")
    public ApiResponse<MemberResponseDTO.MemberResponseDto> updateMemberRole(@RequestBody MemberRequestDTO.UserRoleUpdateDto roleUpdateDto) {
        Member member = MemeberConverter.toMember(roleUpdateDto);  // DTO -> Member
        member = memberCommandService.updateRole(member);

        MemberResponseDTO.MemberResponseDto responseDto = MemeberConverter.toUserDTO(member);  // Member -> DTO
        return ApiResponse.onSuccess(responseDto);
    }
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",description = "OK"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "Bad Request",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "401", description = "Unauthorized",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "500", description = "Internal Server Error",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "503", description = "Service Unavailable",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @PutMapping("/account/delete")
    public ApiResponse<MemberResponseDTO.MemberResponseDto> deleteMember(@RequestBody MemberRequestDTO.UserDeleteDto deleteDto) {
        Member member = MemeberConverter.toMember(deleteDto);  // DTO -> Member
        member =memberCommandService.deleteMember(member);
        MemberResponseDTO.MemberResponseDto responseDto= MemeberConverter.toUserDTO(member);

        return ApiResponse.onSuccess(responseDto);
    }
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",description = "OK"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "Bad Request",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "401", description = "Unauthorized",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "500", description = "Internal Server Error",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "503", description = "Service Unavailable",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @PostMapping("/signUp")
    public ApiResponse<MemberResponseDTO.MemberResponseDto> signUpMember(@RequestBody MemberRequestDTO.SignUpDto signUpDto) {
        Member member = MemeberConverter.toMember(signUpDto);  // DTO -> Member
        member = memberCommandService.signUp(member);

        MemberResponseDTO.MemberResponseDto responseDto = MemeberConverter.toSignUpDTO(member);  // Member -> DTO
        return ApiResponse.onSuccess(responseDto);
    }
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",description = "OK"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "Bad Request",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "401", description = "Unauthorized",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "500", description = "Internal Server Error",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "503", description = "Service Unavailable",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @PostMapping("/createAdmin")
    public ApiResponse<MemberResponseDTO.MemberResponseDto> createAdmin(@RequestBody MemberRequestDTO.CreatedAdminDto createdAdminDto) {
        Member member = MemeberConverter.toMember(createdAdminDto);  // DTO -> Member
        member = memberCommandService.createAdmin(member);

        MemberResponseDTO.MemberResponseDto responseDto = MemeberConverter.toUserDTO(member);  // Member -> DTO
        return ApiResponse.onSuccess(responseDto);
    }
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",description = "OK"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "Bad Request",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "401", description = "Unauthorized",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "500", description = "Internal Server Error",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "503", description = "Service Unavailable",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @PostMapping("/signIn")
    public ApiResponse<MemberResponseDTO.MemberResponseDto> signInMember(@RequestBody MemberRequestDTO.SignInDto signInDto) {
        Member member = MemeberConverter.toMember(signInDto);  // DTO -> Member
        member = memberCommandService.signIn(member);

        MemberResponseDTO.MemberResponseDto responseDto = MemeberConverter.toUserDTO(member);  // Member -> DTO
        return ApiResponse.onSuccess(responseDto);
    }
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",description = "OK"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "Bad Request",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "401", description = "Unauthorized",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "500", description = "Internal Server Error",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "503", description = "Service Unavailable",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @GetMapping("/account")
    public ApiResponse<MemberResponseDTO.MemberResponseDto> getUserById(@RequestParam Long userId) {
        Member member = memberQueryService.findByUserId(userId);

        MemberResponseDTO.MemberResponseDto responseDto = MemeberConverter.toUserDTO(member);  // Member -> DTO
        return ApiResponse.onSuccess(responseDto);
    }

    /*@GetMapping("/account/project")
    public ApiResponse<ProjectResponseDTO.ProjectResponseDto> getProject(
            @RequestHeader Long userId,
            @RequestParam Long projectId) {

        Project project = memberQueryService.findProject(userId, projectId);
        ProjectResponseDTO.ProjectResponseDto responseDto=ProjectConverter.toProject(project);
        return ApiResponse.onSuccess(responseDto);
    }

    @GetMapping("/account/project/role")
    public ApiResponse<ProjectResponseDTO.ProjectResponseDto> getProjectWithRole(
            @RequestHeader Long userId,
            @RequestParam Long projectId, @RequestParam Role role) {

        Project project = memberQueryService.findProject(userId, projectId);
        ProjectResponseDTO.ProjectResponseDto responseDto=ProjectConverter.toProject(project);
        return ApiResponse.onSuccess(responseDto);
    }*/
}


