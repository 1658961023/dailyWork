package date180702pm;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Map的方法
 */
public class TestMap {
    public static void main(String[] args) {
        Map<String , Double> map = new HashMap<>( ) ;
        Double d = map.put("ThinkPadt470p" , 15000.0 ) ;
        System.out.println( d );
       d = map.put("小米游戏笔记本" , 8000.0 ) ;
        System.out.println( d );
        int size = map.size();
        System.out.println(size);
        d = map.put("小米游戏笔记本" , 5000.0 ) ;
        System.out.println( d );
        System.out.println( map.toString() );
        // 根据键 来获取 对应的值
        Double dd = map.get( "小米游戏笔记本" ) ;
        System.out.println( dd );

        // 比较的key 其实 是 按照 key的 equals 方法 进行比较的
        map.containsKey( 123 ) ;
        // 按照 value 的 equals 方法
        map.containsValue( 123123 ) ;

        // 是否是空的
        map.isEmpty() ;

        // 清空集合
//        map.clear();

        //  根据键 删除 元素
      Double ddd  =  map.remove( 123) ;
        System.out.println( ddd );

        System.out.println("--------遍历Map----------");
        Set<Map.Entry<String  , Double > > set = map.entrySet() ;
        for( Map.Entry<String  , Double > e  : set ){
            System.out.println( e.getKey() + " :  " + e.getValue() );
        }
        System.out.println("--------遍历Map----------");
        Set<String> keySet = map.keySet() ;
        for( String s  : keySet ){
            System.out.println( s + " : " + map.get( s  ));
        }
        System.out.println("--------遍历Map----------");
        Collection<Double> c = map.values() ; 
        for( Double dddd : c ){
            System.out.println( dddd );
        }
    }
}
