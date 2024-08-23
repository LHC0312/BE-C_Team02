package ICT_Team2.ITS_Back_End_main.service;

import ICT_Team2.ITS_Back_End_main.domain.Project;
import ICT_Team2.ITS_Back_End_main.domain.mapping.Member;
import ICT_Team2.ITS_Back_End_main.repository.ProjectRepository;
import ICT_Team2.ITS_Back_End_main.web.dto.ProjectRequestDTO;
import ICT_Team2.ITS_Back_End_main.web.dto.ProjectResponseDTO;
import org.springframework.stereotype.Service;

@Service
public interface ProjectCommandService {
    ProjectResponseDTO.ProjectResponseDto createProject(ProjectRequestDTO.ProjectCreateDto projectCreateDto);

    ProjectResponseDTO.ProjectResponseDto addMember(ProjectRequestDTO.MemberAddDto memberAddDto);

    ProjectResponseDTO.ProjectResponseDto removeMember(ProjectRequestDTO.MemberRemoveDto memberRemoveDto);


}
