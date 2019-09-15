package cn.com.lee;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author Guoqing
 * @date 2017-11-29
 *
 */
@RestController
@SpringBootApplication
public class UeditorApplication  extends SpringBootServletInitializer {
	
private static final Logger LOGGER = LoggerFactory.getLogger(UeditorApplication.class);
	
	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(UeditorApplication.class);
        application.run(args);
        LOGGER.info("Ueditor application started!!!");
	}
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
			// TODO Auto-generated method stub
		return builder.sources(UeditorApplication.class);
	}
}
