package ICT_Team2.ITS_Back_End_main.service;

import ICT_Team2.ITS_Back_End_main.domain.enums.Status;
import ICT_Team2.ITS_Back_End_main.repository.UserRepository;
import ICT_Team2.ITS_Back_End_main.web.dto.MemberRequestDTO;
import ICT_Team2.ITS_Back_End_main.web.dto.MemberResponse;
import ICT_Team2.ITS_Back_End_main.apiPayLoad.exception.handler.MemberHandler;
import ICT_Team2.ITS_Back_End_main.apiPayLoad.code.status.ErrorStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MemberCommandServiceImpl implements MemberCommandService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public MemberResponse.MemberResponseDTO signUp(MemberRequestDTO.SignUpDto signUpDto) {
        CheckSignUp(signUpDto);

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
                .role(user.getRole())
                .isDeleted(user.isDeleted())
                .build();
    }

    private void CheckSignUp(MemberRequestDTO.SignUpDto signUpDto) {
        if (userRepository.existsBySignId(signUpDto.getSignId())) {
            throw new MemberHandler(ErrorStatus._SIGNUP_ERROR);
        }

        if (signUpDto.getPassword() == null || signUpDto.getPassword().isEmpty()) {
            throw new MemberHandler(ErrorStatus._SIGNUP_ERROR);
        }
    }

    @Override
    @Transactional
    public MemberResponse.MemberResponseDTO signIn(MemberRequestDTO.SignInDto signInDto) {
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
    public MemberResponse.MemberResponseDTO updateRole(MemberRequestDTO.RoleUpdateDto roleUpdateDto) {
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
    public MemberResponse.MemberResponseDTO deleteMember(MemberRequestDTO.DeleteDto deleteDto) { // 반환 타입 수정
        User user = userRepository.findById(deleteDto.getId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid user ID"));

        user.setStatus(Status.INACTIVE);
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
    public MemberResponse.MemberResponseDTO createdAdmin(MemberRequestDTO.CreatedAdmin createdAdminDTO) {
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
