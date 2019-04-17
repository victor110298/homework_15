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
@Table(name = "skills")
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "language", length = 255)
    private String language;

    @Column(name = "level", length = 255)
    @Enumerated(EnumType.STRING)
    private SkillLevel skillLevel;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "skills")
    private Set<Developer> developers = new HashSet<>();

    @PrePersist
    public void prePersist() {
        log.info("Skill.onPrePersist()");
    }

    @PostPersist
    public void postPersist() {
        log.info("Skill.onPostPersist()");
    }

    @PreUpdate
    public void preUpdate() {
        log.info("Skill.onPreUpdate()");
    }

    @PostUpdate
    public void postUpdate() {
        log.info("Skill.onPostUpdate()");
    }

    @PreRemove
    public void preRemove() {
        log.info("Skill.onPreRemove()");
    }

    @PostRemove
    public void postRemove() {
        log.info("Skill.onPostRemove()");
    }

    @PostLoad
    public void postLoad() {
        log.info("Skill.onPostLoad()");
    }
}
