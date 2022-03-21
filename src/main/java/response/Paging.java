package response;

import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@NoArgsConstructor
public class Paging {
    public String cursor;

    public Paging(String cursor) {
        setCursor(cursor);

    }

    public void setCursor(String cursor) {
        if (cursor==null){
            LocalDateTime now = LocalDateTime.now();
            this.cursor = now.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        }
    }
}
