package org.example.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.net.UrlEscapers;
import java.net.URL;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import java.util.stream.StreamSupport;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.example.Models.Controllers;
import org.example.Models.LocationSearch;

public class LocationsSearchService {
    private final String SEARCH_URL;
    private final String FORMAT;

    private final ObjectMapper objectMapper;

    @SneakyThrows
    public LocationsSearchService(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
        Properties properties = new Properties();
        properties.load(getClass().getClassLoader().getResourceAsStream("config.properties"));
        SEARCH_URL = properties.getProperty("API_URL_SEARCH");
        FORMAT = "&format=json";
    }

    @SneakyThrows
    public List<LocationSearch> getLocationsFromApi(String location, int limit) {
        location = UrlEscapers.urlFragmentEscaper().escape(location);

        JsonNode jsonNode = objectMapper.readTree(new URL(SEARCH_URL + location + "&limit=" + limit + FORMAT));

        if (jsonNode.isEmpty()) {
            return Collections.emptyList();
        }

        return StreamSupport.stream(jsonNode.spliterator(), false)
                .map(LocationsSearchService::fromJsonToLocation)
                .toList();
    }

    @SneakyThrows
    private static LocationSearch fromJsonToLocation(JsonNode location) {
        return LocationSearch.builder()
                .placeId(location.get("place_id").intValue())
                .lat(location.get("lat").textValue())
                .lon(location.get("lon").textValue())
                .displayName(location.get("display_name").textValue())
                .build();
    }
}
