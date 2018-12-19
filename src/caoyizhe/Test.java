package caoyizhe;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Test {
	public static final String driver = "com.mysql.jdbc.Driver";
	public static final String url = "jdbc:mysql://localhost:3306/xmglxt";
    public static final String user = "root";
    public static final String password = "";
    private static int Id = 0;
    private static String No = null;
	private static String Name = null;
	private static String Password = null;

	public static void main(String[] args) throws Exception {
		JavaBean jb = new JavaBean();
		List<JavaBean> list=new ArrayList<JavaBean>();
		//加载驱动程序
		Class.forName(driver);
		//获得数据库连接
		jb.getConnection();
		//操作数据库，实现增删改查
        ResultSet rs = jb.select("SELECT * FROM user");
        System.out.println("-----------------------------数据库数据为：-----------------------------");
        //如果有数据，rs.next()返回true
        while(rs.next()){
        	Id = rs.getInt(1);
        	No = rs.getString(2);
        	Name = rs.getString(3);
        	Password = rs.getString(4);
        	
        	jb.setId(Id);
        	jb.setNo(No);
        	jb.setName(Name);
        	jb.setPassword(Password);
        	
        	list.add(jb);
        	
            System.out.println("user_name："+jb.getId()+" || user_no："+jb.getNo()+" || user_name："+jb.getName()+" || user_password："+jb.getPassword()+"\t");
        }
	}
}
