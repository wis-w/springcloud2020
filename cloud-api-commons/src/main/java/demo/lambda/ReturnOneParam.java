package demo.lambda;

/**
 * @author wyg_edu
 * @version 1.0
 * @date 2020/4/7 19:40
 */
/**一个参数有返回值*/
@FunctionalInterface
public interface ReturnOneParam {
    int method(int a);
}