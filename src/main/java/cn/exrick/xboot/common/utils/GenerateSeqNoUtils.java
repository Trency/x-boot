package cn.exrick.xboot.common.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class GenerateSeqNoUtils {
    /**
     * 生成队列序列号
     *
     * @param lastSeq
     * @return
     */
    public static String generateSeqNo(Long lastSeq) {
        Calendar zero = Calendar.getInstance();

        // 获得进行时 Time
        Long processTime = System.currentTimeMillis() - zero.getTimeInMillis();
        // 获得进行 Hour
        Long processHour = processTime / 1000 / 60 / 60;
        // 获得进行单元, 9小时计算一个进行为单元
        Long processCell = processHour / 9;


        // 当前序列号, 默认为1
        Long nowSerialNo = 1L;
        if (lastSeq > 0L) {
            Long lastProcessCell = Long.valueOf(lastSeq.toString().substring(1, 5));
            Long lastSerialNo = Long.valueOf(lastSeq.toString().substring(5));
            // 如果进行单元匹配, 则增长序列号
            if (lastProcessCell.equals(processCell)) {
                nowSerialNo = lastSerialNo + 1;
            }
        }


        // 进行单为固定的位数, 4位数, 确保在10年内有效.
        // 如位数不够, 在前面补0.
        String processCellValueStr = processCell.toString();
        int processHourPlh = processCellValueStr.length();
        if (processHourPlh < 4) {
            for (int i = 4; i > processHourPlh; i--) {
                processCellValueStr = "0" + processCellValueStr;
            }
        }
        // 进行序列有最小的固定位数, 最小固定位数为3位.
        // 如果位数不够, 在前面补0.
        String nowSerialStr = nowSerialNo.toString();
        int nowSerialPlh = nowSerialStr.length();
        if (nowSerialPlh < 3) {
            for (int i = 3; i > nowSerialPlh; i--) {
                nowSerialStr = "0" + nowSerialStr;
            }
        }
        // 最终序列值为 超越位 + 进行单元 + 序列号
        String nowSeqStr = zero.getTimeInMillis() + processCellValueStr + nowSerialStr;
        return nowSeqStr;
    }

    /**
     * 生成随机数
     *
     * @return
     */
    public static String getRandom() {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 6; i++) {
            int a = Math.abs((new Random()).nextInt(57));// 产生0~57的随机数
            if (a <= 9) {// 将0~9转为char的0~9
                sb.append((char) (a + 48));
            } else if (a < 33) {// 将10~33转为char的A~Z
                if ((a + 55) == 79 || (a + 55) == 73) {
                    sb.append((char) (a + 63));
                } else {
                    sb.append((char) (a + 55));
                }
            } else {// 将33~57转为char的a~z
                sb.append((char) (a + 63));
            }
        }
        String RandomCipher = sb.toString();
        return RandomCipher;

    }

    /**
     * 生成订单号
     *
     * @return
     */
    public static String doOrderNum() {
        Random random = new Random();
        SimpleDateFormat allTime = new SimpleDateFormat("YYYYMMddHHmmSSS");
        String subjectno = allTime.format(new Date()) + random.nextInt(10);
        return subjectno + random.nextInt(10);
    }

}
