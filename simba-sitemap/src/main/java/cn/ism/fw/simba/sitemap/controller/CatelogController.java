package cn.ism.fw.simba.sitemap.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.validation.groups.Default;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.ism.fw.simba.base.ResultVO;
import cn.ism.fw.simba.jsr.validation.VCreate;
import cn.ism.fw.simba.jsr.validation.groups.CreateGroup;
import cn.ism.fw.simba.sitemap.CatelogVO;
import cn.ism.fw.simba.sitemap.service.ICatelogService;

@RestController
@RequestMapping("/api/sitemap")
public class CatelogController {

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
  public ResultVO findTreeList() {
    return ResultVO.SUCCESS(catelogService.findTreeList());
  } 
}
