package cn.ism.fw.simba.base.dao.mybatis;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import org.apache.ibatis.jdbc.SQL;

import cn.ism.fw.simba.base.PageVO;
import cn.ism.fw.simba.base.PagedResult;
import cn.ism.fw.simba.base.dao.IBaseDao;
import cn.ism.fw.simba.orm.mybatis.util.SqlHelper;
import cn.ism.fw.simba.util.GenricUtil;

public abstract class BaseDao<T, K> implements IBaseDao<T, K> {

  private Class<?> entityClass;
  private Table $table;
  private List<Column> columns;

  public BaseDao() {
    $table = getEntityClass().getDeclaredAnnotation(Table.class);
    if ($table == null) {
      $table = new Table() {
        @Override
        public Class<? extends Annotation> annotationType() {
          return Table.class;
        }

        @Override
        public UniqueConstraint[] uniqueConstraints() {
          return null;
        }

        @Override
        public String schema() {
          return null;
        }

        @Override
        public String name() {
          return entityClass.getName();
        }

        @Override
        public String catalog() {
          return null;
        }
      };
    }


    Field[] declaredFields = getEntityClass().getDeclaredFields();
    List<Column> columns = new ArrayList<>(declaredFields.length);
    for (Field field : declaredFields) {
      if (field.isAnnotationPresent(Transient.class))
        continue;
      Column column = field.getDeclaredAnnotation(Column.class);
      if (column == null) {
        column = new Column() {
          @Override
          public Class<? extends Annotation> annotationType() {
            return Column.class;
          }

          @Override
          public boolean updatable() {
            return false;
          }

          @Override
          public boolean unique() {
            return false;
          }

          @Override
          public String table() {
            return null;
          }

          @Override
          public int scale() {
            return 0;
          }

          @Override
          public int precision() {
            return 0;
          }

          @Override
          public boolean nullable() {
            return false;
          }

          @Override
          public String name() {
            return field.getName();
          }

          @Override
          public int length() {
            return 0;
          }

          @Override
          public boolean insertable() {
            return false;
          }

          @Override
          public String columnDefinition() {
            return null;
          }
        };
      }
      columns.add(column);
    }
    this.columns = columns;
  }

  private String getFullColumnString() {
    StringBuilder sb = new StringBuilder();
    if (columns.size() > 0) {
      sb.append(columns.get(0).name());
      for (int i = 1; i < columns.size(); i++) {
        sb.append(", ").append(columns.get(0).name());
      }
    }
    return sb.toString();
  }

  protected Class<?> getEntityClass() {
    return entityClass == null ? entityClass = GenricUtil.getGenricClass(getClass(), 0) : entityClass;
  }

  @Override
  public T create(T t) {
    String sql = new SQL() {
      {
        INSERT_INTO($table.name());
        for (int i = 0; i < columns.size(); i++) {
          String columnName = columns.get(i).name();
          VALUES(columnName, String.format("#{%s,jdbcType=%s}", columnName, "VARCHAR"));
        }
      }
    }.toString();
    if (SqlHelper.insert(sql) != 1) {
      throw new RuntimeException("Insert data ");
    }
    return t;
  }

  @Override
  public int delete(K k) {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public T update(T t) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public T save(T t) {
    // TODO Auto-generated method stub
    return null;
  }

  @SuppressWarnings("unchecked")
  @Override
  public T getOne(K k) {
    String sql = new SQL() {
      {
        SELECT(getFullColumnString());
        FROM($table.name());
        WHERE("id = #{id}");
      }
    }.toString();
    return (T) SqlHelper.selectOne(sql, entityClass); 
  }

  @Override
  public PagedResult<T> getPageData(PageVO page, T condition) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<T> getAll(T condition) {
    // TODO Auto-generated method stub
    return null;
  }

}
