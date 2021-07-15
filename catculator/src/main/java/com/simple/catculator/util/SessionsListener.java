package com.simple.catculator.util;

import com.simple.catculator.service.InitialCostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;
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

        if (session.isNew()) {
            initialCostService.addNewList(sessionId);
        }
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        HttpSession session = se.getSession();
        String sessionId = session.getId();

        InitialCostService initialCostService = (InitialCostService) this.getObjectFromApplication(session.getServletContext(), "initialCostServiceImpl");

        initialCostService.removeDeprecatedList(sessionId);
    }

    private Object getObjectFromApplication(ServletContext servletContext, String beanName){
        //通过WebApplicationContextUtils 得到Spring容器的实例。
        ApplicationContext application= WebApplicationContextUtils.getWebApplicationContext(servletContext);
        //返回Bean的实例。
        assert application != null;
        return application.getBean(beanName);
    }
}
