package com.example.tournamentInvitationService.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TournamentOverview {
    private Long id;
    private String name;
    private String participantNum;
    private String startDate;
    private String endDate;
    private String organizer;
    private String status;
}