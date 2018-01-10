package cn.ism.fw.simba.base.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import cn.ism.fw.simba.base.PageVO;
import cn.ism.fw.simba.base.PagedResult;
import cn.ism.fw.simba.base.dao.IBaseDao;
import cn.ism.fw.simba.base.dao.mybatis.BaseDao;
import cn.ism.fw.simba.jsr.validation.VCreate;
import cn.ism.fw.simba.jsr.validation.VUpdate;

public abstract class BaseService<T, K> implements IBaseService<T, K> {

  @Inject
  private BaseDao<T, K> baseDao;

  public IBaseDao<T, K> getDao() {
    return baseDao;
  }

  @PostMapping
  @Override
  public T create(@RequestBody @VCreate T t) {
    return getDao().create(t);
  }

  @DeleteMapping("/{id}")
  @Override
  public int delete(@PathVariable("id") K k) {
    return getDao().delete(k);
  }

  @PutMapping
  @Override
  public T update(@RequestBody @VUpdate T t) {
    return getDao().update(t);
  }

  @PostMapping("/save")
  @Override
  public T save(@RequestBody T t) {
    return getDao().save(t);
  }

  @GetMapping("/{id}")
  @Override
  public T getOne(@PathVariable(name = "id", required = true) K k) {
    return getDao().getOne(k);
  }

  @GetMapping("")
  @Override
  public PagedResult<T> getPageData(PageVO page, T condition) {
    return getDao().getPageData(page, condition);
  }

  @Override
  public List<T> getAll(T condition) {
    return getDao().getAll(condition);
  }

}
