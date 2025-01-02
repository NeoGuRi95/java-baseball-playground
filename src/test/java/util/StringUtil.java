package util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringUtil {

    public static List<Integer> arrStrToList(String arrStr) {
        return Arrays.stream(arrStr.replace("[", "").replace("]", "").split(","))
            .mapToInt(c -> Integer.parseInt(c.trim()))
            .boxed()
            .collect(Collectors.toList());
    }

}
