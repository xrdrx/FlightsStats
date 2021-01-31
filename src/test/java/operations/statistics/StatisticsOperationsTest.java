package operations.statistics;

import operations.statistics.StatisticsOperations;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StatisticsOperationsTest {

    private StatisticsOperations<Integer> operations = new StatisticsOperations<>();

    @Test
    public void percentileMethodThrowsOnEmptyList() {
        List<Integer> emptyList = new ArrayList<>();
        assertThrows(
                IllegalArgumentException.class,
                () -> operations.getPercentileItemFromList(emptyList, 10));
    }

    @Test
    public void percentileMethodThrowsOnPercentileOver100Test() {
        List<Integer> list = new ArrayList<>();
        list.add(15);
        assertThrows(
                IllegalArgumentException.class,
                () -> operations.getPercentileItemFromList(list, 110));
    }

    @Test
    public void percentileMethodThrowsOnPercentile0Test() {
        List<Integer> list = new ArrayList<>();
        list.add(15);
        assertThrows(
                IllegalArgumentException.class,
                () -> operations.getPercentileItemFromList(list, 0));
    }

    @Test
    public void percentileMethodThrowsOnPercentileLessThan0Test() {
        List<Integer> list = new ArrayList<>();
        list.add(15);
        assertThrows(
                IllegalArgumentException.class,
                () -> operations.getPercentileItemFromList(list, -1));
    }

    @Test
    public void percentileMethodOneItemListTest() {
        List<Integer> oneItem = new ArrayList<>();
        oneItem.add(15);
        assertEquals(15, operations.getPercentileItemFromList(oneItem, 10));
    }

    @Test
    public void percentileMethodTwoItemListTest() {
        List<Integer> oneItem = new ArrayList<>();
        oneItem.add(15);
        oneItem.add(18);
        assertEquals(15, operations.getPercentileItemFromList(oneItem, 50));
    }

    @Test
    public void percentileMethodTenItemListTest() {
        List<Integer> tenItems = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            tenItems.add(i);
        }
        assertEquals(8, operations.getPercentileItemFromList(tenItems, 90));
    }

    @Test
    public void percentileMethodTwentyFiveItemListTest() {
        List<Integer> tenItems = new ArrayList<>();
        for (int i = 0; i < 25; i++) {
            tenItems.add(i);
        }
        assertEquals(22, operations.getPercentileItemFromList(tenItems, 90));
    }

}