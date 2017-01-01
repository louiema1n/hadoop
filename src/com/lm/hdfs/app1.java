package com.lm.hdfs;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.hadoop.fs.FsUrlStreamHandlerFactory;
import org.apache.hadoop.io.IOUtils;

/**
 * hdfs����
 * @author xtztx
 *
 */
public class app1 {
	//���峣��path
	//hdfs://louiemain:9000/hello
	static final String path = "hdfs://louiemain:9000/hello";
	public static void main(String[] args) throws Exception {
		
		//���URL֧��hdfs
		URL.setURLStreamHandlerFactory(new FsUrlStreamHandlerFactory());
		
		URL url = new URL(path);
		InputStream inputStream = url.openStream();
		
		/**
		 * in	������
		 * out	�����
		 * buffsize	�����С
		 * close	�����ɺ��Ƿ�ر���
		 */
		IOUtils.copyBytes(inputStream, System.out, 1024, true);
	}
}
