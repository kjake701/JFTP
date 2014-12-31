package ftpupload;

import ftpupload.util.ftpClientGraphic;
import ftpupload.util.ftpVarUtil;
import org.apache.commons.net.ftp.FTP;

/**
 * Created by Joshua on 12/27/2014.
 */
public class ftpupload {

    FTP tp = new FTP();
    private static int id = ftpVarUtil.getwID();

    public static void main(String args[]){
        System.out.println("Starting client...");
        if(id == 1) {
            System.out.println("Session verified");
            ftpClientGraphic j = new ftpClientGraphic(id);
        } else {
            System.out.println("Can't verify window");
        }
    }


}
