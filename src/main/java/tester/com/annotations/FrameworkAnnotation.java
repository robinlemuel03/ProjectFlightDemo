package Robin.com.annotations;

import Robin.com.enums.AuthorType;
import Robin.com.enums.CategoryType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//This is an Custom Annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface FrameworkAnnotation {

    // This is not a method
    public AuthorType[] author();

    // public String[] category();
    public CategoryType[] category();


}
