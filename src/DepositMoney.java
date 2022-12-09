import javax.swing.*;
import java.awt.*;

public class DepositMoney extends JFrame{
    private JLabel cq1;
    private JButton cancel1,done1;
    private JTextField cqInput;
    public DepositMoney(){
        super("存钱");
        Container con = this.getContentPane();
        con.setLayout(new FlowLayout());
        cq1=new JLabel("存入金额：");
        cqInput = new JTextField(20);
        cancel1=new JButton("取消");
        done1=new JButton("确定");
        con.add(cq1);
        con.add(cqInput);
        con.add(cancel1);
        con.add(done1);
        this.setSize(340, 100);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        SQL sql = new SQL();
        sql.createTable();
        cancel1.addActionListener(e -> {
            MenuMain me =new MenuMain();
        });
        done1.addActionListener(e -> {
            MenuMain me =new MenuMain();
        });
    }
}