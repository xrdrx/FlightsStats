package operations.time;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.util.TimeZone;

import static org.junit.jupiter.api.Assertions.*;

class TimeOperationsTest {

    private TimeOperations operations = new TimeOperations();

    @Test
    public void oneHourDifferenceTest() {
        ZonedDateTime first = ZonedDateTime.of(
                LocalDate.of(2021, 1, 30),
                LocalTime.of(7, 15),
                TimeZone.getTimeZone("Asia/Vladivostok").toZoneId());
        ZonedDateTime second = ZonedDateTime.of(
                LocalDate.of(2021, 1, 30),
                LocalTime.of(0, 15),
                TimeZone.getTimeZone("Asia/Tel_Aviv").toZoneId());
        long result = operations.getIntervalBetweenTwoDatesInMinutes(first, second);
        assertEquals(60, result);
    }

}