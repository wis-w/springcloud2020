package demo.lambda;

/**
 * @author wyg_edu
 * @version 1.0
 * @date 2020/4/7 19:30
 */
public class MainLambda {

    public void fun(NoReturnMultiParam n1){};
    public void fun(NoReturnOneParam n2){};

    public static void main(String[] args) {
        NoReturnMultiParam noReturnMultiParam = (a,b) -> {};
        new MainLambda().fun((a,b)->{});
    }
}
