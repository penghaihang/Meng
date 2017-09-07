package com.peng.meng.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.http.MediaType;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.http.converter.xml.Jaxb2RootElementHttpMessageConverter;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
@Configuration  
@ComponentScan(basePackages={"com.peng.meng.web"})  
@EnableWebMvc  
@EnableSpringDataWebSupport 
public class MvcConfig extends WebMvcConfigurerAdapter{
	
	 @Override  
	    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {  
	        converters.add(new MappingJackson2HttpMessageConverter());  
	    }  
//	@Override  
//    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {  
//        //converters.add(new MappingJacksonHttpMessageConverter());  
//       converters.add(new ByteArrayHttpMessageConverter());
//        StringHttpMessageConverter stringConverter = new StringHttpMessageConverter();
////        stringConverter.setWriteAcceptCharset(false);
////        ArrayList textTypes = new ArrayList();
////        textTypes.add(MediaType.TEXT_PLAIN);
////        textTypes.add(MediaType.TEXT_HTML);
////        textTypes.add(MediaType.TEXT_XML);
////        textTypes.add(MediaType.APPLICATION_XML);
////        textTypes.add(MediaType.APPLICATION_JSON);
////        stringConverter.setSupportedMediaTypes(textTypes);
//        converters.add(stringConverter);
//        converters.add(new Jaxb2RootElementHttpMessageConverter());
//        converters.add(getJsonConverter());
//    }  
    @Override  
    public void addResourceHandlers(ResourceHandlerRegistry registry) { 
    	registry.addResourceHandler(new String[] { "/static/**"}).
    	addResourceLocations(new String[] {"/static/"});
            registry.addResourceHandler(new String[] { "/resources/**"
            }).addResourceLocations(new String[] {
                "/resources/"
            });
           
    	
        
    }  
    @Bean  
    public InternalResourceViewResolver internalResourceViewResolver() {  
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();  
        resolver.setPrefix("/");  
        resolver.setSuffix(".jsp");  
        return resolver;  
    }  
    @Bean  
    public MultipartResolver multipartResolver(){  
        CommonsMultipartResolver bean=new CommonsMultipartResolver();  
        bean.setDefaultEncoding("UTF-8");  
        bean.setMaxUploadSize(8388608);  
        return bean;  
    }  

    
    
//    @Bean
//    public MappingJackson2HttpMessageConverter getMappingJacksonHttpMessageConverter()
//    {
//        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
//        List supportedMediaTypes = new ArrayList();
//       //supportedMediaTypes.add(MediaType.TEXT_HTML);
//        supportedMediaTypes.add(MediaType.ALL);
//        converter.setSupportedMediaTypes(supportedMediaTypes);
//        return converter;
//    }
    
    
}
