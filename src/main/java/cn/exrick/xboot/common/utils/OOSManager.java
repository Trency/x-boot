package cn.exrick.xboot.common.utils;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.BucketInfo;

import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * 上传阿里云服务图片
 *
 * @author DOY
 */
public class OOSManager {
    /**
     * @param
     * @return
     */

    public static void uploadPic(InputStream is, String fileName, String endpoint, String accesskeyId, String accessKeySecret, String bucketName) {

        // 生成OSSClient，您可以指定一些参数，详见“SDK手册 > Java-SDK > 初始化”，
        // 链接地址是：https://help.aliyun.com/document_detail/oss/sdk/java-sdk/init.html?spm=5176.docoss/sdk/java-sdk/get-start
        OSSClient ossClient = new OSSClient(endpoint, accesskeyId, accessKeySecret);
        try {
            // 判断Bucket是否存在。详细请参看“SDK手册 > Java-SDK > 管理Bucket”。
            // 链接地址是：https://help.aliyun.com/document_detail/oss/sdk/java-sdk/manage_bucket.html?spm=5176.docoss/sdk/java-sdk/init
            if (!(ossClient.doesBucketExist(bucketName))) {
                // 创建Bucket。详细请参看“SDK手册 > Java-SDK > 管理Bucket”。
                ossClient.createBucket(bucketName);  //当为空，创建一个Bucket
            }
            // 查看Bucket信息。详细请参看“SDK手册 > Java-SDK > 管理Bucket”。
            // 链接地址是：https://help.aliyun.com/document_detail/oss/sdk/java-sdk/manage_bucket.html?spm=5176.docoss/sdk/java-sdk/init
            BucketInfo info = ossClient.getBucketInfo(bucketName);
            // 链接地址是：https://help.aliyun.com/document_detail/oss/sdk/java-sdk/upload_object.html?spm=5176.docoss/user_guide/upload_object
            ossClient.putObject(bucketName, fileName, is);
        } catch (OSSException oe) {
            oe.printStackTrace();
        } catch (ClientException ce) {
            ce.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("上传成功");
            ossClient.shutdown();
        }
    }


    /**
     * 删除一个Bucket和其中的Object
     *
     * @param
     * @param bucketName Bucket名
     */
    public static boolean deleteBucket(String imgPath, String endpoint, String accesskeyId, String accessKeySecret, String bucketName) {
        OSSClient client = new OSSClient(endpoint, accesskeyId, accessKeySecret);
        //如果不为空，先删除bucket下的指定的文件
        boolean success = false;
        try {
            client.deleteObject(bucketName, imgPath);
            success = true;
        } catch (OSSException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return success;
    }

    public static void main(String[] args) throws FileNotFoundException {
		/*File f = new File("E:/11.png");   
        InputStream is = new FileInputStream(f);   
		//InputStream is = headImage.getInputStream();
		CdnUploadTools.uploadPic( is,"image/ss.png");*/
        //OOSManager.deleteBucket("http://beadwallet.oss-cn-hangzhou.aliyuncs.com/upload/backend/20160826152028584.png");
    }

}
