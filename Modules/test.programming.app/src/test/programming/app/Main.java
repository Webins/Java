package test.programming.app;

import test.data.database.app.server;
import test.data.database.app.Server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Server servers = new Server();
        List<server> myServers = servers.getServerList();
        for(server srv : myServers){
            System.out.println("ip address: " + srv.getServerIp());
        }
       /*
        //old way
        URL url = new URL("https://www.buildappswithpaulo.com");
        URLConnection urlConnection = url.openConnection();
        BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
        String inputLine;
        while((inputLine= reader.readLine()) != null) {
            System.out.println(inputLine);
        }*/
    }
}