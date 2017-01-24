package hei.tp04.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.velocity.VelocityConfigurer;
import org.springframework.web.servlet.view.velocity.VelocityViewResolver;

/**
 * Created by audrey on 24/01/2017.
 */
//Pour démarrer Spring WebMVC
@EnableWebMvc
//Pour pouvoir déclarer les beans
@Configuration
//Pour lui faire scruter hei.tp04.web.controller
@ComponentScan(basePackages = ("hei.tp04.web.controller"))
public class WebConfig extends WebMvcConfigurerAdapter {

    //pour surcharger la méthode on fait un @Override
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        registry.addResourceHandler("/webjars/**").addResourceLocations("/webjars/");
    }

    @Bean
    public VelocityConfigurer velocityConfig() {
        VelocityConfigurer velocityConfigurer = new VelocityConfigurer();
        velocityConfigurer.setResourceLoaderPath("/WEB-INF/velocity/");
        return velocityConfigurer;
    }

    @Bean
    public VelocityViewResolver velocityViewResolver()
    {
        VelocityViewResolver vvw = new VelocityViewResolver();
        vvw.setSuffix( ".vm" );
        return vvw;
    }
}
