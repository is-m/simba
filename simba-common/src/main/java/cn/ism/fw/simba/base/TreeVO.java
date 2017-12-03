package cn.ism.fw.simba.base;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.util.ClassUtils;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ReflectionUtils;

import cn.ism.fw.simba.util.Assert;

public class TreeVO<T> {

  private static final Logger logger = LoggerFactory.getLogger(TreeVO.class);

  private List<TreeNodeVO> nodes;

  public List<TreeNodeVO> getNodes() {
    return nodes;
  }


  public void setNodes(List<TreeNodeVO> nodes) {
    this.nodes = nodes;
  }


  public TreeVO() {}

  public TreeVO(List<TreeVO<T>.TreeNodeVO> nodes) {
    this.nodes = nodes;
  }


  public TreeVO(List<T> data, String idFieldName, String parentIdFieldName, Object rootParentId)
      throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
    Assert.isFalse(CollectionUtils.isEmpty(data), "data is empty");

    Map<Object, TreeNodeVO> nodeMapping = new HashMap<>();

    Class<?> clz = null;
    Field idField = null, parentIdField = null;

    // 构造树节点
    for (T item : data) {

      if (clz == null) {
        clz = item.getClass();
        idField = ReflectionUtils.findField(clz, idFieldName);
        parentIdField = ReflectionUtils.findField(clz, parentIdFieldName);
        
        idField.setAccessible(true);
        parentIdField.setAccessible(true);
      }

      Object idValue = idField.get(item);

      TreeNodeVO nodeVO = new TreeNodeVO(item, null, new ArrayList<>());
      Assert.isFalse(nodeMapping.containsKey(idValue), "data is repeated of id " + idValue);
      nodeMapping.put(idValue, nodeVO);
    }

    nodes = new ArrayList<>();
    for (Map.Entry<Object, TreeNodeVO> treeNode : nodeMapping.entrySet()) {
      TreeNodeVO item = treeNode.getValue();

      Object parentIdValue = parentIdField.get(item.getData());

      // 如果是根节点则加入到根节点
      if (Objects.equals(rootParentId, parentIdValue)) {
        nodes.add(item);
        continue;
      }


      if (!nodeMapping.containsKey(parentIdValue)) {
        logger.warn("missing parent node of id {}", parentIdValue);
      } else {
        TreeVO<T>.TreeNodeVO treeNodeVO = nodeMapping.get(parentIdValue);
        treeNodeVO.children.add(item);
        item.parent = treeNodeVO;
      }
    }
  }

  public class TreeNodeVO {

    private T data;

    private TreeNodeVO parent;

    private List<TreeNodeVO> children;

    public T getData() {
      return data;
    }

    public void setData(T data) {
      this.data = data;
    }

    public TreeNodeVO getParent() {
      return parent;
    }

    public void setParent(TreeNodeVO parent) {
      this.parent = parent;
    }

    public List<TreeNodeVO> getChildren() {
      return children;
    }

    public void setChildren(List<TreeNodeVO> children) {
      this.children = children;
    }

    public TreeNodeVO(T data, TreeVO<T>.TreeNodeVO parent, List<TreeVO<T>.TreeNodeVO> children) {
      this.data = data;
      this.parent = parent;
      this.children = children;
    }
  }
}
