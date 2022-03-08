package basic.io;

import java.awt.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

/**
 * @author: long
 * @create: 2022-01-01 14:35
 * @Description
 **/

public class ChatClient extends Frame {

    Socket s = null;
    DataOutputStream doc = null;
    DataInputStream dis = null;
    TextField tfText = new TextField();
    TextArea taContent = new TextArea();
    boolean started = false;
    Thread recv = null;

    ChatClient(String name,int x,int y,int w,int h){
        /*super(name);
        this.setBounds(x,y,w,h);
        this.setLayout(new BorderLayout());
        this.addWindowListener(new MonitorWindow());
        taContent.setEditable(false);
        taContent.setEditable(false);
        this.add(tfText, BorderLayout.SOUTH);
        this.add(taContent, BorderLayout.NORTH);
        tfText.addActionListener(new MonitorText());//对于文本框的监视器必须添加在某个文本框上，只有窗口监视器才能添加到Frame上
        this.pack();
        this.setVisible(true); // 必须放在最后一行，否则之下的组件无法显示
        connect();
        ClientNameDialog dialog = new ClientNameDialog(this,"姓名提示框",true);*/
    }


}
