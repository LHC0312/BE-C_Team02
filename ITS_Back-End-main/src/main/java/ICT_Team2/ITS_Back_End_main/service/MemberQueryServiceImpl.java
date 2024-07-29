package ICT_Team2.ITS_Back_End_main.service;


import ICT_Team2.ITS_Back_End_main.domain.User;
import ICT_Team2.ITS_Back_End_main.domain.mapping.Member;
import ICT_Team2.ITS_Back_End_main.repository.MemberRepository;
import ICT_Team2.ITS_Back_End_main.repository.UserRepository;
import ICT_Team2.ITS_Back_End_main.web.dto.MemberResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MemberQueryServiceImpl implements MemberQueryService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public MemberResponse.MemberResponseDTO getUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user ID"));

        return MemberResponse.MemberResponseDTO.builder()
                .id(user.getId())
                .signId(user.getSignId())
                .name(user.getName())
                .role(user.getRole())
                .isDeleted(user.isDeleted())
                .build();
    }

    @Override
    @Transactional
    public MemberResponse.MemberResponseDTO getMember(Long memberId) {
        User member = userRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid member ID"));

        return MemberResponse.MemberResponseDTO.builder()
                .id(member.getId())
                .signId(member.getSignId())
                .name(member.getName())
                .role(member.getRole())
                .isDeleted(member.isDeleted())
                .build();
    }
}

