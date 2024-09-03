package ICT_Team2.ITS_Back_End_main.service.memberService;

import ICT_Team2.ITS_Back_End_main.apiPayLoad.code.status.ErrorStatus;
import ICT_Team2.ITS_Back_End_main.apiPayLoad.exception.handler.MemberHandler;
import ICT_Team2.ITS_Back_End_main.domain.Project;
import ICT_Team2.ITS_Back_End_main.domain.Member;
import ICT_Team2.ITS_Back_End_main.domain.enums.Role;
import ICT_Team2.ITS_Back_End_main.domain.mapping.ProjectMembership;
import ICT_Team2.ITS_Back_End_main.repository.ProjectMembershipRepository;
import ICT_Team2.ITS_Back_End_main.repository.MemberRepository;
import ICT_Team2.ITS_Back_End_main.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class MemberQueryServiceImpl implements MemberQueryService {

    @Autowired
    private final MemberRepository memberRepository;
    @Autowired
    private final ProjectMembershipRepository projectMembershipRepository;
    @Autowired
    private final ProjectRepository projectRepository;

    @Override
    @Transactional
    public Member findByMemberId(Long memberId) {
        return memberRepository.findById(memberId)
                .orElseThrow(() -> new MemberHandler(ErrorStatus._MEMBER_NOT_FOUND));
    }

    @Override
    @Transactional
    public Project findProject(Long memberId, Long projectId) {
        List<ProjectMembership> projectMemberships = projectMembershipRepository.findByMemberId(memberId)
                .orElseThrow(() -> new MemberHandler(ErrorStatus._MEMBER_NOT_FOUND));;

        return projectMemberships.stream()
                .map(ProjectMembership::getProject)  // Member에서 Project 추출
                .filter(project -> project.getId().equals(projectId))  // ProjectId로 필터링
                .findFirst()  // 첫 번째 결과를 찾음
                .orElseThrow(() -> new NoSuchElementException("Project not found for given member and project IDs"));
    }

    public List<Member> findByRole(Long projectId, Role role) {
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new NoSuchElementException("Project not found for given member and project IDs"));
        return project.getProjectMembershipList().stream()
                .map(ProjectMembership::getMember)
                .filter(member -> member.getRole().equals(role))
                .toList();
    }

    @Override
    public List<Member> findAllUser() {
        return memberRepository.findAll();
    }
}


