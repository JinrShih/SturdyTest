package RegexTest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {
    public static void main(String[] args){
        //编写正则表达式
        String regex = ".*杨锦锐yjrpsh彭诗涵.*";
        //要用正则表达式解析的字符串
        String inputStr = "yjr:杨锦锐yjrpsh彭诗涵 dfjdk psh  ";
        //创建一个编译正则表达式的对象
        Pattern p = Pattern.compile(regex);
        //创建一个Matcher对象，然后用正则表达式对象 p 来实例化 m 对象
        Matcher m = p.matcher(inputStr);

        //生成Matcher对象匹配字符传
        System.out.println(m.matches());
        //直接 字符串对象.matchers(regex) 来匹配字符串
        System.out.println(inputStr.matches(regex));

        System.out.println();

        //重新写正则表达式
        regex = ".yjrpsh.";
        //重新编译正则表达式
        p = Pattern.compile(regex);
        m = p.matcher(inputStr);
        int count=0;
        //find()迭代查找
        while(m.find()){
            count++;
            System.out.println("Match number: "+count);
            //此次匹配到的起点索引值
            System.out.print("start(): "+m.start());
            //此次匹配到的终点索引值
            System.out.println(", end(): "+m.end());
            //匹配到的内容，里面可以指定int类型的参数
            System.out.println(m.group(0));
            System.out.println();
        }

        //重置查询的字符串
        m.reset("lkj 杨锦锐yjrpsh彭诗涵 dfjd");
        count = 0;
        //find()迭代查找
        while(m.find()){
            count++;
            System.out.println("Match number: "+count);
            //此次匹配到的起点索引值
            System.out.print("start(): "+m.start());
            //此次匹配到的终点索引值
            System.out.println(", end(): "+m.end());
            //匹配到的内容，里面可以指定int类型的参数
            System.out.println(m.group(0));
            System.out.println();
        }

        //重新写正则表达式 这个表达式带有括号
        regex = "((\\S+)\\s+(\\S+)\\s+(\\S+))";
        //重写inputStr 字符串
        inputStr = "yjr：杨锦锐 love psh, psh：彭诗涵 love yjr,too.";
        //重新编译正则表达式
        p = Pattern.compile(regex);
        m = p.matcher(inputStr);
        count=0;
        int matchStart = 0;
        int matchEnd = 0;
        //find()迭代查找
        System.out.println("输入字符串："+inputStr+'\n');
        while (m.find()){
            count++;
            System.out.printf("Match 第%d次:\n",count);
            for (int i=0;i<=m.groupCount();i++){
                System.out.printf("group(%d):[%s]",i,m.group(i));

                /*测试有参数的start和end方法，找出某个group的起始终结位置*/
                if(i==1) {
                    System.out.print(" , group(1) start: "+m.start(1)+" ,end: "+m.end(1));
                }
                System.out.println();
            }
            System.out.println();
            System.out.println("group(1) start:"+m.start(1)+" ,end:"+m.end(1));
            System.out.println("group(2) start:"+m.start(2)+" ,end:"+m.end(2));
            System.out.println("group(3) start:"+m.start(3)+" ,end:"+m.end(3));
            System.out.println("group(4) start:"+m.start(4)+" ,end:"+m.end(4));
            System.out.println();

            System.out.println("Match start:"+(matchStart=m.start())+" ,end:"+(matchEnd=m.end()));
            System.out.println(inputStr.substring(matchStart,matchEnd));
            System.out.println();
        }

        //检测matches()和lookingAt()的区别
        //重新写正则表达式 这个表达式带有括号
        regex = "hhh abc";
        System.out.println("正则表达式："+regex);
        //重写inputStr 字符串
        inputStr = "hhh abc";
        System.out.println("输入字符串："+inputStr);
        //重新编译正则表达式
        p = Pattern.compile(regex);
        m = p.matcher(inputStr);
        System.out.println("m.matches():"+m.matches()+'\n'+"m.lookingAt():"+m.lookingAt());

        System.out.println();

        //重写inputStr 字符串
        inputStr = "abc hhh abc";
        System.out.println("输入字符串："+inputStr);
        //修改输入字符串
        m.reset(inputStr);
        System.out.println("m.matches():"+m.matches()+'\n'+"m.lookingAt():"+m.lookingAt());

        System.out.println();

        //重写inputStr 字符串
        inputStr = "hhh abc abc";
        System.out.println("输入字符串："+inputStr);
        //修改输入字符串
        m.reset(inputStr);
        System.out.println("m.matches():"+m.matches()+'\n'+"m.lookingAt():"+m.lookingAt());

        System.out.println();

        //不区分大小写匹配Java
        regex = "[J,j][A,a][V,v][A,a]";
        p = Pattern.compile(regex);
        m = p.matcher("java-JavA has regex\r\nJava has regex\r\n" + "JAVA has pretty good regular expressions\r\n"
                + "Regular expressions are in Java");
        while (m.find()){
            System.out.println(m.group());
        }

        System.out.println();

        //对replaceAll方法进行测试
        //将目标字符串里与既有模式相匹配的子串全部替换为指定的字符串，并返回返回新的整个字符串
        regex = "cat";
        p = Pattern.compile(regex);
        m = p.matcher("cat cat cat cat");
        System.out.println("cat cat cat cat");
        System.out.println(m.replaceAll("hat"));

        System.out.println();

        regex = "cat";
        p = Pattern.compile(regex);
        m = p.matcher("cat cat cat cat");
        System.out.println("cat cat cat cat");
        System.out.println(m.replaceFirst("hat"));

        System.out.println();

        /**
            对appendReplacement(StringBuffer sb, String replacement)和appendTail(StringBuffer sb)方法进行测试
         */
        /**
         * appendReplacement将当前匹配子串替换为指定字符串，
         * 并且将上次替换之后的位置 到 这次匹配到的子串替换之后的位置 之间的子串 添加到一个StringBuffer对象里。
         * appendTail将最后一次匹配工作后剩余的字符串添加到一个StringBuffer对象里。
        **/
        regex = "Kelvin";
        p = Pattern.compile(regex);
        m = p.matcher("Kelvin Li and Kelvin Chan are both working in Kelvin Chen's KelvinSoftShop company");
        System.out.println("Kelvin Li and Kelvin Chan are both working in Kelvin Chen's KelvinSoftShop company");
        StringBuffer sb = new StringBuffer();
        int i=0;
        //使用循环将句子里所有的kelvin找出并替换再将内容加到sb里
        while(m.find()) {
            i++;
            m.appendReplacement(sb, "Sakila");
            System.out.println("第"+i+"次匹配后sb的内容是："+sb.toString());
        }
        //最后调用appendTail()方法将最后一次匹配后的剩余字符串加到sb里；
        m.appendTail(sb);
        System.out.println("调用m.appendTail(sb)后sb的最终内容是:"+ sb.toString());
//        sb.append(" ldskfjdkl");
//        System.out.println(sb.toString());
    }
}
