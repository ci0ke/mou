package org.cike.app;

import java.io.IOException;
import java.util.Properties;

import org.json.JSONException;

import com.qiniu.api.auth.AuthException;
import com.qiniu.api.auth.digest.Mac;
import com.qiniu.api.config.Config;
import com.qiniu.api.io.IoApi;
import com.qiniu.api.io.PutExtra;
import com.qiniu.api.io.PutRet;
import com.qiniu.api.rs.PutPolicy;

public class MyQiniu {
	private static String uptoken;
	static {
		Properties p = new Properties();// MyIO.getProperties("qiniu.properties");
		String ak = "iOfTnGIuvgcOJnnu2_ioJhQ5wBAhVG_RBTQLo-dK";//p.getProperty("AK");
		String sk = "f7eY97ZZab-qBeaQF8joaevbHXvY0MDAB-z3gqYu";// p.getProperty("SK");
		String bucket ="cikemou";// p.getProperty("bucket");
		
		setUptoken(ak, sk, bucket);
    
	}
	
	

	private static void setUptoken(String ak, String sk, String bucket) {
		Config.ACCESS_KEY = ak;
		Config.SECRET_KEY = sk;
		Mac mac = new Mac(Config.ACCESS_KEY, Config.SECRET_KEY);
		PutPolicy putPolicy = new PutPolicy(bucket);
		try {
			uptoken = putPolicy.token(mac);
		} catch (AuthException e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
		}
		System.out.print(uptoken);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		initest();

	}

	public static void initest() {
		String key = "" + System.nanoTime();
		String file = "H:/git/mou/pom.xml";
		MyQiniu qiniu = new MyQiniu();
		qiniu.upForm();
		//qiniu.update(key, file);

	}

	public String update(String key, String localFile) {
		PutExtra extra = new PutExtra();

		PutRet ret = IoApi.putFile(uptoken, key, localFile, extra);
		return ret.getKey();
	}

	public String upForm() {
		
		String rs = "<form method='post' action='http://up.qiniu.com/' enctype='multipart/form-data'>"
				+ "<input name='key'  value=''>"
				+ "<input name='token' type='hidden' value='"+uptoken+"' />"
				+ "<input name='file' type='file' />"
				+ "<input type='submit' />" + "</form>";
		System.out.print(rs);
		return rs;

	}

}
