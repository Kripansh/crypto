package com.self.crypto.config;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.PathResource;
import org.springframework.core.io.Resource;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling
public class SchedulerConfig {

	@Bean
	public static PropertyPlaceholderConfigurer properties() {
		final PropertyPlaceholderConfigurer ppc = new PropertyPlaceholderConfigurer();
		final Resource[] resources = {
				new PathResource(System.getProperty("user.home") + "/crypto/crypto_override.properties") };
		ppc.setLocations(resources);
		return ppc;
	}

}
