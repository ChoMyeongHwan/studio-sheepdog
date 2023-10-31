package com.studiosheepdog.dognapper.location.domain.aggregate.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "LOCATION_TB")
@AllArgsConstructor
public class Location {

    @Id
    private Long id; // 유저 아이디
    private double xAxis; // X좌표
    private double yAxis; // y좌표
    private String mapName; // 맵 이름

    public void updateLocation(double xAxis, double yAxis, String mapName) {
        this.xAxis = xAxis;
        this.yAxis = yAxis;
        this.mapName = mapName;
    }
}
