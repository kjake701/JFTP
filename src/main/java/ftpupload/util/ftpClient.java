package ftpupload.util;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

import java.io.IOException;
import java.net.InetAddress;

/**
 * Created by Joshua on 12/27/2014.
 */
public class ftpClient {
    private FTPClient client;
    private boolean connected;

    public ftpClient(){
        client = new FTPClient();
    }

    public void ftpUpload(){
    }

    public void ftpDownload(){

    }

    public void showServerResponse(){
        String[] replies = client.getReplyStrings();
        if(replies != null && replies.length > 0){
            for(String j : replies){
                System.out.println(j);
            }
        }
    }

    public FTPClient getFTPClient(){
        return client;
    }

    public boolean isConnected(){
        return connected;
    }

    public void getDirectory() throws IOException {
        if(connected){
            FTPFile[] direc = client.listDirectories();
            if(direc != null && direc.length > 0){
                for(FTPFile j : direc){
                    System.out.println(j);
                }
            } else {

            }
        } else {
            System.out.print("Not connected");
        }
    }

    public void ftpLogin(String host, String user, String pass, String port) throws IOException {
        int portINT = Integer.parseInt(port);
        InetAddress ipAddress = InetAddress.getByName(host);
        client.connect(ipAddress, portINT);
        showServerResponse();
        connected = client.login(user, pass);
        if(!connected){
            System.out.println("Could not connect to server");
        } else {
           System.out.println("Connected");
            getDirectory();
        }

    }

    public void ftpDisconnect() throws IOException {
        if(client.isConnected()){
            client.logout();
            client.disconnect();
        } else {
            System.out.println("Not connected");
        }

    }

}
