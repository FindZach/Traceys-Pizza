package com.findzach.restaurant.model;

import javax.persistence.*;

import java.util.Date;

/**
 * @author Zach S <zach@findzach.com>
 * @since 9/17/2021
 */
@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "creation_date")
    private Date entityCreationDate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getEntityCreationDate() {
        return entityCreationDate;
    }

    public void setEntityCreationDate(Date entityCreationDate) {
        this.entityCreationDate = entityCreationDate;
    }
}
