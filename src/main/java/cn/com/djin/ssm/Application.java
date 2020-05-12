package cn.com.djin.ssm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 *   springboot项目的启动类
 */
@SpringBootApplication(scanBasePackages = "cn.com.djin.ssm.*")
@MapperScan("cn.com.djin.ssm.mapper")  //扫描找到Mapper代理对象所在的包路径
@ServletComponentScan(basePackages = "cn.com.djin.ssm.filter")
public class Application {

    //程序主入口
    public static void main(String[] args) throws Exception {
        //设置开发者模式（热部署）不启动，关闭
    //    System.setProperty("spring.devtools.restart.enabled", "false");
        //启动运行springboot项目的方法
        SpringApplication.run(Application.class, args);
    }
}
