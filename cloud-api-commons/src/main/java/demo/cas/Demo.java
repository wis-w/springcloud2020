package demo.cas;

/**
 * @author wyg_edu
 * @version 1.0
 * @date 2020/4/13 8:33
 */
public class Demo {
    public static void main(String[] args) {
        System.out.println((new Data()) == (new Data()));
    }
}
class Data {
    Data data;

    public Data() {
        addData();
    }

    public void addData(){
        if (null == data){
            data = new Data();
        }
    }

}
