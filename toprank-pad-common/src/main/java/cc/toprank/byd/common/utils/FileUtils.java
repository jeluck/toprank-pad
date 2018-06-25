package cc.toprank.byd.common.utils;

import java.io.File;

/**
 * Class description
 *
 *
 * @version        2.0.0, 2017-01-12
 * @author         David  
 */
public class FileUtils {

    /**
     * Method description
     *
     *
     * @param filePath
     */
    public static void creatDir(String filePath) {
        File file = new File(filePath);

        if (!file.exists()) {
            file.mkdir();
        }
    }

    /**
     * Method description
     *
     *
     * @param path
     */
    public static void isDir(String path) {
        String[] paths    = path.split("/");
        String   filePath = "";

        for (int i = 0; i < paths.length; i++) {
            if (i == 0) {
                filePath = paths[0];
            } else {
                filePath += "/" + paths[i];
            }

            creatDir(filePath);
        }
    }
}



