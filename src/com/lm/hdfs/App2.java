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
 * fileSystem简单操作
 * @author xtztx
 *
 */
public class App2 {
	static final String PATH = "hdfs://louiemain:9000/";
	public static void main(String[] args) throws Exception {
		FileSystem fileSystem = FileSystem.get(new URI(PATH), new Configuration());
		//创建文件夹
		fileSystem.mkdirs(new Path("/d1"));
		//删除文件夹
		//fileSystem.delete(new Path("/d1"));
		//上传文件
		FSDataOutputStream out = fileSystem.create(new Path("/d1/hello"));
		FileInputStream in = new FileInputStream(new File("D:/BaiduYunDownload/Hadoop/初级班/4.hdfs的java操作方式/1.txt"));
		IOUtils.copyBytes(in, out, 1024, true);
		//下载文件
		FSDataInputStream inputStream = fileSystem.open(new Path("/d1/hello"));
		IOUtils.copyBytes(inputStream, System.out, 1024, true);
		//浏览文件夹
		FileStatus[] listStatus = fileSystem.listStatus(new Path("/"));
		for (FileStatus fileStatus : listStatus) {
			String isDir = fileStatus.isDir()?"文件夹":"文件";
			String path2 = fileStatus.getPath().toString();
			String permission = fileStatus.getPermission().toString();
			System.out.println(isDir + path2 + permission);
		}
	}
}
