/**
 * test.java com.yingjun.ssm.util
 * 
 * Function： TODO
 * 
 * ver date author ────────────────────────────────── ver1.1 2017年7月11日 torreswang
 * 
 * Copyright (c) 2017, EJie All Rights Reserved.
 */

package com.ejie.nbrs.util;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.SSLContext;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpStatus;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.AuthCache;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.LayeredConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.BasicAuthCache;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


/**
 * ClassName:HttpsGET https的GET方式调用别人的接口,其实也可以用于http协议
 * 
 * @author torreswang
 * @version
 * @since Ver 1.1
 * @Date 2017年7月11日 下午2:34:33
 * @see
 */

@Component
public class HttpsGet {
  private final Logger LOG = LoggerFactory.getLogger(this.getClass());
  // IP地址
  @Value("${ejie.interface.ip}")
  String ip;
  // 如果给的链接没有端口号，则默认写为-1
  @Value("${ejie.interface.port}")
  int port;
  // 接口调用所使用的协议
  @Value("${ejie.interface.protocol}")
  String protocol;
  @Value("${ejie.interface.username}")
  String username;
  @Value("${ejie.interface.password}")
  String password;

  /**
   * 
   * httpsRequestsGet:(这里用一句话描述这个方法的作用)
   * 
   * @param @param apiUrl
   * @param @return 设定文件
   * @return String DOM对象
   * @throws
   * @since CodingExample　Ver 1.1
   */
  public String httpsRequestsGet(String apiUrl) {

    String responseBody = "";
    // 注册协议并获取链接对象
    CloseableHttpClient httpClient = getHttpClient();

    HttpHost targetHost = new HttpHost(ip, port, protocol);

    // 验证主机名端口号和用户名密码
    CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
    credentialsProvider.setCredentials(
        new AuthScope(targetHost.getHostName(), targetHost.getPort()),
        new UsernamePasswordCredentials(username, password));

    AuthCache authScope = new BasicAuthCache();
    BasicScheme basicScheme = new BasicScheme();

    authScope.put(targetHost, basicScheme);

    HttpClientContext context = HttpClientContext.create();
    context.setCredentialsProvider(credentialsProvider);
    context.setAuthCache(authScope);

    String url = protocol + "://" + ip + ":" + port + apiUrl;

    LOG.info("访问易捷url：" + url);
    // GET方式调用接口
    HttpGet httpGet = new HttpGet(url);

    CloseableHttpResponse response = null;
    try {
      // 链接目标主机，接收目标主机返回的对象
      response = httpClient.execute(targetHost, httpGet, context);
    } catch (IOException e) {
      e.printStackTrace();
    }
    int status = response.getStatusLine().getStatusCode();

    if (status == HttpStatus.SC_OK) {
      HttpEntity entity = response.getEntity();
      try {
        responseBody = EntityUtils.toString(entity);
      } catch (IOException e) {
        e.printStackTrace();
      } finally {
        try {
          // 关闭连接
          response.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }

    return responseBody;
  }

  /**
   * 
   * getHttpClient: 获取链接对象
   * 
   * @param @return
   * @return CloseableHttpClient 链接对象
   * @throws
   * @since CodingExample　Ver 1.1
   */
  private static CloseableHttpClient getHttpClient() {
    RegistryBuilder<ConnectionSocketFactory> registryBuilder =
        RegistryBuilder.<ConnectionSocketFactory>create();
    ConnectionSocketFactory plainSF = new PlainConnectionSocketFactory();
    // 注册http协议，如果不需要http协议就不需要写。
    registryBuilder.register("http", plainSF);

    // 以下是注册https协议,与http不同的是多了证书的校验
    try {
      KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
      TrustStrategy trustStrategy = new TrustStrategy() {
        @Override
        public boolean isTrusted(X509Certificate[] x509Certificates, String s)
            throws CertificateException {
          return true;
        }
      };

      SSLContext sslContext =
          SSLContexts.custom().useTLS().loadTrustMaterial(trustStore, trustStrategy).build();
      // 允许全部的证书，这样访问的时候就不用去校验证书是否可用。
      LayeredConnectionSocketFactory sslsf =
          new SSLConnectionSocketFactory(sslContext,
              SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
      // 注册https协议
      registryBuilder.register("https", sslsf);

    } catch (KeyStoreException e) {
      e.printStackTrace();
    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
    } catch (KeyManagementException e) {
      e.printStackTrace();
    }

    Registry<ConnectionSocketFactory> registry = registryBuilder.build();
    PoolingHttpClientConnectionManager connManager =
        new PoolingHttpClientConnectionManager(registry);

    return HttpClientBuilder.create().setConnectionManager(connManager).build();

  }
}
