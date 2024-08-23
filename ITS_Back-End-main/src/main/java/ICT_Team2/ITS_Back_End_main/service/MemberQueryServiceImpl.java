package ICT_Team2.ITS_Back_End_main.service;

import ICT_Team2.ITS_Back_End_main.apiPayLoad.code.status.ErrorStatus;
import ICT_Team2.ITS_Back_End_main.apiPayLoad.exception.handler.MemberHandler;
import ICT_Team2.ITS_Back_End_main.domain.Project;
import ICT_Team2.ITS_Back_End_main.domain.User;
import ICT_Team2.ITS_Back_End_main.domain.mapping.Member;
import ICT_Team2.ITS_Back_End_main.repository.MemberRepository;
import ICT_Team2.ITS_Back_End_main.repository.UserRepository;
import ICT_Team2.ITS_Back_End_main.web.dto.MemberResponseDTO;
import ICT_Team2.ITS_Back_End_main.web.dto.ProjectResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class MemberQueryServiceImpl implements MemberQueryService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private MemberRepository memberRepository;

    @Override
    @Transactional
    public User findByUserId(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new MemberHandler(ErrorStatus._MEMBER_NOT_FOUND));
    }

    @Override
    @Transactional
    public Project findProject(Long userId, Long projectId) {
        List<Member> members = memberRepository.findByUserId(userId);

        return members.stream()
                .map(Member::getProject)  // Member에서 Project 추출
                .filter(project -> project.getId().equals(projectId))  // ProjectId로 필터링
                .findFirst()  // 첫 번째 결과를 찾음
                .orElseThrow(() -> new NoSuchElementException("Project not found for given user and project IDs"));
    }
}


