package br.edu.ifpr.pgua.eic.tads;

import br.edu.ifpr.pgua.eic.tads.controllers.IndexController;
import br.edu.ifpr.pgua.eic.tads.utils.JavalinUtils;
import io.javalin.Javalin;
import io.javalin.http.Context;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ){
        var app = JavalinUtils.makeApp(8080);
        
        IndexController indexController = new IndexController();

        app.get("/",indexController.get);
        app.get("/boas-vindas", ctx -> { ctx.result("Olá Mundooooooooo!!");});
        app.get("/cadastro",ctx -> ctx.html("<html lang=pt-BR><meta charset=\"UTF-8\"> Aqui é cadastro!</html>"));
        
    }
}
