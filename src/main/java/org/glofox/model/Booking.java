package org.glofox.model;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class Booking {
    private Long bookingId;
    private Long userId;
    private Long classId;
    private String memberName;
    private Date date;


}
