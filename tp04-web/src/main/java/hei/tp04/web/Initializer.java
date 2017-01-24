package hei.tp04.web;

import hei.tp04.core.config.AppConfig;
import hei.tp04.core.config.DBConfig;
import hei.tp04.web.config.WebConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Created by audrey on 24/01/2017.
 */
public class Initializer extends AbstractAnnotationConfigDispatcherServletInitializer {


    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{AppConfig.class, DBConfig.class};
    }

    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{WebConfig.class};
    }

    protected String[] getServletMappings() {
        return new String[]{"/*"};
    }
}
