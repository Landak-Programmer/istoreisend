package Q2.entity;

import java.io.Serializable;

public interface IEntity<T extends Serializable> {

    T getId();
}
