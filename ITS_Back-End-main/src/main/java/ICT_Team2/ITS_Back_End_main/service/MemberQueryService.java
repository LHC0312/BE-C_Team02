package ICT_Team2.ITS_Back_End_main.service;

import ICT_Team2.ITS_Back_End_main.web.dto.MemberResponse;

public interface MemberQueryService {
    MemberResponse.MemberResponseDTO getUser(Long userId);
    MemberResponse.MemberResponseDTO getMember(Long memberId);
}
