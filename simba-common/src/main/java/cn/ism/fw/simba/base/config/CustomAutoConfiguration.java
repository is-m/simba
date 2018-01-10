package cn.ism.fw.simba.base.config;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.mapper.ClassPathMapperScanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.boot.autoconfigure.AutoConfigurationPackages;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.util.StringUtils;

import cn.ism.fw.simba.base.dao.mybatis.CustomClassPathBeanDefinitionScanner;

@Configuration
public class CustomAutoConfiguration {

  private static final Logger LOG = LoggerFactory.getLogger(CustomAutoConfiguration.class);


  public static class AutoConfiguredDaoScannerRegistrar implements BeanFactoryAware, ImportBeanDefinitionRegistrar, ResourceLoaderAware {


    private BeanFactory beanFactory;

    private ResourceLoader resourceLoader;
    
    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
      this.resourceLoader = resourceLoader; 
    }

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
      LOG.debug("Searching for mappers annotated with @Mapper");

      CustomClassPathBeanDefinitionScanner scanner = new CustomClassPathBeanDefinitionScanner(registry);

      try {
        if (this.resourceLoader != null) {
          scanner.setResourceLoader(this.resourceLoader);
        }

        List<String> packages = AutoConfigurationPackages.get(this.beanFactory);
        if (LOG.isDebugEnabled()) {
          for (String pkg : packages) {
            LOG.debug("Using auto-configuration base package '{}'", pkg);
          }
        }

        scanner.setAnnotationClass(Mapper.class);
        scanner.registerFilters();
        scanner.doScan(StringUtils.toStringArray(packages));
      } catch (IllegalStateException ex) {
        LOG.debug("Could not determine auto-configuration package, automatic mapper scanning disabled.", ex);
      }
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
      this.beanFactory = beanFactory;
    }

  }
}
