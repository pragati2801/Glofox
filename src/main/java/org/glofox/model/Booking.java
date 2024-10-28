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

public class Booking {
    private Long bookingId;
    private Long userId;
    private Long classId;
    private String memberName;
    private Date date;






}
