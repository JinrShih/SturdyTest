package ListIteratorTest;

import java.util.List;
import java.util.ArrayList;
import java.util.ListIterator;

public class ListIteratorTest {
    public static void main(String []args){
        List<String>  collectionsFramework = new ArrayList<>();
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
        ListIterator<String> it = collectionsFramework.listIterator();

        //按顺序输出全部元素
        System.out.println("用 集合名.listIterator() 获取迭代器，按顺序输出全部元素，it.next()获取当前指向元素，然后指向下一个元素。");
        while(it.hasNext()){
            System.out.println(it.nextIndex()+" *** "+it.previousIndex());
            System.out.println(it.next());
        }

        System.out.println();

        //按逆序输出全部元素
        System.out.println("用it.next()访问完所有元素后，it指向末尾，然后用it.previous()获取前一个元素，然后指向上一个元素。");
        while(it.hasPrevious()){
            System.out.println(it.previous());
        }

        System.out.println();

        //指向列表第二个元素，用listIterator(1);
        System.out.println("用 集合名.ListIterator(n)来创建，一开始指向n位置的迭代器。然后输出n位置的元素");
        it = collectionsFramework.listIterator(1);
        System.out.println("输出第二个元素："+it.next());

        System.out.println();

        //用it.remove()删除后，输出剩下的集合
        System.out.println("用it.remove()，删除带有 ”List“ 的元素后，输出剩下的集合");
        //让 it 迭代器指向开始处
        for(;it.hasPrevious();it.previous());
        //删除集合中有"List"的元素
        while(it.hasNext()) {
            if(it.next().indexOf("List")!=-1)
                it.remove();
        }
        //让 it 迭代器指向开始处
        for(;it.hasPrevious();it.previous());
        //输出剩下的元素
        while(it.hasNext()){
            System.out.println(it.next());
        }

        System.out.println();

        //在列表集合的第二个位置插入 ListIterator 元素，然后输出整个集合
        System.out.println("在列表集合的第二个位置插入 ListIterator 元素，用 it.add(元素) 插入元素，插入的地方是it指向之前，然后输出整个集合");
        //让 it 迭代器指向开始处
        for(;it.hasPrevious();it.previous());
        it.next();//运行后，it指向第一个 *|***,运行 it.next()，是先获取元素，再改变指向
        it.next();//运行后，it指向第二个 **|**
        it.previous();//运行后，it指向第一个 *|***，运行 it.previous(),是先改变指向，再获取元素
        it.add("ListIterator");
        //让 it 迭代器指向开始处
        for(;it.hasPrevious();it.previous());
        //输出剩下的元素
        while(it.hasNext()){
            System.out.println(it.next());
        }

        System.out.println();

        //在列表集合的第二个位置改为 List 元素，然后输出整个集合
        System.out.println("在列表集合的第二个位置改为 List 元素，用 it.set(元素) 更改元素，用it.next()，更改的元素是it指向的前一个位置，");
        System.out.println("而用it.previous(),更改的元素是it指向的位置，然后输出整个集合");
        //让 it 迭代器指向开始处
        for(;it.hasPrevious();it.previous());
        it.next();
        it.next();
        it.previous();
        it.set("List");
        //让 it 迭代器指向开始处
        for(;it.hasPrevious();it.previous());
        //输出剩下的元素
        while(it.hasNext()){
            System.out.println(it.next());
        }

        System.out.println();

        System.out.println("总结：ListIterator和Iterator 一些方法差不多，就是ListIterator多了：\n"+
                "add()、set()、hasPrevious()、previous()、nextIndex()、previousIndex()、listIterator(n)方法，\n" +
                "用add()和set方法时候有点区别，用add()方法时候：添加的位置是用了 it.next()和it.previous() 过后，it指向的位置\n" +
                "用set()方法的时候：更改的元素是用了 it.next()和it.previous()过后，这两个方法的返回元素，而不是it指向的位置！！！");
    }
}
