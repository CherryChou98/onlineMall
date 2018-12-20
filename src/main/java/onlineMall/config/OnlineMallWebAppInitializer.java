package onlineMall.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;

/**
 * @ Package: config
 * @ Author     ：linsola
 * @ Date       ：Created in 17:51 2018/12/14
 * @ Description：
 * @ Modified By：
 * @ Version:
 */
public class OnlineMallWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] { RootConfig.class };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] { WebConfig.class };
    }

    /**
     * 配置文件上传
     */
    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        String location = "F:/Java Project/workspace/onlineMall/src/main/webapp/static/image";
        long maxFileSize = 50*1024*1024;
        long maxRequestSize = 100*1024*1024;
        int fileSizeThreshold = 0;
        MultipartConfigElement multipartConfigElement = new MultipartConfigElement(location,maxFileSize,maxRequestSize,fileSizeThreshold);
        registration.setMultipartConfig(multipartConfigElement);
    }
}
