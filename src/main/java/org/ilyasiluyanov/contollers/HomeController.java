package org.ilyasiluyanov.contollers;

import org.ilyasiluyanov.models.Account;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/home")
@SessionAttributes(names = {"myAccount"})
public class HomeController {
    private static final String HOME_PAGE = "homePage";

    @PostMapping
    public String homePage(@ModelAttribute("account") Account account, Model model){
        model.addAttribute("myAccount",account);
        return HOME_PAGE;
    }
}

