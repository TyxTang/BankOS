
import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.*;
import java.util.Vector;
class TeacherAddQuerySysApp
{
    private boolean packFrame=false;
    public TeacherAddQuerySysApp()
    {
        TeacherAddQuerySysFrame frame=new TeacherAddQuerySysFrame();
        if(packFrame)
        {
            frame.pack();
        }
        else
        {
            frame.validate();
        }
        Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize=frame.getSize();
        if(frameSize.height>screenSize.height)
        {
            frameSize.height=screenSize.height=100;
        }
        if(frameSize.width>screenSize.width)
        {
            frameSize.width=screenSize.width;
        }
        frame.setLocation((screenSize.width=frameSize.width)/2,
                (screenSize.height-frameSize.height)/2);
        frame.setVisible(true);
    }
    public static void main(String[]args)
    {
        try
        {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        new TeacherAddQuerySysApp();
    }
}
class TeacherAddQuerySysFrame extends JFrame
{
    private JPanel contentPane;
    private FlowLayout xYLayoutl=new FlowLayout();//构造XYLayout布局管理器
    //创建显示信息使用的组件
    private Label labell=new Label();
    private TextField stunumField=new TextField(10);
    private TextField nameField=new TextField(15);
    private Label label2=new Label();
    private TextField ageField=new TextField(8);
    private Label label3=new Label();
    private TextField sexField=new TextField(8);
    private Label label4=new Label();
    private TextField departmentField=new TextField(18);
    private Label label5=new Label();
    private TextField teleField=new TextField(12);
    private Label label6=new Label();
    private TextField emailField=new TextField(18);
    private Label label7=new Label();
    private Button addrecordButton=new Button ();
    private Button deleteButton=new Button ();
    private Button refreshButton=new Button();
    private Button stunumqueryButton=new Button();
    private Button allrecordButton=new Button();
    Vector vector;                   //声明一个向量对象
    String title[]={"学号","姓名","年龄","性别","系别","电话","email地址"};
    //二维表列名
    Connection connection=null;	//声明Connection接口对象connection
    ResultSet rset=null;//定义数据库查询的结果集
    Statement statement=null;	//定义查询数据库的Statement对象
    AbstractTableModel tm;//声明一个AbstractTableModel类对象 tm
    public TeacherAddQuerySysFrame()
    {
        enableEvents(AWTEvent.WINDOW_EVENT_MASK);
        try
        {
            jbInit();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    private void jbInit() throws Exception
    {
        contentPane=(JPanel) this.getContentPane();
        //初始化组件
        labell.setText("工号");
        contentPane.setLayout(xYLayoutl);//设置容器的布局管理器对象
        this.setSize(new Dimension(550,350)); //设置容器窗口的大小
        this.setTitle("老师地址信息查询系统");
        label2.setText("姓名");
        label3.setText("年龄");
        label4.setText("性别");
        label5.setText("系别");
        label6.setText("电话");
        label7.setText("EMAIL地址");
        addrecordButton.setLabel("添加");
        deleteButton.setLabel("删除");
        refreshButton.setLabel("更新");
        stunumqueryButton.setLabel("工号查询");
        allrecordButton.setLabel("全部记录");
        addrecordButton.addActionListener(new java.awt.event.ActionListener()
                //注册按钮事件监听对象，实现ActionListener接口的actionPerformed方法
        {
            public void actionPerformed(ActionEvent e)
            {
                addrecordButton_actionPerformed(e);
            }
        });
        deleteButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                deleteButton_actionPerformed(e);
            }
        });
        refreshButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                stunumqueryButton_actionPerformed(e);
            }
        });
        stunumqueryButton.addActionListener (new java.awt.event.ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                stunumqueryButton_actionPerformed (e);
            }
        });
        allrecordButton.addActionListener (new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                allrecordButton_actionPerformed(e);
            }
        });
        contentPane.add(labell);			//在容器中添加组件对象
        contentPane.add(stunumField);
        contentPane.add(label2);
        contentPane.add(nameField);
        contentPane.add(label3);
        contentPane.add(ageField);
        contentPane.add(label4);
        contentPane.add(sexField);
        contentPane.add(label5);
        contentPane.add(departmentField);
        contentPane.add(label6);
        contentPane.add(teleField);
        contentPane.add(label7);
        contentPane.add(emailField);
        contentPane.add(addrecordButton);
        contentPane.add(deleteButton);
        contentPane.add(refreshButton);
        contentPane.add(stunumqueryButton);
        contentPane.add(allrecordButton);
        createtable(); //在初始化函数中调用createtable()函数显示表格
    }
    void createtable()
    {
        JTable table;
        JScrollPane scroll;
        vector=new Vector();
        tm=new AbstractTableModel()
        {
            public int getColumnCount()
            {
                return title.length;
            }
            public int getRowCount ()
            {
                return vector.size();
            }
            public Object getValueAt(int row,int column)
            {
                if(!vector.isEmpty())
                {
                    return ((Vector)vector.elementAt(row)).elementAt (column);
                }
                else
                {
                    return null;
                }
            }
            public void setValueAt(Object value,int row,int column)
            {
            }
            public String getColumnName(int column)
            {
                return title[column];
            }
            public Class getColumnClass(int c)
            {
                return getValueAt(0,c).getClass();
            }
            public boolean isCellEditable(int row,int column)
            {
                return false;
            }
        };
        table=new JTable(tm);
        table.setToolTipText("DisplayQuery Result");
        table.setAutoResizeMode(table.AUTO_RESIZE_OFF);
        table.setCellSelectionEnabled(false);
        table.setShowHorizontalLines(true);
        table.setShowVerticalLines(true);
        scroll=new JScrollPane(table);
        scroll.setPreferredSize(new Dimension(530,200));
        contentPane.add(scroll);
    }
    protected void processWindowEvent(WindowEvent e)
    {
        super.processWindowEvent(e);
        if(e.getID()==WindowEvent.WINDOW_CLOSING)
        {
            System.exit(0);
        }
    }
    void addrecordButton_actionPerformed(ActionEvent e)
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");System.out.println("加载成功");
            connection=DriverManager.getConnection("jdbc:mysql://www.tyxtang.com/mydb?serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true","root","Tyx20020818");
            System.out.println("连接成功");

            statement=connection.createStatement();
            String sql="create Table studentbase(工号 int primary key,姓名 varchar(10) not null,年龄 int(5) not null,性别 char(1) not null,系别 char(10) not null)";
            String sqr="create Table studentaddress(电话 char(15) not null,email地址 char(20) not null)";
            statement.execute(sql);
            statement.execute(sqr);
            String sql1="insert into studentbase(工号,姓名,年龄,性别,系别)values (`"+Integer.parseInt(stunumField.getText())+"`,`"+nameField.getText()+"`,`"+Integer.parseInt(ageField.getText())+"`,`"+sexField.getText()+"`,`"+departmentField.
                    getText()+"`)";
            String sql2="insert into studentaddress(电话,email地址)values(`"+teleField.getText()+"`,`"+emailField.getText()+"`)";
            statement.executeUpdate(sql2);
            statement.executeUpdate(sql1);
            stunumField.setText("");
            nameField.setText("");
            ageField.setText("");
            sexField.setText("");
            departmentField.setText("");
            teleField.setText("");
            emailField.setText("");
        }
        catch(SQLException ex)
        {
            System.out.println("\nERROR:----- SOLException -----\n");
            while(ex!=null)
            {
                System.out.println("Message:"+ex.getMessage());
                System.out.println("SQLState:"+ex.getSQLState());
                System.out.println("ErrorCode:"+ex.getErrorCode());
                ex=ex.getNextException();
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            try
            {
                if(statement!=null)
                {
                    statement.close();
                }
                if(connection!=null)
                {
                    connection.close(); //关闭Connection 接口实例0
                }
            }
            catch(SQLException ex)
            {
                System.out.println("\nERROR:--- SQLException ---\n");
                System.out.println("Message:"+ex.getMessage());
                System.out.println("SQLState:"+ex.getSQLState());
                System.out.println("ErrorCode:"+ex.getErrorCode());
            }
        }
    }
    void deleteButton_actionPerformed(ActionEvent e)
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection=DriverManager.getConnection("jdbc:mysql://www.tyxtang.com/mydb?serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true","root","Tyx20020818");
            System.out.println("连接成功");
            statement=connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            String sql="select*from studentbase where 学号="+Integer.parseInt(stunumField.getText()+" ");
            rset=statement.executeQuery(sql);
            if(rset.next ()==false) //判断数据库中是否有要删除的记录,如没有则显示提示框
            {
                JOptionPane msg=new JOptionPane();
                JOptionPane. showMessageDialog (TeacherAddQuerySysFrame.this,
                        "数据库中没有您删除的学号","数据库中没有您删除的学号!",1);
            }
            else
            {
                String sqll="delete from studentbase where 学号="
                        +Integer.parseInt (stunumField.getText ())+" ";
                statement.executeUpdate (sqll);
                String sql2="delete from studentaddress where 学号="
                        +Integer.parseInt (stunumField.getText ())+" ";
                statement.executeUpdate (sql2);
                stunumField.setText ("");
                nameField.setText ("");
                ageField.setText ("");
                sexField.setText ("");
                departmentField.setText ("");
                teleField.setText ("");
                emailField.setText ("");
            }
        }
        catch(SQLException ex)        //捕捉异常
        {
            System. out. println("\nERROR:----- SQLException -----\n");
            while(ex!=null)
            {
                System. out. println("Message:"+ex.getMessage());
                System. out. println("SQLState:"+ex.getSQLState());
                System. out. println("ErrorCode:"+ex.getErrorCode());
                ex=ex.getNextException();
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            try
            {
                if(statement!=null)
                {
                    statement. close();  //关闭Statement接口实例
                }
                if(connection!=null)
                {
                    connection. close();    //关闭Connection 接口实例
                }
            }
            catch(SQLException ex)
            {
                System. out. println("\nERROR:----- SQLException -----\n");
                System. out. println("Message:"+ex.getMessage());
                System. out. println("SQLState:"+ex.getSQLState());
                System. out. println("ErrorCode:"+ex.getErrorCode());
            }
        }
    }
    //对表studentbase和表studentaddress.中的记录根据在各文本框中的输入值进行修改
    void refreshButton_actionPerformed(ActionEvent e)
    //处理refreshButton(修改按钮)的ActionEvent
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection=DriverManager.getConnection("jdbc:mysql://www.tyxtang.com/mydb?serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true","root","Tyx20020818");
            System.out.println("连接成功");//连接数据库
            statement=connection.createStatement();//创建Statement接口对象
            String sql1="update studentbase set姓名='"+nameField.getText()+
                    "',年龄="+Integer.parseInt(ageField.getText())+",性别='"
                    +sexField.getText()+"',系别='"+departmentField.getText()+
                    "' where 学号="+Integer.parseInt (stunumField.getText())+" ";
            statement.executeUpdate(sql1);            //更新studentbase表中输入学号的记录
            String sq12="update studentaddress set 电话='"+teleField.
                    getText()+"', email地址='"+emailField.getText()+"' where 学号="+Integer.parseInt(stunumField.getText())+" ";
            statement.executeUpdate(sq12);           //更新studentaddress表中输入学号的记录
            stunumField.setText("");     //清空信息框
            nameField.setText("");
            ageField.setText("");
            sexField.setText("");
            departmentField.setText("");
            teleField.setText("");
            emailField.setText("");
        }
        catch(SQLException ex)        //捕捉异常
        {
            System. out. println("\nERROR:----- SQLException -----\n");
            while(ex!=null)
            {
                System. out. println("Message:"+ex.getMessage());
                System. out. println("SQLState:"+ex.getSQLState());
                System. out. println("ErrorCode:"+ex.getErrorCode());
                ex=ex.getNextException();
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            try
            {
                if(statement!=null)
                {
                    statement. close();    //关闭Statement接口实例
                }
                if(connection!=null)
                {
                    connection. close();  //关闭Connection接口实例
                }
            }
            catch(SQLException ex)
            {
                System. out. println("\nERROR:----- SQLException -----\n");
                System. out. println("Message:"+ex.getMessage());
                System. out. println("SQLState:"+ex.getSQLState());
                System. out. println("ErrorCode:"+ex.getErrorCode());
            }
        }
    }
    //按照输入的学号,执行表studentbase、studentaddress的联合查询语句
    void stunumqueryButton_actionPerformed(ActionEvent e)
    //处理stunumqueryButton(学号查询按钮)的ActionEvent{try
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");          //实例化JDBC-ODBC桥的驱动
            connection=DriverManager.getConnection("jdbc:mysql://www.tyxtang.com/mydb?serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true","root","Tyx20020818");
            System.out.println("连接成功");//连接数据库
            statement= connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);//创建 Statement 接口对象
            String sql="select*from studentbase where 学号 ="+Integer.parseInt (stunumField.getText());
            rset=statement.executeQuery(sql);//执行学号为输入学号的查询语句
            if(rset.next()==false)  //判断数据库中是否有要查询的记录,如没有则显示提示框
            {
                JOptionPane msg= new JOptionPane();
                JOptionPane.showMessageDialog(TeacherAddQuerySysFrame. this,"数据库中没有您查询的学号","数据库中没有您查询的学号! ",1);
            }
            else
            {
                sql="select studentbase.学号,姓名,年龄,性别,系别,电话, email 地址from studentbase inner join student address on (studentbase.学号=studentaddress. 学号) where studentbase. 学号="+Integer.parseInt(stunumField.getText ( ) ) +" " ;
                ResultSet rs=statement.executeQuery(sql);
                //执行表studentbase、studentaddress的联合查询语句,将结果集放入rs中stunumField.setText(""); //清空输入学号
                vector.removeAllElements();  //初始化向量对象
                tm.fireTableStructureChanged();     //更新表格内容
                while(rs.next())
                {
                    Vector rec_vector= new Vector( );
                    rec_vector.addElement( String.valueOf( rs.getInt(1))); //从结果集中取数据放入向量 rec_vector 中
                    rec_vector.addElement( rs.getString(2));
                    rec_vector.addElement( String.valueOf( rs.getInt(3)));
                    rec_vector.addElement( rs.getString(4));
                    rec_vector.addElement( rs.getString(5));
                    rec_vector.addElement( rs.getString(6));
                    rec_vector.addElement( rs.getString(7));
                    vector.addElement(rec_vector);
                }
                tm.fireTableStructureChanged();
            }
        }
        catch(SQLException ex)        //捕捉异常
        {
            System.out.println("\nERROR:----- SOLException -----\n");
            while(ex!=null)
            {
                System.out.println("Message:"+ex.getMessage());
                System.out.println("SQLState:"+ex.getSQLState());
                System.out.println("ErrorCode:"+ex.getErrorCode());
                ex=ex.getNextException();
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            try
            {
                if(statement!=null)
                {
                    statement.close();     //关闭Statement接口实例
                }
                if(connection!=null)
                {
                    connection.close();      //关闭Connection接口实例
                }
            }
            catch(SQLException ex)
            {
                System.out.println("\nERROR;----- SQLException -----\n");
                System.out.println("Message:"+ex.getMessage());
                System.out.println("SQLState:"+ex.getSQLState());
                System.out.println("ErrorCode:"+ex.getErrorCode());
            }
        }
    }
    //执行表studentbase、studentaddress 的联合查询语句
    void allrecordButton_actionPerformed(ActionEvent e)
    //处理allrecordButton(全部记录按钮)的ActionEvent
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");     //实例化JDBC-ODBC 桥的驱动
            connection=DriverManager.getConnection("jdbc:mysql://www.tyxtang.com/mydb?serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true","root","Tyx20020818");
            System.out.println("连接成功");//连接数据库
            //创建Statement接口对象
            statement=connection.createStatement (ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String sql="select studentbase.学号,姓名,年龄,性别,系别,电话,emai1地址 from studentbase inner join studentaddress on (studentbase.学号=gtudentaddress.学号)";
            rset=statement.executeQuery(sql);
            //执行表studentbase、studentaddress的联合查询语句，将结果集放入rSet中
            vector.removeAllElements();    //初始化向量对象
            tm.fireTableStructureChanged();   //更新表格内容
            while(rset.next())
            {
                Vector rec_vector=new Vector();
                rec_vector.addElement(String.valueOf(rset.getInt(1)));  //从结果集中取数据放入向量rec_vector中
                rec_vector.addElement(rset.getString(2));
                rec_vector.addElement(String.valueOf(rset.getInt(3)));
                rec_vector.addElement(rset.getString(4));
                rec_vector.addElement(rset.getString(5));
                rec_vector.addElement(rset.getString(6));
                rec_vector.addElement(rset.getString(7));
                vector.addElement(rec_vector);//向量rec vector加入向量vector中
            }
            tm.fireTableStructureChanged();   //更新表格，显示向量 vector 的内容
        }
        catch(SQLException ex)
        {
            System.out.println("\nERROR:-----SQLException -----\n");
            while(ex!=null)
            {
                System.out.println("Message:"+ex.getMessage());
                System.out.println("SQLState:"+ex.getSQLState());
                System.out.println("ErrorCode:"+ex.getErrorCode());
                ex=ex.getNextException();
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            try
            {
                if(statement!=null)
                {
                    statement.close();
                }
                if(connection!=null)
                {
                    connection.close();
                }
            }
            catch(SQLException ex)
            {
                System.out.println("\nERROR:----- SQLException -----\n");
                System.out.println("Message:"+ex.getMessage());
                System.out.println("SQLState:"+ex.getSQLState());
                System.out.println("ErrorCode:"+ex.getErrorCode());
            }
        }
    }
}
