package org.example.Models;

import java.io.Serializable;
import java.util.Map;
import lombok.*;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
public class LocationReverse extends LocationSearch implements Serializable {
    //    private int placeId;
    //    private String lat;
    //    private String lon;
    //    private String displayName;
    private Map<String, String> address;
}
