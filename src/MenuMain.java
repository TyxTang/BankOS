import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuMain extends JFrame {
    private JLabel Title1,Title2,Title3;
    private JButton checkInf, inMoney, outMoney, editInf, quit;
    public MenuMain(){
        super("主菜单");
        Container c = this.getContentPane();
        c.setLayout(new FlowLayout());
        Title1 = new JLabel("主菜单");
        Title1.setFont(new Font("黑体", Font.PLAIN, 40));
        Title1.setHorizontalAlignment(SwingConstants.CENTER);
        JButton d=new JButton("                          " +"                    ");
        d.setContentAreaFilled(false);
        d.setBorderPainted(false);
        d.setEnabled(false);
        Title2 = new JLabel("余额：");
        Title2.setFont(new Font("黑体", Font.PLAIN, 14));
        Title2.setHorizontalAlignment(SwingConstants.CENTER);
        //Title3的值为从数据库中读取的余额
        SQL sql_menu = new SQL();
        Title3 = new JLabel(sql_menu.getBalance(IDnow.getID_now()) + "");
        Title3.setFont(new Font("黑体", Font.PLAIN, 14));
        Title3.setHorizontalAlignment(SwingConstants.CENTER);
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
        c.add(Title2);
        c.add(Title3);
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
            MenuMain.this.dispose();
        });
        inMoney.addActionListener(e -> {
            DepositMoney de=new DepositMoney();
            MenuMain.this.dispose();
        });
        outMoney.addActionListener(e -> {
            WithdrawMoney wi=new WithdrawMoney();
            MenuMain.this.dispose();
        });
        editInf.addActionListener(e -> {
            changimformation changimformation = new changimformation();
            MenuMain.this.dispose();
        });
    }
    class handlerTc implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            LoginUI login = new LoginUI();
            MenuMain.this.dispose();
        }
    }
}
