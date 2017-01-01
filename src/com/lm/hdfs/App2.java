package com.lm.hdfs;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.permission.FsPermission;
import org.apache.hadoop.io.IOUtils;

/**
 * fileSystem�򵥲���
 * @author xtztx
 *
 */
public class App2 {
	static final String PATH = "hdfs://louiemain:9000/";
	public static void main(String[] args) throws Exception {
		FileSystem fileSystem = FileSystem.get(new URI(PATH), new Configuration());
		//�����ļ���
		fileSystem.mkdirs(new Path("/d1"));
		//ɾ���ļ���
		//fileSystem.delete(new Path("/d1"));
		//�ϴ��ļ�
		FSDataOutputStream out = fileSystem.create(new Path("/d1/hello"));
		FileInputStream in = new FileInputStream(new File("D:/BaiduYunDownload/Hadoop/������/4.hdfs��java������ʽ/1.txt"));
		IOUtils.copyBytes(in, out, 1024, true);
		//�����ļ�
		FSDataInputStream inputStream = fileSystem.open(new Path("/d1/hello"));
		IOUtils.copyBytes(inputStream, System.out, 1024, true);
		//����ļ���
		FileStatus[] listStatus = fileSystem.listStatus(new Path("/"));
		for (FileStatus fileStatus : listStatus) {
			String isDir = fileStatus.isDir()?"�ļ���":"�ļ�";
			String path2 = fileStatus.getPath().toString();
			String permission = fileStatus.getPermission().toString();
			System.out.println(isDir + path2 + permission);
		}
	}
}
