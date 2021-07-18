package com.simple.catculator.controller;

import com.simple.catculator.domain.InitialCost;
import com.simple.catculator.domain.Statistic;
import com.simple.catculator.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/statistic")
public class StatisticController {

    @Autowired
    private StatisticService statisticService;

    @GetMapping
    public Statistic getStatistic(HttpServletRequest request) {
        String sessionId = request.getSession().getId();
        return statisticService.getStatistic(sessionId);
    }

}
