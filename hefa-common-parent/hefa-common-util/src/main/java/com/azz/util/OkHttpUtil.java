package com.azz.util;

import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

import org.apache.commons.collections.MapUtils;

import com.alibaba.fastjson.JSON;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by hao.wang on 2016/7/18 0018.
 */
@Slf4j
@UtilityClass
public class OkHttpUtil {

    public final static int CONNECT_TIMEOUT = 60;
    public final static int READ_TIMEOUT = 100;
    public final static int WRITE_TIMEOUT = 60;


    private static OkHttpClient client = new OkHttpClient.Builder()
            // 设置读取超时时间
            .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
            // 设置写的超时时间
            .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
            // 设置连接超时时间
            .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS).build();
    public static final MediaType MEDIA_TYPE_JSON =
            MediaType.parse("application/json; charset=utf-8");

    public static String get(String url) {
        Request request = new Request.Builder().url(url).build();
        String result = "";
        try {
            //log.info("发送GET请求的URL:" + url);
            Response response = client.newCall(request).execute();
            result = response.body().string();
            //log.info("GET请求返回值:" + result);

        } catch (Exception e) {
            log.error("发送GET请求异常", e);
        }
        return result;
    }

    /**
     * 以Content-Type = application/json，请求参数最终以JSONString的形式放在requestBody中的POST请求
     *
     * @param url 发送的URL
     * @param json 发送的参数，JSONString 形式,数据在payload中
     * @return 响应的的字符串
     */
    public static String post(String url, String json) {
        RequestBody body = RequestBody.create(MEDIA_TYPE_JSON, json);
        Request request = new Request.Builder().url(url).post(body).build();
        String result = "";
        try {
            log.debug("POST请求URL：{}", request.url());
            log.debug("POST请求参数：{}", json);
            Response response = client.newCall(request).execute();
            result = response.body().string();
        } catch (IOException e) {
            log.error("发送POST请求异常", e);
        }
        log.debug("payload发送post请求结果:" + result);
        return result;
    }
    
    /**
     * 模拟表单提交发送post请求，参数无顺序
     *
     * @param url 发送的URL
     * @param params 发送表单的key-value，数据在requestbody formData中
     * @return 返回的数据，字符串格式
     * @author 王好(17720589316)
     * @since 2016-9-23 11:56:47
     */
    public static String postFormData(String url, Map<String, String> params) {
        // 构造表单对象
        log.debug("post请求URL[{}],请求参数:{}", url, JSON.toJSONString(params));
        FormBody.Builder formBodyBuilder = new FormBody.Builder();
        if (CollectionUtils.isNotEmpty(params)) {
            for (Entry<String, String> entry : params.entrySet()) {
                formBodyBuilder.add(entry.getKey(), entry.getValue());
            }
        }
        FormBody formBody = formBodyBuilder.build();

        // 构造request对象
        Request request = new Request.Builder().url(url).post(formBody).build();
        String result = "";
        try {
            Response response = client.newCall(request).execute();
            result = response.body().string();
        } catch (IOException e) {
            log.error("发送POST请求异常", e);
        }
        log.debug("formData发送POST请求结果:" + result);
        return result;
    }
    
    /**
     * 
     * <p>模拟表单提交发送post请求，参数无顺序，包含header</p>
     * @param url 发送的URL
     * @param params 发送表单的key-value，数据在requestbody formData中
     * @param headersMap header的内容
     * @return
     * @author 黄智聪（13510946256）  2018年8月29日 上午11:02:41
     */
    public static String postFormDataWithHeader(String url, Map<String, String> params, Map<String, String> headersMap) {
        // 构造表单对象
        log.debug("post请求URL[{}],请求参数:{}", url, JSON.toJSONString(params));
        FormBody.Builder formBodyBuilder = new FormBody.Builder();
        if (CollectionUtils.isNotEmpty(params)) {
            for (Entry<String, String> entry : params.entrySet()) {
                formBodyBuilder.add(entry.getKey(), entry.getValue());
            }
        }
        FormBody formBody = formBodyBuilder.build();
        Headers headers = Headers.of(headersMap);
        
        // 构造request对象
        Request request = new Request.Builder().url(url).post(formBody).headers(headers).build();
        String result = "";
        try {
            Response response = client.newCall(request).execute();
            result = response.body().string();
        } catch (IOException e) {
            log.error("发送POST请求异常", e);
        }
        log.debug("formData发送POST请求结果:" + result);
        return result;
    }


    public static String generateURL(String scheme, String host, String PathSegments,
            Map<String, String> queryParameter) {
        HttpUrl.Builder builder = new HttpUrl.Builder()
                // http
                .scheme(scheme)
                // api.map.baidu.com
                .host(host)
                // geocoder/v2/
                .addPathSegments(PathSegments);
        if (MapUtils.isNotEmpty(queryParameter)) {
            for (Map.Entry<String, String> entry : queryParameter.entrySet()) {
                builder.addQueryParameter(entry.getKey(), entry.getValue());
            }
        }
        return builder.build().toString();
    }

    /**
     * URL拼接，用于get请求(参数顺序无要求)
     *
     * @param baseURI
     * @param queryParameter
     * @return
     */
    public static String generateURL(String baseURI, Map<String, String> queryParameter) {
        HttpUrl httpUrl = HttpUrl.parse(baseURI);
        HttpUrl.Builder builder = httpUrl.newBuilder();
        if (MapUtils.isNotEmpty(queryParameter)) {
            for (Map.Entry<String, String> entry : queryParameter.entrySet()) {
                builder.addQueryParameter(entry.getKey(), entry.getValue());
            }
        }

        return builder.build().toString();
    }
}
