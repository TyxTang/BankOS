import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class MenuMain extends JFrame {
    private JLabel Title1;
    private JButton checkInf, inMoney, outMoney, editInf, ExitMenu;
    public MenuMain(){
        super("主菜单");
        Container c = this.getContentPane();
        c.setLayout(new FlowLayout());
        Title1 = new JLabel("湛科银行");
        Title1.setFont(new Font("黑体", Font.PLAIN, 40));
        Title1.setHorizontalAlignment(SwingConstants.CENTER);
        checkInf =new JButton("1.查看账户信息");
        inMoney =new JButton("2.存钱");
        outMoney =new JButton("3.取钱");
        editInf =new JButton("4.修改个人信息");
        ExitMenu =new JButton("5.退出");
        checkInf.setPreferredSize(new Dimension(200,35));
        inMoney.setPreferredSize(new Dimension(200,35));
        outMoney.setPreferredSize(new Dimension(200,35));
        editInf.setPreferredSize(new Dimension(200,35));
        ExitMenu.setPreferredSize(new Dimension(200,35));
        checkInf.addActionListener(new CheckInf());
        outMoney.addActionListener(new inMoney_menu());
        editInf.addActionListener(new outMoney_menu());
        ExitMenu.addActionListener(new handlerTc());
        c.add(Title1);
        c.add(checkInf);
        c.add(inMoney);
        c.add(outMoney);
        c.add(editInf);
        c.add(ExitMenu);
        this.setSize(340, 300);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        System.out.println("账号：" + IDnow.getID_now());

    }

    class handlerTc implements ActionListener {
        public  void actionPerformed(ActionEvent e) {
            MenuMain.this.dispose();
            new LoginUI();
        }

    }
    class CheckInf implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Imformation imformation = new Imformation();
        }
    }
    class inMoney_menu implements ActionListener {
        public void withdraw(double a){

        }
        public void actionPerformed(ActionEvent e) {
            withdraw(100);
        }
    }
    class outMoney_menu implements ActionListener {
        public void actionPerformed(ActionEvent e) {

        }
    }
}