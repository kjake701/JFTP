package ftpupload.util;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * Created by Joshua on 12/27/2014.
 */
public class ftpClientGraphic {
    ftpVarUtil ftpUtil;
    ftpClient fClient;

    JFrame ftp;
    JPanel ftpPanelTextFields, ftpPanelButtons, ftpPanelLabels;
    JButton set, close, upload, login, disconnect;
    JTextField host, user, port;
    JPasswordField pass;
    JLabel hostl, userl, passl, portl, loginL, loginStatusL;
    Rectangle setR;
    private boolean isConnected;
    private BufferedImage img;

    public ftpClientGraphic(){
        ftpUtil = new ftpVarUtil();
        fClient = new ftpClient();

        isConnected = fClient.getFTPClient().isConnected();

        makeFrame();
    }

    public void makeFrame(){

        ftp = new JFrame();
        ftpPanelTextFields = new JPanel();
        ftpPanelButtons = new JPanel();
        ftpPanelLabels = new JPanel();

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception  e){
            System.out.println(e);
        }

        getframeProperties();

        addComponents();
        buttonLogic();

        ftp.setVisible(true);
    }

    public Dimension getMaxWindowDimension(){
        Dimension windowDimension = new Dimension();
        windowDimension.setSize(500, 500);

        return  windowDimension;
    }

    public void getframeProperties() {

                try {
                    img = ImageIO.read(this.getClass().getResource("/ftp.png"));
                } catch (IOException e){
                    e.printStackTrace();
                }


        ftp.setSize(700, 150);
        ftp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ftp.setMaximumSize(getMaxWindowDimension());
        ftp.getContentPane().setLayout(new BoxLayout(ftp.getContentPane(), BoxLayout.Y_AXIS));
        ftp.setResizable(false);
        ftp.setTitle("(Blog Chan - Asus Router) File Sync");
        ftp.setIconImage(img);

        ftpPanelLabels.setLayout(new FlowLayout());

        ftpPanelButtons.setBackground(Color.DARK_GRAY);
        ftpPanelTextFields.setBackground(Color.DARK_GRAY);
        ftpPanelLabels.setBackground(Color.DARK_GRAY);

        ftp.add(ftpPanelLabels);
        ftp.add(ftpPanelTextFields);
        ftp.add(ftpPanelButtons);

        ftpPanelTextFields.setSize(250, 250);
        ftpPanelButtons.setSize(250, 250);
    }

    public void addComponents(){
        setR = new Rectangle(50, 50, 50, 50);

        set = new JButton("Set");
        upload = new JButton("Upload");
        close = new JButton("Close");
        login = new JButton("Login");
        disconnect = new JButton("Disconnect");

        disconnect.setBounds(setR);
        login.setBounds(setR);
        upload.setBounds(setR);
        close.setBounds(setR);
        set.setBounds(setR);

        login.setBackground(Color.DARK_GRAY);
        upload.setBackground(Color.DARK_GRAY);
        close.setBackground(Color.DARK_GRAY);
        set.setBackground(Color.DARK_GRAY);

        host = new JTextField("192.168.1.64", 15);
        user = new JTextField("Fang", 15);
        pass = new JPasswordField("Redford9724!", 15);
        port = new JTextField("21", 5);

        hostl = new JLabel("Host Name                     ");
        userl = new JLabel("        User Name");
        passl = new JLabel("                        Password                      ");
        portl = new JLabel("Port Number");
        loginL = new JLabel("Connected: ");
        loginStatusL = new JLabel(String.valueOf(isConnected));

        ftpPanelLabels.add(hostl);
        ftpPanelLabels.add(userl);
        ftpPanelLabels.add(passl);
        ftpPanelLabels.add(portl);

        ftpPanelTextFields.add(host);
        ftpPanelTextFields.add(user);
        ftpPanelTextFields.add(pass);
        ftpPanelTextFields.add(port);

        ftpPanelButtons.add(set);
        ftpPanelButtons.add(login);
        ftpPanelButtons.add(disconnect);
        ftpPanelButtons.add(upload);
        ftpPanelButtons.add(close);
        ftpPanelButtons.add(loginL);
        ftpPanelButtons.add(loginStatusL);
    }

    public void buttonLogic(){

        close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ftp.dispose();
            }
        });

        set.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(ftpUtil.setHost(host.getText().toString()) + " " + ftpUtil.setUser(user.getText().toString()) + " "
                        + ftpUtil.setPass(pass.getText().toString()) + " " + ftpUtil.setPort(port.getText().toString()));
            }
        });

        upload.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    fClient.ftpLogin(ftpUtil.getHost(), ftpUtil.getUser(), ftpUtil.getPass(), ftpUtil.getPort());
                    loginStatusL.setText(String.valueOf(fClient.isConnected()));
                    System.out.println(isConnected);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });

        disconnect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    fClient.ftpDisconnect();
                    loginStatusL.setText(String.valueOf(fClient.isConnected()));
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
    }

}
