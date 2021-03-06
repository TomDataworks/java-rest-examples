package io.github.arven.flare.utils;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import javax.enterprise.inject.spi.Annotated;
import javax.inject.Qualifier;

/**
 *
 * @author brian.becker
 */
public class FlareUtils {
    
    public static String emptyNull(String unitName) {
        if(unitName.equals("")) {
            return null;
        } else {
            return unitName;
        }
    }  
    
    public static Class<?> getType(Type type) {
        if (type instanceof Class) {
            return (Class<?>) type;
        } else if (type instanceof ParameterizedType) {
            return getType(((ParameterizedType) type).getRawType());
        } else {
            throw new RuntimeException("Could not determine type of object");
        }
    }
    
    public static Annotation[] getQualifiers(Annotated ann) {
        return FlareUtils.getQualifiers(ann.getAnnotations().toArray(new Annotation[0]));
    }
    
    public static Annotation[] getQualifiers(Annotation[] anns) {
        List<Annotation> quals = new LinkedList<Annotation>();
        for(Annotation a : anns) {
            if(a.annotationType().isAnnotationPresent(Qualifier.class)) {
                quals.add(a);
            }
        }
        return quals.toArray(new Annotation[0]);
    }
        
}
