/**
* @Title: GZipUtil.java
* @Package cn.songzx.resendWS.util
* @Description: TODO(用一句话描述该文件做什么)
* @author Songzx songzx_2326@163.com
* @date 2017年9月6日 下午5:49:04
* @version V1.0
*/
package cn.songzx.resendWS.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
* @ClassName: GZipUtil
* @Description: TODO(这里用一句话描述这个类的作用)
* @author Songzx songzx_2326@163.com
* @date 2017年9月6日 下午5:49:04
*
*/
public class GZipUtil {
	/**
     * gzip 压缩
     */
    public static byte[] gZip(byte[] data) {
        byte[] b = null;
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            GZIPOutputStream gzip = new GZIPOutputStream(bos);
            gzip.write(data);
            gzip.finish();
            gzip.close();
            b = bos.toByteArray();
            bos.close();
        } catch (Exception e) {
            e.printStackTrace();;
        }
        return b;
    }

    /**
     * Gzip 解压缩
     */
    public static String unGZip(byte[] data) {

        byte[] b = null;

        try {
            ByteArrayInputStream bis = new ByteArrayInputStream(data);
            GZIPInputStream gzip = new GZIPInputStream(bis);
            byte[] buf = new byte[1024];
            int num = -1;
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            while ((num = gzip.read(buf, 0, buf.length)) != -1) {
                baos.write(buf, 0, num);
            }
            b = baos.toByteArray();
            baos.flush();
            baos.close();
            gzip.close();
            bis.close();

        } catch (Exception e) {
            e.printStackTrace();
            return "error:" + e.getMessage();
        }

        return new String(b);
    }
}
