package com.damg.agreementsapiendpoints.agreementsapiendpoints.models.entitys;

import com.fasterxml.jackson.databind.ser.Serializers;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Objects;

@MappedSuperclass
public abstract class BaseEntity implements Serializable, Cloneable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 43 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return false;
        }
        if (this.id == null){
            return false;
        }
        if (obj instanceof BaseEntity && obj.getClass().equals(getClass())){
            return  this.id.equals(((BaseEntity) obj).id);
        }

        return false;
    }
}
