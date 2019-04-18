package jpa.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.MappedSuperclass;

import java.util.HashSet;
import java.util.Set;

@MappedSuperclass
@Log4j
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "projects")
public class Project extends Model {

    @Column(name = "type", length = 255)
    private String type;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "projects")
    private Set<Developer> developers = new HashSet<>();

    @PrePersist
    public void prePersist() {
        log.info("Project.onPrePersist()");
    }

    @PostPersist
    public void postPersist() {
        log.info("Project.onPostPersist()");
    }

    @PreUpdate
    public void preUpdate() {
        log.info("Project.onPreUpdate()");
    }

    @PostUpdate
    public void postUpdate() {
        log.info("Project.onPostUpdate()");
    }

    @PreRemove
    public void preRemove() {
        log.info("Project.onPreRemove()");
    }

    @PostRemove
    public void postRemove() {
        log.info("Project.onPostRemove()");
    }

    @PostLoad
    public void postLoad() {
        log.info("Project.onPostLoad()");
    }
}
