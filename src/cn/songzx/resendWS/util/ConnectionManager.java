/**
* @Title: ConnectionManager.java
* @Package cn.songzx.resendWS.dao
* @Description: TODO(用一句话描述该文件做什么)
* @author Songzx songzx_2326@163.com
* @date 2017年9月6日 下午3:47:38
* @version V1.0
*/
package cn.songzx.resendWS.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @ClassName: ConnectionManager
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Songzx songzx_2326@163.com
 * @date 2017年9月6日 下午3:47:38
 *
 */
public class ConnectionManager {

	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/pur?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "act123";

	/**
	 * 使用ThreadLocal保存Connection变量
	 */
	private static ThreadLocal<Connection> CONNECTION_HOLDER = new ThreadLocal<Connection>();

	/**
	 *
	 * @Date: 2017年9月6日下午3:52:32
	 * @Title: getConnection
	 * @Description: TODO(获取数据库连接)
	 * @return
	 * @return Connection 返回值类型
	 */
	public static Connection getConnection() throws Exception {
		Connection conn = CONNECTION_HOLDER.get();// ThreadLocal取得当前线程的connection
		if (conn == null) {// 如果ThreadLocal没有绑定相应的Connection，创建一个新的Connection，并将其保存到本地线程变量中。
			try {
				Class.forName(DRIVER);
				conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				CONNECTION_HOLDER.set(conn);// 将当前线程的Connection设置到ThreadLocal
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				throw new Exception("系统错误，请联系系统管理员");
			} catch (SQLException e) {
				e.printStackTrace();
				throw new Exception("系统错误，请联系系统管理员");
			}
		}
		return conn;
	}

	/**
	 *
	 * @Date: 2017年9月6日下午3:53:45
	 * @Title: closeConnection
	 * @Description: TODO(关闭Connection，清除集合中的Connection)
	 * @return void 返回值类型
	 */
	public static void closeConnection() {
		Connection conn = CONNECTION_HOLDER.get();// ThreadLocal取得当前线程的connection
		if (conn != null) {// 当前线程的connection不为空时，关闭connection
			try {
				conn.close();
				CONNECTION_HOLDER.remove();// connection关闭之后，要从ThreadLocal的集合中清除Connection
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}

	/**
	 *
	 * @Date: 2017年9月6日下午4:42:39
	 * @Title: beginTransaction
	 * @Description: TODO(开启事务)
	 * @throws Exception
	 * @return void 返回值类型
	 */
	public static void beginTransaction() throws Exception {
		Connection conn = CONNECTION_HOLDER.get();// ThreadLocal取得当前线程的connection
		conn.setAutoCommit(false);
	}

	/**
	 *
	 * @Date: 2017年9月6日下午4:42:53
	 * @Title: commit
	 * @Description: TODO(提交事务)
	 * @throws Exception
	 * @return void 返回值类型
	 */
	public static void commit() throws Exception {
		Connection conn = CONNECTION_HOLDER.get();// ThreadLocal取得当前线程的connection
		if (conn != null) {
			conn.commit();
		}
	}

	/**
	 *
	 * @Date: 2017年9月6日下午4:43:07
	 * @Title: rollback
	 * @Description: TODO(回滚事务)
	 * @throws Exception
	 * @return void 返回值类型
	 */
	public static void rollback() throws Exception {
		Connection conn = CONNECTION_HOLDER.get();// ThreadLocal取得当前线程的connection
		if (conn != null) {
			conn.rollback();
		}
	}

}
