package repository.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) 
@Target(ElementType.TYPE)  // type phụ thuộc vào vị trí của entity( vì @Entity đặt trước annotation/class/interface nên nó kiểu type) 
public @interface Entity {

}
