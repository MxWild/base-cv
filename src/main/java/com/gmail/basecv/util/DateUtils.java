package com.gmail.basecv.util;

import lombok.experimental.UtilityClass;

import java.time.LocalDate;
import java.time.Month;

@UtilityClass
public class DateUtils {

    public static LocalDate of(int year, Month month) {
        return LocalDate.of(year, month, 1);
    }

}
