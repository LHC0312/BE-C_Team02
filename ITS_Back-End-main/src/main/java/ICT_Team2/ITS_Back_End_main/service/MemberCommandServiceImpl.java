package ICT_Team2.ITS_Back_End_main.service;

import ICT_Team2.ITS_Back_End_main.apiPayLoad.code.status.ErrorStatus;
import ICT_Team2.ITS_Back_End_main.apiPayLoad.exception.handler.MemberHandler;
import ICT_Team2.ITS_Back_End_main.domain.User;
import ICT_Team2.ITS_Back_End_main.domain.enums.Role;
import ICT_Team2.ITS_Back_End_main.repository.UserRepository;
import ICT_Team2.ITS_Back_End_main.web.dto.MemberRequestDTO;
import ICT_Team2.ITS_Back_End_main.web.dto.MemberResponse;
import ICT_Team2.ITS_Back_End_main.web.dto.RoleUpdateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import org.springframework.transaction.annotation.Transactional;

import ICT_Team2.ITS_Back_End_main.domain.enums.Status;

@Service
public class MemberCommandServiceImpl implements MemberCommandService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public MemberResponse.MemberResponseDTO signUp(MemberRequestDTO.SignUpDTO signUpDto) {
        // Sign up checks
        CheckSignUp(signUpDto);

        // Create and save new user
        User user = User.builder()
                .signId(signUpDto.getSignId())
                .password(signUpDto.getPassword())
                .name(signUpDto.getName())
                .role(signUpDto.getRole())
                .status(Status.ACTIVE)
                .build();

        userRepository.save(user);

        return MemberResponse.MemberResponseDTO.builder()
                .id(user.getId())
                .signId(user.getSignId())
                .name(user.getName())
                .role(Role.valueOf(user.getRole().name()))
                .isDeleted(user.isDeleted())
                .build();
    }

    private void CheckSignUp(MemberRequestDTO.SignUpDTO signUpDto) {
        // Check if signId is already taken
        if (userRepository.existsBySignId(signUpDto.getSignId())) {
            throw new MemberHandler(ErrorStatus._SIGNUP_ERROR);
        }

        // Check if password is not empty and meets security requirements
        if (signUpDto.getPassword() == null || signUpDto.getPassword().isEmpty()) {
            throw new MemberHandler(ErrorStatus._SIGNUP_ERROR);
        }
    }

    @Override
    @Transactional
    public MemberResponse.MemberResponseDTO signIn(MemberRequestDTO.SignInDTO signInDto) {
        User user = (User) userRepository.findBySignIdAndPassword(signInDto.getSignId(), signInDto.getPassword())
                .orElseThrow(() -> new MemberHandler(ErrorStatus._MEMBER_NOT_FOUND));

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
    public MemberResponse.MemberResponseDTO updateRole(MemberRequestDTO.RoleUpdateDTO roleUpdateDto) {
        User user = userRepository.findById(roleUpdateDto.getId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid user ID"));

        user.setRole(roleUpdateDto.getRole());
        userRepository.save(user);

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
    public void deleteMember(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user ID"));

        user.setStatus(Status.INACTIVE);
        user.setInactiveDate(LocalDate.now());
        userRepository.save(user);
    }

    @Override
    @Transactional
    public MemberResponse.MemberResponseDTO createdAdmin(MemberRequestDTO.CreatedAdminDTO createdAdminDTO) {
        User user = User.builder()
                .signId(createdAdminDTO.getSignId())
                .password(createdAdminDTO.getPassword())
                .name(createdAdminDTO.getName())
                .role(createdAdminDTO.getRole())
                .status(Status.ACTIVE)
                .build();

        userRepository.save(user);

        return MemberResponse.MemberResponseDTO.builder()
                .id(user.getId())
                .signId(user.getSignId())
                .name(user.getName())
                .role(user.getRole())
                .isDeleted(user.isDeleted())
                .build();
    }
}



