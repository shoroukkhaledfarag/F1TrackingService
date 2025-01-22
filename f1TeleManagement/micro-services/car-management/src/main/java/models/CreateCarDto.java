package models;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Setter
@Getter
public record CreateCarDto(
        @NotBlank(message = "Car name must not be blank")
        @Min(value = 4, message = "Car name must be greater than 4")
        @Max(value = 50, message = "Car name must be less than or equal to 50")
        String name,

        @NotNull(message = "Car number must not be null")
        @Min(value = 1, message = "Car number must be greater than 0")
        Integer carNumber,

        @NotNull(message = "Season must not be null")
        @Min(value = 1, message = "Season must be greater than 0")
        @Max(value = 2025, message = "Season must be less than or equal to the Current Year")
        Integer season,

        @NotNull(message = "Team ID must not be null")
        Long team_id
) {
}
