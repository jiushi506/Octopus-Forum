package com.zhangyu.coderman.advice;

import org.springframework.beans.factory.annotation.Value;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class WebStartListener implements ServletContextListener {

    //百度
    @Value("${baidu.client.id}")
    private String baidu_clientID;

    @Value("${baidu.client.secret}")
    private String baicdu_clientSecret;

    @Value("${baidu.client.redirecturi}")
    private String baidu_Redirect;

    //github
    @Value("${github.client.id}")
    private String clientId;

    @Value("${github.client.secret}")
    private String clientSecret;

    @Value("${github.client.redirecturi}")
    private String RedirectUri;

    @Value("${index.loginUrl}")
    private String loginUrl;

    @Value("${index.baidu_Url}")
    private String baidu_loginUrl;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        //登入的地址
        loginUrl=loginUrl+"?client_id="+clientId+"&redirect_uri="+RedirectUri+"&scope=user&state=1";
        ServletContext servletContext = servletContextEvent.getServletContext();
        servletContext.setAttribute("loginUrl",loginUrl);
        //百度授权登入

        baidu_loginUrl="http://openapi.baidu.com/oauth/2.0/authorize?response_type=code&client_id="+baidu_clientID+"&redirect_uri="+baidu_Redirect+"&display=popup";
        servletContext.setAttribute("baidu_loginUrl",baidu_loginUrl);
        System.out.println(baidu_loginUrl);

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
