package ICT_Team2.ITS_Back_End_main.service;

import ICT_Team2.ITS_Back_End_main.converter.UserConverter;
import ICT_Team2.ITS_Back_End_main.domain.User;
import ICT_Team2.ITS_Back_End_main.domain.enums.Role;
import ICT_Team2.ITS_Back_End_main.domain.enums.Status;
import ICT_Team2.ITS_Back_End_main.repository.UserRepository;
import ICT_Team2.ITS_Back_End_main.web.dto.MemberRequestDTO;
import ICT_Team2.ITS_Back_End_main.web.dto.MemberResponseDTO;
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
    public User signUp(User user) {
        if (userRepository.existsBySignId(user.getSignId())) {
            throw new MemberHandler(ErrorStatus._SIGNID_ERROR);
        }

        user.setStatus(Status.ACTIVE);
        userRepository.save(user);

        return user;
    }

    @Override
    @Transactional
    public User signIn(User user) {
        User existingUser = (User) userRepository.findBySignId(user.getSignId())
                .orElseThrow(() -> new MemberHandler(ErrorStatus._MEMBER_NOT_FOUND));

        // 비밀번호 확인 로직
        if (!existingUser.getPassword().equals(user.getPassword())) {
            throw new MemberHandler(ErrorStatus._INVALID_PASSWORD);
        }

        return existingUser;
    }


    @Override
    @Transactional
    public User updateRole(User user) {
        User existingUser = userRepository.findById(user.getId())
                .orElseThrow(() -> new MemberHandler(ErrorStatus._MEMBER_NOT_FOUND));

        existingUser.setRole(user.getRole());
        userRepository.save(existingUser);

        return existingUser;
    }

    @Override
    @Transactional
    public User deleteMember(User user) {
        User existingUser = userRepository.findById(user.getId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid user ID"));

        existingUser.setStatus(Status.INACTIVE);
        userRepository.save(existingUser);

        return existingUser;
    }

    @Override
    @Transactional
    public User createAdmin(User user) {
        user.setRole(Role.ADMIN);
        userRepository.save(user);

        return user;
    }
}


