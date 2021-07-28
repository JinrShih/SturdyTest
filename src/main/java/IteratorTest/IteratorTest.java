package IteratorTest;
// 引入 ArrayList 和 Iterator 类
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class IteratorTest {
    public static void main(String[] args) {

        // 创建集合
        ArrayList<String> collectionsFramework = new ArrayList<String>();
        collectionsFramework.add("Iterator");
        collectionsFramework.add("ListIterator");
        collectionsFramework.add("Collection");
        collectionsFramework.add("Set");
        collectionsFramework.add("HashSet");
        collectionsFramework.add("LinkedHashSet");
        collectionsFramework.add("TreeSet");
        collectionsFramework.add("List");
        collectionsFramework.add("ArrayList");
        collectionsFramework.add("LinkedList");
        collectionsFramework.add("Map");
        collectionsFramework.add("HashMap");
        collectionsFramework.add("LinkedHashMap");
        collectionsFramework.add("TreeMap");

        // 第一次获取迭代器
        Iterator<String> it = collectionsFramework.iterator();

        // 输出集合中的第一个元素
        System.out.println(it.next());
        // 输出集合中的第二个元素
        System.out.println(it.next());
        System.out.println();

        // 输出集合中后面的所有元素
        while(it.hasNext()) {
            System.out.println(it.next());
        }

        System.out.println();

        // 第二次重新获取迭代器
        it=collectionsFramework.iterator();
        // 输出集合中的所有元素
        while(it.hasNext()) {
            System.out.println(it.next());
        }

        System.out.println();

        // 第三次重新获取迭代器
        it=collectionsFramework.iterator();
        //删除集合中有"Map"的元素
        while(it.hasNext()) {
            if(it.next().indexOf("Map")!=-1)
                it.remove();
        }

        // 第四次重新获取迭代器
        it=collectionsFramework.iterator();
        // 输出集合中的删除Map后，剩下的元素
        it.next();
        it.next();
        while(it.hasNext()) {
            System.out.println(it.next());
            it.remove();
        }

        System.out.println();

        // 第五次重新获取迭代器
        it=collectionsFramework.iterator();
        // 输出集合中剩下的元素
        while(it.hasNext()) {
            System.out.println(it.next());
        }

        System.out.println("总结：迭代器遍历完后，不会重新到最开始！！！ 如果想要再遍历，则需要重新获取迭代器（it=集合名.Iterator()）。");
        System.out.println("只有执行 it.next() 后，它才会指向下一个元素。但是执行 it.next() 后，马上执行 it.remove() ，虽然 it 指向下一个，它是删除上一个元素");

    }
}
