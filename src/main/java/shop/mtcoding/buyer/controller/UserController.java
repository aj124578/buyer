package shop.mtcoding.buyer.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import shop.mtcoding.buyer.model.User;
import shop.mtcoding.buyer.model.UserRepository;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private HttpSession session;

    @GetMapping("/logout")
    public String logout() {
        session.invalidate(); // invalidate() 메소드를 사용하여 세션의 키를 날려버림
        return "redirect:/";
    }

    @GetMapping("/joinForm")
    public String joinForm() {
        return "user/joinForm";
    }

    @PostMapping("/join")
    public String join(String username, String password, String email) {
        int result = userRepository.insert(username, password, email);
        if (result == 1) {
            return "redirect:/loginForm";
        }
        return "redirect:/joinForm";
    }

    @GetMapping("/loginForm")
    public String loginForm(HttpServletRequest request) {
        // remember=ssar; JSESSIONID=FEF71A2C74CBAC9963F4190FD6ABEB80
        String username = "";
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("remember")) {
                username = cookie.getValue();
            }
        }
        request.setAttribute("remember", username);
        return "user/loginForm";
    }

    @PostMapping("/login")
    public String login(String username, String password, String remember, HttpServletResponse response) {
        User user = userRepository.findByUsernameAndPassword(username, password);
        if (user == null) {
            return "redirect:/loginForm";
        } else {
            // 요청헤더 : Cookie
            // 응답헤더 : Set-Cookie
            if (remember == null) { // remember에 공백이라도 넣으면 null이 아니니까 안 터짐
                remember = "";
            }

            // if(remember != null && remember.equals("on")){ // 이렇게 적으면 헷갈릴수도 있음
            if (remember.equals("on")) {
                // Set-Cookie에 담음
                Cookie cookie = new Cookie("remember", "ssar");
                response.addCookie(cookie);

            } else {
                Cookie cookie = new Cookie("remember", ""); // remember을 공백으로 덮어씌움
                cookie.setMaxAge(0); // 시간을 0초로 설정해서 밸류값을 받자말자 바로 없앰
                response.addCookie(cookie);
            }
            session.setAttribute("principal", user);
            return "redirect:/";
        }

    }
}