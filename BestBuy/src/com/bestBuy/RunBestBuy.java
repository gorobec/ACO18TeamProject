package com.bestBuy;

import com.bestBuy.server.Server;
import com.bestBuy.controller.BestBuy;
import com.bestBuy.dao.MapDataBase;

import java.io.IOException;

public class RunBestBuy {

    public static void main(String[] args) throws IOException {

        BestBuy service = new BestBuy(new MapDataBase());
        service.loadDatabase();

        Server server = new Server(service);

        //этот метод надо вызвать при закрытии формы
//        service.saveDatabase();
    }
}
