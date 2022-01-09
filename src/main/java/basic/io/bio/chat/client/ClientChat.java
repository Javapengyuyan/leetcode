package basic.io.bio.chat.client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.net.Socket;

/**
 * @author: long
 * @create: 2022-01-04 22:28
 * @Description
 **/

public class ClientChat {
    private JFrame win = new JFrame();
    /** 2.消息内容框*/
    public JTextArea smsContent = new JTextArea(23,50);
    /** 3.发送消息框*/
    public JTextArea smsSend = new JTextArea(4,40);
    /** 4.展示在线人数窗口*/
    public JList<String> onLineUsers = new JList<>();
    //是否私聊按钮
    private JCheckBox isPrivateBn = new JCheckBox("私聊");
    //消息按钮
    private JButton sendBn = new JButton("发送");
    //登录界面
    private JFrame loginView;
    private JTextField ipEt,nameEt,idEt;
    private Socket socket;

    public static void main(String[] args) {
        new ClientChat().initView();
    }

    private void initView(){
        win.setSize(60,30);
        displayLoginView();

    }

    private void displayLoginView() {
        /**
         * 先让用户登录
         * 服务端ip
         * 用户名
         * id
         *
         */
        loginView = new JFrame("登录");
        loginView.setLayout(new GridLayout(3,1));
        loginView.setSize(400,230);

        JPanel ip = new JPanel();
        JLabel label = new JLabel("IP:");
        ip.add(label);
        ipEt = new JTextField(20);
        ip.add(ipEt);
        loginView.add(ip);

        JPanel name = new JPanel();
        JLabel label1 = new JLabel("姓名");
        name.add(label);
        nameEt=new JTextField(20);
        name.add(nameEt);
        loginView.add(name);

        JPanel btnView = new JPanel();
        JButton login = new JButton("登录");
        btnView.add(login);
        JButton cancle = new JButton("取消");
        btnView.add(cancle);
        loginView.add(btnView);
        //关闭窗口推出程序
        loginView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setWindowCenter(loginView,400,260,true);

        /** 给登录和取消绑定点击事件*/
        login.addActionListener((ActionListener) this);
        cancle.addActionListener((ActionListener) this);

    }

    private void setWindowCenter(JFrame jFrame, int width, int height, boolean flag) {

    }

    //todo

}
