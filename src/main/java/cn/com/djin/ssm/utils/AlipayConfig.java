package cn.com.djin.ssm.utils;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：  ksfxhw3818@sandbox.com   111111
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2016101800718767";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQChfZOTkj0aI7c8+qr8eBSgn59+q6R4UUjDSHAO/Zeqas1/qo6A1I8ka6FnOSFl760IfHZ0ZvIAJ0BwARtrcVWMyGuZBy26cLMZSvNyBaG+C6hfawZIXdnycdp4xpH5Kh24vgyQG+/nMOoT+Fe1bFk2ThNfWDq3WPxnyT7xL4zya+cfy5vBgmRXMrx13DzpkINsIe5EbILy2wbE2UbX3eFIYBRr5YtOr1d/Q/JKdAywLRoFYlAitzSB46JxAFGlWXlL6oE7IfiHQ9otZG914fV2YFMZw7B/+6XMh5sHQwAke4XGlFiORiLcoULnzHX4l8ib/qlns1r3S+MrgN/c/kArAgMBAAECggEBAJtcvr+4b0RYnA70cc+WjvHA36bz5rVCLiiB5hzl6CWxvqZWJebXmCbHzW4LTpBNN0D0zNlLuQJgwOOAjSqezFk28B03BM1bY1KwAuntdR/rAz9ZLaAtemJ/GlobX5BA7nsvi9KQrgrTyj8QKwGFjYZrMsQFk+eUmrAWspFC1+zYTr1ceZNWvKRezMhBxWF84FWiiybR1oIanRLxq1UKRgX0a5dQ2rzdn1OuqTAu3YrLctaEDLSyTo+tn3Rk0no5n0WV/qJ8VcvhWFhRJafz625dNLlxeKzSm3cFojtC5a0oFpoIgdcSZTIi1UnpF5kaadEnTz35McNfF8abIO/w6FECgYEA1Zijve9lOc/Bgcc5Yg7q+k07UwhZv1g2cRPoyWJz9QE7MtZ+SAs6E2RcAQ57GmH4FDODB32H+wZ0yZhDuDkSESk3P3Xt3AQMiMQ+iPseUXE4PRVrgm8F6is+qhFvvQH3bKzVgWUjzXI5zDTw39xrE7n0lOgryCMUuEqexWuvfBcCgYEAwYzTucx+RYiSxT8r381xC5ElJcgh4Q64scxTtKjA35Wm0d0CK4ECor6j+Emfc38c9HdjuYzZ6cVgvLFRiNpR6J83Jlp6wDSc3Uvodd4YrGIV4BX5LWIHuABrsz+nEQO/jKvtSlxAgBhUakurJCdbSEGa/U8OaoppnaGKEgRrhQ0CgYBqBv8hBXjmHa8c0Nw3RNh3r2bHbNnAFfXQY+WmMe0FrbrJHZhKAuitP6A8FggdrIwM2xUr3rBld2r5t0/GXu4M/ryiD9Qm5wuhyGiSbrU6EE2uZLedY6c3+od8vHMPC67aj2DcfmwrS4xNRepb9XphrGkwkZ9KFb/vS3tM3IubuQKBgD4qt47ECgLXfRzxz2vRFvA6LI5YG9mn2tbw5Cnw0hJ+hNh/fkTu6SPQy+Xh798vAuPavSNKBGw7w3iYE7I7PXfUO+iLw0WdII1L5lyFe7NSxef15tUW2ZfWOsGWPlkOtSW/yzXJL8Z1ChgiOdQg+AbbW6blD6JU1tuUmT50QPy5AoGBAKTJ42SXOhkY5igbhqihuSNVTF4UZ5gZbPP/DXjYJPLhNxfdgkK7O0QrVM6GRGRXqEbEEXq/5MkbfuGS1c4WR4GEkwgr8G+z7ry3cj00V1zHTzijW8DOsPsVUTSpVmjHQIcq1f3PATYFriJ56E0daAsdgf1TIv/XSIjqYSHk3Jyb";

	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAoX2Tk5I9GiO3PPqq/HgUoJ+ffqukeFFIw0hwDv2XqmrNf6qOgNSPJGuhZzkhZe+tCHx2dGbyACdAcAEba3FVjMhrmQctunCzGUrzcgWhvguoX2sGSF3Z8nHaeMaR+SoduL4MkBvv5zDqE/hXtWxZNk4TX1g6t1j8Z8k+8S+M8mvnH8ubwYJkVzK8ddw86ZCDbCHuRGyC8tsGxNlG193hSGAUa+WLTq9Xf0PySnQMsC0aBWJQIrc0geOicQBRpVl5S+qBOyH4h0PaLWRvdeH1dmBTGcOwf/ulzIebB0MAJHuFxpRYjkYi3KFC58x1+JfIm/6pZ7Na90vjK4Df3P5AKwIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://工程公网访问地址/alipay.trade.page.pay-JAVA-UTF-8/notify_url.jsp";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	//支付成功后的地址回调（系统自定发送get请求，并且请求中有我们需要用到的参数订单编号out_trade_no）
    //完成支付成功后项目中的其它操作  修改订单支付状态，添加销售记录数据
    public static String return_url = "http://47.114.80.125/k9511_hotel-1.0-SNAPSHOT/orders/afterOrdersPay";

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	
	// 支付宝网关
	public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

