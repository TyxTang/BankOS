import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuMain extends JFrame {
    private JLabel Title1;
    private JButton checkInf, inMoney, outMoney, editInf, quit;
    public MenuMain(){
        super("主菜单");
        Container c = this.getContentPane();
        c.setLayout(new FlowLayout());
        Title1 = new JLabel("主菜单");
        Title1.setFont(new Font("黑体", Font.PLAIN, 40));
        Title1.setHorizontalAlignment(SwingConstants.CENTER);
        checkInf =new JButton("1.查看账户信息");
        inMoney =new JButton("2.存钱");
        outMoney =new JButton("3.取钱");
        editInf =new JButton("4.修改个人信息");
        quit =new JButton("5.退出");
        checkInf.setPreferredSize(new Dimension(200,35));
        inMoney.setPreferredSize(new Dimension(200,35));
        outMoney.setPreferredSize(new Dimension(200,35));
        editInf.setPreferredSize(new Dimension(200,35));
        quit.setPreferredSize(new Dimension(200,35));
        quit.addActionListener(new handlerTc());
        c.add(Title1);
        c.add(checkInf);
        c.add(inMoney);
        c.add(outMoney);
        c.add(editInf);
        c.add(quit);
        this.setSize(340, 300);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        SQL sql = new SQL();
        sql.createTable();
        checkInf.addActionListener(e -> {
            Imformation imformation = new Imformation();
        });
        inMoney.addActionListener(e -> {
            DepositMoney de=new DepositMoney();
        });
        outMoney.addActionListener(e -> {
            WithdrawMoney wi=new WithdrawMoney();
        });
        editInf.addActionListener(e -> {
            LoginUI login = new LoginUI();
        });
    }
    class handlerTc implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            LoginUI login = new LoginUI();
            MenuMain.this.dispose();
        }
    }
}
