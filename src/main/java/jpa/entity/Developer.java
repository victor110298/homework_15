package jpa.entity;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.Setter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

import javax.persistence.Column;
import javax.persistence.Entity;
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
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.Enumerated;
import javax.persistence.EnumType;

import java.util.HashSet;
import java.util.Set;

@MappedSuperclass
@Log4j
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "developers")
public class Developer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name", length = 255)
    private String name;

    @Column(name = "surname", length = 255)
    private String type;

    @Column(name = "age")
    private Integer age;

    @Column(name = "sex")
    @Enumerated(EnumType.STRING)
    private Sex sex;


    @ManyToMany
    @JoinTable(name = "devel_skill",
            joinColumns = @JoinColumn(name = "devel_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "skill_id", referencedColumnName = "id")
    )
    private Set<Skill> skills = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "devel_project",
            joinColumns = @JoinColumn(name = "devel_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "project_id", referencedColumnName = "id")
    )
    private Set<Project> project = new HashSet<>();

    @PrePersist
    public void prePersist() {
        log.info("Developer.onPrePersist()");
    }

    @PostPersist
    public void postPersist() {
        log.info("Developer.onPostPersist()");
    }

    @PreUpdate
    public void preUpdate() {
        log.info("Developer.onPreUpdate()");
    }

    @PostUpdate
    public void postUpdate() {
        log.info("Developer.onPostUpdate()");
    }

    @PreRemove
    public void preRemove() {
        log.info("Developer.onPreRemove()");
    }

    @PostRemove
    public void postRemove() {
        log.info("Developer.onPostRemove()");
    }

    @PostLoad
    public void postLoad() {
        log.info("Developer.onPostLoad()");
    }
}

