package org.glofox.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor


public class Class {
    private Long classId;
    private String className;
    private Date startDate;
    private Date endDate;
    private int capacity;


}
