package operations.statistics;

import java.util.List;
import java.util.stream.Collectors;

public class StatisticsOperations<E extends Comparable<E>> {

    public E getPercentileItemFromList(List<E> items, double percentile) {
        if (items == null || items.isEmpty()) {
            throw new IllegalArgumentException("Operation requires a list with at least one item");
        }
        if (percentile > 100 || percentile <= 0) {
            throw new IllegalArgumentException("Percentile should be greater than 0 and less than or equal to 100");
        }

        List<E> sorted = items.stream().sorted().collect(Collectors.toList());
        int index = (int) Math.ceil((percentile / 100) * items.size());
        return sorted.get(index - 1);
    }

}
