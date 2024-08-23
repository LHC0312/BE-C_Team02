package ICT_Team2.ITS_Back_End_main.web.controller;

/*import ICT_Team2.ITS_Back_End_main.apiPayLoad.ApiResponse;
import ICT_Team2.ITS_Back_End_main.converter.IssueConverter;
import ICT_Team2.ITS_Back_End_main.domain.Issue;
import ICT_Team2.ITS_Back_End_main.service.IssueQueryService;
import ICT_Team2.ITS_Back_End_main.web.dto.IssueRequestDTO;
import ICT_Team2.ITS_Back_End_main.web.dto.IssueResponseDTO;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
=======
import lombok.RequiredArgsConstructor;
>>>>>>> 8146e61ea944e080fbdeaf825f8c0674470a7e53
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/issues")
public class IssueRestController {
<<<<<<< HEAD
    private final IssueQueryService issueQueryService;

    @Autowired
    public IssueRestController(IssueQueryService issueQueryService) {
        this.issueQueryService = issueQueryService;
    }
    @GetMapping("/")
    public ApiResponse<List<IssueResponseDTO.IssueResponseDto>> getById(@RequestParam Integer id,
                                                                        @RequestParam Integer issueid) {
        List<Issue> issue = issueQueryService.getIssue();
        return ApiResponse.onSuccess(IssueConverter.toGetResultDTO(issue));
    }

    @GetMapping("/{projectId}")
    public ApiResponse<IssueResponseDTO.IssueResponseDto> getByProject(@RequestParam Integer id,
                                                                       @PathVariable("id") Integer projectId) {
        //Issue issue = issueQueryService.getIssue();
        //return ApiResponse.onSuccess(IssueConverter.toGetResultDTO(issue));
        return null;
    }

    @GetMapping("/{projectId}/tester")
    public ApiResponse<IssueResponseDTO.IssueResponseDto> getByTester(@RequestParam Integer id,
                                                                      @PathVariable("id") Integer projectId) {
        //Issue issue = issueQueryService.getIssue();
        //return ApiResponse.onSuccess(IssueConverter.toGetResultDTO(issue));
        return null;
    }

    @GetMapping("/{projectId}/dev")
    public ApiResponse<IssueResponseDTO.IssueResponseDto> getByDev(@RequestParam Integer id,
                                                                   @PathVariable("id") Integer projectId) {
        //Issue issue = issueQueryService.getIssue();
        //return ApiResponse.onSuccess(IssueConverter.toGetResultDTO(issue));
        return null;
    }

    @GetMapping("/search")
    public ApiResponse<IssueResponseDTO.IssueResponseDto> getBySearch(@RequestParam Integer id,
                                                                      @RequestParam String category,
                                                                      @RequestParam String keyword,
                                                                      @RequestParam Integer projectId) {
        //Issue issue = issueQueryService.getIssue();
        //return ApiResponse.onSuccess(IssueConverter.toGetResultDTO(issue));
        return null;
    }

    @GetMapping("/issueRecommend")
    public ApiResponse<IssueResponseDTO.IssueRecommandDto> getByRecommend(@RequestParam Integer id,
                                                                          @RequestParam Integer issueid) {
        return null;
    }

    @GetMapping("/deleteRequest/find")
    public ApiResponse<IssueResponseDTO.IssueResponseDto> getByDeletedeRequest(@RequestParam Integer id,
                                                                               @RequestParam Integer issueid) {
        return null;
    }

    @GetMapping("all")
    public ApiResponse<IssueResponseDTO.IssueResponseDto> getAll(@RequestParam Integer id) {
        return null;
    }

    @PutMapping("/update")
    public ApiResponse<IssueResponseDTO.IssueResponseDto> update(@RequestParam Integer id,
                                                                 @RequestBody @Valid IssueRequestDTO.IssueUpdateRequestDTO request) {
        return null;
    }

    @PutMapping("/update/dev")
    public ApiResponse<IssueResponseDTO.IssueResponseDto> updateDev(@RequestParam Integer id,
                                                                    @RequestBody @Valid IssueRequestDTO.IssueStatusUpdateRequestDTO request) {
        return null;
    }

    @PutMapping("/reassign")
    public ApiResponse<IssueResponseDTO.IssueResponseDto> reassign(@RequestParam Integer id,
                                                                   @RequestBody @Valid IssueRequestDTO.IssueAssignRequestDTO request) {
        return null;
    }

    @PutMapping("/assign")
    public ApiResponse<IssueResponseDTO.IssueResponseDto> assign(@RequestParam Integer id,
                                                                 @RequestBody @Valid IssueRequestDTO.IssueAssignRequestDTO request) {
        return null;
    }

    @PutMapping("/deleteRequest")
    public ApiResponse<IssueResponseDTO.IssueResponseDto> deleteRequest(@RequestParam Integer id,
                                                                        @RequestBody @Valid IssueRequestDTO.IssueDeleteRequestDTO request) {
        return null;
    }

    @PutMapping("/deleteRequest/delete")
    public ApiResponse<IssueResponseDTO.IssueResponseDto> delete(@RequestParam Integer id) {
        return null;
    }

    @PostMapping("/create")
    public ApiResponse<IssueResponseDTO.IssueResponseDto> create(@RequestParam Integer id) {
        return null;
    }

}*/

