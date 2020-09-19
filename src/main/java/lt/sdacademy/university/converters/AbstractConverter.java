package lt.sdacademy.university.converters;

import static java.util.stream.Collectors.toList;

import java.util.List;

public abstract class AbstractConverter<T, R> {

    public abstract R convert(T obj);

    public List<R> convert(List<T> items) {
        return items.stream().map(this::convert).collect(toList());
    }
}
