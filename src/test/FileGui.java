package test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class FileGui extends JFrame {
    private JFrame jFrame = new JFrame();
    private JTextArea txtMsg;
    private JPanel jPanel = new JPanel();
    private JScrollPane jScrollPane = new JScrollPane();
    ImageIcon icon = new ImageIcon("resources/�˳�.png");
    private JButton btn_exit = new JButton(icon);
    public FileGui() throws IOException {
        setLayout(new FlowLayout());
        setBounds(50, 50, 500, 400);
        setTitle("�ļ��ϴ�������");
        add(jPanel);
        init();
        setIconImage(Toolkit.getDefaultToolkit().getImage("resources/kaoqin.jpg"));
        setVisible(true);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        FileServer.Start(txtMsg);
    }
    public void init() throws IOException {
        System.out.println("����������");
        txtMsg = new JTextArea(16,35);
        /*jPanel.add(txtMsg);*/
        jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane.setViewportView(txtMsg);
        jPanel.add(jScrollPane);
        txtMsg.setEditable(false);
        Box boxTop = Box.createHorizontalBox();
        boxTop.add(Box.createHorizontalStrut(5));
        boxTop.add(btn_exit);
        add(boxTop);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                int result = JOptionPane.showConfirmDialog(jFrame,"ȷ�Ϲرշ�����?","ȷ���˳�",JOptionPane.YES_NO_OPTION,JOptionPane.PLAIN_MESSAGE);
                if(result==JOptionPane.OK_OPTION){
                    System.exit(0);
                }else if(result==JOptionPane.NO_OPTION){
                    jFrame.setVisible(true);
                }
            }
        });
        btn_exit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int result = JOptionPane.showConfirmDialog(jFrame,"ȷ�Ϲرշ�����?","ȷ���˳�",JOptionPane.YES_NO_OPTION,JOptionPane.PLAIN_MESSAGE);
                if(result==JOptionPane.OK_OPTION){
                    System.exit(0);
                }else if(result==JOptionPane.NO_OPTION){
                    jFrame.setVisible(true);
                }
            }
        });

    }



    public static void main(String[] args) throws Exception {
        System.out.println("����������");
        new FileGui();

    }

}