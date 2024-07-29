package ICT_Team2.ITS_Back_End_main.service;

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

        List<MemberResponse.MemberResponseDTO> members = user.getMemberList().stream()
                .map(User -> MemberResponse.MemberResponseDTO.builder()
                        .id(user.getId())
                        .role(user.getRole())
                        .build())
                .collect(Collectors.toList());

        return MemberResponse.MemberResponseDTO.builder()
                .id(user.getId())
                .signId(user.getSignId())
                .name(user.getName())
                .role(user.getRole())  // Assuming you want to return the user's role
                .isDeleted(user.isDeleted())
                .build();
    }

    @Override
    @Transactional
    public MemberResponse.MemberResponseDTO getMember(Long memberId) {
        User user = userRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid member ID"));

        return MemberResponse.MemberResponseDTO.builder()
                .id(user.getId())
                .role(user.getRole())
                .build();
    }
}

