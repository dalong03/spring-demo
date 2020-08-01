package com.fb.webdemo.util;

import java.util.Date;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.transaction.annotation.Transactional;

import com.fb.webdemo.common.exception.BusinessException;
import com.fb.webdemo.common.exception.Exceptions;
import com.fb.webdemo.dao.LogDao;
import com.fb.webdemo.entity.Log;
import com.fb.webdemo.entity.User;

/**
 * 字典工具类
 */
public class LogUtils {

	private static LogDao logDao = SpringContextHolder.getBean(LogDao.class);

	/**
	 * 保存日志
	 */
	public static void saveLog(HttpServletRequest request, Integer type) {
		saveLog(request, null, null, type);
	}

	/**
	 * 保存日志
	 */
	public static void saveLog(HttpServletRequest request, Object handler, Exception ex, Integer type) {
		User user = UserUtils.getUser();
		if (user != null && user.getId() != null) {
			Log log = new Log();
			if (ex != null) {
				if (ex instanceof BusinessException) {
					log.setType(Log.TYPE_BUSI_EXCEPTION);
				} else {
					log.setType(Log.TYPE_SYS_EXCEPTION);
				}
			} else {
				log.setType(type);
			}
			log.setIpAddr(RequestUtils.getRemoteAddr(request));
			log.setUserAgent(request.getHeader("user-agent"));
			log.setRequestUri(request.getRequestURI());
			log.setMethod(request.getMethod());
			Map<String, String[]> paramsMap = request.getParameterMap();
			StringBuffer params = new StringBuffer("");
			Set<String> keys = paramsMap.keySet();
			if(keys != null){
				for (String key : keys) {
					params.append(key + ":");
					String[] values = paramsMap.get(key);
					for (String value : values) {
						params.append(value + " ");
					}
					params.append(";");
				}
			}
			log.setParams(params.toString().equals("") ? null : params.toString());
			log.setCreateUser(user.getId());
			log.setCreateDate(new Date());
			// 异步保存日志
			new Thread(new SaveLogThread(log, ex)).start();
		}
	}

	/**
	 * 保存日志线程
	 */
	public static class SaveLogThread implements Runnable {

		private Log log;
		private Exception ex;

		public SaveLogThread(Log log, Exception ex) {
			this.log = log;
			this.ex = ex;
		}

		@Override
		@Transactional
		public void run() {
			// 如果有异常，设置异常信息
			log.setExSynopsis(Exceptions.getExSynopsis(ex));
			log.setException(Exceptions.getStackTraceAsString(ex));
			// 保存日志信息
			logDao.save(log);
		}
	}
}
