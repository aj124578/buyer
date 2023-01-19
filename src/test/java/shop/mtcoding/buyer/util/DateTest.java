package shop.mtcoding.buyer.util;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.Test;

public class DateTest {
    
    @Test
    public void parse_test(){
        // given
        LocalDateTime current = LocalDateTime.now(); // java에서는 localDateTime을 젤 많이 씀 

        Timestamp stamp = Timestamp.valueOf(current);
        System.out.println(stamp);

        LocalDateTime nowTime = stamp.toLocalDateTime();

        // yyyy-MM-dd-hh:mm:ss
        String nowStr = nowTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        System.out.println(nowStr);
    }
}
