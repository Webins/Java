package test.data.database.app;
import java.util.ArrayList;
import java.util.List;
public class Server {
    public List<server> getServerList(){
        List<server> serverList = new ArrayList();
        server new_server = new server();
        for(int i = 0; i < 5; i++){
            new_server.setServerIp("192.168."+i);
            serverList.add(new_server);
        }

    return serverList;
    }
}
