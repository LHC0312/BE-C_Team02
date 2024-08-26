package ICT_Team2.ITS_Back_End_main.service;

import ICT_Team2.ITS_Back_End_main.domain.User;
import ICT_Team2.ITS_Back_End_main.web.dto.MemberRequestDTO;
import ICT_Team2.ITS_Back_End_main.web.dto.MemberResponseDTO;

public interface MemberCommandService {
    User signUp(User user);
    User signIn(User user);
    User updateRole(User user);
    User deleteMember(User user);
    User createAdmin(User user);  // 추가된 메서드
}


