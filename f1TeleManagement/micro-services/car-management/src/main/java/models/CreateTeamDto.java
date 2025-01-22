package models;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public record CreateTeamDto(String name){
}