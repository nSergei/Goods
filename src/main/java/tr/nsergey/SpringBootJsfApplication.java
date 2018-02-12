package tr.nsergey;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.servlet.ServletContext;

@SpringBootApplication
public class SpringBootJsfApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJsfApplication.class, args);
	}

	@Configuration
	@Profile("dev")
	static class ConfigureJSFContextParameters implements ServletContextInitializer {

		@Override
		public void onStartup(ServletContext servletContext){

			servletContext.setInitParameter("primefaces.THEME", "bootstrap");
			servletContext.setInitParameter("javax.faces.DEFAULT_SUFFIX",
					".xhtml");
			servletContext.setInitParameter(
					"javax.faces.PARTIAL_STATE_SAVING_METHOD", "true");
			servletContext.setInitParameter("javax.faces.PROJECT_STAGE",
					"Development");
			servletContext.setInitParameter("facelets.DEVELOPMENT", "true");
			servletContext.setInitParameter(
					"javax.faces.FACELETS_REFRESH_PERIOD", "1");
			servletContext.setInitParameter("org.apache.myfaces.LOG_WEB_CONTEXT_PARAMS", "false");

		}
	}

	@Configuration
	@Profile("production")
	static class ConfigureJSFContextParametersProd implements ServletContextInitializer {

		@Override
		public void onStartup(ServletContext servletContext){

			servletContext.setInitParameter("primefaces.THEME", "bootstrap");
			servletContext.setInitParameter("javax.faces.DEFAULT_SUFFIX",
					".xhtml");
			servletContext.setInitParameter(
					"javax.faces.PARTIAL_STATE_SAVING_METHOD", "true");
			servletContext.setInitParameter("javax.faces.PROJECT_STAGE",
					"Production");
			servletContext.setInitParameter("facelets.DEVELOPMENT", "false");
			servletContext.setInitParameter(
					"javax.faces.FACELETS_REFRESH_PERIOD", "-1");

		}
	}
}



