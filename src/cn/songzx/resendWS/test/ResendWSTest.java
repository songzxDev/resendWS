/**
* @Title: ResendWSTest.java
* @Package cn.songzx.resendWS.test
* @Description: TODO(用一句话描述该文件做什么)
* @author Songzx songzx_2326@163.com
* @date 2017年9月6日 下午4:08:07
* @version V1.0
*/
package cn.songzx.resendWS.test;

import java.util.List;

import cn.songzx.resendWS.entity.MiddleMessageSynclogTab;
import cn.songzx.resendWS.service.MiddleMessageSynclogServiceI;
import cn.songzx.resendWS.service.impl.MiddleMessageSynclogServiceImpl;
import cn.songzx.resendWS.util.ConnectionManager;
import cn.songzx.resendWS.util.HttpClientResendWSUtil;

/**
 * @ClassName: ResendWSTest
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Songzx songzx_2326@163.com
 * @date 2017年9月6日 下午4:08:07
 *
 */
public class ResendWSTest {

	/**
	 * 调用采购系统审批流程相关webservice服务接口地址
	 */
	private static final String TEST_WSDL_URL = "http://10.0.105.12:7014/pur/services/CordysServer?wsdl";// 验证环境

	public static void main(String[] args) {
		MiddleMessageSynclogServiceI middleMessageSynclogService = new MiddleMessageSynclogServiceImpl();
		try {
			System.out.println(ConnectionManager.getConnection());
			List<MiddleMessageSynclogTab> queryList = middleMessageSynclogService.getAllMiddleMessageSynclogTab();
			if (queryList != null && queryList.size() > 0) {
				for (MiddleMessageSynclogTab synclogTab : queryList) {
					String requestSoapXml = synclogTab.getSoap_request();
					if (requestSoapXml == null || requestSoapXml.length() <= 0 || requestSoapXml.equals("null") || requestSoapXml.equals("(null)")) {
						continue;
					}
					String responseSoapXml = HttpClientResendWSUtil.sendPostRequest(TEST_WSDL_URL, requestSoapXml);
					if (responseSoapXml != null && responseSoapXml.contains("true")) {
						middleMessageSynclogService.updateMiddleMessageSynclogTabByPk(synclogTab.getMms_id());
					}
					//break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
