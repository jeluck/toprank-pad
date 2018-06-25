package cc.toprank.byd.common.utils.qrcode;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.oned.Code39Writer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Hashtable;

/**
 * Enum description
 *
 */
public enum QrCodeUtil {
    INSTANCE;

    /** Field description */
    private static final String CHARSET = "utf-8";

    /** Field description */
    private static final String FORMAT_NAME = "JPG";

    // ��ά��ߴ�

    /** Field description */
    private int qrcodeSize = 260;

    /**
     * Method description
     *
     *
     * @param content
     *
     * @return
     */
    public byte[] createImage(String content) {
        byte[]                data   = null;
        ByteArrayOutputStream stream = new ByteArrayOutputStream();

        try {
            Hashtable<EncodeHintType, Object> hints = new Hashtable<>();

            hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
            hints.put(EncodeHintType.CHARACTER_SET, CHARSET);
            hints.put(EncodeHintType.MARGIN, 1);

            BitMatrix bitMatrix = new MultiFormatWriter().encode(content,
                                                                 BarcodeFormat.QR_CODE,
                                                                 qrcodeSize,
                                                                 qrcodeSize,
                                                                 hints);

            MatrixToImageWriter.writeToStream(bitMatrix, FORMAT_NAME, stream);
            data = stream.toByteArray();
        } catch (WriterException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                stream.flush();
                stream.close();
            } catch (IOException e) {}
        }

        return data;
    }

    /**
     * Method description
     *
     *
     * @param content
     * @param islogo
     * @param logStream
     * @param need
     *
     * @return
     */
    private byte[] createImage(String content, boolean islogo, InputStream logStream, boolean need) {
        byte[]                data         = null;
        InputStream           sourceStream = null;                           // Դ�ļ���
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();    // ����ļ���

        try {
            byte[] stream = createImage(content);

            if (!islogo) {
                return stream;
            }

            sourceStream = new ByteArrayInputStream(stream);

            BufferedImage image = insertLogo(sourceStream, logStream, need);

            ImageIO.write(image, FORMAT_NAME, outputStream);
            data = outputStream.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sourceStream != null) {
                try {
                    sourceStream.close();
                } catch (IOException e) {}
            }

            try {
                outputStream.flush();
                outputStream.close();
            } catch (IOException e) {}
        }

        return data;
    }

    /**
     * Method description
     *
     *
     * @param content
     *
     * @return
     */
    public byte[] encode(String content) {
        return createImage(content, false, null, false);
    }

    /**
     * Method description
     *
     *
     * @param content
     * @param logoStream
     * @param needCompress
     *
     * @return
     */
    public byte[] encode(String content, InputStream logoStream, boolean needCompress) {
        return createImage(content, true, logoStream, needCompress);
    }

    /**
     * Method description
     *
     *
     * @param content
     * @param url
     * @param needCompress
     *
     * @return
     */
    public byte[] encode(String content, String url, boolean needCompress) {
        if (url == null) {
            return null;
        }

        byte[]                data         = null;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        InputStream           inputStream  = null;

        try {
            URL           httpUrl = new URL(url);
            BufferedImage image   = ImageIO.read(httpUrl);

            ImageIO.write(image, FORMAT_NAME, outputStream);
            inputStream = new ByteArrayInputStream(outputStream.toByteArray());
            data        = createImage(content, true, inputStream, needCompress);
        } catch (IOException e) {}
        finally {
            try {
                outputStream.flush();
                outputStream.close();
            } catch (IOException e) {}

            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {}
            }
        }

        return data;
    }

    /**
     * Method description
     *
     *
     * @param code
     * @param width
     * @param height
     *
     * @return
     *
     * @throws WriterException
     */
    public byte[] encodeQRcode39(String code, int width, int height) throws WriterException {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        byte[]                data   = null;
        BitMatrix             matrix = new Code39Writer().encode(code, BarcodeFormat.CODE_39, width, height);

        try {
            MatrixToImageWriter.writeToStream(matrix, FORMAT_NAME, stream);
            data = stream.toByteArray();
        } catch (IOException e) {}
        finally {
            try {
                stream.flush();
                stream.close();
            } catch (IOException e) {}
        }

        return data;
    }

    /**
     * Method description
     *
     *
     * @param sourceStream
     * @param logoStream
     * @param needCompress
     *
     * @return
     *
     * @throws Exception
     */
    private BufferedImage insertLogo(InputStream sourceStream, InputStream logoStream, boolean needCompress)
            throws Exception {
        if (logoStream == null) {
            return null;
        }

        BufferedImage source = ImageIO.read(sourceStream);
        Image         src    = ImageIO.read(logoStream);
        int           width  = src.getWidth(null);
        int           height = src.getHeight(null);

        if (needCompress) {                    // ѹ��LOGO
            width  = Math.min((int) (qrcodeSize / 3.5), width);
            height = Math.min((int) (qrcodeSize / 3.5), height);

            Image         image = src.getScaledInstance(width, height, Image.SCALE_SMOOTH);
            BufferedImage tag   = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            Graphics      g     = tag.getGraphics();

            g.drawImage(image, 0, 0, null);    // ������С���ͼ
            g.dispose();
            src = image;
        }

        // ����LOGO
        Graphics2D graph = source.createGraphics();
        int        x     = (qrcodeSize - width) / 2;
        int        y     = (qrcodeSize - height) / 2;

        graph.drawImage(src, x, y, width, height, null);

        Shape shape = new RoundRectangle2D.Float(x, y, width, width, 2, 2);

        graph.setStroke(new BasicStroke(3f));
        graph.draw(shape);
        graph.dispose();

        return source;
    }

    /**
     * Method description
     *
     *
     * @param size
     *
     * @return
     */
    public QrCodeUtil setSize(int size) {
        this.qrcodeSize = size;

        return this;
    }
}



