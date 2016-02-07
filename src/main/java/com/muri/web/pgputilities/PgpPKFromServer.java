package com.muri.web.pgputilities;

//import org.apache.commons.httpclient.NameValuePair;
//import org.apache.http.HttpEntity;
//import org.apache.http.HttpResponse;
//import org.apache.http.client.ClientProtocolException;
//import org.apache.http.client.HttpClient;
//import org.apache.http.client.entity.UrlEncodedFormEntity;
//import org.apache.http.client.methods.HttpPost;
//import org.apache.http.impl.client.DefaultHttpClient;
//import org.apache.http.message.BasicNameValuePair;
//import org.apache.http.util.EntityUtils;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by andrei.muresan on 9/24/2014.
 */
public class PgpPKFromServer {
    public static String SERVER_PATH = "http://pgp.mit.edu:11371";

    public static ByteArrayOutputStream getKey(String email) {
	ByteArrayOutputStream out = null;

	try {
	    URL yahoo = new URL(SERVER_PATH + "/pks/lookup?op=get&exact=on&search=" + email);
	    URLConnection yc = yahoo.openConnection();
	    BufferedReader in = null;
	    in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
	    String inputLine;
	    StringBuilder sb = new StringBuilder();

	    while ((inputLine = in.readLine()) != null) {
		System.out.println(inputLine);
		sb.append(inputLine).append("\r\n");
	    }
	    in.close();
	    System.out.println(sb.toString());
	    int a = sb.toString().indexOf("<pre>") + 7;
	    int b = sb.toString().indexOf("</pre>");
	    String aux = sb.toString().substring(a, b);
	    out = new ByteArrayOutputStream(aux.length());
	    out.write(aux.getBytes());
	} catch (IOException e) {
	    e.printStackTrace();
	}
	return out;
    }

//    public static boolean saveKeyOnPublic(String publicKey) {
//	System.out.println("PgpPKFromServer.saveKeyOnPublic =" + publicKey);
//	boolean status = false;
//	HttpClient httpClient = new DefaultHttpClient();
//	HttpPost httpPost = new HttpPost(SERVER_PATH + "/pks/add");
//	// Request parameters and other properties.
//	List<BasicNameValuePair> params = new ArrayList<BasicNameValuePair>();
//	params.add(new BasicNameValuePair("keytext", publicKey));
//	try {
//	    httpPost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
//	} catch (UnsupportedEncodingException e) {
//	    // writing error to Log
//	    e.printStackTrace();
//	}
//	/*
//	 * Execute the HTTP Request
//	 */
//	try {
//	    HttpResponse response = httpClient.execute(httpPost);
//	    HttpEntity respEntity = response.getEntity();
//	    System.out.println(response.getStatusLine().getStatusCode());
//	    if (response.getStatusLine().getStatusCode() == 200)
//		status = true;
//	    if (respEntity != null) {
//		// EntityUtils to get the response content
//		String content = EntityUtils.toString(respEntity);
//		System.out.println(content);
//
//	    }
//	} catch (ClientProtocolException e) {
//	    // writing exception to log
//	    e.printStackTrace();
//	} catch (IOException e) {
//	    // writing exception to log
//	    e.printStackTrace();
//	}
//	return status;
//    }
}
