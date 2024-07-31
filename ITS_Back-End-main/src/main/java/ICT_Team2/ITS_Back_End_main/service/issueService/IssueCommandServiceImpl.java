package ICT_Team2.ITS_Back_End_main.service.issueService;

import ICT_Team2.ITS_Back_End_main.converter.IssueConverter;
import ICT_Team2.ITS_Back_End_main.domain.Issue;
import ICT_Team2.ITS_Back_End_main.repository.IssueRepository;
import ICT_Team2.ITS_Back_End_main.web.dto.IssueRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class IssueCommandServiceImpl implements IssueCommandService{
    //    public void createIssue(IssueRequestDTO.IssueCreateRequestDto) {
//    }
    private final IssueRepository issueRepository;
    @Override
    public Issue create (IssueRequestDTO.IssueCreateRequestDto request) {
        Issue newIssue = IssueConverter.toIssue(request);
        return issueRepository.save(newIssue);
    }
}
