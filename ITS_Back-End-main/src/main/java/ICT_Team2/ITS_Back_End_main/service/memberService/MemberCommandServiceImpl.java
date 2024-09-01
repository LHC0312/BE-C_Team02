package ICT_Team2.ITS_Back_End_main.service.memberService;

import ICT_Team2.ITS_Back_End_main.domain.Member;
import ICT_Team2.ITS_Back_End_main.domain.enums.Role;
import ICT_Team2.ITS_Back_End_main.domain.enums.Status;
import ICT_Team2.ITS_Back_End_main.repository.MemberRepository;
import ICT_Team2.ITS_Back_End_main.apiPayLoad.exception.handler.MemberHandler;
import ICT_Team2.ITS_Back_End_main.apiPayLoad.code.status.ErrorStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@RequiredArgsConstructor
public class MemberCommandServiceImpl implements MemberCommandService {

    @Autowired
    private MemberRepository memberRepository;

    @Override
    @Transactional
    public Member signUp(Member member) {
        if (memberRepository.existsBySignId(member.getSignId())) {
            throw new MemberHandler(ErrorStatus._SIGNID_ERROR);
        }

        member.setStatus(Status.ACTIVE);
        memberRepository.save(member);

        return member;
    }

    @Override
    @Transactional
    public Member signIn(Member member) {
        Member existingMember = (Member) memberRepository.findBySignId(member.getSignId())
                .orElseThrow(() -> new MemberHandler(ErrorStatus._MEMBER_NOT_FOUND));

        // 비밀번호 확인 로직
        if (!existingMember.getPassword().equals(member.getPassword())) {
            throw new MemberHandler(ErrorStatus._INVALID_PASSWORD);
        }

        return existingMember;
    }


    @Override
    @Transactional
    public Member updateRole(Member member) {
        Member existingMember = memberRepository.findById(member.getId())
                .orElseThrow(() -> new MemberHandler(ErrorStatus._MEMBER_NOT_FOUND));

        existingMember.setRole(member.getRole());
        memberRepository.save(existingMember);

        return existingMember;
    }

    @Override
    @Transactional
    public Member deleteMember(Member member) {
        Member existingMember = memberRepository.findById(member.getId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid member ID"));

        existingMember.setStatus(Status.INACTIVE);
        memberRepository.save(existingMember);

        return existingMember;
    }

    @Override
    @Transactional
    public Member createAdmin(Member member) {
        member.setRole(Role.ADMIN);
        memberRepository.save(member);

        return member;
    }
}


