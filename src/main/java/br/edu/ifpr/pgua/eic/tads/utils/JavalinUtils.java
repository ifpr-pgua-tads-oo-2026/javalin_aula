package br.edu.ifpr.pgua.eic.tads.utils;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;
import io.javalin.rendering.template.JavalinThymeleaf;


public class JavalinUtils {
    
    public static Javalin makeApp(int port){

        Javalin app = Javalin.create(config->{
            ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
            templateResolver.setPrefix("/public/"); 
            templateResolver.setSuffix(".html");       
            templateResolver.setTemplateMode("HTML");
            templateResolver.setCharacterEncoding("UTF-8");
            templateResolver.setCacheable(false);      

            TemplateEngine templateEngine = new TemplateEngine();
            templateEngine.setTemplateResolver(templateResolver);
            config.fileRenderer(new JavalinThymeleaf(templateEngine));
            config.requestLogger.http((ctx, ms) -> {
                System.out.println(ctx.method() +" "+ ctx.fullUrl());
            });
            config.staticFiles.add("public",Location.CLASSPATH);
            
        }).start(port);
        return app;
    }


}

