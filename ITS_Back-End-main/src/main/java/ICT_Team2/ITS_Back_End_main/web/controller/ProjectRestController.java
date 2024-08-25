package ICT_Team2.ITS_Back_End_main.web.controller;

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
@RequestMapping("/api/projects")
public class ProjectRestController {

    @Autowired
    private ProjectCommandService projectCommandService;

    @Autowired
    private ProjectQueryService projectQueryService;

    @PostMapping
    public ResponseEntity<ProjectResponseDTO> createProject(@RequestBody ProjectRequestDTO projectRequestDTO) {
        ProjectResponseDTO projectResponseDTO = projectCommandService.createProject(projectRequestDTO);
        return new ResponseEntity<>(projectResponseDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProjectResponseDTO> updateProject(@PathVariable Long id, @RequestBody ProjectRequestDTO projectRequestDTO) {
        ProjectResponseDTO projectResponseDTO = projectCommandService.updateProject(id, projectRequestDTO);
        return ResponseEntity.ok(projectResponseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProject(@PathVariable Long id) {
        projectCommandService.deleteProject(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectResponseDTO> getProjectById(@PathVariable Long id) {
        ProjectResponseDTO projectResponseDTO = projectQueryService.getProjectById(id);
        return ResponseEntity.ok(projectResponseDTO);
    }

    @GetMapping
    public ResponseEntity<List<ProjectResponseDTO>> getAllProjects() {
        List<ProjectResponseDTO> projectResponseDTOs = projectQueryService.getAllProjects();
        return ResponseEntity.ok(projectResponseDTOs);
    }
}
