package com.example.springluyentap1.controller;

import com.example.springluyentap1.entity.Product;
import com.example.springluyentap1.model.ProductModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Calendar;

@Controller
public class AdminController {

    @Autowired
    private ProductModel productModel;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String getListProduct(Model model, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int limit) {
        Page<Product> pagination = productModel.findProductsByStatus(1, PageRequest.of(page - 1, limit));
        model.addAttribute("pagination", pagination);
        model.addAttribute("page", page);
        model.addAttribute("limit", limit);
        model.addAttribute("datetime", Calendar.getInstance().getTime());
        return "product-list";
    }


   @RequestMapping(path = "/about" ,method = RequestMethod.GET)
   public String about(){return "about";
   }

   @RequestMapping(path = "/order/list" ,method = RequestMethod.GET)
   public String ordernamager(){return "order-namager";
   }

   @RequestMapping(path = "/user/list" , method = RequestMethod.GET)
   public String usernamager(){return "user-namager";
   }

    @RequestMapping(path = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }
}
