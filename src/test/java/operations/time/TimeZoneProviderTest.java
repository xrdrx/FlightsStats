package operations.time;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.TimeZone;

class TimeZoneProviderTest {

    private TimeZoneProvider provider = new TimeZoneProvider();

    @Test
    public void TimeZoneVladivostokTest() {
        TimeZone tz = provider.getTimeZoneForCity("Владивосток");
        TimeZone expected = TimeZone.getTimeZone("Asia/Vladivostok");
        assertEquals(expected, tz);
    }

    @Test
    public void TimeZoneTelAvivTest() {
        TimeZone tz = provider.getTimeZoneForCity("Тель-Авив");
        TimeZone expected = TimeZone.getTimeZone("Asia/Tel_Aviv");
        assertEquals(expected, tz);
    }

    @Test
    public void TimeZoneUnknownCity() {
        TimeZone tz = provider.getTimeZoneForCity("NotACity");
        assertNull(tz);
    }

}