package ziyujewelry.com.dbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;




/**
 * 本类专门负责数据库的连接于关闭操作，在实例化本类对象时候就意味着要进行数据库的开发</br>
 * 所以在本类的构造方法里要进行数据库驱动加载与数据库连接取得
 * @author Administrator
 *
 */

public class ConnectionDemo {
	private static final String DBDRIVER = "com.mysql.jdbc.Driver";
	private static final String DBURL = "jdbc:mysql://localhost:3306/products";	
	private static final String PASS = "xin2007617";
	private static final String USER = "yves";
	private Connection conn = null;
	
	/**
	 * 在构造方法里面为conn对象进行实例化，可以直接取得数据库的连接对象</br>
	 */
	public ConnectionDemo() {
		
		try {
			Class.forName(DBDRIVER);
			this.conn = DriverManager.getConnection(DBURL,USER,PASS);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 取得一个数据库的连接对象
	 * @return Connection实例化对象
	 */
	public Connection getConnection(){
		return this.conn;
	}
	
	/**
	 * 负责数据库的关闭
	 */
	public void close(){
		if(this.conn != null){
			try {
				this.conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	} 

	
	

}
