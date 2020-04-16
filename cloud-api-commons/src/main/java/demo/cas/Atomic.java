package demo.cas;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author wyg_edu
 * @version 1.0
 * @date 2020/4/16 8:34
 */
public class Atomic {
    public static void main(String[] args) {
        User u1 = new User("zhang", 1);
        User u2 = new User("li", 2);
        AtomicReference<User> user = new AtomicReference<>();
        user.set(u1);
        System.out.println(user.compareAndSet(u1, u2));
        System.out.println(user.compareAndSet(u1, u2) + "/t" + user.get().toString());
    }
}
@Data
@AllArgsConstructor
class User{
    String name;
    int age;
}
