package com.jesse.training.spring.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.domain.Persistable;

@MappedSuperclass
@Getter
public abstract class AbstractPersistable<PK extends Serializable> implements Persistable<PK> {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private PK      id;

  @JsonIgnore
  public boolean isNew() { return null == getId(); }

  @Override
  public String toString() {
    return String.format("Entity of type %s with id: %s", this.getClass().getName(), getId());
  }

  @Override
  public boolean equals(Object obj) {
    if (null == obj) {
      return false;
    }

    if (!getClass().equals(obj.getClass())) {
      return false;
    }

    if (this == obj) {
      return true;
    }

    AbstractPersistable<?> that = (AbstractPersistable<?>) obj;
    return null != this.getId() && this.getId().equals(that.getId());
  }

  @Override
  public int hashCode() {
    int hashCode = 17;
    hashCode += null == getId() ? 0 : getId().hashCode() * 31;
    return hashCode;
  }
}
