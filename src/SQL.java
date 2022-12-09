import java.sql.*;

public class SQL {
    //连接数据库mysql
    private Connection con ;

    String driver = "com.mysql.jc.jdbc.Driver";
    String url = "jdbc:mysql://www.tyxtang.com:3306/Bank";

    String user = "root";

    String password = "Tyx20020818";

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
            String sql = "create table user (ID bigint primary key, name char(15) not null, password char(20) not null, phone char(15) not null, email char(30) not null, address char(60) not null,type char(15) not null, balance int not null)";
            stmt.execute(sql);
            stmt.close();
            System.out.println("建立数据库成功!");
        } catch (SQLException e) {
            System.out.println("\n检测到数据库已存在 返回代码（可能不是错误）：\"" + e.getMessage() + "\"\n");
        }
    }
    //插入数据
    public void insertData(long ID, String name, String password, String phone, String email, String address, String type, double balance) {
        try {
            Statement stmt = con.createStatement();
            String sql = "insert into user values(" + ID + ",'" + password + "','" + name + "','" + phone + "','" + email + "','" + address + "','" + type + "'," + balance + ")";
            stmt.execute(sql);
            stmt.close();
            System.out.println("插入数据成功!");
        } catch (SQLException e) {
            System.out.println("插入数据失败! 错误代码：\"" + e.getMessage() + "\"");
        }
    }

    //传入账户名和密码,返回是否匹配
    public boolean match(long ID, String password) {
        try {
            Statement stmt = con.createStatement();
            String sql = "select * from user where ID = " + ID;
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                if (rs.getString("password").equals(password)) {
                    IDnow id = new IDnow(ID);
                    return true;
                }
            }
            stmt.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println("查询失败! 错误代码：\"" + e.getMessage() + "\"");
        }
        return false;
    }
    //传入账户名,返回手机号
    public String getPhone(long ID) {
        try {
            Statement stmt = con.createStatement();
            String sql = "select * from user where ID = " + ID;
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                return rs.getString("phone");
            }
            stmt.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println("查询失败! 错误代码：\"" + e.getMessage() + "\"");
        }
        return null;
    }

    //传入账户名,返回邮箱
    public String getEmail(long ID) {
        try {
            Statement stmt = con.createStatement();
            String sql = "select * from user where ID = " + ID;
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                return rs.getString("email");
            }
            stmt.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println("查询失败! 错误代码：\"" + e.getMessage() + "\"");
        }
        return null;
    }

    //传入账户名,返回地址
    public String getAddress(long ID) {
        try {
            Statement stmt = con.createStatement();
            String sql = "select * from user where ID = " + ID;
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                return rs.getString("address");
            }
            stmt.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println("查询失败! 错误代码：\"" + e.getMessage() + "\"");
        }
        return null;
    }

    //传入账户名,返回余额
    public double getBalance(long ID) {
        try {
            Statement stmt = con.createStatement();
            String sql = "select * from user where ID = " + ID;
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                return rs.getDouble("balance");
            }
            stmt.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println("查询失败! 错误代码：\"" + e.getMessage() + "\"");
        }
        return 0;
    }

    //传入账户名,返回类型
    public String getType(long ID) {
        try {
            Statement stmt = con.createStatement();
            String sql = "select * from user where ID = " + ID;
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                return rs.getString("type");
            }
            stmt.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println("查询失败! 错误代码：\"" + e.getMessage() + "\"");
        }
        return null;
    }

    //传入账户名,返回姓名
    public String getName(long ID) {
        try {
            Statement stmt = con.createStatement();
            String sql = "select * from user where ID = " + ID;
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                return rs.getString("name");
            }
            stmt.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println("查询失败! 错误代码：\"" + e.getMessage() + "\"");
        }
        return null;
    }

    //传入账户名和金额,返回是否充值成功
    public boolean recharge(long ID, double money) {
        try {
            Statement stmt = con.createStatement();
            String sql = "update user set balance = balance + " + money + " where ID = " + ID;
            stmt.execute(sql);
            stmt.close();
            return true;
        } catch (SQLException e) {
            System.out.println("充值失败! 错误代码：\"" + e.getMessage() + "\"");
        }
        return false;
    }

    //传入账户名和金额,检查余额是否不足,返回是否消费成功
    public boolean outMoney(long ID, double money) {
        try {
            Statement stmt = con.createStatement();
            String sql = "select * from user where ID = " + ID;
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                if (rs.getInt("balance") < money) {
                    return false;
                }
            }
            sql = "update user set balance = balance - " + money + " where ID = " + ID;
            stmt.execute(sql);
            stmt.close();
            rs.close();
            return true;
        } catch (SQLException e) {
            System.out.println("取款失败! 错误代码：\"" + e.getMessage() + "\"");
        }
        return false;
    }

    //传入账户名和新密码,返回是否修改成功
    public boolean changePassword(long ID, String password) {
        try {
            Statement stmt = con.createStatement();
            String sql = "update user set password = '" + password + "' where ID = " + ID;
            stmt.execute(sql);
            stmt.close();
            return true;
        } catch (SQLException e) {
            System.out.println("修改密码失败! 错误代码：\"" + e.getMessage() + "\"");
        }
        return false;
    }

    //传入账户名和新地址,新电话,新邮箱,返回是否修改成功
    public boolean changeInfo(long ID, String address, String phone, String email) {
        try {
            Statement stmt = con.createStatement();
            String sql = "update user set address = '" + address + "', phone = '" + phone + "', email = '" + email + "' where ID = " + ID;
            stmt.execute(sql);
            stmt.close();
            return true;
        } catch (SQLException e) {
            System.out.println("修改信息失败! 错误代码：\"" + e.getMessage() + "\"");
        }
        return false;
    }

    //传入账户名，检查是否存在，返回是否存在
    public boolean checkID(long ID) {
        try {
            Statement stmt = con.createStatement();
            String sql = "select * from user where ID = " + ID;
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                return true;
            }
            stmt.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println("查询失败! 错误代码：\"" + e.getMessage() + "\"");
        }
        return false;
    }
}
