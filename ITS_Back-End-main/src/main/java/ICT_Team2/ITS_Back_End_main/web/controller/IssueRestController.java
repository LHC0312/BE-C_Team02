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

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/v1/issue")
@RequiredArgsConstructor
public class IssueRestController {
    private final IssueQueryService issueQueryService;
    private final IssueCommandService issueCommandService;

    @GetMapping()
    public ResponseEntity<IssueResponseDTO.IssueResponseDto> getById(@RequestHeader Long id,
                                                                     @RequestParam Long issueId) {
        Issue issue = issueQueryService.getIssueById(issueId);
        return ResponseEntity.ok(IssueConverter.toResultDTO(issue));
    }

    @GetMapping("/{projectId}")
    public ResponseEntity<List<IssueResponseDTO.IssueResponseDto>> getByProject(@RequestHeader Long id,
                                                                                @PathVariable Long projectId) {
        List<Issue> issue = issueQueryService.getIssueByProject(projectId);
        return ResponseEntity.ok(IssueConverter.toResultDTO(issue));
    }

    @GetMapping("/{projectId}/tester")
    public ResponseEntity<List<IssueResponseDTO.IssueResponseDto>> getByTester(@RequestHeader Long id,
                                                                               @PathVariable Long projectId) {

        List<Issue> issue = issueQueryService.getIssueByRepoter(projectId, Role.TESTER);
        return ResponseEntity.ok(IssueConverter.toResultDTO(issue));
    }

    @GetMapping("/{projectId}/dev")
    public ResponseEntity<List<IssueResponseDTO.IssueResponseDto>> getByDev(@RequestHeader Long id,
                                                                            @PathVariable Long projectId) {

        List<Issue> issue = issueQueryService.getIssueByRepoter(projectId, Role.DEV);
        return ResponseEntity.ok(IssueConverter.toResultDTO(issue));
    }

    @GetMapping("/search")
    public ResponseEntity<IssueResponseDTO.IssueResponseDto> getBySearch(@RequestHeader Long id,
                                                                         @RequestParam String category,
                                                                         @RequestParam String keyword,
                                                                         @RequestParam Integer projectId) {
        //Issue issue = issueQueryService.getIssue();
        //return ResponseEntity.ok(IssueConverter.toGetResultDTO(issue));
        return null;
    }

    @GetMapping("/issueRecommend")
    public ResponseEntity<List<IssueResponseDTO.IssueRecommandDto>> getByRecommend(@RequestHeader Long id,
                                                                             @RequestParam Long issueId) {
        List<Issue> issue = Arrays.asList(issueQueryService.getIssueRecommend(issueId));
        return ResponseEntity.ok(IssueConverter.toRecommendDTO(issue));
    }

    @GetMapping("/deleteRequest/find")
    public ResponseEntity<List<IssueResponseDTO.IssueResponseDto>> getByDeletedeRequest(@RequestHeader Long id) {
        List<Issue> issue = issueQueryService.getDeletedIssue();
        return ResponseEntity.ok(IssueConverter.toResultDTO(issue));
    }

    @GetMapping("all")
    public ResponseEntity<List<IssueResponseDTO.IssueResponseDto>> getAll(@RequestHeader Long id) {
        List<Issue> issue = issueQueryService.getIssueAll();
        return ResponseEntity.ok(IssueConverter.toResultDTO(issue));
    }

    @PutMapping("/update")
    public ResponseEntity<IssueResponseDTO.IssueResponseDto> update(@RequestHeader Long id,
                                                                    @RequestBody @Valid IssueRequestDTO.IssueUpdateRequestDTO request) {
        Issue issue = issueCommandService.updateIssue(request);
        return ResponseEntity.ok(IssueConverter.toResultDTO(issue));
    }

    @PutMapping("/update/dev")
    public ResponseEntity<IssueResponseDTO.IssueResponseDto> updateDev(@RequestHeader Long id,
                                                                       @RequestBody @Valid IssueRequestDTO.IssueStatusUpdateRequestDTO request) {
        Issue issue = issueCommandService.updateDev(request);
        return ResponseEntity.ok(IssueConverter.toResultDTO(issue));
    }

    @PutMapping("/reassign")
    public ResponseEntity<IssueResponseDTO.IssueResponseDto> reassign(@RequestHeader Long id,
                                                                      @RequestBody @Valid IssueRequestDTO.IssueAssignRequestDTO request) {
        Issue issue = issueCommandService.reassign(request);
        return ResponseEntity.ok(IssueConverter.toResultDTO(issue));
    }

    @PutMapping("/assign")
    public ResponseEntity<IssueResponseDTO.IssueResponseDto> assign(@RequestHeader Long id,
                                                                    @RequestBody @Valid IssueRequestDTO.IssueAssignRequestDTO request) {
        Issue issue = issueCommandService.assign(request);
        return ResponseEntity.ok(IssueConverter.toResultDTO(issue));
    }

    @PutMapping("/deleteRequest")
    public ResponseEntity<IssueResponseDTO.IssueResponseDto> deleteRequest(@RequestHeader Long id,
                                                                           @RequestBody @Valid IssueRequestDTO.IssueDeleteRequestDTO request) {
        Issue issue = issueCommandService.deleteRequest(request);
        return ResponseEntity.ok(IssueConverter.toResultDTO(issue));
    }

    @PutMapping("/deleteRequest/delete")
    public ResponseEntity<IssueResponseDTO.IssueResponseDto> delete(@RequestHeader Long id,
                                                                    @RequestBody @Valid IssueRequestDTO.IssueDeleteRequestDTO request) {
        Issue issue = issueCommandService.delete(request);
        return ResponseEntity.ok(IssueConverter.toResultDTO(issue));
    }

    @PostMapping("/create")
    public ResponseEntity<IssueResponseDTO.IssueResponseDto> create(@RequestHeader Long id,
                                                                    @RequestBody @Valid IssueRequestDTO.IssueCreateDTO request) {
        Issue issue = issueCommandService.createIssue(id, request);
        return ResponseEntity.ok(IssueConverter.toResultDTO(issue));
    }

}
