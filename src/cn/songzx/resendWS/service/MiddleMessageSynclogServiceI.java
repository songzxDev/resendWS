package cn.songzx.resendWS.service;

import java.util.List;

import cn.songzx.resendWS.entity.MiddleMessageSynclogTab;

public interface MiddleMessageSynclogServiceI {

	public List<String> getAllResendSoapRequest() throws Exception;

	public List<MiddleMessageSynclogTab> getAllMiddleMessageSynclogTab() throws Exception;

	public void updateMiddleMessageSynclogTabByPk(long mms_id) throws Exception;
}
