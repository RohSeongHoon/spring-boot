package com.devagit.springbootstudy.util;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

@Getter
@NoArgsConstructor
public class Page<T> {
    private List<T> data;
    private Paging paging;

    public Page(List<T> data, @Nullable Paging paging) {
        this.data = data;
        this.paging = paging;
    }

    public static <T,R> Page<T> convert(List<T> list,Function<T,R> cursorGetter,int limit,Long total){
        if (list.size() > limit) {
            R cursorObject = cursorGetter.apply(list.get(limit));
            String cursor = Optional.ofNullable(cursorObject).map(String::valueOf).orElse(null);
            if (cursorObject instanceof LocalDateTime) {
                cursor = ((LocalDateTime) cursorObject).format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
            }
            return new Page<>(list.subList(0, limit), new Paging(cursor, total));
        }
        return new Page<>(list,new Paging(null,total));
    }
}
//List<QuickTakeView> quickTakeViews = convertQuickTakeViews(quickTakes, requestUserId);
//        return Page.convert(quickTakeViews, QuickTakeView::getCreatedAt, limit);
//package com.cryptoquant.live.api.interfaces.client;
//
//import java.time.ZonedDateTime;
//import java.time.format.DateTimeFormatter;
//import java.util.Collections;
//import java.util.List;
//import java.util.Optional;
//import java.util.function.Function;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//
//@Getter
//@NoArgsConstructor
//public class Page<T> {
//
//    private List<T> data;
//    private Paging paging;
//
//    private Page(List<T> data, Paging paging) {
//        this.data = data;
//        this.paging = paging;
//    }
//
//    public static <T, R> Page<T> convertAndReserve(List<T> list, Function<T, R> cursorGetter, int limit) {
//        Page<T> result = convert(list, cursorGetter, limit, null);
//        Collections.reverse(result.data);
//        return result;
//    }
//
//    public static <T, R> Page<T> convert(List<T> list, Function<T, R> cursorGetter, int limit) {
//        return convert(list, cursorGetter, limit, null);
//    }
//
//    public static <T, R> Page<T> convert(List<T> list, Function<T, R> cursorGetter, int limit, Long total) {
//        if (list.size() > limit) {
//            R cursorObject = cursorGetter.apply(list.get(limit));
//            String cursor = Optional.ofNullable(cursorObject).map(String::valueOf).orElse(null);
//            if (cursorObject instanceof ZonedDateTime) {
//                cursor = ((ZonedDateTime) cursorObject).format(DateTimeFormatter.ISO_INSTANT);
//            }
//            return new Page<>(list.subList(0, limit), new Paging(total, cursor));
//        }
//        return new Page<>(list, new Paging(total, null));
//    }
//
//    public static <T> Page<T> convert(List<T> list, Paging paging) {
//        return new Page<>(list, paging);
//    }
//
//    public static <T> Page<T> convert(List<T> list) {
//        return new Page<>(list, Paging.EMPTY);
//    }
//
//    public static <T> Page<T> getEmptyInstance() {
//        return new Page<>(List.of(), Paging.EMPTY);
//    }
//
//}


