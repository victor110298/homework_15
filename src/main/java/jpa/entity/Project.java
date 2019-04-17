package jpa.entity;

import lombok.*;
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
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name", length = 255)
    private String name;

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
