package cn.ism.fw.simba.base.dao.mybatis;

import java.io.IOException;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;
import org.springframework.stereotype.Component;

/**
 * 自定义的注册bean定义
 * @since 2017年12月27日
 * @author Administrator
 */
@Component
public class CustomBeanDefinitionRegistry implements BeanDefinitionRegistryPostProcessor {

  private static final Logger LOG = LoggerFactory.getLogger(CustomBeanDefinitionRegistry.class);

  @Override
  public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
    LOG.info("CustomBeanDefinitionRegistryPostProcessor.postProcessBeanFactory");
  }

  @Override
  public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
    LOG.info("CustomBeanDefinitionRegistryPostProcessor.postProcessBeanDefinitionRegistry");
    // 注册所有没有实现类的Dao接口

    // 获取指定DAO包下的所有接口
    // 是否使用默认的filter，使用默认的filter意味着只扫描那些类上拥有Component、Service、Repository或Controller注解的类
   /* boolean useDefaultFilters = false;
    
    String basePackage = "cn.ism.fw.simba.sitemap.dao";

    
    // ClassPathScanningCandidateComponentProvider 可以根据一定的规则扫描类路径下满足特定条件的Class来作为候选的bean定义
    ClassPathScanningCandidateComponentProvider beanScanner = new ClassPathScanningCandidateComponentProvider(useDefaultFilters);
    
    beanScanner.addIncludeFilter(new TypeFilter() { 
      @Override
      public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
        return metadataReader.getClassMetadata().isConcrete();
      }
    });
    
    Set<BeanDefinition> beanDefinitions = beanScanner.findCandidateComponents(basePackage);
    for (BeanDefinition beanDefinition : beanDefinitions) {
        //beanName通常由对应的BeanNameGenerator来生成，比如Spring自带的AnnotationBeanNameGenerator、DefaultBeanNameGenerator等，也可以自己实现。
        String beanName = beanDefinition.getBeanClassName();
        registry.registerBeanDefinition(beanName, beanDefinition);
    }
*/
  }

}
