package com.capgemini.mmbank.zuulproxyserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.capgemini.mmbank.zuulproxyserver.filter.ErrorFilter;
import com.capgemini.mmbank.zuulproxyserver.filter.PostFilter;
import com.capgemini.mmbank.zuulproxyserver.filter.PreFilter;
import com.capgemini.mmbank.zuulproxyserver.filter.RouteFilter;

@EnableZuulProxy
@SpringBootApplication
@EnableDiscoveryClient
public class ZuulProxyServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulProxyServerApplication.class, args);
	}

	@Bean
	public PreFilter preFilter() {
		return new PreFilter();
	}

	@Bean
	public PostFilter postFilter() {
		return new PostFilter();
	}

	@Bean
	public ErrorFilter errorFilter() {
		return new ErrorFilter();
	}

	@Bean
	public RouteFilter routeFilter() {
		return new RouteFilter();
	}
}
