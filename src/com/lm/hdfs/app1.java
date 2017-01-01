package com.lm.hdfs;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.hadoop.fs.FsUrlStreamHandlerFactory;
import org.apache.hadoop.io.IOUtils;

/**
 * hdfs操作
 * @author xtztx
 *
 */
public class app1 {
	//定义常量path
	//hdfs://louiemain:9000/hello
	static final String path = "hdfs://louiemain:9000/hello";
	public static void main(String[] args) throws Exception {
		
		//添加URL支持hdfs
		URL.setURLStreamHandlerFactory(new FsUrlStreamHandlerFactory());
		
		URL url = new URL(path);
		InputStream inputStream = url.openStream();
		
		/**
		 * in	输入流
		 * out	输出流
		 * buffsize	缓冲大小
		 * close	输出完成后是否关闭流
		 */
		IOUtils.copyBytes(inputStream, System.out, 1024, true);
	}
}
