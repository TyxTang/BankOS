import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class changimformation extends JFrame {
    JTextField ID = new JTextField(20);

    //设置Passwd为密码框
    JPasswordField Passwd = new JPasswordField(20);
    JPasswordField Passwd_is = new JPasswordField(20);
    JButton EditPasswd = new JButton("               确定修改密码               ");

    JTextField name = new JTextField(20);


    JTextField Phone = new JTextField(20);

    JTextField mail = new JTextField(20);
    JTextField address = new JTextField(20);
    JTextField type = new JTextField(20);

    JButton operate = new JButton("确定修改（非密码）");
    JButton exit = new JButton("退出");

    public changimformation() {
        super("账户信息修改");
        SQL sql = new SQL();
        this.setLayout(new FlowLayout());
        this.add(new JLabel("新密码"));
        this.add(Passwd);

        this.add(new JLabel("确认密码"));
        this.add(Passwd_is);
        this.add(EditPasswd);
        JButton d=new JButton("                                                     " +"                    ");
        d.setContentAreaFilled(false);
        d.setBorderPainted(false);
        d.setEnabled(false);
        this.add(d);
        this.add(new JLabel("新电话号码"));
        this.add(Phone);
        Phone.setText(String.valueOf(IDnow.getPhone()));
        this.add(new JLabel("新邮箱"));
        this.add(mail);
        mail.setText(String.valueOf(IDnow.getEmail()));
        this.add(new JLabel("新地址"));
        this.add(address);
        address.setText(String.valueOf(IDnow.getAddress()));
        this.add(operate);
        this.add(exit);
        this.pack();
        exit.addActionListener(new ActionQuit());
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        this.setSize(280, 400);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        EditPasswd.addActionListener(e -> {
            SQL sql_pass = new SQL();
            if (String.valueOf(Passwd.getPassword()).equals("")  || String.valueOf(Passwd_is.getPassword()).equals("")) {
                JOptionPane.showMessageDialog(null, "密码不能为空！", "提示", JOptionPane.INFORMATION_MESSAGE);
            }else{
                if (String.valueOf(Passwd.getPassword()).equals(String.valueOf(Passwd_is.getPassword()))) {
                    sql_pass.changePassword(IDnow.getID_now(), Passwd.getText());
                    JOptionPane.showMessageDialog(null, "密码修改成功");
                } else {
                    JOptionPane.showMessageDialog(null, "两次密码不一致");
                }
            }
        });

        operate.addActionListener(e -> {
            SQL sql_Info = new SQL();
            if(sql_Info.changeInfo(IDnow.getID_now(), Phone.getText(), mail.getText(), address.getText())){
                JOptionPane.showMessageDialog(null, "信息修改成功");
            }
            else{
                JOptionPane.showMessageDialog(null, "信息修改失败");
            }
        });
    }

    class ActionQuit implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            changimformation.this.dispose();
            MenuMain menuMain = new MenuMain();
        }
    }
}