package ICT_Team2.ITS_Back_End_main.web.controller;

import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<IssueResponseDTO.IssueResponseDto> getById(@RequestParam Long issueid) {
        Issue issue = issueQueryService.getIssueById(issueid);
        return ResponseEntity.ok(IssueConverter.toResultDTO(issue));
    }

    @GetMapping("/{projectId}")
    public ResponseEntity<List<IssueResponseDTO.IssueResponseDto>> getByProject(@PathVariable Long projectId) {
        List<Issue> issue = issueQueryService.getIssueByProject(projectId);
        return ResponseEntity.ok(IssueConverter.toResultDTO(issue));
    }

    @GetMapping("/{projectId}/tester")
    public ResponseEntity<List<IssueResponseDTO.IssueResponseDto>> getByTester(@PathVariable Long projectId) {

        List<Issue> issue = issueQueryService.getIssueByRepoter(projectId, Role.TESTER);
        return ResponseEntity.ok(IssueConverter.toResultDTO(issue));
    }

    @GetMapping("/{projectId}/dev")
    public ResponseEntity<List<IssueResponseDTO.IssueResponseDto>> getByDev(@PathVariable Long projectId) {

        List<Issue> issue = issueQueryService.getIssueByRepoter(projectId, Role.DEV);
        return ResponseEntity.ok(IssueConverter.toResultDTO(issue));
    }

    @GetMapping("/search")
    public ResponseEntity<IssueResponseDTO.IssueResponseDto> getBySearch(@RequestParam String category,
                                                                      @RequestParam String keyword,
                                                                      @RequestParam Integer projectId) {
        //Issue issue = issueQueryService.getIssue();
        //return ResponseEntity.ok(IssueConverter.toGetResultDTO(issue));
        return null;
    }

    @GetMapping("/issueRecommend")
    public ResponseEntity<IssueResponseDTO.IssueRecommandDto> getByRecommend(@RequestParam Integer issueid) {
        return null;
    }

    @GetMapping("/deleteRequest/find")
    public ResponseEntity<List<IssueResponseDTO.IssueResponseDto>> getByDeletedeRequest() {
        List<Issue> issue = issueQueryService.getDeletedIssue();
        return ResponseEntity.ok(IssueConverter.toResultDTO(issue));
    }

    @GetMapping("all")
    public ResponseEntity<List<IssueResponseDTO.IssueResponseDto>> getAll() {
        List<Issue> issue = issueQueryService.getIssueAll();
        return ResponseEntity.ok(IssueConverter.toResultDTO(issue));
    }

    @PutMapping("/update")
    public ResponseEntity<IssueResponseDTO.IssueResponseDto> update(@RequestBody @Valid IssueRequestDTO.IssueUpdateRequestDTO request) {
        Issue issue = issueCommandService.updateIssue(request);
        return ResponseEntity.ok(IssueConverter.toResultDTO(issue));
    }

    @PutMapping("/update/dev")
    public ResponseEntity<IssueResponseDTO.IssueResponseDto> updateDev(@RequestBody @Valid IssueRequestDTO.IssueStatusUpdateRequestDTO request) {
        Issue issue = issueCommandService.updateDev(request);
        return ResponseEntity.ok(IssueConverter.toResultDTO(issue));
    }

    @PutMapping("/reassign")
    public ResponseEntity<IssueResponseDTO.IssueResponseDto> reassign(@RequestBody @Valid IssueRequestDTO.IssueAssignRequestDTO request) {
        Issue issue = issueCommandService.assign(request);
        return ResponseEntity.ok(IssueConverter.toResultDTO(issue));
    }

    @PutMapping("/assign")
    public ResponseEntity<IssueResponseDTO.IssueResponseDto> assign(@RequestBody @Valid IssueRequestDTO.IssueAssignRequestDTO request) {
        Issue issue = issueCommandService.reassign(request);
        return ResponseEntity.ok(IssueConverter.toResultDTO(issue));
    }

    @PutMapping("/deleteRequest")
    public ResponseEntity<IssueResponseDTO.IssueResponseDto> deleteRequest(@RequestBody @Valid IssueRequestDTO.IssueDeleteRequestDTO request) {
        Issue issue = issueCommandService.deleteRequest(request);
        return ResponseEntity.ok(IssueConverter.toResultDTO(issue));
    }

    @PutMapping("/deleteRequest/delete")
    public ResponseEntity<IssueResponseDTO.IssueResponseDto> delete(@RequestBody @Valid IssueRequestDTO.IssueDeleteRequestDTO request) {
        Issue issue = issueCommandService.delete(request);
        return ResponseEntity.ok(IssueConverter.toResultDTO(issue));
    }

    @PostMapping("/create")
    public ResponseEntity<IssueResponseDTO.IssueResponseDto> create(@RequestBody @Valid IssueRequestDTO.IssueCreateDTO request) {
        Issue issue = issueCommandService.createIssue(request);
        return ResponseEntity.ok(IssueConverter.toResultDTO(issue));
    }

}
