package ICT_Team2.ITS_Back_End_main.web.controller;

import ICT_Team2.ITS_Back_End_main.apiPayLoad.ApiResponse;
import ICT_Team2.ITS_Back_End_main.converter.UserConverter;
import ICT_Team2.ITS_Back_End_main.domain.Project;
import ICT_Team2.ITS_Back_End_main.domain.User;
import ICT_Team2.ITS_Back_End_main.domain.enums.Role;
import ICT_Team2.ITS_Back_End_main.service.MemberCommandServiceImpl;
import ICT_Team2.ITS_Back_End_main.service.MemberQueryService;
import ICT_Team2.ITS_Back_End_main.service.MemberQueryServiceImpl;
import ICT_Team2.ITS_Back_End_main.web.dto.MemberRequestDTO;
import ICT_Team2.ITS_Back_End_main.web.dto.MemberResponseDTO;
import ICT_Team2.ITS_Back_End_main.service.MemberCommandService;
import ICT_Team2.ITS_Back_End_main.web.dto.ProjectResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/member")
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
        User user = UserConverter.toUser(roleUpdateDto);  // DTO -> User
        user = memberCommandService.updateRole(user);

        MemberResponseDTO.MemberResponseDto responseDto = UserConverter.toUserDTO(user);  // User -> DTO
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
        User user = UserConverter.toUser(deleteDto);  // DTO -> User
        user=memberCommandService.deleteMember(user);
        MemberResponseDTO.MemberResponseDto responseDto=UserConverter.toUserDTO(user);

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
        User user = UserConverter.toUser(signUpDto);  // DTO -> User
        user = memberCommandService.signUp(user);

        MemberResponseDTO.MemberResponseDto responseDto = UserConverter.toSignUpDTO(user);  // User -> DTO
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
        User user = UserConverter.toUser(createdAdminDto);  // DTO -> User
        user = memberCommandService.createAdmin(user);

        MemberResponseDTO.MemberResponseDto responseDto = UserConverter.toUserDTO(user);  // User -> DTO
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
        User user = UserConverter.toUser(signInDto);  // DTO -> User
        user = memberCommandService.signIn(user);

        MemberResponseDTO.MemberResponseDto responseDto = UserConverter.toUserDTO(user);  // User -> DTO
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
        User user = memberQueryService.findByUserId(userId);

        MemberResponseDTO.MemberResponseDto responseDto = UserConverter.toUserDTO(user);  // User -> DTO
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


