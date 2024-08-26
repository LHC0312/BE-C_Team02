package ICT_Team2.ITS_Back_End_main.service.issueService;

import ICT_Team2.ITS_Back_End_main.domain.Issue;
import ICT_Team2.ITS_Back_End_main.domain.enums.Role;

import java.util.List;
import java.util.Optional;

public interface IssueQueryService {
    public Issue getIssueById(Long issueId);
    public List<Issue> getIssueAll();
    public List<Issue> getDeletedIssue();
    public List<Issue> getIssueByProject(Long projectId);
    public List<Issue> getIssueByRepoter(Long projectId, Role role);
}
