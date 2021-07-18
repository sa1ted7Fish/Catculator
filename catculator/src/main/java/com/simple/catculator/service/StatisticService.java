package com.simple.catculator.service;

import com.simple.catculator.domain.InitialCost;
import com.simple.catculator.domain.Statistic;

import java.util.List;

public interface StatisticService {
    Statistic getStatistic(String sessionId);
}
