package cn.ism.fw.simba.sitemap.controller;

import javax.inject.Inject;

import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.ism.fw.simba.base.ResultVO;
import cn.ism.fw.simba.jsr.validation.groups.CreateGroup;
import cn.ism.fw.simba.sitemap.CatelogVO;
import cn.ism.fw.simba.sitemap.service.ICatelogService;

@RestController
@RequestMapping("/api/sitemap")
public class CatelogController {

  @Inject
  private ICatelogService catelogService;

  @PostMapping
  public ResultVO create(@RequestBody @Validated(CreateGroup.class) CatelogVO catelogVO, BindingResult result) {
    return result.hasErrors() ? ResultVO.ERROR_PARAMS(result) : ResultVO.SUCCESS(catelogService.createObj(catelogVO));
  }
 
  @GetMapping
  public ResultVO findList(){
    return ResultVO.SUCCESS(catelogService.findList());
  }
}
