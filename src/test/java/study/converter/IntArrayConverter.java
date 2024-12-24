package study.converter;

import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;

public class IntArrayConverter extends SimpleArgumentConverter {

    @Override
    protected int[] convert(Object source, Class<?> targetType) throws ArgumentConversionException {
        if (source instanceof String && int[].class.isAssignableFrom(targetType)) {
            String[] strArr = ((String) source).split(", ");
            int[] intArr = new int[strArr.length];
            for (int i = 0; i < strArr.length; i++) {
                intArr[i] = Integer.parseInt(strArr[i]);
            }
            return intArr;
        } else {
            throw new IllegalArgumentException("Conversion from " + source.getClass() + " to "
                + targetType + " not supported.");
        }
    }

}
