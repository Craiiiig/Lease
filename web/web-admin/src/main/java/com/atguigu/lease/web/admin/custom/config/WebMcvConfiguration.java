package com.atguigu.lease.web.admin.custom.config;

import com.atguigu.lease.web.admin.custom.converter.StringToBaseEnumConverterFactory;
import com.atguigu.lease.web.admin.custom.converter.StringToItemTypeConverter;
import com.atguigu.lease.web.admin.custom.interceptor.AuthorisationInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMcvConfiguration implements WebMvcConfigurer {

    @Autowired
    private StringToItemTypeConverter stringToItemTypeConverter;

    @Autowired
    private StringToBaseEnumConverterFactory stringToBaseEnumConverterFactory;

    @Autowired
    private AuthorisationInterceptor authorisationInterceptor;

    // Register Converter(ConverterFactory)
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(this.stringToItemTypeConverter);
        registry.addConverterFactory(this.stringToBaseEnumConverterFactory);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(this.authorisationInterceptor)
                .addPathPatterns("/admin/**")
                .excludePathPatterns("/admin/login/**")
        ;
    }
}
