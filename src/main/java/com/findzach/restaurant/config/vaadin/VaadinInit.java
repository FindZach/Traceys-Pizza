package com.findzach.restaurant.config.vaadin;

import com.vaadin.flow.spring.SpringServlet;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * @author: Zach Smith
 * @date: 12/2/2023
 * @time: 10:03 AM
 */
public abstract class VaadinInit
        implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext)
            throws ServletException {
        AnnotationConfigWebApplicationContext context =
                new AnnotationConfigWebApplicationContext();
        registerConfiguration(context);
        servletContext.addListener(
                new ContextLoaderListener(context));

        ServletRegistration.Dynamic registration =
                servletContext.addServlet("dispatcher", (Servlet) new SpringServlet(context, true));
        registration.setLoadOnStartup(1);
        registration.addMapping("/*");
    }

    private void registerConfiguration(
            AnnotationConfigWebApplicationContext context) {
        // register your configuration classes here
    }

}