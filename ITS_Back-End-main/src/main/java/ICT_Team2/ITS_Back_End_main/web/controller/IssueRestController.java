package ICT_Team2.ITS_Back_End_main.web.controller;

import ICT_Team2.ITS_Back_End_main.apiPayLoad.ApiResponse;
import ICT_Team2.ITS_Back_End_main.converter.IssueConverter;
import ICT_Team2.ITS_Back_End_main.domain.Issue;
import ICT_Team2.ITS_Back_End_main.domain.enums.Role;
import ICT_Team2.ITS_Back_End_main.service.issueService.IssueCommandService;
import ICT_Team2.ITS_Back_End_main.service.issueService.IssueQueryService;
import ICT_Team2.ITS_Back_End_main.web.dto.IssueRequestDTO;
import ICT_Team2.ITS_Back_End_main.web.dto.IssueResponseDTO;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/issue")
@RequiredArgsConstructor
public class IssueRestController {
    private final IssueQueryService issueQueryService;
    private final IssueCommandService issueCommandService;

    @GetMapping("/")
    public ApiResponse<IssueResponseDTO.IssueResponseDto> getById(@RequestParam Long issueid) {
        Issue issue = issueQueryService.getIssueById(issueid);
        return ApiResponse.onSuccess(IssueConverter.toResultDTO(issue));
    }

    @GetMapping("/{projectId}")
    public ApiResponse<List<IssueResponseDTO.IssueResponseDto>> getByProject(@PathVariable Long projectId) {
        List<Issue> issue = issueQueryService.getIssueByProject(projectId);
        return ApiResponse.onSuccess(IssueConverter.toResultDTO(issue));
    }

    @GetMapping("/{projectId}/tester")
    public ApiResponse<List<IssueResponseDTO.IssueResponseDto>> getByTester(@PathVariable Long projectId) {

        List<Issue> issue = issueQueryService.getIssueByRepoter(projectId, Role.TESTER);
        return ApiResponse.onSuccess(IssueConverter.toResultDTO(issue));
    }

    @GetMapping("/{projectId}/dev")
    public ApiResponse<List<IssueResponseDTO.IssueResponseDto>> getByDev(@PathVariable Long projectId) {

        List<Issue> issue = issueQueryService.getIssueByRepoter(projectId, Role.DEV);
        return ApiResponse.onSuccess(IssueConverter.toResultDTO(issue));
    }

    @GetMapping("/search")
    public ApiResponse<IssueResponseDTO.IssueResponseDto> getBySearch(@RequestParam String category,
                                                                      @RequestParam String keyword,
                                                                      @RequestParam Integer projectId) {
        //Issue issue = issueQueryService.getIssue();
        //return ApiResponse.onSuccess(IssueConverter.toGetResultDTO(issue));
        return null;
    }

    @GetMapping("/issueRecommend")
    public ApiResponse<IssueResponseDTO.IssueRecommandDto> getByRecommend(@RequestParam Integer issueid) {
        return null;
    }

    @GetMapping("/deleteRequest/find")
    public ApiResponse<List<IssueResponseDTO.IssueResponseDto>> getByDeletedeRequest() {
        List<Issue> issue = issueQueryService.getDeletedIssue();
        return ApiResponse.onSuccess(IssueConverter.toResultDTO(issue));
    }

    @GetMapping("all")
    public ApiResponse<List<IssueResponseDTO.IssueResponseDto>> getAll() {
        List<Issue> issue = issueQueryService.getIssueAll();
        return ApiResponse.onSuccess(IssueConverter.toResultDTO(issue));
    }

    @PutMapping("/update")
    public ApiResponse<IssueResponseDTO.IssueResponseDto> update(@RequestBody @Valid IssueRequestDTO.IssueUpdateRequestDTO request) {
        Issue issue = issueCommandService.updateIssue(request);
        return ApiResponse.onSuccess(IssueConverter.toResultDTO(issue));
    }

    @PutMapping("/update/dev")
    public ApiResponse<IssueResponseDTO.IssueResponseDto> updateDev(@RequestBody @Valid IssueRequestDTO.IssueStatusUpdateRequestDTO request) {
        Issue issue = issueCommandService.updateDev(request);
        return ApiResponse.onSuccess(IssueConverter.toResultDTO(issue));
    }

    @PutMapping("/reassign")
    public ApiResponse<IssueResponseDTO.IssueResponseDto> reassign(@RequestBody @Valid IssueRequestDTO.IssueAssignRequestDTO request) {
        Issue issue = issueCommandService.assign(request);
        return ApiResponse.onSuccess(IssueConverter.toResultDTO(issue));
    }

    @PutMapping("/assign")
    public ApiResponse<IssueResponseDTO.IssueResponseDto> assign(@RequestBody @Valid IssueRequestDTO.IssueAssignRequestDTO request) {
        Issue issue = issueCommandService.reassign(request);
        return ApiResponse.onSuccess(IssueConverter.toResultDTO(issue));
    }

    @PutMapping("/deleteRequest")
    public ApiResponse<IssueResponseDTO.IssueResponseDto> deleteRequest(@RequestBody @Valid IssueRequestDTO.IssueDeleteRequestDTO request) {
        Issue issue = issueCommandService.deleteRequest(request);
        return ApiResponse.onSuccess(IssueConverter.toResultDTO(issue));
    }

    @PutMapping("/deleteRequest/delete")
    public ApiResponse<IssueResponseDTO.IssueResponseDto> delete(@RequestBody @Valid IssueRequestDTO.IssueDeleteRequestDTO request) {
        Issue issue = issueCommandService.delete(request);
        return ApiResponse.onSuccess(IssueConverter.toResultDTO(issue));
    }

    @PostMapping("/create")
    public ApiResponse<IssueResponseDTO.IssueResponseDto> create(@RequestBody @Valid IssueRequestDTO.IssueCreateDTO request) {
        Issue issue = issueCommandService.createIssue(request);
        return ApiResponse.onSuccess(IssueConverter.toResultDTO(issue));
    }

}
