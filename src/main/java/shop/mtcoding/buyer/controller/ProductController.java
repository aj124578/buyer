package shop.mtcoding.buyer.controller;

import java.util.List;

import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import shop.mtcoding.buyer.model.Product;
import shop.mtcoding.buyer.model.ProductRepository;
import shop.mtcoding.buyer.model.User;

@Controller
public class ProductController {
    
    @Autowired // 의존성 주입 = DI
    ProductRepository productRepository;

    @Autowired
    HttpSession httpSession;


    @GetMapping({"/", "/product"})
    public String findAll(Model model){
        List<Product> productList = productRepository.findAll();
        model.addAttribute("productList", productList); // 공유영역 request에 담아두면 view에서 찾아낼 수 있음
        return "product/list";
    }

    // select * from product where price = 1000
    // PathVariable에는 pk만 씀
    // pk가 아니면 queryString으로 전송
    @GetMapping("product/{id}")
    public String findById(@PathVariable int id, Model model){
        Product product = productRepository.findById(id);
        if(product == null){
            return "redirect:/notfound";
        }else{
            model.addAttribute("product", product); 
            return "product/detailPage";
        }
    }

    @PostMapping("product/{id}/purchase")
    public String updateById(@PathVariable int id, int qty) {

        User a = (User)httpSession.getAttribute("principal");
        if (a == null) {
            return "redirect:/loginForm";
        } else{ 
            Product product = productRepository.findById(id);
            Integer updateQty = product.getQty() - qty;
            int reuslt = productRepository.updateById(id, updateQty); 
        
        if (reuslt == 1) {
            return "redirect:/product/" + id;
        } else {
            return "redirect:/product/";
        }

        }

    }
}
