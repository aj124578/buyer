package shop.mtcoding.buyer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import shop.mtcoding.buyer.model.PurchaseRepository;

@Controller
public class PurchaseController {

    @Autowired
    PurchaseRepository purchaseRepository;

    @GetMapping("/purchase/purchaseForm")
    public String purchaseForm() {
        return "purchase/purchaseForm";
    }

    // @PostMapping("/purchase/")
    // public String purchase(){
    //        User user = userRepository.findByUsernameAndPassword(username, password);

    // if(user==null){
    //     return "redirect:/loginForm";
    // } else {
    //     session.setAttribute("principal", user);
    //     return "redirect:/";
    // }
}
