package cn.songzx.resendWS.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.songzx.resendWS.dao.MiddleMessageSynclogDaoI;
import cn.songzx.resendWS.entity.MiddleMessageSynclogTab;
import cn.songzx.resendWS.util.ConnectionManager;

public class MiddleMessageSynclogDaoImpl extends ConnectionManager implements MiddleMessageSynclogDaoI {

	/**
	 * @Date: 2017年9月6日下午4:28:57
	 * @Title: getAllMiddleMessageSynclogTab
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 * @return 返回值类型
	 */
	@Override
	public List<MiddleMessageSynclogTab> getAllMiddleMessageSynclogTab() throws SQLException, Exception {
		String querySql = "SELECT * FROM MIDDLE_MESSAGE_SYNCLOG WHERE EXE_STATUS='001'";
		List<MiddleMessageSynclogTab> queryList = new ArrayList<MiddleMessageSynclogTab>();
		PreparedStatement ps = getConnection().prepareStatement(querySql);
		if (ps != null) {
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				long mms_id = rs.getLong("MMS_ID");
				String soap_request = rs.getString("SOAP_REQUEST");
				MiddleMessageSynclogTab synclogTab = new MiddleMessageSynclogTab();
				synclogTab.setMms_id(mms_id);
				synclogTab.setSoap_request(soap_request);
				queryList.add(synclogTab);
			}
		}
		return queryList;
	}

	/**
	 * @Date: 2017年9月7日上午9:34:57
	 * @Title: updateMiddleMessageSynclogTabByPk
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param mms_id
	 * @throws SQLException
	 * @throws Exception
	 * @return 返回值类型
	 */
	@Override
	public void updateMiddleMessageSynclogTabByPk(long mms_id) throws SQLException, Exception {
		String updateSql = "UPDATE MIDDLE_MESSAGE_SYNCLOG SET EXE_STATUS='002' WHERE MMS_ID=?";
		PreparedStatement ps = getConnection().prepareStatement(updateSql);
		ps.setLong(1, mms_id);
		ps.executeUpdate();
	}

}
