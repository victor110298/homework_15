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

@Log4j
@MappedSuperclass
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customers")
public class Customer extends Model {

    @Column(name = "surname", length = 255)
    private String surname;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "customers")
    private Set<Company> companies = new HashSet<>();

    @PrePersist
    public void prePersist() {
        log.info("Customer.onPrePersist()");
    }

    @PostPersist
    public void postPersist() {
        log.info("Customer.onPostPersist()");
    }

    @PreUpdate
    public void preUpdate() {
        log.info("Customer.onPreUpdate()");
    }

    @PostUpdate
    public void postUpdate() {
        log.info("Customer.onPostUpdate()");
    }

    @PreRemove
    public void preRemove() {
        log.info("Customer.onPreRemove()");
    }

    @PostRemove
    public void postRemove() {
        log.info("Customer.onPostRemove()");
    }

    @PostLoad
    public void postLoad() {
        log.info("Customer.onPostLoad()");
    }
}
