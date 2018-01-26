package com.tghelper.globalosin.core.entity.address;

import com.tghelper.globalosin.core.entity.BaseEntity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by infamouSs on 1/23/18.
 */
@Entity(name = "Wand")
@Table(name = "tbl_wand")
public class Wand extends BaseEntity implements Serializable {
    
    @NotBlank(message = "Name is required")
    @Column(name = "name")
    private String name;
    
    @OneToMany(
              fetch = FetchType.LAZY,
              targetEntity = Street.class,
              cascade = {CascadeType.ALL}
    )
    @JoinColumn(name = "street_id")
    @OrderBy("name ASC")
    private List<Street> streets;
    
    public Wand() {
        super();
    }
    
    @Override
    public void update(Object... fields) {
    
    }
    
    public Wand(String name) {
        super();
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public List<Street> getStreets() {
        return streets;
    }
    
    public void setStreets(List<Street> streets) {
        this.streets = streets;
    }
    
    public void addStreet(Street street) {
        if (this.streets == null) {
            this.streets = new ArrayList<>();
        }
        this.streets.add(street);
    }
    
    @Override
    public String toString() {
        return "Wand{" +
               "name='" + name + '\'' +
               ", streets=" + streets +
               '}';
    }
}
