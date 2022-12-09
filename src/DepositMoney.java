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
        con.add(done1);
        con.add(cancel1);
        this.setSize(340, 100);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        SQL sql = new SQL();
        sql.createTable();
        cancel1.addActionListener(e -> {
            DepositMoney.this.dispose();
        });
        done1.addActionListener(e -> {
            //存钱
            double cq = Double.parseDouble(cqInput.getText());
            SQL sql1 = new SQL();
            sql1.recharge(IDnow.getID_now(),cq);
            //弹出存钱成功
            JOptionPane.showMessageDialog(null, "存钱成功！存款金额为：" + cq , "提示", JOptionPane.INFORMATION_MESSAGE);
            DepositMoney.this.dispose();
        });
    }
}