package ICT_Team2.ITS_Back_End_main.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

public class User {

  @OneToMany(mappedBy = "Comment", cascade = CascadeType.ALL)
  private List<Comment> commentList = new ArrayList<>();


}
