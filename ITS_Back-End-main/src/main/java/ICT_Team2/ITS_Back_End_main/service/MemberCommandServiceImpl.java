package ICT_Team2.ITS_Back_End_main.service;

import ICT_Team2.ITS_Back_End_main.apiPayLoad.exception.handler.MemberHandler;
import ICT_Team2.ITS_Back_End_main.domain.User;
import ICT_Team2.ITS_Back_End_main.domain.enums.Role;
import ICT_Team2.ITS_Back_End_main.repository.UserRepository;
import ICT_Team2.ITS_Back_End_main.web.dto.MemberRequestDTO;
import ICT_Team2.ITS_Back_End_main.web.dto.MemberResponseDTO;
import ICT_Team2.ITS_Back_End_main.web.dto.RoleUpdateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import org.springframework.transaction.annotation.Transactional;

import ICT_Team2.ITS_Back_End_main.domain.enums.Status;

@Service
public abstract class MemberCommandServiceImpl implements MemberCommandService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public MemberResponseDTO.ResponseDTO signUp(MemberRequestDTO.SignUpDTO signUpDto) {
        User user = User.builder()
                .signId(signUpDto.getSignId())
                .password(signUpDto.getPassword())
                .name(signUpDto.getName())
                .role(signUpDto.getRole())
                .status(Status.ACTIVE)
                .build();

        userRepository.save(user);

        return MemberResponseDTO.ResponseDTO.builder()
                .id(user.getId())
                .signId(user.getSignId())
                .name(user.getName())
                .role(Role.valueOf(user.getRole().name()))
                .isDeleted(user.isDeleted())
                .build();
    }

    @Override
    @Transactional
    public MemberResponseDTO.ResponseDTO signIn(MemberRequestDTO.SignInDTO signInDto) {
        User user = userRepository.findBySignIdAndPassword(signInDto.getSignId(), signInDto.getPassword())
                .orElseThrow(() -> new MemberHandler(ErrorStatus.NOT_FOUND_MEMBER));

        return MemberResponseDTO.ResponseDTO.builder()
                .id(user.getId())
                .signId(user.getSignId())
                .name(user.getName())
                .role(user.getRole().name())
                .isDeleted(user.isDeleted())
                .build();
    }

    @Override
    @Transactional
    public MemberResponseDTO.ResponseDTO updateRole(MemberRequestDTO.RoleUpdateDTO roleUpdateDto) {
        User user = userRepository.findById(RoleUpdateDTO.getId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid user ID"));

        user.setRole(roleUpdateDto.getRole());
        userRepository.save(user);

        return MemberResponseDTO.ResponseDTO.builder()
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

        user.setStatus(Status.INACTIVE);
        user.setInactiveDate(LocalDate.now());
        userRepository.save(user);
    }
}

