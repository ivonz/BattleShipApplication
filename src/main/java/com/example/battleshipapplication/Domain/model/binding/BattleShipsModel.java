package com.example.battleshipapplication.Domain.model.binding;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class BattleShipsModel {
    private Long loggedUserWithShips;
    private Long notLoggedUserWithShips;
}
