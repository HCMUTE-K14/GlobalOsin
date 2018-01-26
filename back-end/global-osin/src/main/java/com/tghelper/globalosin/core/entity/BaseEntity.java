package com.tghelper.globalosin.core.entity;

import com.tghelper.globalosin.utils.TextUtils;
import com.tghelper.globalosin.utils.UUIDGenerator;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

/**
 * Created by infamouSs on 1/23/18.
 */
@MappedSuperclass
public abstract class BaseEntity implements Serializable {
    
    @Id
    @Column(name = "id", nullable = false, unique = true)
    protected String id;
    
    @Column(name = "date_created", nullable = false)
    protected Date dateCreated;
    
    @Column(name = "date_modified", nullable = false)
    protected Date dateModified;
    
    public BaseEntity() {
    
    }
    
    @PrePersist
    protected void onCreate() {
        this.dateCreated = new Date();
        this.dateModified = new Date();
        if (TextUtils.isEmpty(this.id)) {
            this.id = UUIDGenerator.randomUUID();
        }
    }
    
    @PreUpdate
    protected void onUpdate() {
        this.dateModified = new Date();
    }
    
    abstract public void update(Object... fields);
    
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
