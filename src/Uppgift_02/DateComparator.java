package Uppgift_02;

import java.time.LocalDate;

public class DateComparator {
    public static boolean lessThanOneYearAgo(LocalDate paymentDate) {
        LocalDate oneYearAgo = LocalDate.now().minusYears(1);
        return paymentDate.isAfter(oneYearAgo);
    }
}
