package ICT_Team2.ITS_Back_End_main.service.issueService;

import ICT_Team2.ITS_Back_End_main.domain.Issue;
import ICT_Team2.ITS_Back_End_main.web.dto.IssueRequestDTO;

public interface IssueCommandService {
    public Issue create(IssueRequestDTO.IssueCreateRequestDto request);
}
