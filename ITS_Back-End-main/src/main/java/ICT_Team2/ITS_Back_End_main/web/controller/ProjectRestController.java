package ICT_Team2.ITS_Back_End_main.web.controller;
import ICT_Team2.ITS_Back_End_main.converter.IssueConverter;
import ICT_Team2.ITS_Back_End_main.converter.ProjectConverter;
import ICT_Team2.ITS_Back_End_main.domain.Member;
import ICT_Team2.ITS_Back_End_main.domain.Project;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import ICT_Team2.ITS_Back_End_main.web.dto.ProjectRequestDTO;
import ICT_Team2.ITS_Back_End_main.web.dto.ProjectResponseDTO;
import ICT_Team2.ITS_Back_End_main.service.projectService.ProjectCommandService;
import ICT_Team2.ITS_Back_End_main.service.projectService.ProjectQueryService;

@RestController
@RequestMapping("/api/v1/project")
@RequiredArgsConstructor
public class ProjectRestController {

    private final ProjectCommandService projectCommandService;
    private final ProjectQueryService projectQueryService;

    @PostMapping("/create")
    public ResponseEntity<ProjectResponseDTO.ProjectResponeDto> createProject(@RequestBody ProjectRequestDTO.ProjectCreateRequestDto request) {
        Project project = projectCommandService.createProject(request);
        return ResponseEntity.ok(ProjectConverter.toResponseDto(project));
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<ProjectResponseDTO> updateProject(@PathVariable Long id, @RequestBody ProjectRequestDTO projectRequestDTO) {
//        ProjectResponseDTO projectResponseDTO = projectCommandService.updateProject(id, projectRequestDTO);
//        return ResponseEntity.ok(projectResponseDTO);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteProject(@PathVariable Long id) {
//        projectCommandService.deleteProject(id);
//        return ResponseEntity.noContent().build();
//    }
//
    @GetMapping("/{id}")
    public ResponseEntity<ProjectResponseDTO.ProjectResponeDto> getProjectById(@PathVariable Long id) {
        Project project = projectQueryService.getProjectById(id);
        return ResponseEntity.ok(ProjectConverter.toResponseDto(project));
    }

    @GetMapping
    public ResponseEntity<List<ProjectResponseDTO.ProjectResponeDto>> getAllProjects() {
        List<Project> project = projectQueryService.getAllProjects();
        return ResponseEntity.ok(ProjectConverter.toResponseDto(project));
    }

    @PutMapping("/{id}/member/add")
    public ResponseEntity<ProjectResponseDTO.ProjectResponeDto> addProjectMember(@PathVariable Long id,
                                                                                 @RequestBody ProjectRequestDTO.ProjectMemberAddRequestDto request) {
        Project project = projectCommandService.addMember(id, request);
        return ResponseEntity.ok(ProjectConverter.toResponseDto(project));
    }

    @PutMapping("/{id}/member/delete")
    public ResponseEntity<ProjectResponseDTO.ProjectResponeDto> deleteProjectMember(@PathVariable Long id,
                                                                                    @RequestBody ProjectRequestDTO.ProjectMemberRemoveRequestDto request) {
        Project project = projectCommandService.deleteMember(id, request);
        return ResponseEntity.ok(ProjectConverter.toResponseDto(project));
    }

    @PutMapping("/{projectId}")
    public ResponseEntity<ProjectResponseDTO.ProjectResponeDto> deleteProject(@PathVariable Long projectId) {
        Project project = projectCommandService.deleteProject(projectId);
        return ResponseEntity.ok(ProjectConverter.toResponseDto(project));
    }
}
