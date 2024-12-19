package learn.utils;

import org.apache.commons.beanutils.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class FormUtil {

    @SuppressWarnings("unchecked")
    public static <T> T toModel(Class<T> tClass, HttpServletRequest request) throws IOException, InstantiationException, IllegalAccessException, InvocationTargetException {
        T object = null;
        object = tClass.newInstance();
        BeanUtils.populate(object, request.getParameterMap());
        return object;
    }
}
