package ICT_Team2.ITS_Back_End_main.service;

import ICT_Team2.ITS_Back_End_main.web.dto.MemberResponseDTO;

public interface MemberQueryService {
    MemberResponseDTO.UserResponseDto getUser(Long userId);
    MemberResponseDTO.MemberResponseDto getMember(Long memberId);
}
