package com.baeksoo.shop.sales;

import com.baeksoo.shop.member.CustomUser;
import com.baeksoo.shop.member.Member;
import com.baeksoo.shop.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class SalesController {

    private final SalesRepository salesRepository;

    @PostMapping("/order")
    String postOrder(@RequestParam String title,
                     @RequestParam Integer price,
                     @RequestParam Integer count,
                     Authentication auth) {

        Sales sales = new Sales();
        sales.setItemName(title);
        sales.setPrice(price);
        sales.setCount(count);
        CustomUser user = (CustomUser) auth.getPrincipal();
        var member = new Member();
        member.setId(user.id);
        sales.setMember(member);

        salesRepository.save(sales);

        return "redirect:/list/page/1";
    }

    @GetMapping("/order/all")
    String getOrderAll(){
        List<Sales> result = salesRepository.customFindAll();
        System.out.println(result);

        return "sales.html";
    }

    /*
    class SalesDto{
        public String itemName;
        public Integer price;
        public String username;
    }
    */
}
