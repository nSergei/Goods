package tr.nsergey.jsf;

import org.apache.myfaces.ee6.MyFacesContainerInitializer;
import org.apache.myfaces.webapp.MyFacesServlet;
import org.apache.myfaces.webapp.StartupServletContextListener;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import java.util.HashSet;
import java.util.Set;

/**
 * User: kirill.salyamov
 * Time: 2016-05-06 18:27
 */
@Configuration
@ComponentScan(basePackages = "tr.nsergey")
public class JsfConfig {

    @Bean
    public ServletRegistrationBean facesServletRegistration() {
        ServletRegistrationBean servletRegistrationBean = new JsfServletRegistrationBean(new MyFacesServlet());
        servletRegistrationBean.setLoadOnStartup(1);
        return servletRegistrationBean;
    }

    public class JsfServletRegistrationBean extends ServletRegistrationBean {

        public JsfServletRegistrationBean(Servlet servlet, String... urlMappings) {
            super(servlet, urlMappings);
        }

        @Override
        public void onStartup(ServletContext servletContext)
                throws ServletException {

            MyFacesContainerInitializer facesInitializer = new MyFacesContainerInitializer();
            Set<Class<?>> clazz = new HashSet<>();
            clazz.add(JsfConfig.class);
            facesInitializer.onStartup(clazz, servletContext);

            servletContext.addListener(new StartupServletContextListener());

        }
    }
}
