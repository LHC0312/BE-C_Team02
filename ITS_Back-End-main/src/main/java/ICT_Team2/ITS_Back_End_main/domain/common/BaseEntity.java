package ICT_Team2.ITS_Back_End_main.domain.common;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@MappedSuperclass
@Getter
@Setter

public abstract class BaseEntity {

  @CreatedDate
  @Column(nullable = false, updatable = false)
  private LocalDateTime createdAt;

  @LastModifiedDate
  @Column(nullable = true) //이거 펄스일까요, 업뎃 안 할 수도 있잖아
  private LocalDateTime updatedAt;

  @Column(nullable = false)
  private Boolean isDeleted;


  @Column(nullable = true)
  private LocalDateTime inactiveDate;
  public void deactivate() {
    this.inactiveDate = LocalDateTime.now();
  }

}
