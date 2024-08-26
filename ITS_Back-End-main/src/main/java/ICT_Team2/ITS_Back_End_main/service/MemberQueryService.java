package ICT_Team2.ITS_Back_End_main.service;

import ICT_Team2.ITS_Back_End_main.domain.Project;
import ICT_Team2.ITS_Back_End_main.domain.User;
import ICT_Team2.ITS_Back_End_main.web.dto.MemberResponseDTO;
import ICT_Team2.ITS_Back_End_main.web.dto.ProjectResponseDTO;

public interface MemberQueryService {
    User findByUserId(Long userId);
    Project findProject(Long userId, Long projectId);

}
