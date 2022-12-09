import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class Imformation extends JFrame {
    JTextField ID = new JTextField(20);
    //设置不可编辑ID

    JTextField name = new JTextField(20);


    JTextField Phone = new JTextField(20);

    JTextField mail = new JTextField(20);
    JTextField address = new JTextField(20);
    JTextField type = new JTextField(20);
    JTextField balance = new JTextField(20);

    JButton operate =  new JButton("继续");
    JButton exit = new JButton("退出");
    public Imformation() {
        super("账户信息查询");
        SQL sql = new SQL();
        this.setLayout(new FlowLayout());
        this.add(new JLabel("银行卡号"));
        this.add(ID);
        ID.setText(String.valueOf(IDnow.getID_now()));
        ID.setEditable(false);
        this.add(new JLabel("姓        名"));
        this.add(name);
        name.setText(String.valueOf(IDnow.getName()));
        name.setEditable(false);
        this.add(new JLabel("电话号码"));
        this.add(Phone);
        Phone.setText(String.valueOf(IDnow.getPhone()));
        Phone.setEditable(false);
        this.add(new JLabel("邮        箱"));
        this.add(mail);
        mail.setText(String.valueOf(IDnow.getEmail()));
        mail.setEditable(false);
        this.add(new JLabel("地        址"));
        this.add(address);
        address.setText(String.valueOf(IDnow.getAddress()));
        address.setEditable(false);
        this.add(new JLabel("余        额"));
        this.add(balance);
        balance.setText(String.valueOf(IDnow.getBalance()));
        balance.setEditable(false);
        this.add(new JLabel("账户类型"));
        this.add(type);
        type.setText(String.valueOf(IDnow.getType()));
        type.setEditable(false);
        this.add(exit);
        this.pack();
        exit.addActionListener(new ActionQuit());
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        this.setSize(305,280);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
    class ActionQuit implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Imformation.this.dispose();
            MenuMain menuMain = new MenuMain();
        }
    }
    /*public static void main(String[] args) {
        Imformation Do = new Imformation();
    }*/
}

