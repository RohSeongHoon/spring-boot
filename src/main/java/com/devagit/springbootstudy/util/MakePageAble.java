package com.devagit.springbootstudy.util;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class MakePageAble {
    public static final int DEFAULT_SIZE = 5;
    public static LocalDateTime currentTime = LocalDateTime.now();


    public static Pageable makePageAble(int page, Integer size) {
        if (size == null) {
            size = DEFAULT_SIZE;
        }
        return PageRequest.of(page, size);
    }

    //List<QuickTakeView> quickTakeViews = convertQuickTakeViews(quickTakes, requestUserId);
    //return Page.convert(quickTakeViews, QuickTakeView::getCreatedAt, limit);
//    public static <T, R> Page<T> convert(List<T> list, Function<T, R> cursorGetter, int limit, Long total) {
//        if (list.size() > limit) {
//            R cursorObject = cursorGetter.apply(list.get(limit));
//            String cursor = Optional.ofNullable(cursorObject).map(String::valueOf).orElse(null);
//            if (cursorObject instanceof LocalDateTime) {
//                cursor = ((LocalDateTime) cursorObject).format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
//                return new Page<>(list, null);
//
//            }
//        }
//    }
}

//    public static <T, R> Page<T> convert1(List<T> list, Function<T, R> cursorGetter, int limit, Long total) {
//        if (list.size() > limit) {
//            R cursorObject = cursorGetter.apply(list.get(limit));
//            String cursor = Optional.ofNullable(cursorObject).map(String::valueOf).orElse(null);
//            if (cursorObject instanceof ZonedDateTime) {
//                cursor = ((ZonedDateTime) cursorObject).format(DateTimeFormatter.ISO_INSTANT);
//            }
//            return new Page<>(list.subList(0, limit), new Paging(total, cursor));
//        }
//        return new Page<>(list, new Paging(total, null));
//    } 총몇개,마지막
//    List<QuickTakeView> quickTakeViews = convertQuickTakeViews(quickTakes, requestUserId);
//        return Page.convert(quickTakeViews, QuickTakeView::getCreatedAt, limit);


