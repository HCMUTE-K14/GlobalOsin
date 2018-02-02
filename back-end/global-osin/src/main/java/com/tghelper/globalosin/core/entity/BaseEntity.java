package com.tghelper.globalosin.core.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tghelper.globalosin.utils.TextUtils;
import com.tghelper.globalosin.utils.UUIDGenerator;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import org.hibernate.annotations.GenericGenerator;

/**
 * Created by infamouSs on 1/23/18.
 */
@MappedSuperclass
public abstract class BaseEntity implements Serializable {
    
    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    private String id;
    
    @Column(name = "date_created", nullable = false)
    @JsonIgnore
    private Date dateCreated;
    
    @Column(name = "date_modified", nullable = false)
    @JsonIgnore
    private Date dateModified;
    
    protected BaseEntity() {
    }
    
    @PrePersist
    protected void onCreate() {
        this.dateCreated = new Date();
        this.dateModified = new Date();
    }
    
    @PreUpdate
    protected void onUpdate() {
        this.dateModified = new Date();
    }
    
    public abstract void update(Object... fields);
    
    public String getId() {
        if (TextUtils.isEmpty(this.id)) {
            this.id = UUIDGenerator.randomUUID();
        }
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public Date getDateCreated() {
        return dateCreated;
    }
    
    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }
    
    public Date getDateModified() {
        return dateModified;
    }
    
    public void setDateModified(Date dateModified) {
        this.dateModified = dateModified;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        
        BaseEntity that = (BaseEntity) o;
        
        return id != null ? id.equals(that.id) : that.id == null;
    }
    
    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
