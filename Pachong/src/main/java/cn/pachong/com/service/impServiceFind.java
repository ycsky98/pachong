package cn.pachong.com.service;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

@Service
public class impServiceFind {

	public void pachong(String url){
		String str = getURLResult(url);
		System.out.println(str);
	}

	//获取网页数据
	private String getURLResult(String urlfind) {
		InputStreamReader isr = null;
		BufferedReader br = null;
		try {
			URL url = new URL(urlfind);
			//URLConnection conn = url.openConnection();//该对象用于获取图片的字节
			isr = new InputStreamReader(url.openStream(),"utf-8");
			br = new BufferedReader(isr);
			StringBuffer sb = new StringBuffer();
			String str = null;
			while((str = br.readLine()) != null){
				sb.append(str);
			}
			return sb.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				isr.close();
				br.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return null;
	}
	
	
	//获取网页数据("进行细封装")(图片)
	private byte[] getURLFileByte(String urlfind) {
		InputStream isr = null;
		ByteArrayOutputStream out = null;
		ByteArrayInputStream inputStream;
		try {
			out = new ByteArrayOutputStream();
			URL url = new URL(urlfind.trim());
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/61.0.3163.79 Safari/537.36");
			connection.connect();
			//URLConnection conn = url.openConnection();//该对象用于获取图片的字节
			isr = new BufferedInputStream(connection.getInputStream());//不能使用InputStreamReader,该流针对文字有效
			byte[] a = new byte[1024*10];
			int arr;
			while((arr = isr.read()) != -1){
				out.write(arr);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				isr.close();
				out.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return out.toByteArray();
	}
	
	/**
	 * 正则匹配
	 * */
	public List<String> findAll(String str,String reg){
		//传入正则匹配
		Pattern pattern = Pattern.compile(reg);
		//传入所需要匹配的数据
		Matcher matcher = pattern.matcher(str);
		List<String> addString = new ArrayList<String>();
		//条件为是否有匹配的下一项
		int count = 0;//匹配正则所筛选的每一项数据
		while(matcher.find()){
			addString.add(matcher.group(count));
			count++;
		}
		return addString;
	}
	
	//存储数据
	public static void FileOut(byte[] b){
		FileOutputStream outputStream = null;
		try {
			outputStream = new FileOutputStream(new File("D:\\爬虫数据存储\\1.jpg"));
			outputStream.write(b);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				outputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	//获取文件2
	public static void getImg(String url) throws IOException{
        long startTime = System.currentTimeMillis();
        URL imgURL = new URL(url.trim());//转换URL
        HttpURLConnection urlConn = (HttpURLConnection) imgURL.openConnection();//构造连接
        urlConn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/61.0.3163.79 Safari/537.36");
        urlConn.connect();
        System.out.println(impServiceFind.class.toString()+":获取连接="+urlConn.getResponseMessage());
        if(urlConn.getResponseCode()==200){//返回的状态码是200 表示成功
            InputStream ins = urlConn.getInputStream(); //获取输入流,从网站读取数据到 内存中
            OutputStream out = new BufferedOutputStream(new FileOutputStream(new File("D:\\爬虫数据存储\\1.jpg")));
            int len=0;
            byte[] buff = new byte[1024*10];//10k缓冲流 视你内存大小而定咯
            
            while(-1!=(len=(new BufferedInputStream(ins)).read(buff))){//长度保存到len,内容放入到 buff
                out.write(buff, 0, len);//将图片数组内容写入到图片文件
            }
            urlConn.disconnect();
            ins.close();
            out.close();
            System.out.println(impServiceFind.class.toString()+"：获取图片完成,耗时="+((System.currentTimeMillis()-startTime)/1000)+"s");
        }
    }
	
	public static void main(String[] args) {
		impServiceFind find = new impServiceFind();
		byte[] str = find.getURLFileByte("url");
		FileOut(str);
		/*try {
			find.getImg("http://192.168.31.36:3000/images/3.jpg");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		/*String rea = find.getURLResult("http://192.168.31.36:3000/pubu#");
		System.out.println(rea);*/
	}
}
