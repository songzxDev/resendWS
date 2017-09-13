package cn.songzx.resendWS.service.impl;

import java.util.ArrayList;
import java.util.List;

import cn.songzx.resendWS.dao.MiddleMessageSynclogDaoI;
import cn.songzx.resendWS.dao.impl.MiddleMessageSynclogDaoImpl;
import cn.songzx.resendWS.entity.MiddleMessageSynclogTab;
import cn.songzx.resendWS.service.MiddleMessageSynclogServiceI;
import cn.songzx.resendWS.util.ConnectionManager;

public class MiddleMessageSynclogServiceImpl implements MiddleMessageSynclogServiceI {

	private MiddleMessageSynclogDaoI getMiddleMessageSynclogDao() {
		return new MiddleMessageSynclogDaoImpl();
	}

	/**
	 * @Date: 2017年9月6日下午4:55:57
	 * @Title: getAllResendSoapRequest
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @return
	 * @throws Exception
	 * @return 返回值类型
	 */
	@Override
	public List<String> getAllResendSoapRequest() throws Exception {
		List<String> resendSoapRequestList = new ArrayList<String>();
		try {
			List<MiddleMessageSynclogTab> queryList = getMiddleMessageSynclogDao().getAllMiddleMessageSynclogTab();
			if (queryList != null && queryList.size() > 0) {
				for (MiddleMessageSynclogTab middleMessageSynclogTab : queryList) {
					resendSoapRequestList.add(middleMessageSynclogTab.getSoap_request());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.closeConnection();
		}
		return resendSoapRequestList;
	}

	/**
	 * @Date: 2017年9月7日上午9:11:55
	 * @Title: getAllMiddleMessageSynclogTab
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @return
	 * @throws Exception
	 * @return 返回值类型
	 */
	@Override
	public List<MiddleMessageSynclogTab> getAllMiddleMessageSynclogTab() throws Exception {
		List<MiddleMessageSynclogTab> queryList = null;
		try {
			queryList = getMiddleMessageSynclogDao().getAllMiddleMessageSynclogTab();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.closeConnection();
		}
		return queryList;
	}

	/**
	 * @Date: 2017年9月7日上午9:39:37
	 * @Title: updateMiddleMessageSynclogTabByPk
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param mms_id
	 * @throws Exception
	 * @return 返回值类型
	 */
	@Override
	public void updateMiddleMessageSynclogTabByPk(long mms_id) throws Exception {
		try {
			getMiddleMessageSynclogDao().updateMiddleMessageSynclogTabByPk(mms_id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.closeConnection();
		}
	}

}
