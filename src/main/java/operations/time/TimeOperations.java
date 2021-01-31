package operations.time;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.util.TimeZone;

public class TimeOperations {

    public ZonedDateTime getZonedDateTime(LocalDate date, LocalTime time, TimeZone zone) {
        return ZonedDateTime.of(date, time, zone.toZoneId());
    }

    public long getIntervalBetweenTwoDatesInMinutes(ZonedDateTime first, ZonedDateTime second) {
        return Duration.between(first, second).toMinutes();
    }

}
