package com.sauzny.jkitchen_note.trycatchfinally;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DemoAutoCloseable {
	// 声明资源时要分析好资源关闭顺序,先声明的后关闭
	// 在try-with-resource中也可以有catch与finally块。
	// 只是catch与finally块是在处理完try-with-resource后才会执行。
	public static void main(String[] args) {
		try (Resource res = new Resource(); ResourceOther resOther = new ResourceOther();) {
			res.doSome();
			resOther.doSome();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	// JDK1.7以前的版本，释放资源的写法
	static String readFirstLingFromFile(String path) throws IOException {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(path));
			return br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null)
				br.close();
		}
		return null;
	}

	// JDK1.7中的写法，利用AutoCloseable接口
	// 代码更精练、完全
	static String readFirstLineFromFile(String path) throws IOException {
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			return br.readLine();
		}
	}
}

class Resource implements AutoCloseable {
	void doSome() {
		System.out.println("do something");
	}

	@Override
	public void close() throws Exception {
		System.out.println("resource closed");
	}
}

class ResourceOther implements AutoCloseable {
	void doSome() {
		System.out.println("do something other");
	}

	@Override
	public void close() throws Exception {
		System.out.println("other resource closed");
	}
}
