package lombok;

//import lombok.extern.log4j.Log4j;
//import lombok.extern.slf4j.Slf4j;
//import org.slf4j.LoggerFactory;
//import java.util.logging.Logger;

//@Slf4j
//@Log4j
public class LombokTest {

    //private static  Logger logger = (Logger) LoggerFactory.getLogger(LombokTest.class);
    public static void main(String []args){
        System.out.println("//调用@Data生成的构造方法创建对象");
        A a = new A(1);
        System.out.println("//调用@Data生成的setName方法,设置a对象的name值");
        a.setName("yjr");
        System.out.println("//调用@Data生成的toString方法,并打印出a");
        System.out.println(a.toString());
        System.out.println("//调用@AllArgsConstructor生成的构造方法，创建对象");
        A a1 = new A(2,"psh");
        System.out.println("//用@Data生成的get方法，获取a1的属性，然后打印出来");
        System.out.println("A["+"id="+a1.getId()+","+"name="+a1.getName()+"]");
        System.out.println("比较a和a1是否相等");
        System.out.println(a.equals(a1));
        System.out.println("打印出a和a1的hash值");
        System.out.println("a的hash值："+a.hashCode()+","+"a1的hash值："+a1.hashCode());

        A a2 = new A(1,"yjr");
        System.out.println("a2的hash值："+a2.hashCode());
        System.out.println(a.canEqual(a1));

        System.out.println("通过@Builder生成的 流式set法，设置a对象的值");
        System.out.println("Code: a = A.builder().id(3).name(\"YJR\").build();");
        a = A.builder().id(3).name("YJR").build();
        System.out.println("输出a的值：");
        System.out.println(a.toString());

        System.out.println();

        System.out.println("用@Slf4j生成的log，打印出日志");
    }
}

@Builder
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
@AllArgsConstructor
@Data
class A{
    @Getter
    @Setter
    final int id;
    @Getter
    @Setter
    String name;
}
