package ftpupload.util;

/**
 * Created by Joshua on 12/27/2014.
 */
public class ftpVarUtil {
    private String[] info = {"192.168.1.64", "Fang", "Redford9724!", "21"};
    private static int wID = 1;

    public static int getwID(){
        return wID;
    }

    public String getHost(){
        return info[0];
    }

    public String getUser(){
        return info[1];
    }

    public String getPass(){
        return info[2];
    }

    public String getPort(){
        return info[3];
    }

    public String setHost(String host){
        info[0] = host;

        return info[0];
    }

    public String setUser(String user){
        info[1] = user;

        return info[1];
    }

    public String setPass(String pass){
        info[2] = pass;

        return info[2];
    }

    public String setPort(String port){
        info[3] = port;

        return info[3];
    }

}
