package com.turing.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@MapperScan(basePackages = "com.turing.mapper") //扫描mapper接口
@EnableTransactionManagement //Spring中必须加；SpringBoot可以省略
@ImportResource("classpath:spring-transaction.xml") //导入其它的spring配置文件
public class SpringConfig {
    /**
     * 配置Druid数据源
     * 只要在容器中，覆盖了原理的数据源，就会用最新的
     * @return
     */
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource(){
        DataSource ds = new DruidDataSource();
        return ds;
    }

    /**
     * 注册过滤器，用于监听获取应用的数据 ---用于收集数据
     * 进入控制台页面：http://localhost/druid
     * @return
     */
    @Bean
    public ServletRegistrationBean statViewServlet(){
        //创建StatViewServlet，绑定到/druid/路径下,开启后，访问：localhost/druid就可以看到管理后台
        ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(),"/druid/*");
        //设置初始化参数
        Map<String,String> param = new HashMap<>();
        param.put("loginUsername","admin");
        param.put("loginPassword","123456");
        param.put("allow","");//哪些IP允许访问后台，""代表所有地址
        param.put("deny","192.168.91.20");//不允许这个ip访问
        bean.setInitParameters(param);
        return bean;
    }

    /**
     * 拦截器
     * @return
     */
    @Bean
    public FilterRegistrationBean webStatFilter(){
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new WebStatFilter());//设置过滤器
        bean.addUrlPatterns("/*");//拦截所有请求
        Map<String,String> param = new HashMap<>();
        //排除不需要拦截的资源
        param.put("exclusions","*.js,*.css,*.png,*.woff,/druid/*");
        bean.setInitParameters(param);
        return bean;
    }

}
