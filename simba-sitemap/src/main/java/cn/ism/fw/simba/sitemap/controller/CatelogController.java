package cn.ism.fw.simba.sitemap.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import cn.ism.fw.simba.base.ResultVO;
import cn.ism.fw.simba.jsr.validation.VCreate;
import cn.ism.fw.simba.sitemap.CatelogVO;
import cn.ism.fw.simba.sitemap.service.ICatelogService;

@RestController
@RequestMapping("/api/sitemap")
public class CatelogController {

  private static final Logger LOG = LoggerFactory.getLogger(CatelogController.class);
  
  @Inject
  private ICatelogService catelogService;

  private ResultVO fieldErrors(BindingResult bindingResult) {
    Map<String, List<String>> errorMap = new HashMap<>();
    for (FieldError err : bindingResult.getFieldErrors()) {
      String field = err.getField();
      List<String> fieldErrors = null;
      if (!errorMap.containsKey(err)) {
        fieldErrors = new ArrayList<>();
        errorMap.put(field, fieldErrors);
      } else {
        fieldErrors = errorMap.get(field);
      }

      fieldErrors.add(err.getDefaultMessage());

    }
    return ResultVO.ERROR_PARAMS(errorMap);
  }

  @PostMapping
  public ResultVO create(@RequestBody @VCreate CatelogVO catelogVO, BindingResult bindingResult) {
    return bindingResult.hasErrors() ? fieldErrors(bindingResult) : ResultVO.SUCCESS(catelogService.createObj(catelogVO));
  }

  @GetMapping
  public ResultVO findList() {
    return ResultVO.SUCCESS(catelogService.findList());
  }

  @GetMapping("/s/tree")
  public ResultVO findTreeList(CatelogVO catelogVO) {
    return ResultVO.SUCCESS(catelogService.findTreeList(catelogVO));
  }

  @GetMapping("/{id}")
  public ResultVO findTreeList(@PathVariable("id") String id) {
    return ResultVO.SUCCESS(catelogService.findById(id));
  }

  /**
   * 导入数据
   * 
   * @since 2017年12月7日
   * @author Administrator
   * @throws IOException 
   * @throws IllegalStateException 
   */
  @PostMapping("/import")
  public ResultVO importDat(HttpServletRequest request) throws IllegalStateException, IOException {
    CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getServletContext());
    
    String fileDir = "E:/springUpload/";
    Path dirPath = Paths.get(fileDir);
    if(!Files.exists(dirPath) || !Files.isDirectory(dirPath)) {      
      Files.createDirectory(dirPath);
    }
    
    if(multipartResolver.isMultipart(request)) {
      LOG.info("form type is 'multipart/form-data'");
      MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
      Iterator iter = multipartRequest.getFileNames();

      while (iter.hasNext()) {
        // 一次遍历所有文件
        MultipartFile file = multipartRequest.getFile(iter.next().toString());
        if (file != null) {
          String path = fileDir + file.getOriginalFilename();
          // 上传
          file.transferTo(new File(path));
        } 
      }
    }else {
      LOG.info("form type is not 'multipart/form-data'");
      /*Files.new*/
    }  
    return ResultVO.SUCCESS();
  }
}
