package ICT_Team2.ITS_Back_End_main.service.issueService;

import ICT_Team2.ITS_Back_End_main.converter.IssueConverter;
import ICT_Team2.ITS_Back_End_main.domain.Issue;
import ICT_Team2.ITS_Back_End_main.domain.Member;
import ICT_Team2.ITS_Back_End_main.domain.Project;
import ICT_Team2.ITS_Back_End_main.domain.enums.Priority;
import ICT_Team2.ITS_Back_End_main.domain.enums.Status;
import ICT_Team2.ITS_Back_End_main.repository.IssueRepository;
import ICT_Team2.ITS_Back_End_main.repository.ProjectRepository;
import ICT_Team2.ITS_Back_End_main.repository.MemberRepository;
import ICT_Team2.ITS_Back_End_main.web.dto.IssueRequestDTO;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class IssueCommandServiceImpl implements IssueCommandService{

    private final IssueRepository issueRepository;
    private final ProjectRepository projectRepository;
    private final MemberRepository memberRepository;

    @Transactional
    public Issue createIssue(Long id, IssueRequestDTO.IssueCreateDTO request) {

        Project project = projectRepository.findById(request.getProjectId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid project ID"));

        Member reporter = memberRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid project ID"));


        Issue issue = IssueConverter.toIssue(request, project, reporter);
        return issueRepository.save(issue);
    }

    @Transactional
    public Issue updateIssue(IssueRequestDTO.IssueUpdateRequestDTO request) {

        Priority priority = Priority.valueOf(request.getPriority());
        Status status = Status.valueOf(request.getStatus());

        Issue issue = issueRepository.findById(request.getIssueId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid issue ID"));

        issue.setPriority(priority);
        issue.setStatus(status);
        issue.setDescription(request.getDescription());
        issue.setCategory(request.getCategory());

        return issue;

    }

    @Transactional
    public Issue updateDev(IssueRequestDTO.IssueStatusUpdateRequestDTO request) {

        Status status = Status.valueOf(request.getStatus());

        Issue issue = issueRepository.findById(request.getIssueId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid issue ID"));

        issue.setStatus(status);

        return issue;

    }

    @Transactional
    public Issue assign(IssueRequestDTO.IssueAssignRequestDTO request) {

        Member asignee = memberRepository.findById(request.getAssigneeId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid member ID"));

        Issue issue = issueRepository.findById(request.getIssueId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid issue ID"));

        issue.updateStatus(Status.ASSIGNED);
        issue.setAssignee(asignee);
        return issue;

    }

    @Transactional
    public Issue reassign(IssueRequestDTO.IssueAssignRequestDTO request) {

//        Issue issue = issueRepository.findById(request.getIssueId())
//                .orElseThrow(() -> new IllegalArgumentException("Invalid issue ID"));
//
//        AssigneeMember assigneeMember = assigneeMemberRepository.findByMemberIdAndIssueId(request.getAssigneeId(), request.getIssueId())
//                .orElseThrow(() -> new IllegalArgumentException("Invalid member ID or issue ID"));
//
//        assigneeMemberRepository.delete(assigneeMember);
//
//        return issue;

        Member asignee = memberRepository.findById(request.getAssigneeId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid member ID"));

        Issue issue = issueRepository.findById(request.getIssueId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid issue ID"));

        issue.setAssignee(asignee);

        issue.updateStatus(Status.ASSIGNED);
        return issue;

    }

    @Transactional
    public Issue deleteRequest(IssueRequestDTO.IssueDeleteRequestDTO request) {

        Issue issue = issueRepository.findById(request.getIssueId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid issue ID"));

        issue.setStatus(Status.DELETE_REQUEST);

        return issue;

    }

    @Transactional
    public Issue delete(IssueRequestDTO.IssueDeleteRequestDTO request) {

        Issue issue = issueRepository.findById(request.getIssueId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid issue ID"));

        issue.deactivate();

        return issue;

    }


}
