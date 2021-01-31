package operations.time;

import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

public class TimeZoneProvider {
    private static final Map<String, TimeZone> timeZones;
    static {
        Map<String, TimeZone> map = new HashMap<>();
        map.put("Владивосток", TimeZone.getTimeZone("Asia/Vladivostok"));
        map.put("Тель-Авив", TimeZone.getTimeZone("Asia/Tel_Aviv"));
        timeZones = map;
    }

    public TimeZone getTimeZoneForCity(String city) {
        TimeZone timeZone = timeZones.get(city);
        if (timeZone == null) {
            System.out.println("TimeZone not found!");
        }
        return timeZone;
    }
}

