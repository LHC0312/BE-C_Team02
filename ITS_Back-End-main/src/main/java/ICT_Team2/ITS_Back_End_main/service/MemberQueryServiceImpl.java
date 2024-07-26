package ICT_Team2.ITS_Back_End_main.service.impl;

import ICT_Team2.ITS_Back_End_main.domain.User;
import ICT_Team2.ITS_Back_End_main.domain.mapping.Member;
import ICT_Team2.ITS_Back_End_main.repository.MemberRepository;
import ICT_Team2.ITS_Back_End_main.repository.UserRepository;
import ICT_Team2.ITS_Back_End_main.service.MemberQueryService;
import ICT_Team2.ITS_Back_End_main.web.dto.MemberResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MemberQueryServiceImpl implements MemberQueryService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MemberRepository memberRepository;

    @Override
    @Transactional
    public MemberResponseDTO.UserResponseDto getUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user ID"));

        List<MemberResponseDTO.MemberDto> members = user.getMemberList().stream()
                .map(member -> MemberResponseDTO.MemberDto.builder()
                        .id(member.getId())
                        .role(member.getRole())
                        .build())
                .collect(Collectors.toList());

        return MemberResponseDTO.UserResponseDto.builder()
                .id(user.getId())
                .signId(user.getSignId())
                .name(user.getName())
                .members(members)
                .build();
    }

    @Override
    @Transactional
    public MemberResponseDTO.MemberResponseDto getMember(Long memberId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid member ID"));

        return MemberResponseDTO.MemberResponseDto.builder()
                .id(member.getId())
                .role(member.getRole())
                .build();
    }
}