package com.yitsd.listener;

import javax.servlet.ServletContextListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.annotation.WebListener;

/**
 * @ClassName MyServletContextListener
 * @Date 2022/7/2 15:59
 */
@WebListener
public class MyServletContextListener implements ServletContextListener{

    @Override
    public void contextInitialized(ServletContextEvent sce){
        System.out.println("Servlet上下文对象初始化动作被监听到……");
    }


    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("Servlet上下文对象销毁动作被监听到……");

    }


}
