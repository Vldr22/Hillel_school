package org.example.hillel_school.controller;

import org.example.hillel_school.service.CustomNewsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/local")
public class LocalController {

    private final CustomNewsService customNewsService;

    public LocalController(CustomNewsService customNewsService) {
        this.customNewsService = customNewsService;
    }

    @GetMapping("/getTopHeadLinesByCountry")
    public List<String> getCustomizedNews(@RequestParam(required = false, defaultValue = "") String category,
                                          @RequestParam(required = false, defaultValue = "") String sources,
                                          @RequestParam(required = false, defaultValue = "") String q,
                                          @RequestParam(required = false, defaultValue = "") String country,
                                          @RequestParam(required = false, defaultValue = "") String language) {
        return customNewsService.getTopHeadLines(category, sources, q, country, language);
    }
}
