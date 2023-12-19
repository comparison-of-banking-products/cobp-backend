package ru.cobp.backend.common;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Utils {

    public static Pageable getPageSortedByDepositRateDesc(int page, int size) {
        return PageRequest.of(page, size, Sort.by(Constants.DEPOSIT_RATE).descending());
    }

    public static Pageable getPageSortedByDepositRateAsc(int page, int size) {
        return PageRequest.of(page, size, Sort.by(Constants.DEPOSIT_RATE).ascending());
    }

    public static <T> List<T> toList(Iterable<T> iterable) {
        return StreamSupport
                .stream(iterable.spliterator(), false)
                .collect(Collectors.toList());
    }

}
