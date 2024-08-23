package ICT_Team2.ITS_Back_End_main.service;

import ICT_Team2.ITS_Back_End_main.domain.Issue;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IssueQueryService {

    public List<Issue> getIssue();
}
