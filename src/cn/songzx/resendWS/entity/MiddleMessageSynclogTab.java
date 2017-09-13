/**
* @Title: MiddleMessageSynclogTab.java
* @Package cn.songzx.resendWS.entity
* @Description: TODO(用一句话描述该文件做什么)
* @author Songzx songzx_2326@163.com
* @date 2017年9月6日 下午4:24:32
* @version V1.0
*/
package cn.songzx.resendWS.entity;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @ClassName: MiddleMessageSynclogTab
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Songzx songzx_2326@163.com
 * @date 2017年9月6日 下午4:24:32
 *
 */
public class MiddleMessageSynclogTab implements Serializable {

	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 */
	private static final long serialVersionUID = 445311698218101700L;

	private long mms_id;

	private String current_guid;

	private String log_code;

	private String log_text;

	private String soap_request;

	private String soap_response;

	private String syn_date;

	private String step_name;

	private Timestamp create_date;

	private String exe_status;

	/**
	 * @return the mms_id
	 */
	public long getMms_id() {
		return mms_id;
	}

	/**
	 * @param mms_id
	 *            the mms_id to set
	 */
	public void setMms_id(long mms_id) {
		this.mms_id = mms_id;
	}

	/**
	 * @return the current_guid
	 */
	public String getCurrent_guid() {
		return current_guid;
	}

	/**
	 * @param current_guid
	 *            the current_guid to set
	 */
	public void setCurrent_guid(String current_guid) {
		this.current_guid = current_guid;
	}

	/**
	 * @return the log_code
	 */
	public String getLog_code() {
		return log_code;
	}

	/**
	 * @param log_code
	 *            the log_code to set
	 */
	public void setLog_code(String log_code) {
		this.log_code = log_code;
	}

	/**
	 * @return the log_text
	 */
	public String getLog_text() {
		return log_text;
	}

	/**
	 * @param log_text
	 *            the log_text to set
	 */
	public void setLog_text(String log_text) {
		this.log_text = log_text;
	}

	/**
	 * @return the soap_request
	 */
	public String getSoap_request() {
		return soap_request;
	}

	/**
	 * @param soap_request
	 *            the soap_request to set
	 */
	public void setSoap_request(String soap_request) {
		this.soap_request = soap_request;
	}

	/**
	 * @return the soap_response
	 */
	public String getSoap_response() {
		return soap_response;
	}

	/**
	 * @param soap_response
	 *            the soap_response to set
	 */
	public void setSoap_response(String soap_response) {
		this.soap_response = soap_response;
	}

	/**
	 * @return the syn_date
	 */
	public String getSyn_date() {
		return syn_date;
	}

	/**
	 * @param syn_date
	 *            the syn_date to set
	 */
	public void setSyn_date(String syn_date) {
		this.syn_date = syn_date;
	}

	/**
	 * @return the step_name
	 */
	public String getStep_name() {
		return step_name;
	}

	/**
	 * @param step_name
	 *            the step_name to set
	 */
	public void setStep_name(String step_name) {
		this.step_name = step_name;
	}

	/**
	 * @return the create_date
	 */
	public Timestamp getCreate_date() {
		return create_date;
	}

	/**
	 * @param create_date
	 *            the create_date to set
	 */
	public void setCreate_date(Timestamp create_date) {
		this.create_date = create_date;
	}

	/**
	 * @return the exe_status
	 */
	public String getExe_status() {
		return exe_status;
	}

	/**
	 * @param exe_status
	 *            the exe_status to set
	 */
	public void setExe_status(String exe_status) {
		this.exe_status = exe_status;
	}

}
