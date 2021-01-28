package com.jaymartmedia.patientservice.security;

import com.google.gson.Gson;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplicationSecurityController {

    @RequestMapping("/current-user")
    public String getCurrentUser() {
        Gson gson = new Gson();

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        //return String.format("{\"username\": \"%s\",\"permissions\":%s}", auth.getName(), gson.toJson(auth.getAuthorities()));
        return gson.toJson(auth);
    }
}
