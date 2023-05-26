package org.example.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.example.Models.LocationReverse;

@RequiredArgsConstructor
public class LocationsReverseService {

    private static final String REVERSE_URL = "https://nominatim.openstreetmap.org/reverse?";
    private static final String FORMAT = "&format=json";
    private static final String ZOOM = "&zoom=";

    private final ObjectMapper objectMapper;

    @SneakyThrows
    public LocationReverse getLocationFromCoordinates(String lat, String lon, String zoom) {
        JsonNode jsonNode =
                objectMapper.readTree(new URL(REVERSE_URL + "lat=" + lat + "&lon=" + lon + ZOOM + zoom + FORMAT));

        if (jsonNode.fieldNames().next().equals("error")) {
            System.out.println("Nie ma takich wspolrzednych");
            return null;
        }

        return LocationReverse.builder()
                .placeId(jsonNode.get("place_id").intValue())
                .lat(jsonNode.get("lat").textValue())
                .lon(jsonNode.get("lon").textValue())
                .displayName(jsonNode.get("display_name").textValue())
                .address(getAddress(jsonNode))
                .build();
    }

    private static Map<String, String> getAddress(JsonNode jsonNode) {
        JsonNode address = jsonNode.get("address");
        return StreamSupport.stream(Spliterators.spliteratorUnknownSize(address.fields(), Spliterator.ORDERED), false)
                .collect(Collectors.toMap(
                        Map.Entry::getKey, entry -> entry.getValue().asText()));
    }

    //    private static Map<String, String> getAddress(JsonNode jsonNode) {
    //        JsonNode address = jsonNode.get("address");
    //        List<String> keys = ImmutableList.copyOf(address.fieldNames());
    //
    //        Map<String, String> map = new HashMap<>();
    //
    //        for(String key : keys) {
    //            map.put(key, address.get(key).asText());
    //        }
    //        return map;
    //    }
}
