package cn.com.sany.symc.zg.ui;

/**
 * Created by sany on 2017/3/23.
 */

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.hardware.Camera;
import android.hardware.Camera.PictureCallback;
import android.hardware.Camera.ShutterCallback;
import android.util.Log;
import android.view.SurfaceHolder;

import cn.com.sany.symc.zg.util.CacheData;
import cn.com.sany.symc.zg.util.LogUtil;

import java.io.ByteArrayOutputStream;


public class CameraInterface {
    private static final String TAG = "yanzi";
    private Camera mCamera;
    private Camera.Parameters mParams;
    public boolean isPreviewing = false;
    private float mPreviwRate = 0.1f;
    private static CameraInterface mCameraInterface;
   // public TcpClient tcpClient=null;

    public interface CamOpenOverCallback{
        public void cameraHasOpened();
    }
    public boolean CameraState()
    {
        if(mCamera==null)
            return  false;
        else
             return  true;
    }
    public CameraInterface(){

    }
    public static synchronized CameraInterface getInstance(){
        if(mCameraInterface == null){
            mCameraInterface = new CameraInterface();
        }
        return mCameraInterface;
    }
    public  int FindFrontCamera()
    {
        int cameraCount=0;

        Camera.CameraInfo cameraInfo=new Camera.CameraInfo();
        cameraCount= Camera.getNumberOfCameras();
        for(int idx=0;idx<cameraCount;idx++)
        {
            Camera.getCameraInfo(idx,cameraInfo);
            CacheData.setMsg_info("===========cameraInfo.facing=========="+cameraInfo.facing,1);
            CacheData.setMsg_info("===========cameraInfo.facing=========="+cameraInfo.facing,1);
           ; if(cameraInfo.facing == 7)//1 为后置摄像头 0为前置摄像头
            {
                return idx;
            }
//            if(cameraInfo.facing == 1)//1 为后置摄像头 0为前置摄像头
//            {
//                return idx;
//            }
                if(cameraInfo.facing == 5)//1 为后置摄像头 0为前置摄像头
                {
                    return idx;
            }
        }
        return  -1;
    }
    /**��Camera
     * @param callback
     */
    public void doOpenCamera(CamOpenOverCallback callback,int cameraIndex){
        try {
            LogUtil.d("doOpenCamera","============打开摄像头==01============");
          //  int CameraIndex=FindFrontCamera();
           // int CameraIndex=7;

            if(cameraIndex!=-1) {
                if(mCamera!=null)
                {
                    mCamera.stopPreview();
                    mCamera.release();
                    mCamera=null;
                }

                    LogUtil.d("doOpenCamera","============打开摄像头=====02=========CameraIndex：" + cameraIndex);
                    mCamera = Camera.open(cameraIndex);
                    LogUtil.d("doOpenCamera","============已经打开摄像头======03=========CameraIndex：" + cameraIndex);
                    callback.cameraHasOpened();
            }

        }catch (Exception e) {
            e.printStackTrace();
            LogUtil.d("doOpenCamera","============打开摄像头异常==============：" + e.toString());
        }

    }

    /**����Ԥ��
     * @param holder
     * @param previewRate
     */
    public void doStartPreview(SurfaceHolder holder, float previewRate){
        LogUtil.d("doStartPreview","===========开始预览==============01=============" );
        if(mCamera != null){
            try {
                mCamera.setPreviewDisplay(holder);
                mCamera.startPreview();//����Ԥ��
                isPreviewing=true;
                LogUtil.d("doStartPreview","预览成功");
                mPreviwRate = previewRate;

                mParams = mCamera.getParameters(); //����getһ��
                LogUtil.d(TAG, "预览宽度 = " + mParams.getPreviewSize().width
                        + "Height = " + mParams.getPreviewSize().height);
                LogUtil.d(TAG, "图片宽度 = " + mParams.getPictureSize().width
                        + "Height = " + mParams.getPictureSize().height);
            } catch (Exception e) {

                LogUtil.d("doStartPreview","============预览失败==============：" + e.toString());
                e.printStackTrace();
            }

        }

    }


    //自动对焦回调函数(空实现)
    private Camera.AutoFocusCallback myAutoFocus = new Camera.AutoFocusCallback() {
        @Override
        public void onAutoFocus(boolean success, Camera camera) {
        }
    };
    /**
     * ֹͣԤ�����ͷ�Camera
     */
    public void doStopCamera(){
        if(null != mCamera)
        {
           // mCamera.setPreviewCallback(null);
            mCamera.stopPreview();
            isPreviewing = false;
            /*mPreviwRate = -1f;*/
            mCamera.release();
            mCamera = null;
        }
    }
    /**
     * ����
     */
    public void doTakePicture(){
        if(isPreviewing && (mCamera != null)){
            try {
//                if(tcpClient!=null) {
//                    tcpClient.showInformation("拍照");
//                }
                mCamera.takePicture(mShutterCallback, null, mJpegPictureCallback);
                Log.i(TAG, "拍照");
            }catch (Exception e)
            {
                Log.i(TAG, "拍照错误："+e.getMessage());
//                if(tcpClient!=null) {
//                    tcpClient.showInformation("拍照错误" + e.getMessage());
//                }
            }

        }
    }

    public static byte[] Bitmap2Bytes(Bitmap bm){
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bm.compress(Bitmap.CompressFormat.JPEG, 40, baos);

        return baos.toByteArray();
    }
    /*Ϊ��ʵ�����յĿ������������ձ�����Ƭ��Ҫ���������ص�����*/
    ShutterCallback mShutterCallback = new ShutterCallback()
            //���Ű��µĻص������������ǿ����������Ʋ��š����ꡱ��֮��Ĳ�����Ĭ�ϵľ������ꡣ
    {
        public void onShutter() {
            // TODO Auto-generated method stub
            Log.i(TAG, "myShutterCallback:onShutter...");
        }
    };
    PictureCallback mRawCallback = new PictureCallback()
            // �����δѹ��ԭ���ݵĻص�,����Ϊnull
    {

        public void onPictureTaken(byte[] data, Camera camera) {
            // TODO Auto-generated method stub
            Log.i(TAG, "myRawCallback:onPictureTaken...");

        }
    };
    PictureCallback mJpegPictureCallback = new PictureCallback()
            //��jpegͼ�����ݵĻص�,����Ҫ��һ���ص�
    {
        public void onPictureTaken(byte[] data, Camera camera) {
            // TODO Auto-generated method stub
            Log.i(TAG, "拍照成功...");
//            if(tcpClient!=null) {
//                tcpClient.showInformation("拍照成功");
//            }
            Bitmap b = null;
            if(null != data){
                Log.i(TAG, "拍照有数据...");
//                if(tcpClient!=null) {
//                    tcpClient.showInformation("拍照有数据。。。");
//                }
                b = BitmapFactory.decodeByteArray(data, 0, data.length);//data���ֽ����ݣ����������λͼ
               /* if(!GlobalVar.isCameraOpened) {//若之前没有打开摄像头，则关闭预览
                    doStopCamera();
                    *//*mCamera.stopPreview();
                    isPreviewing = false;*//*

                }*/

            }
            //����ͼƬ��sdcard
            if(null != b)
            {
                //����FOCUS_MODE_CONTINUOUS_VIDEO)֮��myParam.set("rotation", 90)ʧЧ��
                //ͼƬ��Ȼ������ת�ˣ�������Ҫ��ת��
                //Bitmap rotaBitmap = ImageUtil.getRotateBitmap(b, 90.0f);
//                Log.i(TAG, "保存照片...");
//               // String filename=FileUtil.saveBitmap(b);//rotaBitmap);
//
//                GlobalVar.takePictureData=Bitmap2Bytes(b);
//                GlobalVar.isFinishDoPic=true;
//                if(tcpClient!=null) {
//                    byte[] img = new byte[GlobalVar.takePictureData.length + 8];
//                    byte[] bid = NumberBytes.intToBytes(GlobalVar.takepictureid);
//                    System.arraycopy(bid, 0, img, 0, 4);
//                    img[4] = 0x00;//0为图片，1为音频，2为视频
//                    img[5] = 0x00;//0为jpg,1为tif，2为mp3
//                    img[6] = 0x00;//0为平台下发指令，1为定时动作
//                    img[7] = 0x01;//通道
//
//                    System.arraycopy(GlobalVar.takePictureData, 0, img, 8, GlobalVar.takePictureData.length);
//
//                    short pkgcount = (short) (img.length / GlobalVar.transDataLenth);
//                    if (img.length % GlobalVar.transDataLenth != 0) pkgcount += 1;
//                               /* text.append("总包数：" + String.valueOf(pkgcount));*/
//                    // showInformation("总包数：" + String.valueOf(pkgcount));
//                    tcpClient.showInformation("总包数：" + String.valueOf(pkgcount));
//                    int index = 0;
//                    for (short i = 1; i <= pkgcount; i++) {
//                        try {
//                            int lenth = GlobalVar.transDataLenth;
//                            byte[] data1 = new byte[lenth];
//                            if (index + GlobalVar.transDataLenth > img.length) {
//                                lenth = img.length - index;
//                                data1 = new byte[lenth];
//                            }
//                            //拷贝数据
//                            System.arraycopy(img, index, data1, 0, lenth);
//                            //showInformation("索引号：" + String.valueOf(index)+"数据长度："+String.valueOf(lenth));
//                            index += lenth;//data.length;
//                            byte[] d = Protocol.PictureUpData(data1, NumberBytes.intTo2Bytes(pkgcount), NumberBytes.intTo2Bytes(i));
//
//                            tcpClient.outputStream.write(d);
//                            tcpClient.outputStream.flush();
//                            GlobalVar.SerialNum++;
//                            Thread.sleep(50);
//
//                        } catch (IOException e) {
//                            // TODO Auto-generated catch block
//                            e.printStackTrace();
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                }
//
//               /* Toast.makeText(getApplicationContext(), "上传抓拍完成",
//                        Toast.LENGTH_SHORT).show();
//                text.append("上传抓拍完成\n");*/
//                if(tcpClient!=null) {
//                    tcpClient.showInformation("抓拍上传完成");
//                }
            }
            //�ٴν���Ԥ��

            mCamera.startPreview();
            isPreviewing = true;
        }
    };


}
