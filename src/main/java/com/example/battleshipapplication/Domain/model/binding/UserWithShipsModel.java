package com.example.battleshipapplication.Domain.model.binding;

import com.example.battleshipapplication.Domain.model.ShipModel;
import com.example.battleshipapplication.Domain.model.UserModel;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserWithShipsModel {

    private UserModel userModel;
    private List<ShipModel> shipModelList;

}
