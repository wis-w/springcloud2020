package demo.lambda;

/**
 * @author wyg_edu
 * @version 1.0
 * @date 2020/4/7 19:40
 */
/**多个参数有返回值*/
@FunctionalInterface
public interface ReturnMultiParam {
    int method(int a, int b);
}
