package org.mackenzine.commons;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Collections {

    public static <T> List<List<T>> mapRepeat(Collection<T> items, int length) {
        return items.stream()
                .map(item -> repeat(item, length))
                .collect(Collectors.toList());
    }

    public static <T> List<T> repeat(T item, int limit) {
        return Stream.generate(() -> item)
                .limit(limit)
                .collect(Collectors.toList());
    }

    public static <T> List<T> getDifferentElements(Collection<T> elements) {
        return elements.stream()
                .distinct()
                .collect(Collectors.toList());
    }

    public static <T> List<List<T>> consecutiveSubLists(List<T> list, int length) {
        return Stream.iterate(0, i -> i + 1)
                .limit(list.size() - length + 1)
                .map(i -> list.subList(i, i + length))
                .collect(Collectors.toList());
    }
}
