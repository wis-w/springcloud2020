package demo.lambda;

/**
 * @author wyg_edu
 * @version 1.0
 * @date 2020/4/7 19:39
 */
/**一个参数无返回*/
@FunctionalInterface
public interface NoReturnOneParam {
    void method(int a);
}