package org.oark.verflixt.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Bootstrap {

	private static Logger log = LoggerFactory.getLogger(Bootstrap.class);
	
	private static final ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");

    public static ApplicationContext getContext()
    {
        return context;
    }
	
	public static void main(String[] args) {
		log.info("bootstrapping application...");
	}

}
