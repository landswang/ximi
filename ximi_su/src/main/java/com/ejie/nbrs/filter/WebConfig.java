// /**
// * CORSFilter.java com.ejie.nbrs.filter
// *
// * Function： TODO
// *
// * ver date author ────────────────────────────────── ver1.1 2017年7月14日 torreswang
// *
// * Copyright (c) 2017, EJie All Rights Reserved.
// */
//
// package com.ejie.nbrs.filter;
//
// import org.springframework.context.annotation.Configuration;
// import org.springframework.web.servlet.config.annotation.CorsRegistry;
// import org.springframework.web.servlet.config.annotation.EnableWebMvc;
// import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//
// /**
// * ClassName:CORSFilter
// *
// * @author torreswang
// * @version
// * @since Ver 1.1
// * @Date 2017年7月14日 上午10:09:26
// * @see
// */
// @Configuration
// @EnableWebMvc
// public class WebConfig extends WebMvcConfigurerAdapter {
//
// @Override
// public void addCorsMappings(CorsRegistry registry) {
// registry.addMapping("/api/**").allowedOrigins("http://domain2.com")
// .allowedMethods("PUT", "DELETE").allowedHeaders("header1", "header2", "header3")
// .exposedHeaders("header1", "header2").allowCredentials(false).maxAge(3600);
// }
// }
