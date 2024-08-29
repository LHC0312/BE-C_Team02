package ICT_Team2.ITS_Back_End_main.service.memberService;

import ICT_Team2.ITS_Back_End_main.domain.Project;
import ICT_Team2.ITS_Back_End_main.domain.Member;

import java.util.List;

public interface MemberQueryService {
    public Member findByMemberId(Long userId);
    public Project findProject(Long userId, Long projectId);
    public List<Member> findAllUser();
}
