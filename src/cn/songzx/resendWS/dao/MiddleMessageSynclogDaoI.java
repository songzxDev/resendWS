package cn.songzx.resendWS.dao;

import java.sql.SQLException;
import java.util.List;

import cn.songzx.resendWS.entity.MiddleMessageSynclogTab;

public interface MiddleMessageSynclogDaoI {

	/**
	 *
	 * @Date: 2017年9月6日下午4:28:04
	 * @Title: getAllMiddleMessageSynclogTab
	 * @Description: TODO(获取需要重新调用webservcie服务接口的日志信息)
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 * @return List<MiddleMessageSynclogTab> 返回值类型
	 */
	public List<MiddleMessageSynclogTab> getAllMiddleMessageSynclogTab() throws SQLException, Exception;

	/**
	 *
	 * @Date: 2017年9月7日上午9:34:20
	 * @Title: updateMiddleMessageSynclogTabByPk
	 * @Description: TODO(根据日志数据主键更新日志信息)
	 * @param mms_id
	 * @throws SQLException
	 * @throws Exception
	 * @return void 返回值类型
	 */
	public void updateMiddleMessageSynclogTabByPk(long mms_id) throws SQLException, Exception;
}
