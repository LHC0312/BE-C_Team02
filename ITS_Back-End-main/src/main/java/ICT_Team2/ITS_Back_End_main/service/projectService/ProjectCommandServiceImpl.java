package ICT_Team2.ITS_Back_End_main.service.projectService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ICT_Team2.ITS_Back_End_main.web.dto.ProjectRequestDTO;
import ICT_Team2.ITS_Back_End_main.web.dto.ProjectResponseDTO;
import ICT_Team2.ITS_Back_End_main.repository.ProjectRepository;
import ICT_Team2.ITS_Back_End_main.converter.ProjectConverter;

@Service
@Transactional
public class ProjectCommandServiceImpl implements ProjectCommandService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private ProjectConverter projectConverter;

    @Override
    public ProjectResponseDTO createProject(ProjectRequestDTO projectRequestDTO) {
        Project project = projectConverter.toEntity(projectRequestDTO);
        projectRepository.save(project);
        return projectConverter.toResponseDto(project);
    }

    @Override
    public ProjectResponseDTO updateProject(Long id, ProjectRequestDTO projectRequestDTO) {
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Project not found with id " + id));

        project.setName(projectRequestDTO.getName());
        project.setIsCreated(projectRequestDTO.getIsCreated());
        project.setStatus(projectRequestDTO.getStatus());
        project.setCreatedAt(projectRequestDTO.getCreatedAt());
        project.setInactiveDate(projectRequestDTO.getInactiveDate());
        project.setIsDeleted(projectRequestDTO.getIsDeleted());
        project.setUpdatedAt(projectRequestDTO.getUpdatedAt());

        projectRepository.save(project);

        return projectConverter.toResponseDto(project);
    }

    @Override
    public void deleteProject(Long id) {
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Project not found with id " + id));
        projectRepository.delete(project);
    }
}
