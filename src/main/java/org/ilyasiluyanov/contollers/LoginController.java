package org.ilyasiluyanov.contollers;

import lombok.extern.slf4j.Slf4j;
import org.ilyasiluyanov.data.AccountDatabase;
import org.ilyasiluyanov.models.Account;
import org.ilyasiluyanov.models.ClassicAccount;
import org.ilyasiluyanov.models.RawAccount;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import java.util.ArrayList;
import java.util.List;

@Controller
@Slf4j
@SessionAttributes(types = Account.class)
public class LoginController {

    private static final String LOGIN_PAGE = "loginPage";
    private static final String UNSUCCESSFUL_LOGIN = "isLoginUnsuccessful";

    private final AccountDatabase<ClassicAccount> classicAccountDatabase;

    public LoginController(AccountDatabase<ClassicAccount> classicAccountDatabase) {
        this.classicAccountDatabase = classicAccountDatabase;
    }

    @GetMapping
    public String loginPage(Model model, RawAccount rawAccount) {
        if (!rawAccount.isEmpty() && !rawAccount.isCorrect()) {
            log.info("Login is unsuccessful");
            model.addAttribute(UNSUCCESSFUL_LOGIN, true);
        }
        log.info("GET: /");
        if (rawAccount.isEmpty())
            model.addAttribute("rawAccount", new RawAccount());
        return LOGIN_PAGE;
    }

    @PostMapping("/login")
    public String loginValidation(RawAccount rawAccount, Model model, SessionStatus status) {
        log.info("GET: /login    " + rawAccount.toString());

        List<Account> accounts = new ArrayList<>();
        classicAccountDatabase.findAll().forEach(accounts::add);
        boolean isAccountFound = false;
        Account foundAccount = null;
        for (Account account : accounts) {
            if (rawAccount.equals(account)) {
                isAccountFound = true;
                foundAccount = account;
                break;
            }
        }
        rawAccount.setCorrect(isAccountFound);
        if (!isAccountFound) {
            return "redirect:";
        }
        status.setComplete();
        model.addAttribute("account", foundAccount);
        return "goToHomePage";
    }


}
