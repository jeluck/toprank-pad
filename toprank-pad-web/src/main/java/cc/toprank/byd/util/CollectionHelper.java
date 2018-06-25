package cc.toprank.byd.util;
/*********************************************************************************************.
 *
 *
 * <p>版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司</p>
 *
 *
 *********************************************************************************************/




import cc.toprank.byd.common.utils.ObjectUtil;
import cc.toprank.byd.common.utils.number.NumberUtil;
import cc.toprank.byd.vo.TreeNodeVO;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.core.convert.converter.Converter;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.Predicate;

/**
 * 集合工具类
 *
 * @author LinYN
 * @date 2017-4-19
 */
public class CollectionHelper {

    private CollectionHelper(){}

    /**
     * 将集合的元素取出来转换后放到Set中
     *
     * @param collection 集合
     * @param converter 转换器
     * @param <S> 源类型
     * @param <T> 目标类型
     * @exception IllegalArgumentException 如果没有提供转换器则抛此异常
     * @return Set
     *
     * @author LinYN
     * @date 2017-4-19
     */
    public static <S, T> Set<T> collect(Collection<S> collection, Converter<S, T> converter){
        if (collection == null) return null;
        if (converter == null) {
            throw new IllegalArgumentException("Converter is not provide.");
        }
        Set<T> results = new HashSet<>();
        for (S element : collection) {
            T converted = converter.convert(element);
            if (converted == null) continue;
            results.add(converted);
        }
        return results;
    }

    /**
     * 将集合的元素取出来转换后放到List中
     *
     * @param collection 集合
     * @param converter 转换器
     * @param <S> 源类型
     * @param <T> 目标类型
     * @exception IllegalArgumentException 如果没有提供转换器则抛此异常
     * @return List
     *
     * @author LinYN
     * @date 2017-4-19
     */
    public static <S, T> List<T> map(Collection<S> collection, Converter<S, T> converter){
        if (collection == null) return null;
        if (converter == null) {
            throw new IllegalArgumentException("Converter is not provide.");
        }
        List<T> results = new LinkedList<>();
        for (S element : collection) {
            results.add(converter.convert(element));
        }
        return results;
    }

    /**
     * 将List集合的元素分组后放到Map中，Map的元素是List类型
     *
     * @param collection 集合
     * @param converter 转换器
     * @param <S> 元素类型
     * @param <T> 键值类型
     * @exception IllegalArgumentException 如果没有提供转换器则抛此异常
     * @return Map
     *
     * @author LinYN
     * @date 2017-4-19
     */
    public static <S, T> Map<T, List<S>> group(Collection<S> collection, Converter<S, T> converter){
        if (collection == null) return null;
        if (converter == null) {
            throw new IllegalArgumentException("Converter is not provide.");
        }
        Map<T, List<S>> results = new HashMap<>();
        for (S element : collection) {
            T key = converter.convert(element);
            List<S> list = results.get(key);
            if (list == null) {
                list = new LinkedList<S>();
                results.put(key, list);
            }
            list.add(element);
        }
        return results;
    }

    /**
     * 将List集合的元素分组后放到Map中，Map的元素类型是List集合的元素类型, Key是主键值
     *
     * @param collection 集合
     * @param converter 转换器
     * @param <S> 元素类型
     * @param <T> 键值类型
     * @exception IllegalArgumentException 如果没有提供转换器则抛此异常
     * @return Map
     *
     * @author LinYN
     * @date 2017-4-19
     */
    public static <S, T> Map<T,S> asMap(Collection<S> collection, Converter<S, T> converter){
        if (collection == null) return null;
        if (converter == null) {
            throw new IllegalArgumentException("Converter is not provide.");
        }
        Map<T, S> results = new HashMap<>();
        for (S element : collection) {
            T key = converter.convert(element);
            results.put(key, element);
        }
        return results;
    }

    /**
     * 将List集合的元素分组后放到TreeNode中，元素需要重写 equals 和 hashCode方法 ＝
     *
     * @param collection 集合
     * @param accepter 是否子节点
     * @param <T> 值类型
     * @return TreeNodeVO
     *
     * @author LinYN
     * @date 2017-4-19
     */
    public static <T extends TreeNodeVO<T>> List<T> asTree(Collection<T> collection, Predicate<T> accepter){
        if (collection == null) return null;
        Predicate<T> useAccepter = accepter == null ? (key) -> true : accepter;
        List<T> results = new LinkedList<T>();
        for (T element : collection) {
            T copyElement = null;
            try {
                copyElement = (T)element.clone();
            } catch (CloneNotSupportedException e) {
                throw new RuntimeException(e.getMessage(), e);
            }
            T result = findElement(results, copyElement);
            if (result == null) {
                result = copyElement;
                results.add(result);
            }
            if (useAccepter.test(element)){
                List<T> childs = result.getChilds();
                if (CollectionUtils.isEmpty(childs)) {
                    childs = new LinkedList<T>();
                    result.setChilds(childs);
                }
                childs.add(element);
            }
        }
        return results;
    }

    private static <T> T findElement(List<T> list, T indexElement){
        return  find(list, element -> ObjectUtil.equals(element, indexElement));
    }

    /**
     * 查找集合中的元素，返回第一个匹配的元素
     *
     * @param collection
     * @param accepter
     * @param <T>
     * @return
     */
    public static <T> T find(Collection<T> collection, Predicate<T> accepter){
        if (collection == null || collection.isEmpty() || accepter == null) return null;
        for (T element : collection) {
            if (accepter.test(element))
                return element;
        }
        return null;
    }

    /**
     * 过滤集合中的元素
     *
     * @param collection
     * @param accepter
     * @param <T>
     * @return
     */
    public static <T> List<T> filter(Collection<T> collection, Predicate<T> accepter) {
        if (collection == null) return null;
        Predicate<T> useAccepter = accepter == null ? (element) -> true : accepter;
        List<T> results = new LinkedList<T>();
        for (T element : collection) {
            if (useAccepter.test(element))
                results.add(element);
        }
        return results;
    }

    /**
     * 集合中元素某个字段求和
     *
     * @param collection
     * @param accepter
     * @param <T>
     * @return 字段总和， BigDecimal类型
     */
    public static <T> BigDecimal sum(Collection<T> collection, Converter<T, BigDecimal> selector, Predicate<T> accepter) {
        if (CollectionUtils.isEmpty(collection))
            return new BigDecimal(0);
        if (selector == null) {
            throw new IllegalArgumentException("Selector is not provide.");
        }
        Predicate<T> useAccepter = accepter == null ? (element) -> true : accepter;
        BigDecimal sumValue = new BigDecimal(0);
        for (T element : collection) {
            if (useAccepter.test(element))
                sumValue = NumberUtil.add(sumValue, selector.convert(element));
        }
        return sumValue;
    }


    /**
     * 集合中元素某个字段求和
     *
     * @param collection
     * @param <T>
     * @return 字段总和， BigDecimal类型
     */
    public static <T> BigDecimal sum(Collection<T> collection, Converter<T, BigDecimal> selector) {
        return sum(collection, selector, null);
    }

    /**
     * 集合中元素某个字段求和
     *
     * @param collection
     * @param accepter
     * @param <T>
     * @return 字段总和， BigDecimal类型
     */
    public static <T> Integer sumOfInteger(Collection<T> collection, Converter<T, Integer> selector, Predicate<T> accepter) {
        if (CollectionUtils.isEmpty(collection))
            return new Integer(0);
        if (selector == null) {
            throw new IllegalArgumentException("Selector is not provide.");
        }
        Predicate<T> useAccepter = accepter == null ? (element) -> true : accepter;
        Integer sumValue = new Integer(0);
        for (T element : collection) {
            if (useAccepter.test(element))
                sumValue = NumberUtil.add(sumValue, selector.convert(element));
        }
        return sumValue;
    }


    /**
     * 集合中元素某个字段求和
     *
     * @param collection
     * @param <T>
     * @return 字段总和， BigDecimal类型
     */
    public static <T> Integer sumOfInteger(Collection<T> collection, Converter<T, Integer> selector) {
        return sumOfInteger(collection, selector, null);
    }

    /**
     * 集合中元素某个字段求和
     *
     * @param collection
     * @param accepter
     * @param <T>
     * @return 字段总和， BigDecimal类型
     */
    public static <T> Float sumOfFloat(Collection<T> collection, Converter<T, Float> selector, Predicate<T> accepter) {
        if (CollectionUtils.isEmpty(collection))
            return new Float(0.0f);
        if (selector == null) {
            throw new IllegalArgumentException("Selector is not provide.");
        }
        Predicate<T> useAccepter = accepter == null ? (element) -> true : accepter;
        Float sumValue = new Float(0.0f);
        for (T element : collection) {
            if (useAccepter.test(element))
                sumValue = NumberUtil.add(sumValue, selector.convert(element));
        }
        return sumValue;
    }


    /**
     * 集合中元素某个字段求和
     *
     * @param collection
     * @param <T>
     * @return 字段总和， BigDecimal类型
     */
    public static <T> Float sumOfFloat(Collection<T> collection, Converter<T, Float> selector) {
        return sumOfFloat(collection, selector, null);
    }
}
