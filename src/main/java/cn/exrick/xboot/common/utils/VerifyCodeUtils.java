package cn.exrick.xboot.common.utils;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * Created by Administrator on 2017/12/10.
 */
public class VerifyCodeUtils {
    public static final String RANDOM_CODE = "randomCode";
    private static final int IMAGE_HEIGHT = 30;
    private static final int image_Start_X = 1;
    private static final int image_Start_Y = 25;
    private static final String FONT_NAME = "仿宋_GB2312";
    private static final int STYLE = Font.BOLD;
    private static final int FONT_SIZE = 20;
    /**
     * 去掉 0,'O','o'
     */
    private static final String[] codeArray = new String[]{
            "a", "b", "c", "d", "e", "f", "g", "h", "j", "k", "m", "n", "p", "r", "s", "t", "u", "v", "w", "x", "y", "z",
            "A", "B", "C", "D", "E", "F", "G", "H", "J", "K", "M", "N", "P", "R", "S", "T", "U", "V", "W", "X", "Y", "Z",
            "2", "3", "4", "5", "6", "7", "8", "9"
    };
    private static int CODE_SIZE = 4;

    /**
     * 获取随机验证码
     */
    public static BufferedImage genVerifyCode(String randomCode, HttpServletRequest request) {
        int frontColorInt = getIntValue(request.getParameter("fcs"), 16, 0);
        int fontSize = getIntValue(request.getParameter("fontSize"), 10, FONT_SIZE);
        int codeSize = getIntValue(request.getParameter("codeSize"), 10, CODE_SIZE);
        int imageHeight = getIntValue(request.getParameter("height"), 10, IMAGE_HEIGHT);
        String fontName = getValue(request.getParameter("fontName"), FONT_NAME);
        int style = getIntValue(request.getParameter("style"), 10, STYLE);
        int bgColorInt = getIntValue(request.getParameter("bgColor"), 16, 0xDCDCDC);
        // 默认背景色改成随机背景色
        Color bgColor = bgColorInt == 0xDCDCDC ? getRandColor(200, 250) : new Color(bgColorInt);
        final int width = codeSize * 18;


        BufferedImage image = new BufferedImage(width, imageHeight, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = image.createGraphics();
        g.setColor(bgColor);
        // 画边框
        g.drawRect(0, 0, width - 1, imageHeight - 1);
        g.setColor(bgColor);
        // 填充颜色
        g.fillRect(1, 1, width - 2, imageHeight - 2);
        Font font = new Font(fontName, style, fontSize);
        g.setFont(font);
        // 默认颜色色
        if (frontColorInt == 0) {
            //生成随机类
            Random random = new Random();
            //随机产生155条干扰线，使图象中的认证码不易被其它程序探测到
            g.setColor(getRandColor(160, 200));
            for (int i = 0; i < 155; i++) {
                int x = random.nextInt(width);
                int y = random.nextInt(imageHeight);
                int xl = random.nextInt(12);
                int yl = random.nextInt(12);
                g.drawLine(x, y, x + xl, y + yl);
            }
            // 随机颜色
            for (int i = 0; i < randomCode.length(); i++) {
                g.setColor(getRandColor(20, 130));
                g.drawString(randomCode.substring(i, i + 1), image_Start_X + 19 * i, image_Start_Y);
            }
        } else {
            // 指定颜色
            g.setColor(new Color(frontColorInt));
            g.drawString(randomCode, image_Start_X, image_Start_Y);
        }
        g.dispose();

        return image;
    }

    private static int getIntValue(String value, int radio, int vdefault) {
        try {
            return StringUtils.isEmpty(value) ? vdefault : Integer.parseInt(value, radio);
        } catch (Exception e) {
        }
        return vdefault;
    }

    private static String getValue(String value, String vdefault) {
        try {
            return StringUtils.isEmpty(value) ? vdefault : value;
        } catch (Exception e) {
        }
        return vdefault;
    }

    /**
     * 给定范围获得随机颜色
     *
     * @param fc
     * @param bc
     * @return
     */
    private static Color getRandColor(int fc, int bc) {
        Random random = new Random();
        if (fc > 255) {
            fc = 255;
        }
        if (bc > 255) {
            bc = 255;
        }
        int r = fc + random.nextInt(bc - fc);
        int g = fc + random.nextInt(bc - fc);
        int b = fc + random.nextInt(bc - fc);
        return new Color(r, g, b);
    }

    public static String getSerialId(int size, boolean includeTs) {
        String perfix = includeTs ? Long.toString(System.currentTimeMillis(), 32) : "";
        StringBuffer code = new StringBuffer(perfix.toUpperCase());
        int pos;
        for (int i = size; i > 0; i--) {
            pos = (int) (Math.random() * (codeArray.length - 1));
            code.append(codeArray[pos]);
        }
        return code.toString();
    }

    private static String generatCode(String seed) {
        StringBuilder calculateBuffer = new StringBuilder();
        char[] timeArray = seed.toCharArray();
        for (int j = timeArray.length - 1; j >= timeArray.length - 6; j--) {
            calculateBuffer.append(timeArray[j]);
        }
        Long calculateValue = Long.parseLong(calculateBuffer.toString());
        // convert To 33 进制
        StringBuilder codeBuffer = new StringBuilder(Long.toString(calculateValue, 33));
        // 获得补码
        int complementCode = 4 - codeBuffer.length();
        if (complementCode != 0) {
            for (int i = 0; i < complementCode; i++) {
                codeBuffer.append(timeArray[timeArray.length - 1 - i]);
            }
        }
        return codeBuffer.toString();
    }


    public static String generatCode(Long nowTime) {
        return generatCode(nowTime.toString());
    }

    public static void main(String[] args) {
        System.out.println("========" + System.currentTimeMillis());
//        System.out.println("========"+generatCode(UUID.randomUUID().toString()));
    }


}