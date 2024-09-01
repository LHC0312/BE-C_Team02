package ICT_Team2.ITS_Back_End_main.web.controller;

import ICT_Team2.ITS_Back_End_main.apiPayLoad.ApiResponse;
import ICT_Team2.ITS_Back_End_main.converter.MemberConverter;
import ICT_Team2.ITS_Back_End_main.converter.ProjectConverter;
import ICT_Team2.ITS_Back_End_main.domain.Member;
import ICT_Team2.ITS_Back_End_main.domain.Project;
import ICT_Team2.ITS_Back_End_main.domain.enums.Role;
import ICT_Team2.ITS_Back_End_main.service.memberService.MemberQueryService;
import ICT_Team2.ITS_Back_End_main.web.dto.MemberRequestDTO;
import ICT_Team2.ITS_Back_End_main.web.dto.MemberResponseDTO;
import ICT_Team2.ITS_Back_End_main.service.memberService.MemberCommandService;
import ICT_Team2.ITS_Back_End_main.web.dto.ProjectResponseDTO;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<MemberResponseDTO.MemberResponseDto> updateMemberRole(@RequestBody MemberRequestDTO.MemberRoleUpdateDto roleUpdateDto) {
        Member member = MemberConverter.toMember(roleUpdateDto);  // DTO -> Member
        member = memberCommandService.updateRole(member);

        MemberResponseDTO.MemberResponseDto responseDto = MemberConverter.toUserDTO(member);  // Member -> DTO
        return ResponseEntity.ok(responseDto);
    }
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",description = "OK"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "Bad Request",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "401", description = "Unauthorized",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "500", description = "Internal Server Error",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "503", description = "Service Unavailable",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @PutMapping("/account/delete")
    public ResponseEntity<MemberResponseDTO.MemberResponseDto> deleteMember(@RequestBody MemberRequestDTO.MemberDeleteDto deleteDto) {
        Member member = MemberConverter.toMember(deleteDto);  // DTO -> Member
        member =memberCommandService.deleteMember(member);
        MemberResponseDTO.MemberResponseDto responseDto= MemberConverter.toUserDTO(member);

        return ResponseEntity.ok(responseDto);
    }
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",description = "OK"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "Bad Request",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "401", description = "Unauthorized",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "500", description = "Internal Server Error",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "503", description = "Service Unavailable",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @PostMapping("/signUp")
    public ResponseEntity<MemberResponseDTO.MemberResponseDto> signUpMember(@RequestBody MemberRequestDTO.SignUpDto signUpDto) {
        Member member = MemberConverter.toMember(signUpDto);  // DTO -> Member
        member = memberCommandService.signUp(member);

        MemberResponseDTO.MemberResponseDto responseDto = MemberConverter.toSignUpDTO(member);  // Member -> DTO
        return ResponseEntity.ok(responseDto);
    }
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",description = "OK"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "Bad Request",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "401", description = "Unauthorized",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "500", description = "Internal Server Error",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "503", description = "Service Unavailable",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @PostMapping("/createAdmin")
    public ResponseEntity<MemberResponseDTO.MemberResponseDto> createAdmin(@RequestBody MemberRequestDTO.CreatedAdminDto createdAdminDto) {
        Member member = MemberConverter.toMember(createdAdminDto);  // DTO -> Member
        member = memberCommandService.createAdmin(member);

        MemberResponseDTO.MemberResponseDto responseDto = MemberConverter.toUserDTO(member);  // Member -> DTO
        return ResponseEntity.ok(responseDto);
    }
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",description = "OK"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "Bad Request",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "401", description = "Unauthorized",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "500", description = "Internal Server Error",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "503", description = "Service Unavailable",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @PostMapping("/signIn")
    public ResponseEntity<MemberResponseDTO.MemberResponseDto> signInMember(@RequestBody MemberRequestDTO.SignInDto signInDto) {
        Member member = MemberConverter.toMember(signInDto);  // DTO -> Member
        member = memberCommandService.signIn(member);

        MemberResponseDTO.MemberResponseDto responseDto = MemberConverter.toUserDTO(member);  // Member -> DTO
        return ResponseEntity.ok(responseDto);
    }
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",description = "OK"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "Bad Request",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "401", description = "Unauthorized",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "500", description = "Internal Server Error",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "503", description = "Service Unavailable",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
//    @GetMapping("/account")
//    public ResponseEntity<MemberResponseDTO.MemberResponseDto> getUserById(@RequestParam Long id) {
//        Member member = memberQueryService.findByMemberId(id);
//        MemberResponseDTO.MemberResponseDto responseDto = MemberConverter.toUserDTO(member);  // Member -> DTO
//        return ResponseEntity.ok(responseDto);
//    }

    @GetMapping("/account")
    public ResponseEntity<List<MemberResponseDTO.MemberResponseDto>> getAllUser() {
        List<Member> member = memberQueryService.findAllUser();
        List<MemberResponseDTO.MemberResponseDto> responseDto = MemberConverter.toUserDTO(member);  // Member -> DTO
        return ResponseEntity.ok(responseDto);
    }

    /*@GetMapping("/account/project")
    public ResponseEntity<ProjectResponseDTO.ProjectResponseDto> getProject(
            @RequestHeader Long userId,
            @RequestParam Long projectId) {

        Project project = memberQueryService.findProject(userId, projectId);
        ProjectResponseDTO.ProjectResponseDto responseDto=ProjectConverter.toProject(project);
        return ResponseEntity.ok(responseDto);
    }
    */
    @GetMapping("/account/project/role")
    public ResponseEntity<List<MemberResponseDTO.MemberResponseDto>> getMemberByRole(
            @RequestParam Long projectId, @RequestParam Role role) {

        List<Member> member = memberQueryService.findByRole(projectId, role);
        return ResponseEntity.ok(MemberConverter.toUserDTO(member));
    }
}


