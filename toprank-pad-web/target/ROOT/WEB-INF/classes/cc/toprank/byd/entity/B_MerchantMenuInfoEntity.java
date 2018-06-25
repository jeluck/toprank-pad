package cc.toprank.byd.entity;

/**********************************************************************************************************************
 *
 *   版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *
 *   该类为自动生成的实体类基类，不能手动修改。
 *   如有需要扩展的字段，请在B_MerchantMenuInfo类中进行修改
 *
 * ********************************************************************************************************************/
public class B_MerchantMenuInfoEntity extends B_MerchantMenuInfoEntityBase {

    private int produceMinute;
    private String filePath;

    public int getProduceMinute() {
        return produceMinute;
    }

    public void setProduceMinute(int produceMinute) {
        this.produceMinute = produceMinute;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

}