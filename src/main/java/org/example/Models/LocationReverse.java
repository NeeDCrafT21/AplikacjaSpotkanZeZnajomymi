package org.example.Models;

import java.util.Map;
import lombok.*;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
public class LocationReverse extends LocationSearch {
    //    private int placeId;
    //    private String lat;
    //    private String lon;
    //    private String displayName;
    private Map<String, String> address;
}
