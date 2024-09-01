package ICT_Team2.ITS_Back_End_main.service.issueService;

import ICT_Team2.ITS_Back_End_main.domain.Issue;
import ICT_Team2.ITS_Back_End_main.domain.enums.Role;
import ICT_Team2.ITS_Back_End_main.domain.enums.Status;
import ICT_Team2.ITS_Back_End_main.repository.IssueRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IssueQueryServiceImpl implements IssueQueryService{
    private final IssueRepository issueRepository;

    public List<Issue> getDeletedIssue() {
        return issueRepository.findByStatus(Status.DELETE_REQUEST)
                .orElseThrow(() -> new IllegalArgumentException("not found"));

    }

    public Issue getIssueById(Long issueId) {
        return issueRepository.findById(issueId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid issue ID"));

    }

    public List<Issue> getIssueAll() {
        return issueRepository.findAll();

    }

    public List<Issue> getIssueByProject(Long projectId) {

        return issueRepository.findByProjectId(projectId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid project ID"));
    }

    public List<Issue> getIssueByRepoter(Long projectId, Role role) {

        List<Issue> issueList = issueRepository.findByProjectId(projectId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid project ID"));

        return issueList.stream()
                .filter( issue -> issue.getReporter().getRole() == role )
                .toList();
    }

    public Issue getIssueRecommend(Long issueId) {
        return issueRepository.findById(issueId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid issue ID"));
    }
}
