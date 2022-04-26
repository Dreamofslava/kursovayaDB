package com.javamaster.spring_crud.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TripDto {
    private Integer id;
    private String number;
    private String starttime;
    private String endtime;
    private String interval;
    private String protyaj;
}
