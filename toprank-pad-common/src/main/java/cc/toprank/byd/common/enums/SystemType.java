
package cc.toprank.byd.common.enums;

/**
 * Enum description
 *
 */
public enum SystemType {
    ADMIN(0, "��Ӫ����ϵͳ", "admin"), MEMBER(1, "��Ա����ϵͳ", "member"), NEWS(2, "������ϵͳ", "news"), ORDER(3, "��������ϵͳ", "order"),
    PRODUCT(4, "��Ʒ����ϵͳ", "product"), PUBLICDIC(5, "��������ϵͳ", "public"), SHOP(6, "��Ʒ����ϵͳ", "shop"),
    TRANS(7, "���׹���ϵͳ", "trans"), PAY(8, "֧������ϵͳ", "pay"), NOTIFY(9, "�ص�����ϵͳ", "notify"), MSG(10, "��Ϣ����ϵͳ", "msg"),
    AUTH(11, "TOKEN��֤", "auth"), SITE(12, "web��վ", "site");

    /** Field description */
    private int id;

    /** Field description */
    private String dis;

    /** Field description */
    private String group;

    /**
     * Constructs ...
     *
     *
     * @param id
     * @param dis
     * @param group
     */
    SystemType(int id, String dis, String group) {
        this.id    = id;
        this.dis   = dis;
        this.group = group;
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public String getDis() {
        return dis;
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public String getGroup() {
        return group;
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public int getId() {
        return id;
    }
}



