import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class Imformation extends JFrame {
    JTextField ID = new JTextField(20);
    JTextField name = new JTextField(20);


    JTextField home = new JTextField(20);
    JTextField address = new JTextField(29);

    JButton operate =  new JButton("继续");
    JButton exit = new JButton("退出");
    public Imformation() {
        super("账户信息查询");
        this.setLayout(new FlowLayout());
        this.add(new JLabel("银行卡号"));
        this.add(ID);
        this.add(new JLabel("姓名"));
        this.add(name);
        this.add(new JLabel("电话号码"));
        this.add(home);
        this.add(new JLabel("邮箱"));
        this.add(address);
        this.add(operate);
        this.add(exit);
        this.pack();
        operate.addActionListener(new ActionListener1());
        exit.addActionListener(new ActionListener1());
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        this.setSize(400,250);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
    class ActionListener1 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource () == operate){
                ID.setText (" ");
                name.setText (" ");

                home.setText (" ");
                address.setText (" ");

            }
            else if (e.getSource () == exit) {
                System.exit(0);
            }
        }
    }
    public static void main(String[] args) {
        Imformation Do = new Imformation();
    }
}

