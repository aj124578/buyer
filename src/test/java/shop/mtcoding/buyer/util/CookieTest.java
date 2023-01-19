package shop.mtcoding.buyer.util;

import org.junit.jupiter.api.Test;

public class CookieTest {
    
    @Test
    public void parse_test(){
        String cookies = "remember=ssar; JSESSIONID=FEF71A2C74CBAC9963F4190FD6ABEB80";
        String arr[] = cookies.split(";");
        String username = arr[0].split("=")[1].trim(); // 파싱할때 앞뒤 공백 제거를 위해 trim()을 무조건 사용해줘야 함

        System.out.println(arr[0]);
        System.out.println(arr[1]);
        System.out.println(username);
    }
}
