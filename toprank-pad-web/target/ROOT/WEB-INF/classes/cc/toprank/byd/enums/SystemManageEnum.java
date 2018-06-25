package cc.toprank.byd.enums;

/******************************************************************************************************
 *
 *   版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *
 *   该类为自动生成的字典枚举类，不能手动修改。
 *
 * ****************************************************************************************************/

public class SystemManageEnum {

    /**
     * 实体状态
     */
    public enum EntityStatus {
        /**
         * 待审核
         */
        AUDITING(8, "待审核"),
        /**
         * 正常
         */
        NORMAL(9, "正常"),
        /**
         * 已过期
         */
        EXPIRED(10, "已过期"),
        /**
         * 已删除
         */
        DELETED(11, "已删除"),
        /**
         * 禁用
         */
        DISABLE(846, "禁用");

        private final long value;
        private final String name;

        private EntityStatus(long value, String name) {
            this.value = value;
            this.name = name;
        }

        public long getValue() {
            return this.value;
        }

        public String getName() {
            return this.name;
        }
    }

    /**
     * 机构类型
     */
    public enum OrgType {
        /**
         * 机构
         */
        ORGANIZATION(12, "机构"),
        /**
         * 部门
         */
        DEPARTMENT(13, "部门"),
        /**
         * 餐饮企业
         */
        CATERINGENTERPRISE(281, "餐饮企业"),
        /**
         * 餐厅
         */
        RESTAURANT(282, "餐厅"),
        /**
         * 门店
         */
        STORE(283, "门店"),
        /**
         * 档口
         */
        STALL(284, "档口"),
        /**
         * 酒店企业
         */
        HOTELENTERPRISE(285, "酒店企业"),
        /**
         * 保险
         */
        INSURANCE(286, "保险"),
        /**
         * 传媒
         */
        MEDIA(287, "传媒"),
        /**
         * 网络媒体
         */
        NETWORKMEDIA(288, "网络媒体"),
        /**
         * 未知
         */
        UNKNOWN(289, "未知"),
        /**
         * 生产厂商
         */
        MANUFACTURER(634, "生产厂商");

        private final long value;
        private final String name;

        private OrgType(long value, String name) {
            this.value = value;
            this.name = name;
        }

        public long getValue() {
            return this.value;
        }

        public String getName() {
            return this.name;
        }
    }

    /**
     * 行业
     */
    public enum Industry {
        /**
         * 未知
         */
        UNKNOWN(14, "未知"),
        /**
         * 软件开发
         */
        SOFTWAREDEVELOPE(15, "软件开发"),
        /**
         * 餐饮
         */
        CATERING(378, "餐饮"),
        /**
         * 酒店
         */
        HOTEL(513, "酒店");

        private final long value;
        private final String name;

        private Industry(long value, String name) {
            this.value = value;
            this.name = name;
        }

        public long getValue() {
            return this.value;
        }

        public String getName() {
            return this.name;
        }
    }

    /**
     * 角色类别
     */
    public enum RoleType {
        /**
         * 管理角色
         */
        MANAGERROLE(4, "管理角色"),
        /**
         * 执行角色
         */
        EXECUTIONROLE(5, "执行角色");

        private final long value;
        private final String name;

        private RoleType(long value, String name) {
            this.value = value;
            this.name = name;
        }

        public long getValue() {
            return this.value;
        }

        public String getName() {
            return this.name;
        }
    }

    /**
     * 用户类型
     */
    public enum UserType {
        /**
         * 系统用户
         */
        SYSTEMUSER(44, "系统用户"),
        /**
         * 客户
         */
        CUSTOMER(45, "客户");

        private final long value;
        private final String name;

        private UserType(long value, String name) {
            this.value = value;
            this.name = name;
        }

        public long getValue() {
            return this.value;
        }

        public String getName() {
            return this.name;
        }
    }

    /**
     * 审核状态
     */
    public enum AuditStatus {
        /**
         * 未知
         */
        UNKNOWN(505, "未知"),
        /**
         * 审核中
         */
        AUDITING(506, "审核中"),
        /**
         * 已审核
         */
        AUDITED(507, "已审核"),
        /**
         * 已拒绝
         */
        REFUSED(508, "已拒绝"),
        /**
         * 已过期
         */
        EXPIRED(509, "已过期");

        private final long value;
        private final String name;

        private AuditStatus(long value, String name) {
            this.value = value;
            this.name = name;
        }

        public long getValue() {
            return this.value;
        }

        public String getName() {
            return this.name;
        }
    }

}