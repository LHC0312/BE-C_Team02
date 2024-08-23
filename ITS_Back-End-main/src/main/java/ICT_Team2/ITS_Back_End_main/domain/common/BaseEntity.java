package ICT_Team2.ITS_Back_End_main.domain.common;

import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
<<<<<<< HEAD

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.*;
import lombok.experimental.SuperBuilder;
=======
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
>>>>>>> 8146e61ea944e080fbdeaf825f8c0674470a7e53
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
<<<<<<< HEAD
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
  private LocalDate inactiveDate;
  public void deactivate() {
    this.inactiveDate = LocalDate.now();
  }
=======
public abstract class BaseEntity {
    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;
    @LastModifiedDate
    @Column(nullable = false)
    private LocalDateTime updatedAt;
    @Column(nullable = false)
    private Boolean isDeleted;
    @Column(nullable = true)
    private LocalDateTime inactiveDate;
    public void deactivate() {
        this.inactiveDate = LocalDateTime.now();
    }
>>>>>>> 8146e61ea944e080fbdeaf825f8c0674470a7e53

}
