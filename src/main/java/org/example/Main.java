package org.example;

import java.io.IOException;
import org.example.Frame.MainFrame.MainFrameView;

public class Main {

    public static void main(String[] args) throws IOException {
        new MainFrameView();

        //        ObjectMapper objectMapper = new ObjectMapper();
        //                LocationsSearchService locationsSearchService = new LocationsSearchService(objectMapper);
        //                List<LocationSearch> list = locationsSearchService.getLocationsFromApi("USA", 15);
        //
        //                System.out.println(list.size());
        //
        //                list.stream()
        //                        .filter(i -> i.getDisplayName().contains("USA"))
        //                        .forEach(System.out::println);

        //        LocationsReverseService locationsReverseService = new LocationsReverseService(objectMapper);
        //        System.out.println(locationsReverseService.getLocationFromCoordinates("1", "1", "10"));
        //        locationsReverseService.getLocationFromCoordinates("-123140.7896239", "-123173.9598939",
        // "10").getAddress()
        //                .forEach((key, val) -> System.out.println(key  + "->" + val));
    }
}
