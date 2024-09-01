package ICT_Team2.ITS_Back_End_main.service.memberService;

import ICT_Team2.ITS_Back_End_main.domain.Member;

public interface MemberCommandService {
    Member signUp(Member member);
    Member signIn(Member member);
    Member updateRole(Member member);
    Member deleteMember(Member member);
    Member createAdmin(Member member);  // 추가된 메서드
}


