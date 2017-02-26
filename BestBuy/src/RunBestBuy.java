
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import controller.BestBuy;
import dao.IDataBase;
import dao.MapDataBase;
import view.LoginWindow;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.Arrays;

public class RunBestBuy {

    public static void main(String[] args) {

        BestBuy service = new BestBuy(new MapDataBase());
        service.loadDatabase();

        HttpServer server = null;
        try {
            server = HttpServer.create(new InetSocketAddress(8000), 0);
        } catch (IOException e) {
            e.printStackTrace();
        }
        server.createContext("/test", new HttpHandler() {
            @Override
            public void handle(HttpExchange httpExchange) throws IOException {
                httpExchange.getResponseHeaders().put("Access-Control-Allow-Origin", Arrays.asList("*"));
                String requestUrl = httpExchange.getRequestURI().toString();
                System.out.println(requestUrl);
                System.out.println("HTTP method is " + httpExchange.getRequestMethod());

                try (OutputStream outputStream = httpExchange.getResponseBody()){
                    String s = service.printAllProducts();
                    httpExchange.sendResponseHeaders(200, s.length());

                    outputStream.write(s.getBytes());
                    outputStream.flush();
                    outputStream.close();
                }

            }
        });
//        server.createContext("/post-info", new HttpHandler() {
//            @Override
//            public void handle(HttpExchange httpExchange) throws IOException {
//                httpExchange.getResponseHeaders().put("Access-Control-Allow-Origin", Arrays.asList("*"));
//                if(httpExchange.getRequestMethod().equals("POST")){
//                    Scanner sc = new Scanner(httpExchange.getRequestBody());
//                    StringBuilder sb = new StringBuilder();
//
//                    String line = null;
//                    line = sc.nextLine();
//
//
//                    System.out.println(line);
//                }
//            }
//        });
        server.setExecutor(null); // creates a default executor
        server.start();
        System.out.println("Server started. Connect to localhost:8000/test");

//        LoginWindow log = new LoginWindow(service);

        //этот метод надо вызвать при закрытии формы
//        service.saveDatabase();
    }
}
