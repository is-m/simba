package cn.ism.fw.simba.base.service.impl;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 动态服务API元数据服务
 * @since 2018年2月10日
 * @author Administrator
 */
@RestController
@RequestMapping("/api/meta")
public class DynamicRestApiMetaService {
  
  /**
   * 获取API描述列表
   * API基本信息
   * @return
   * @since 2018年2月10日
   * @author Administrator
   */
  public List<?> getApiDescriptions(){
    return null;
  }
  
  /**
   * 获取API详情
   * 包含API详细描述，请求地址，输入参数，输出参数，状态码，
   * @return
   * @since 2018年2月10日
   * @author Administrator
   */
  public Object getApiDetail(){
    return null;
  }
}
