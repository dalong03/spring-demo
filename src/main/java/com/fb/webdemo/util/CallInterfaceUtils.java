package com.fb.webdemo.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class CallInterfaceUtils {
	/**
	 * 内容类型为 form
	 */
	public static final String CONTENT_TYPE_FORM = "application/x-www-form-urlencoded";
	/**
	 * 内容类型为 json
	 */
	public static final String CONTENT_TYPE_JSON = "application/json";

	/**
	 * 通过 post方式发送信息
	 * 
	 * @param path
	 *            目录地址
	 * @param postContent
	 *            发送的内容
	 * @return
	 * @throws IOException
	 */
	public static String sendMsgByPost(String path, String postContent, String contentType) throws IOException {
		URL url = null;
		url = new URL(path);
		HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
		httpURLConnection.setRequestMethod("POST");// 提交模式
		httpURLConnection.setConnectTimeout(10000);// 连接超时 单位毫秒
		httpURLConnection.setReadTimeout(10000);// 读取超时 单位毫秒
		// 发送POST请求必须设置如下两行
		httpURLConnection.setDoOutput(true);
		httpURLConnection.setDoInput(true);
		httpURLConnection.setRequestProperty("Charset", "UTF-8");
		// httpURLConnection.setRequestProperty("Content-Type", "application/json");
		httpURLConnection.setRequestProperty("Content-Type", contentType);

		// PrintWriter printWriter = new
		// PrintWriter(httpURLConnection.getOutputStream());
		// printWriter.write(postContent);
		// printWriter.flush();

		httpURLConnection.connect();
		OutputStream os = httpURLConnection.getOutputStream();
		os.write(postContent.getBytes("UTF-8"));
		os.flush();

		StringBuilder sb = new StringBuilder();
		int httpRspCode = httpURLConnection.getResponseCode();
		if (httpRspCode == HttpURLConnection.HTTP_OK) {
			// 开始获取数据
			BufferedReader br = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(), "utf-8"));
			String line = null;
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}
			br.close();
			return sb.toString();

		}

		return null;
	}
}
