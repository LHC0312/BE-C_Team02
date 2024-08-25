package ICT_Team2.ITS.Back_End_main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

import ICT_Team2.ITS_Back_End_main.service.projectService.ProjectQueryService;
import ICT_Team2.ITS_Back_End_main.repository.ProjectRepository;
import ICT_Team2.ITS_Back_End_main.converter.ProjectConverter;
import ICT_Team2.ITS_Back_End_main.web.dto.ProjectResponseDTO;



@Service
@Transactional(readOnly = true)
public class ProjectQueryServiceImpl implements ProjectQueryService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private ProjectConverter projectConverter;

    @Override
    public ProjectResponseDTO getProjectById(Long id) {
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Project not found with id " + id));
        return projectConverter.toResponseDto(project);
    }

    @Override
    public List<ProjectResponseDTO> getAllProjects() {
        return projectRepository.findAll().stream()
                .map(projectConverter::toResponseDto)
                .collect(Collectors.toList());
    }
}
