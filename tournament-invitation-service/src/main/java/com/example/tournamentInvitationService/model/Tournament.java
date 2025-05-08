package com.example.tournamentInvitationService.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tournament {
    private Long id;
    private String name;
    private String description;
    private boolean freeToJoin;
    private boolean attend;
    private Long boardTypeId;
    private Long organizingMethodId; // ID tham chiếu đến OrganizingMethod
    private Integer maxPlayer;
    private Integer participants;    // Kiểu String thay vì Date
    private String startDate;  // Kiểu String thay vì Date
    private String endDate;    // Kiểu String thay vì Date
    private String status;    // Kiểu String thay vì Date
}