package ru.cobp.backend.common;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Utils {

    public static Pageable getPageSortedByDepositRateDesc(int from, int size) {
        int page = from / size;
        return PageRequest.of(page, size, Sort.by(Constants.DEPOSIT_RATE).descending());
    }

}
