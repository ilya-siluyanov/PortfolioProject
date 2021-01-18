package org.ilyasiluyanov.contollers;

import lombok.extern.slf4j.Slf4j;
import org.ilyasiluyanov.data.AccountDatabase;
import org.ilyasiluyanov.models.Account;
import org.ilyasiluyanov.models.ClassicAccount;
import org.ilyasiluyanov.models.RawAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@RequestMapping("registerPage")
@SessionAttributes(names = "rawNewAccount")
@Slf4j
public class RegisterController {

    @Autowired
    AccountDatabase<Account> classicAccountDatabase;

    @GetMapping
    public String startRegistration(Model model) {
        log.info("GET: /registerPage");
        model.addAttribute("rawNewAccount", new RawAccount());
        return "registerPage";
    }

    @PostMapping
    public String validateRegistration(SessionStatus status, RawAccount rawNewAccount) {
        log.info("POST: /registerPage   "+rawNewAccount.toString());

        status.setComplete();
        boolean isValidationCorrect = false;
        //TODO:validate all fields
        isValidationCorrect = true;
        ClassicAccount newAccount = new ClassicAccount(
                rawNewAccount.getRawLogin(),
                rawNewAccount.getRawPassword(),
                rawNewAccount.getName(),
                rawNewAccount.getSurname());
        classicAccountDatabase.save(newAccount);
        return "redirect:";
    }

}
