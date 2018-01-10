package cn.ism.fw.simba.fileupload;

import java.io.InputStream;

/**
 * 文件上传处理接口
 * @since 2017年12月7日
 * @author Administrator
 */
public interface FileUploadHandler {

  /**
   * 设置配置
   * @param config
   * @since 2017年12月7日
   * @author Administrator
   */
  public void configure(FileUploadConfig config);
  
  /**
   * 处理流
   * @param is
   * @since 2017年12月7日
   * @author Administrator
   */
  public void process(InputStream is);
  
}
