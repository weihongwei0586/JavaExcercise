import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Test {
    /**
    *
    * 输入一个字符串，输出该字符串中字符的所有组合。
    * 如：abc 输出：a/b/c/ab/ac/bc/abc
    * */
    public static void main(String[] args) {
        char c1 = '2';
        String s1 = "abcd";
        String s2 = "abc";

        String s = new String(String.valueOf(c1));
        System.out.println(s1.compareTo(s2));
        System.out.println(Integer.valueOf(s1).compareTo(Integer.valueOf(s2)));
        AtomicInteger atomicInteger = new AtomicInteger();
        System.out.println(atomicInteger.get());
        System.out.println("Hello,Github");
        System.out.println("hell");
        System.out.println("Hello,hotfix");
        System.out.println("Hello,Master");
        System.out.println("Hello,hotfix2222");
        System.out.println("Push Test");
         System.out.println("Pull Test");
    }

    }


