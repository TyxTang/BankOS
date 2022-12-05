import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SQL {
    //连接数据库mysql
    private Connection con ;

    String driver = "com.mysql.jc.jdbc.Driver";
    String url = "jdbc:mysql://www.tyxtang.com:7706/mydb";

    String user = "TyxTang";

    String password = "root";

    public SQL(){
        try{
            Class.forName(driver);
        }catch(ClassNotFoundException ce){
            System.out.println("SQLException:" + ce.getMessage());
        }

        try{
            con = DriverManager.getConnection(url,user,password);
        }catch(SQLException e){
            System.out.println("SQLException:" + e.getMessage());
        }
    }
    //建立数据库,包含账户名,密码,电话号码,邮箱,地址,余额
    public void createTable() {
        try {
            Statement stmt = con.createStatement();
            String sql = "create table user (ID String primary key, name char(15) not null, password char(15) not null, phone char(15) not null, email char(15) not null, address char(15) not null, balance int not null)";
        } catch (SQLException e) {
            System.out.println("\n检测到数据库已存在 错误代码：\"" + e.getMessage() + "\"\n");
        }
    }
}
