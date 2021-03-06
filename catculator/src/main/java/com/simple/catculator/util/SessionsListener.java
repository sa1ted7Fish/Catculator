package com.simple.catculator.util;

import com.simple.catculator.service.DepositService;
import com.simple.catculator.service.InitialCostService;
import com.simple.catculator.service.IrregularCostService;
import com.simple.catculator.service.MonthlyCostService;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class SessionsListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        HttpSession session = se.getSession();
        String sessionId = session.getId();

        InitialCostService initialCostService = (InitialCostService) this.getObjectFromApplication(session.getServletContext(), "initialCostServiceImpl");
        MonthlyCostService monthlyCostService = (MonthlyCostService) this.getObjectFromApplication(session.getServletContext(), "monthlyCostServiceImpl");
        IrregularCostService irregularCostService = (IrregularCostService) this.getObjectFromApplication(session.getServletContext(), "irregularCostServiceImpl");
        DepositService depositService = (DepositService) this.getObjectFromApplication(session.getServletContext(), "depositServiceImpl");

        if (session.isNew()) {
            initialCostService.addNewList(sessionId);
            monthlyCostService.addNewList(sessionId);
            irregularCostService.addNewList(sessionId);
            depositService.addNewItem(sessionId);
        }
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        HttpSession session = se.getSession();
        String sessionId = session.getId();

        InitialCostService initialCostService = (InitialCostService) this.getObjectFromApplication(session.getServletContext(), "initialCostServiceImpl");
        MonthlyCostService monthlyCostService = (MonthlyCostService) this.getObjectFromApplication(session.getServletContext(), "monthlyCostServiceImpl");
        IrregularCostService irregularCostService = (IrregularCostService) this.getObjectFromApplication(session.getServletContext(), "irregularCostServiceImpl");
        DepositService depositService = (DepositService) this.getObjectFromApplication(session.getServletContext(), "depositServiceImpl");

        initialCostService.removeDeprecatedList(sessionId);
        monthlyCostService.removeDeprecatedList(sessionId);
        irregularCostService.removeDeprecatedList(sessionId);
        depositService.removeDeprecatedItem(sessionId);
    }

    private Object getObjectFromApplication(ServletContext servletContext, String beanName){
        //??????WebApplicationContextUtils ??????Spring??????????????????
        ApplicationContext application= WebApplicationContextUtils.getWebApplicationContext(servletContext);
        //??????Bean????????????
        assert application != null;
        return application.getBean(beanName);
    }
}
