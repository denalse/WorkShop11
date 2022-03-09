package sg.edu.nus.iss.app.workShop11test;

import org.springframework.boot.DefaultApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@SpringBootApplication
public class WorkShop11testApplication {
private static final Logger logger = LoggerFactory.getLogger(WorkShop11testApplication.class);
private static final String DEFAULT_PORT = "3000";
	public static void main(String[] args) {
		//  SpringApplication.run(WorkShop11testApplication.class, args);
		logger.info("Workshop 11");
		SpringApplication app = new SpringApplication(WorkShop11testApplication.class);
		DefaultApplicationArguments appArgs = new DefaultApplicationArguments(args);

		List optVal = appArgs.getOptionValues("port");
		logger.info("optsVal > " + optVal);
		String portNumber = null;

		if(optVal == null || optVal.get(0) == null) {
			portNumber = System.getenv("PORT");

			if(portNumber == null)
				portNumber = DEFAULT_PORT;
		}else{
			portNumber = (String)optVal.get(0);

		}
		
		if(portNumber != null) {
			app.setDefaultProperties(
				Collections.singletonMap("server.port", portNumber));
		}
		app.run(args);
	}

}
