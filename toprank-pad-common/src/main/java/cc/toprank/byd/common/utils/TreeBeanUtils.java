package cc.toprank.byd.common.utils;

import cc.toprank.byd.common.entity.TreeBase;
import cc.toprank.byd.common.entity.TreeObjectDto;

import java.lang.reflect.Field;
import java.util.*;

/**
 * Class description
 *
 *
 * @version        2.0.0, 2017-01-12
 * @author         David  
 */
public class TreeBeanUtils {

    /** Field description */
    List<TreeObjectDto> returnList = new ArrayList<TreeObjectDto>();

    /**
     * Method description
     *
     *
     * @param fields
     * @param childAttrName
     *
     * @return
     */
    public static Field findFieldByName(List<Field> fields, String childAttrName) {
        if ((fields == null) || (fields.size() < 1)) {
            return null;
        }

        Field result = null;

        for (Field field : fields) {
            if (field.getName().equals(childAttrName)) {
                result = field;

                break;
            }
        }

        return result;
    }

    /**
     * Method description
     *
     *
     * @param datas
     */
    public static void printTree(List<? extends TreeBase> datas) {
        if ((datas == null) || (datas.size() <= 0)) {
            System.out.println("data List is empty");

            return;
        }

        for (TreeBase data : datas) {
            System.out.println(data);

            if ((data != null) && (data.getChilds() != null) && (data.getChilds().size() > 0)) {
                printTree(data.getChilds());
            }
        }
    }

    /**
     * Method description
     *
     *
     * @param clazz
     *
     * @return
     */
    public static List<Field> queryAllField(Class<?> clazz) {
        if (clazz == null) {
            return null;
        }

        List<Field> result = null;
        Field[]     fields = clazz.getDeclaredFields();

        if (fields != null) {
            result = new ArrayList<Field>();

            for (Field field : fields) {
                result.add(field);
            }

            if (clazz.getSuperclass() != null) {
                List<Field> returnResults = queryAllField(clazz.getSuperclass());

                if (returnResults != null) {
                    for (Field returnResult : returnResults) {
                        result.add(returnResult);
                    }
                }
            }
        }

        return result;
    }

    /**
     * Method description
     *
     *
     * @param trees
     * @param parentId
     *
     * @return
     */
    public static List<? extends TreeBase> queryChild(List<? extends TreeBase> trees, Long parentId) {
        TreeBase parent = null;

        if (parentId == null) {
            return trees;
        }

        parent = new TreeBase();
        parent.setId(parentId);

        return queryChild(trees, parent);
    }

    /**
     * Method description
     *
     *
     * @param trees
     * @param parent
     *
     * @return
     */
    public static List<TreeBase> queryChild(List<? extends TreeBase> trees, TreeBase parent) {
        return queryChild(trees, parent, null);
    }

    /**
     * Method description
     *
     *
     * @param trees
     * @param parent
     * @param childAttrName
     *
     * @return
     */
    public static List<TreeBase> queryChild(List<? extends TreeBase> trees, TreeBase parent, String childAttrName) {
        if ((trees == null) || (trees.size() <= 0)) {
            return null;
        }

        List<TreeBase> childs = new ArrayList<TreeBase>();

        for (TreeBase tree : trees) {
            if (((tree.getParentId() == null) && (parent == null))
                    || ((tree.getParentId() != null) && (parent != null)
                        && tree.getParentId().equals(parent.getId()))) {
                childs.add(tree);
            }

            List<? extends TreeBase> nodes = null;

            if ((childAttrName == null) || "".equals(childAttrName)) {
                List<Field> fields = queryAllField(tree.getClass());
                Field       field  = findFieldByName(fields, childAttrName);

                if (field != null) {
                    try {
                        boolean tag = field.isAccessible();

                        field.setAccessible(true);
                        nodes = (List<? extends TreeBase>) field.get(tree);
                        field.setAccessible(tag);
                    } catch (IllegalArgumentException e) {}
                    catch (IllegalAccessException e) {}
                }
            } else {
                nodes = tree.getChilds();
            }

            if ((nodes != null) && (nodes.size() > 0)) {
                List<TreeBase> results = queryChild(nodes, parent, childAttrName);

                if ((results != null) && (results.size() > 0)) {
                    for (TreeBase result : results) {
                        childs.add(result);
                    }
                }
            }
        }

        Collections.sort(childs,
                         new Comparator<TreeBase>() {
                             public int compare(TreeBase o1, TreeBase o2) {
                                 if ((o1.getSort() == null) || (o2.getSort() == null)) {
                                     return 0;
                                 }

                                 return o1.getSort() - o2.getSort();
                             }
                         });

        return childs;
    }

    /**
     * Method description
     *
     *
     * @param list
     * @param node
     * @param p
     */
    private void recursionFn(List<TreeObjectDto> list, TreeObjectDto node, String p) {
        List<TreeObjectDto> childList = getChildList(list, node);    // �õ��ӽڵ��б�

        if (hasChild(list, node)) {    // �ж��Ƿ����ӽڵ�
            returnList.add(node);

            Iterator<TreeObjectDto> it = childList.iterator();

            while (it.hasNext()) {
                TreeObjectDto n = (TreeObjectDto) it.next();

                n.setName(p + n.getName());
                recursionFn(list, n, p + p);
            }
        } else {
            returnList.add(node);
        }
    }

    /**
     * Method description
     *
     *
     * @param datas
     * @param parent
     *
     * @return
     */
    public static List<TreeBase> sortTree(List<? extends TreeBase> datas, TreeBase parent) {
        return sortTree(datas, parent, null);
    }

    /**
     * Method description
     *
     *
     * @param datas
     * @param parent
     * @param childAttrName
     *
     * @return
     */
    public static List<TreeBase> sortTree(List<? extends TreeBase> datas, TreeBase parent, String childAttrName) {
        if ((datas == null) || (datas.size() <= 0)) {
            return null;
        }

        List<TreeBase> sortTree = new ArrayList<TreeBase>();

        for (TreeBase data : datas) {
            if (((parent == null) && (data.getParentId() == null))
                    || ((data.getParentId() != null) && (parent != null)
                        && data.getParentId().equals(parent.getId()))) {
                sortTree.add(data);

                List<TreeBase> result = sortTree(datas, data, childAttrName);

                if ((result != null) && (result.size() > 0)) {

                    // ���������ӽڵ�����,Ĭ������child�ڵ�
                    if ((childAttrName == null) || "".equals(childAttrName)) {
                        data.setChilds(result);
                    } else {
                        List<Field> fields = queryAllField(data.getClass());
                        Field       field  = findFieldByName(fields, childAttrName);

                        if (field != null) {

                            // ��������������ֵ
                            try {
                                boolean tag = field.isAccessible();

                                field.setAccessible(true);
                                field.set(data, result);
                                field.setAccessible(tag);
                            } catch (IllegalArgumentException e) {}
                            catch (IllegalAccessException e) {}
                        }
                    }
                }
            }
        }

        Collections.sort(sortTree,
                         new Comparator<TreeBase>() {
                             public int compare(TreeBase o1, TreeBase o2) {
                                 if ((o1.getSort() == null) || (o2.getSort() == null)) {
                                     return 0;
                                 }

                                 return o1.getSort() - o2.getSort();
                             }
                         });

        return sortTree;
    }

    /**
     * Method description
     *
     *
     * @param datas
     *
     * @return
     */
    public static List<? extends TreeBase> sortTreeByParent(List<? extends TreeBase> datas) {
        return sortTree(datas, null);
    }

    /**
     * Method description
     *
     *
     * @param datas
     * @param childAttrName
     *
     * @return
     */
    public static List<? extends TreeBase> sortTreeByParent(List<? extends TreeBase> datas, String childAttrName) {
        return sortTree(datas, null, childAttrName);
    }

    /**
     * Method description
     *
     *
     * @param datas
     * @param parentId
     *
     * @return
     */
    public static List<? extends TreeBase> sortTreeByParentId(List<? extends TreeBase> datas, Long parentId) {
        return sortTreeByParentId(datas, parentId, null);
    }

    /**
     * Method description
     *
     *
     * @param datas
     * @param parentId
     * @param childAttrName
     *
     * @return
     */
    public static List<? extends TreeBase> sortTreeByParentId(List<? extends TreeBase> datas, Long parentId,
                                                              String childAttrName) {
        TreeBase parent = null;

        if (parentId != null) {
            parent = new TreeBase();
            parent.setId(parentId);
        }

        return sortTree(datas, parent, childAttrName);
    }

    // �ж��Ƿ����ӽڵ�

    /**
     * Method description
     *
     *
     * @param list
     * @param t
     *
     * @return
     */
    private boolean hasChild(List<TreeObjectDto> list, TreeObjectDto t) {
        return (getChildList(list, t).size() > 0)
               ? true
               : false;
    }

    // �õ��ӽڵ��б�

    /**
     * Method description
     *
     *
     * @param list
     * @param t
     *
     * @return
     */
    private List<TreeObjectDto> getChildList(List<TreeObjectDto> list, TreeObjectDto t) {
        List<TreeObjectDto>     tlist = new ArrayList<TreeObjectDto>();
        Iterator<TreeObjectDto> it    = list.iterator();

        while (it.hasNext()) {
            TreeObjectDto n = (TreeObjectDto) it.next();

            if (n.getParentId().equals(t.getId())) {
                tlist.add(n);
            }
        }

        return tlist;
    }

    /**
     * Method description
     *
     *
     * @param list
     * @param typeId
     * @param prefix
     *
     * @return
     */
    public List<TreeObjectDto> getChildTreeObjects(List<TreeObjectDto> list, Long typeId, String prefix) {
        if (list == null) {
            return null;
        }

        for (Iterator<TreeObjectDto> iterator = list.iterator(); iterator.hasNext(); ) {
            TreeObjectDto node = (TreeObjectDto) iterator.next();

            // һ�����ݴ����ĳ�����ڵ�ID,�����ø��ڵ�������ӽڵ�
            if (node.getParentId().equals(typeId)) {
                recursionFn(list, node, prefix);
            }

            // �����������еĸ��ڵ��µ������ӽڵ�

            /*
             * if (node.getParentId()==0) {
             *   recursionFn(list, node);
             * }
             */
        }

        return returnList;
    }
}



