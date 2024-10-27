package org.glofox.model;


import lombok.Builder;
import lombok.Data;


import java.util.Date;

@Data
@Builder

public class Class {
    private Long classId;
    private String className;
    private Date startDate;
    private Date endDate;
    private int capacity;

}
