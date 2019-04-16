package jpa;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import lombok.ToString;

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

import java.util.HashSet;
import java.util.Set;

@Log4j
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "developers")
public class Developers {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name", length = 255)
    private String name;

    @Column(name = "surname", length = 255)
    private String type;

    @Column(name = "age")
    private int age;

    @Column(name = "sex")
    private String sex;

    @ManyToMany
    @JoinTable(name = "devel_skill",
            joinColumns = @JoinColumn(name = "devel_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "skill_id", referencedColumnName = "id")
    )
    private Set<Skills> skills = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "devel_project",
            joinColumns = @JoinColumn(name = "devel_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "project_id", referencedColumnName = "id")
    )
    private Set<Projects> project = new HashSet<>();

    @PrePersist
    public void prePersist() {
        log.info("Developers.onPrePersist()");
    }

    @PostPersist
    public void postPersist() {
        log.info("Developers.onPostPersist()");
    }

    @PreUpdate
    public void preUpdate() {
        log.info("Developers.onPreUpdate()");
    }

    @PostUpdate
    public void postUpdate() {
        log.info("Developers.onPostUpdate()");
    }

    @PreRemove
    public void preRemove() {
        log.info("Developers.onPreRemove()");
    }

    @PostRemove
    public void postRemove() {
        log.info("Developers.onPostRemove()");
    }

    @PostLoad
    public void postLoad() {
        log.info("Developers.onPostLoad()");
    }
}

