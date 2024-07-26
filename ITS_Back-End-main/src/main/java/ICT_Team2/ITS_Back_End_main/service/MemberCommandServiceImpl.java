package ICT_Team2.ITS_Back_End_main.service.impl;

import ICT_Team2.ITS_Back_End_main.domain.User;
import ICT_Team2.ITS_Back_End_main.domain.UserStatus;
import ICT_Team2.ITS_Back_End_main.repository.UserRepository;
import ICT_Team2.ITS_Back_End_main.service.MemberCommandService;
import ICT_Team2.ITS_Back_End_main.web.dto.MemberRequestDTO;
import ICT_Team2.ITS_Back_End_main.web.dto.MemberResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.time.LocalDate;

@Service
public class MemberCommandServiceImpl implements MemberCommandService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public MemberResponseDTO.ResponseDto signUp(MemberRequestDTO.SignUpDto signUpDto) {
        User user = User.builder()
                .signId(signUpDto.getSignId())
                .password(signUpDto.getPassword())
                .name(signUpDto.getName())
                .role(signUpDto.getRole())
                .status(UserStatus.ACTIVE)
                .build();

        userRepository.save(user);

        return MemberResponseDTO.ResponseDto.builder()
                .id(user.getId())
                .signId(user.getSignId())
                .name(user.getName())
                .role(user.getRole().name())
                .isDeleted(user.isDeleted())
                .build();
    }

    @Override
    @Transactional
    public MemberResponseDTO.ResponseDto signIn(MemberRequestDTO.SignInDto signInDto) {
        User user = userRepository.findBySignIdAndPassword(signInDto.getSignId(), signInDto.getPassword())
                .orElseThrow(() -> new MemberHandler(ErrorStatus.NOT_FOUND_MEMBER));

        return MemberResponseDTO.ResponseDto.builder()
                .id(user.getId())
                .signId(user.getSignId())
                .name(user.getName())
                .role(user.getRole().name())
                .isDeleted(user.isDeleted())
                .build();
    }

    @Override
    @Transactional
    public MemberResponseDTO.ResponseDto updateRole(MemberRequestDTO.RoleUpdateDto roleUpdateDto) {
        User user = userRepository.findById(roleUpdateDto.getId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid user ID"));

        user.setRole(roleUpdateDto.getRole());
        userRepository.save(user);

        return MemberResponseDTO.ResponseDto.builder()
                .id(user.getId())
                .signId(user.getSignId())
                .name(user.getName())
                .role(user.getRole().name())
                .isDeleted(user.isDeleted())
                .build();
    }

    @Override
    @Transactional
    public void deleteMember(Long memberId) {
        User user = userRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user ID"));

        user.setStatus(UserStatus.INACTIVE);
        user.setInactiveDate(LocalDate.now());
        userRepository.save(user);
    }
}
