package com.example.demo.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringProxyfactoryExampleApplication {

	private static final Logger logger = LoggerFactory.getLogger(SpringProxyfactoryExampleApplication.class);

	@Autowired
	private BeanFactory beanFactory;

	public static void main(String[] args) {
		SpringApplication.run(SpringProxyfactoryExampleApplication.class, args);
	}

	@Bean
	public Calculator calculator() throws ClassNotFoundException {
		logger.info("Create Proxy for Calculator");

		final ProxyFactoryBean proxyFactoryBean = new ProxyFactoryBean();

		final Class<?>[] proxyInterfaces = { Calculator.class };
		proxyFactoryBean.setProxyInterfaces(proxyInterfaces);
		proxyFactoryBean.setTarget(calculatorImpl());
		proxyFactoryBean.setBeanFactory(beanFactory);

		final String[] interceptorNames = { "loggerAdvice" };
		proxyFactoryBean.setInterceptorNames(interceptorNames);

		return (Calculator) proxyFactoryBean.getObject();
	}

	@Bean
	public Calculator calculatorImpl() {
		return new CalculatorImpl();
	}

}
