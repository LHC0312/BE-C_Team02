package ICT_Team2.ITS_Back_End_main.service.memberService;

import ICT_Team2.ITS_Back_End_main.apiPayLoad.code.status.ErrorStatus;
import ICT_Team2.ITS_Back_End_main.apiPayLoad.exception.handler.MemberHandler;
import ICT_Team2.ITS_Back_End_main.domain.Project;
import ICT_Team2.ITS_Back_End_main.domain.Member;
import ICT_Team2.ITS_Back_End_main.domain.mapping.ProjectMembership;
import ICT_Team2.ITS_Back_End_main.repository.ProjectMembershipRepository;
import ICT_Team2.ITS_Back_End_main.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class MemberQueryServiceImpl implements MemberQueryService {

    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private ProjectMembershipRepository memberRepository;

    @Override
    @Transactional
    public Member findByUserId(Long userId) {
        return memberRepository.findById(userId)
                .orElseThrow(() -> new MemberHandler(ErrorStatus._MEMBER_NOT_FOUND));
    }

    @Override
    @Transactional
    public Project findProject(Long userId, Long projectId) {
        List<ProjectMembership> projectMemberships = memberRepository.findByUserId(userId);

        return projectMemberships.stream()
                .map(ProjectMembership::getProject)  // Member에서 Project 추출
                .filter(project -> project.getId().equals(projectId))  // ProjectId로 필터링
                .findFirst()  // 첫 번째 결과를 찾음
                .orElseThrow(() -> new NoSuchElementException("Project not found for given member and project IDs"));
    }
}


