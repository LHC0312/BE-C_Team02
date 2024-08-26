package ICT_Team2.ITS_Back_End_main.service.memberService;

import ICT_Team2.ITS_Back_End_main.domain.Project;
import ICT_Team2.ITS_Back_End_main.domain.Member;

public interface MemberQueryService {
    Member findByUserId(Long userId);
    Project findProject(Long userId, Long projectId);

}
