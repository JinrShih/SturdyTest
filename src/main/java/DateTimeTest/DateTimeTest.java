package DateTimeTest;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class DateTimeTest {
    public static void main(String[] args) throws ParseException {
//        long nowTimeMillis = 0;
//        long lastTimeMillis = 0;
//        while(true)
//        {
//            nowTimeMillis=System.currentTimeMillis();
//            if(nowTimeMillis-lastTimeMillis >= 1000) {
//                System.out.println(nowTimeMillis);
//                lastTimeMillis=nowTimeMillis;
//            }
//        }
        //定义一个当前时间的日期对象
        Date dat = new Date();
        //定义一个日期的格式对象
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss E");
        //输出日期对象默认的格式
        System.out.println(dat+" systime："+System.currentTimeMillis()+" ms:"+dat.getTime());
        //输出格式后的日期
        String datStr = df.format(dat);
        System.out.println(datStr);

        System.out.println();

        //定义一个指定时间的日期对象
        Date dat1 = new Date(40000000L);
        //定义一个日期的格式对象
        df = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒 E ");
        String dat1Str = df.format(dat1);
        System.out.println(dat1Str);
        //将日期格式的字符串转换成Date类型的对象
        Date dat2 = df.parse(dat1Str);
        System.out.println(dat2+" sysTime:"+System.currentTimeMillis()+" ms:"+dat1.getTime());

        System.out.println();

        //获取dat的每个属性
        //获取dat的年
        df = new SimpleDateFormat("yyyy年");
        System.out.println(df.format(dat));
        //获取dat的月
        df = new SimpleDateFormat("MM月");
        System.out.println(df.format(dat));
        //获取dat的日
        df = new SimpleDateFormat("dd日");
        System.out.println(df.format(dat));
        //获取dat的时
        df = new SimpleDateFormat("HH时");
        System.out.println(df.format(dat));
        //获取dat的分
        df = new SimpleDateFormat("mm分");
        System.out.println(df.format(dat));
        //获取dat的秒
        df = new SimpleDateFormat("ss秒");
        System.out.println(df.format(dat));
        //获取dat的毫秒
        df = new SimpleDateFormat("SS毫秒");
        System.out.println(df.format(dat));
        //获取dat的星期几
        df = new SimpleDateFormat("E");
        System.out.println(df.format(dat));
        //获取dat的这一年的第几天
        df = new SimpleDateFormat("这一年的第D天");
        System.out.println(df.format(dat));

        System.out.println();

        //Calendar的一些用法
        //创建一个Calendar对象
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.getTime());
        //设置date
        calendar.setTime(dat);
        //获取日期的每个元素
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH)+1;
        int date = calendar.get(Calendar.DAY_OF_MONTH);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int min = calendar.get(Calendar.MINUTE);
        int sed = calendar.get(Calendar.SECOND);
        int ms = calendar.get(Calendar.MILLISECOND);
        int 星期 = calendar.get(Calendar.DAY_OF_WEEK)-1;
        System.out.println(year+"年"+month+"月"+date+"日 "+hour+":"+min+":"+sed+":"+ms+" 星期"+星期+" ms:"+calendar.getTime().getTime());

        //设置date中的每一个元素
        calendar.set(Calendar.YEAR,year);
        calendar.set(Calendar.MONTH,month-1);
        calendar.set(Calendar.DAY_OF_MONTH,date);
        calendar.set(Calendar.HOUR_OF_DAY,hour);
        calendar.set(Calendar.MINUTE,min);
        calendar.set(Calendar.SECOND,sed);
        calendar.set(Calendar.MILLISECOND,ms);

        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH)+1;
        date = calendar.get(Calendar.DAY_OF_MONTH);
        hour = calendar.get(Calendar.HOUR_OF_DAY);
        min = calendar.get(Calendar.MINUTE);
        sed = calendar.get(Calendar.SECOND);
        ms = calendar.get(Calendar.MILLISECOND);
        星期 = calendar.get(Calendar.DAY_OF_WEEK)-1;
        System.out.println(year+"年"+month+"月"+date+"日 "+hour+":"+min+":"+sed+":"+ms+" 星期"+星期+" ms:"+calendar.getTime().getTime());

        //用add方法修改date的元素
        //date的时间加1秒
        calendar.add(Calendar.SECOND,1);

        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH)+1;
        date = calendar.get(Calendar.DAY_OF_MONTH);
        hour = calendar.get(Calendar.HOUR_OF_DAY);
        min = calendar.get(Calendar.MINUTE);
        sed = calendar.get(Calendar.SECOND);
        ms = calendar.get(Calendar.MILLISECOND);
        星期 = calendar.get(Calendar.DAY_OF_WEEK)-1;
        System.out.println(year+"年"+month+"月"+date+"日 "+hour+":"+min+":"+sed+":"+ms+" 星期"+星期+" ms:"+calendar.getTime().getTime());

        //用 Calendar.DAY_OF_WEEK 让date的时间加一天
        calendar.add(Calendar.DAY_OF_WEEK,1);
        df = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss:SSS E");
        String dateStr = df.format(calendar.getTime());
        System.out.println(dateStr+" ms:"+calendar.getTime().getTime());

        //用 Calendar.DAY_OF_MONTH 让date的时间减一天
        calendar.add(Calendar.DAY_OF_MONTH,-1);
        df = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss:SSS E");
        dateStr = df.format(calendar.getTime());
        System.out.println(dateStr+" ms:"+calendar.getTime().getTime());
    }
}
