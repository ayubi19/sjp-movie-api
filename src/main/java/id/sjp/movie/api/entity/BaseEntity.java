package id.sjp.movie.api.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;


@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
@Getter
@Setter
public abstract class BaseEntity {

    @JsonIgnore
    @CreatedBy
    @Column(name = "created_by")
    protected Long createdBy = 0L;

    @JsonIgnore
    @CreatedDate
    @Column(name = "created_on", nullable = false, updatable = false)
    protected LocalDateTime createdOn = LocalDateTime.now();

    @JsonIgnore
    @LastModifiedBy
    @Column(name = "modified_by")
    protected Long modifiedBy;

    @JsonIgnore
    @LastModifiedDate
    @Column(name = "modified_on")
    protected LocalDateTime modifiedOn;


    @JsonIgnore
    @Column(name = "is_deleted")
    protected boolean isDeleted = false;
}
