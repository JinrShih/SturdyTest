package enumTest;

enum Color
{
    RED(1, "red"){
        @Override
        public String getColor(){
            return "红色";
        }
        @Override
        public int getI(){
            return RED.i;
        }
        @Override
        public String getStr() {
            return RED.str;
        }

    },
    GREEN(2, "green") {
        @Override
        public String getColor() {
            return "绿色";
        }

        @Override
        public int getI() {
            return GREEN.i;
        }

        @Override
        public String getStr() {
            return GREEN.str;
        }
    },
    BLUE(3, "blue") {
        @Override
        public String getColor() {
            return "蓝色";
        }

        @Override
        public int getI() {
            return BLUE.i;
        }

        @Override
        public String getStr() {
            return BLUE.str;
        }
    };
    private int i;
    private String str;

    private Color(int i, String str){
        this.i=i;
        this.str=str;
    }
    public abstract String getColor();
    public abstract int getI();
    public abstract String getStr();
}

public class EnumTest{
    // 执行输出结果
    public static void main(String[] args)
    {
        System.out.println("用Color c1 = Color.BLUE;构造c1:");
        Color c1 = Color.BLUE;
        System.out.println("c1:"+c1);
        System.out.println("c1的位置:"+c1.ordinal()+"，c1的中文："+c1.getColor());

        System.out.println("不转换成数组遍历Color枚举常量：");
        for (Color t:Color.values()){
            System.out.println(t+":"+t.ordinal());
        }

        System.out.println("转换成数组遍历Color枚举常量：");
        Color[] arr = Color.values();
        for (Color t:arr){
            System.out.println(t.toString()+":"+t.ordinal());
        }
        System.out.println("用Color.valueOf(\"RED\")赋值给c1：");
        c1 = Color.valueOf("RED");
        System.out.println("c1:"+c1);
        System.out.println("c1的位置:"+c1.ordinal()+"，c1的中文："+c1.getColor());

        System.out.println();

        System.out.println("输出枚举类型的附带属性");
        for (Color t : Color.values()){
            System.out.println(t+":"+t.ordinal()+","+t.getI()+","+t.getStr()+","+t.getColor());
        }
    }
}
