package com.rasmi.salestest.controller;

import com.rasmi.salestest.utils.FakeDataProvider;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author a simple controller to preview results in your browser
 */
@Controller("/")
public class RootController {

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("baskets", FakeDataProvider.getInstance().getBaskets());
        return "index";
    }

}
