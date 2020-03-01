package com.swageat.dos;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.data.annotation.Id;

import com.swageat.dtos.BaseInterface;

import lombok.Data;

@Data
public class BaseDO implements BaseInterface, Serializable {


    private static final long serialVersionUID = 6485504671053432823L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    protected Long id;
    protected Date updatedDateTime;
    protected Date createdDateTime;
    protected Long createdBy;
    protected Long updatedBy;

    @Override
    public String toString() {
        return "BaseModel [id=" + id + ", updatedDateTime=" + updatedDateTime + ", createdDateTime="
                + createdDateTime + ", createdBy=" + createdBy + ", updatedBy=" + updatedBy + "]";
    }

}
