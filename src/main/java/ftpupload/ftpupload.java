package ftpupload;

import ftpupload.util.ftpClientGraphic;
import org.apache.commons.net.ftp.FTP;

/**
 * Created by Joshua on 12/27/2014.
 */
public class ftpupload {

    FTP tp = new FTP();

    public static void main(String args[]){
        System.out.println("Testing");
        new ftpClientGraphic();
        System.out.println("Jenkins 1");
    }


}
