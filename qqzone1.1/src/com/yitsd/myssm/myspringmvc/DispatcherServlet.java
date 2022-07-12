//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.yitsd.myssm.myspringmvc;

import com.yitsd.myssm.ioc.BeanFactory;
import com.yitsd.myssm.util.StringUtil;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({"*.do"})
public class DispatcherServlet extends ViewBaseServlet {
    private BeanFactory beanFactory;

    public DispatcherServlet() {
    }

    public void init() throws ServletException {
        super.init();
        ServletContext application = this.getServletContext();
        Object beanFactoryObj = application.getAttribute("beanFactory");
        if (beanFactoryObj != null) {
            this.beanFactory = (BeanFactory)beanFactoryObj;
        } else {
            throw new RuntimeException("IOC容器获取失败！");
        }
    }

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String servletPath = request.getServletPath();
        servletPath = servletPath.substring(1);
        int lastDotIndex = servletPath.lastIndexOf(".do");
        servletPath = servletPath.substring(0, lastDotIndex);
        Object controllerBeanObj = this.beanFactory.getBean(servletPath);
        String operate = request.getParameter("operate");
        if (StringUtil.isEmpty(operate)) {
            operate = "index";
        }

        try {
            Method[] methods = controllerBeanObj.getClass().getDeclaredMethods();
            Method[] var8 = methods;
            int var9 = methods.length;

            for(int var10 = 0; var10 < var9; ++var10) {
                Method method = var8[var10];
                if (operate.equals(method.getName())) {
                    Parameter[] parameters = method.getParameters();
                    Object[] parameterValues = new Object[parameters.length];

                    String parameterName;
                    for(int i = 0; i < parameters.length; ++i) {
                        Parameter parameter = parameters[i];
                        parameterName = parameter.getName();
                        if ("request".equals(parameterName)) {
                            parameterValues[i] = request;
                        } else if ("response".equals(parameterName)) {
                            parameterValues[i] = response;
                        } else if ("session".equals(parameterName)) {
                            parameterValues[i] = request.getSession();
                        } else {
                            String parameterValue = request.getParameter(parameterName);
                            String typeName = parameter.getType().getName();
                            Object parameterObj = parameterValue;
                            if (parameterValue != null && "java.lang.Integer".equals(typeName)) {
                                parameterObj = Integer.parseInt(parameterValue);
                            }

                            parameterValues[i] = parameterObj;
                        }
                    }

                    method.setAccessible(true);
                    Object returnObj = method.invoke(controllerBeanObj, parameterValues);
                    String methodReturnStr = (String)returnObj ;
                    if(StringUtil.isEmpty(methodReturnStr)){
                        return;
                    }
                    if (methodReturnStr.startsWith("redirect:")) {
                        parameterName = methodReturnStr.substring("redirect:".length());
                        response.sendRedirect(parameterName);
                    } else if (methodReturnStr.startsWith("json:")) {
                        response.setCharacterEncoding("utf-8");
                        response.setContentType("application/json;charset=utf-8");
                        parameterName = methodReturnStr.substring("json:".length());
                        PrintWriter out = response.getWriter();
                        out.print(parameterName);
                        out.flush();
                    } else {
                        super.processTemplate(methodReturnStr, request, response);
                    }
                }
            }

        } catch (Exception var20) {
            var20.printStackTrace();
            throw new DispatcherServletException("DispatcherServlet出错了...");
        }
    }
}
