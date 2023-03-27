package com.vti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@RestController
@RequestMapping("/api/v1/messages")
public class MessageController {
    @Autowired
    private MessageSource messageSource;

    @GetMapping
    public String findAll(@RequestParam("code") String code){
        return messageSource.getMessage(code, null, LocaleContextHolder.getLocale());

    }
    @GetMapping("/en")
    public String findAllEn(@RequestParam("code") String code){
        return messageSource.getMessage(code, null, Locale.ENGLISH);
    }
    @GetMapping("/vi")
    public String findAllVi(@RequestParam("code") String code){
        return messageSource.getMessage(code, null, new Locale("vi"));
    }
}
