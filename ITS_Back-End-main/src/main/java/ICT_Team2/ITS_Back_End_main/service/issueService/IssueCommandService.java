package ICT_Team2.ITS_Back_End_main.service.issueService;

import ICT_Team2.ITS_Back_End_main.domain.Issue;
import ICT_Team2.ITS_Back_End_main.web.dto.IssueRequestDTO;

import java.util.List;

public interface IssueCommandService {
    public Issue createIssue(Long id, IssueRequestDTO.IssueCreateDTO request);
    public Issue updateIssue(IssueRequestDTO.IssueUpdateRequestDTO request);
    public Issue updateDev(IssueRequestDTO.IssueStatusUpdateRequestDTO request);
    public Issue assign(IssueRequestDTO.IssueAssignRequestDTO request);
    public Issue reassign(IssueRequestDTO.IssueAssignRequestDTO request);
    public Issue deleteRequest(IssueRequestDTO.IssueDeleteRequestDTO request);
    public Issue delete(IssueRequestDTO.IssueDeleteRequestDTO request);
}
