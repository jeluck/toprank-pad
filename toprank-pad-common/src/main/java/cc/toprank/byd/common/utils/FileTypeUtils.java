package cc.toprank.byd.common.utils;

import cc.toprank.byd.common.enums.FileTypeEnum;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Class description
 *
 *
 * @version        2.0.0, 2017-01-12
 * @author         David  
 */
public final class FileTypeUtils {

    /**
     * Method description
     *
     *
     * @param bytes
     *
     * @return
     */
    private static String bytes2hex(byte[] bytes) {
        StringBuilder hex = new StringBuilder();

        for (int i = 0; i < bytes.length; i++) {
            String temp = Integer.toHexString(bytes[i] & 0xFF);

            if (temp.length() == 1) {
                hex.append("0");
            }

            hex.append(temp.toLowerCase());
        }

        return hex.toString();
    }

    /**
     * Method description
     *
     *
     * @param args
     *
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        System.out.println(FileTypeUtils.getType("D:\\BaiduYunDownload\\����.zip"));
    }

    /**
     * Method description
     *
     *
     * @param filePath
     *
     * @return
     *
     * @throws IOException
     */
    private static String getFileHeader(String filePath) throws IOException {
        byte[]      b           = new byte[28];
        InputStream inputStream = null;

        inputStream = new FileInputStream(filePath);
        inputStream.read(b, 0, 28);
        inputStream.close();

        return bytes2hex(b);
    }

    /**
     * Method description
     *
     *
     * @param is
     *
     * @return
     *
     * @throws IOException
     */
    public static FileTypeEnum getType(InputStream is) throws IOException {
        byte[] b = new byte[28];

        is.read(b, 0, 28);
        is.close();

        String fileHead = bytes2hex(b);

        if ((fileHead == null) || (fileHead.length() == 0)) {
            return null;
        }

        fileHead = fileHead.toUpperCase();

        FileTypeEnum[] FileTypeEnums = FileTypeEnum.values();

        for (FileTypeEnum type : FileTypeEnums) {
            if (fileHead.startsWith(type.getValue())) {
                return type;
            }
        }

        return null;
    }

    /**
     * Method description
     *
     *
     * @param filePath
     *
     * @return
     *
     * @throws IOException
     */
    public static FileTypeEnum getType(String filePath) throws IOException {
        String fileHead = getFileHeader(filePath);

        if ((fileHead == null) || (fileHead.length() == 0)) {
            return null;
        }

        fileHead = fileHead.toUpperCase();

        FileTypeEnum[] FileTypeEnums = FileTypeEnum.values();

        for (FileTypeEnum type : FileTypeEnums) {
            if (fileHead.startsWith(type.getValue())) {
                return type;
            }
        }

        return null;
    }
}



