package com.vti.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/logs")
@Log4j2
// test log
public class LogController {
    @GetMapping
    public void testLogs() {
        log.info("info...");
        log.debug("info...");
        log.warn("info...");
        log.error("info...");
        log.trace("info...");
    }
}
