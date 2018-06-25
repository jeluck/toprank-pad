package cc.toprank.byd.common.utils;

/**
 * Class description
 *
 *
 * @version        2.0.0, 2017-01-12
 * @author         David  
 */
public class MaskUtils {

    /**
     * Method description
     *
     *
     * @param bankCardNo
     *
     * @return
     */
    public static String maskBankCardNo(String bankCardNo) {
        return maskCardNo(bankCardNo);
    }

    /**
     * Method description
     *
     *
     * @param cardNo
     *
     * @return
     */
    private static String maskCardNo(String cardNo) {
        if ((cardNo == null) || (cardNo.trim().length() <= 8)) {
            return cardNo;
        }

        cardNo = cardNo.trim();

        int          length      = cardNo.length();
        String       firstFourNo = cardNo.substring(0, 4);
        String       lastFourNo  = cardNo.substring(length - 4);
        StringBuffer mask        = new StringBuffer("");

        for (int i = 0; i < length - 8; i++) {
            mask.append("*");
        }

        return firstFourNo + mask.toString() + lastFourNo;
    }

    /**
     * Method description
     *
     *
     * @param cellphoneNo
     *
     * @return
     */
    public static String maskCellphone(String cellphoneNo) {
        if ((cellphoneNo == null) || (cellphoneNo.trim().length() != 11)) {
            return cellphoneNo;
        }

        return new StringBuilder().append(cellphoneNo.substring(0, 3))
                                  .append("****")
                                  .append(cellphoneNo.substring(cellphoneNo.length() - 4))
                                  .toString();
    }

    /**
     * Method description
     *
     *
     * @param email
     *
     * @return
     */
    public static String maskEmail(String email) {
        return email;
    }

    /**
     * Method description
     *
     *
     * @param idCardNo
     *
     * @return
     */
    public static String maskIDCardNo(String idCardNo) {
        return maskCardNo(idCardNo);
    }
}



