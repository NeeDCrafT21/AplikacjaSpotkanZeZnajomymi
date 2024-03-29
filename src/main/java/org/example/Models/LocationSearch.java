package org.example.Models;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@Data
@SuperBuilder
@Getter
public class LocationSearch implements Serializable {
    private int placeId;
    private String lat;
    private String lon;
    private String displayName;
}
