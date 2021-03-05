package cn.com.sany.symc.zg.util;

import android.os.Environment;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 *
 * 文件工具类
 *
 * @auther bird
 * Created  2018/1/24 10:27
 */

public class FileUtil {

    private static final  String TAG = "FileUtil.class";
    private static final File parentPath = Environment.getExternalStorageDirectory();
    private static final String DST_DATA_FOLER ="ZTC_CONF";
    public static final String DST_DATA_PATH = parentPath + "/" + DST_DATA_FOLER + "/";
    private static final String APK_FOLD =  "/apk_fold/";       //"APK_FOLD/"
    private static final String MOUNTS_FILE = "/proc/mounts";


//    /**
//     *
//     * 序列化对象、保存升级文件到文件系统
//     * @param fileName
//     * @param object
//     * @return
//     *
//     */
//    public static boolean saveUpDateSerialObject(String fileName,Object object){
////        File file=new File(DST_DATA_PATH + fileName);
////        if(!file.exists()){
////            file.mkdir();
////        }
//        return  saveSerialObject(fileName,object);
//    }


    /**
     *
     * 序列化对象、保存到文件系统
     * @param fileName
     * @param object
     * @return
     *
     */
    public synchronized static boolean saveSerialObject(String fileName,Object object){
        //如果文件不存在就创建文件
        ObjectOutputStream fos=null;
        try {
            File file=new File(DST_DATA_PATH + fileName);
            if(!file.getParentFile().exists()){
                file.getParentFile().mkdirs();
            }
            //获取输出流
            fos=new ObjectOutputStream(new FileOutputStream(file));
            //要使用writeObject
            fos.writeObject(object);
        }catch (Exception e){
            e.printStackTrace();
            LogUtil.e(TAG,"===================saveSerialObject===========================>"+e.getMessage());
            return  false;
        }finally{
            try {
                if (fos!=null) {
                    fos.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
                LogUtil.e(TAG,"===================saveSerialObject===========================>"+e.getMessage());
                return  false;
            }

        }

        return true;
    }

    /**
     *
     * 读取序列化对象文件
     * @param fileName
     * @return
     *
     */
    public synchronized  static Object readSerialObject(String fileName){
        //如果文件不存在就创建文件
        ObjectInputStream ois=null;
        Object object = null;
        try {
            //获取输入流
            ois=new ObjectInputStream(new FileInputStream(new File(DST_DATA_PATH + fileName)));
            //获取文件中的数据
            if(ois!=null){
                object = ois.readObject();
            }
            //Log.d(TAG,"----readSerialObject------object.toString()----->"+ object.toString());
            return object;
        }catch (Exception e){
            e.printStackTrace();
            LogUtil.e(TAG,"===================readSerialObject======00=====================>"+e.getMessage());
        }finally{
            try {
                if (ois!=null) {
                    ois.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
                LogUtil.e(TAG,"===================readSerialObject=====11====================>"+e.getMessage());
            }

        }
        return object;
    }

    /**
     *
     * 删除序列化对象文件
     * @param fileName
     * @return
     *
     */
    public synchronized static boolean deleteSerialObject(String fileName){

        try {
            File file=new File(DST_DATA_PATH + fileName);
            if(file.exists()){
                file.delete();
            }
           // Log.d(TAG,"----deleteSerialObject------delete---->"+ fileName);
        }catch (Exception e){
            e.printStackTrace();
            LogUtil.e(TAG,"===================deleteSerialObject====================>"+e.getMessage());
            return false;
        }
        return true;
    }



    /**
     * 根据byte数组，生成文件
     * @param bfile 文件数组
     * @param filePath 文件存放路径
     * @param fileName 文件名称
     */
    public static void byte2File(byte[] bfile,String filePath,String fileName){
        BufferedOutputStream bos=null;
        FileOutputStream fos=null;
        File file=null;
        try{
            File dir=new File(filePath);
            if(!dir.exists() && !dir.isDirectory()){//判断文件目录是否存在
                dir.mkdirs();
            }
            file=new File(filePath+fileName);
            fos=new FileOutputStream(file);
            bos=new BufferedOutputStream(fos);
            bos.write(bfile);
        }
        catch(Exception e){
            LogUtil.e(TAG,"===================byte2File=========00===========>"+e.getMessage());
            e.printStackTrace();
        }
        finally{
            try{
                if(bos != null){
                    bos.close();
                }
                if(fos != null){
                    fos.close();
                }
            }
            catch(Exception e){
                LogUtil.e(TAG,"===================byte2File==========11==========>"+e.getMessage());
                e.printStackTrace();
            }
        }
    }


    /**
     * 获得指定文件的byte数组
     * @param filePath 文件绝对路径
     * @return
     */
    public static byte[] file2Byte(String filePath){
        ByteArrayOutputStream bos=null;
        BufferedInputStream in=null;
        try{
            File file=new File(filePath);
            if(!file.exists()){
                throw new FileNotFoundException("file not exists");
            }
            bos=new ByteArrayOutputStream((int)file.length());
            in=new BufferedInputStream(new FileInputStream(file));
            int buf_size=1024;
            byte[] buffer=new byte[buf_size];
            int len=0;
            while(-1 != (len=in.read(buffer,0,buf_size))){
                bos.write(buffer,0,len);
            }
            return bos.toByteArray();
        }
        catch(Exception e){
            LogUtil.e(TAG,"===================file2Byte==========11==========>"+e.getMessage());
            e.printStackTrace();
            return null;
        }
        finally{
            try{
                if(in!=null){
                    in.close();
                }
                if(bos!=null){
                    bos.close();
                }
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    /**
     *
     * 将字节流保存到文件
     * @param bfile
     * @param fileURI
     *
     */
    public static String addFile(byte[] bfile, String fileURI) {
        fileURI = DST_DATA_PATH + APK_FOLD + fileURI;
        BufferedOutputStream bos = null;
        FileOutputStream fos = null;
        File file = null;
        File dir = null;
        try {

            file=new File(fileURI);
            if(!file.getParentFile().exists()){
                file.getParentFile().mkdirs();
            }
            file = new File(fileURI);
            fos = new FileOutputStream(file);
            bos = new BufferedOutputStream(fos);
            bos.write(bfile);
            bos.flush();
        } catch (Exception e) {
            e.printStackTrace();
            LogUtil.e(TAG,"===================addFile===========================>"+e.getMessage());
            CacheData.setMsg_info("=============addFile====contentData.length====Exception=======>" + e.getMessage() ,4);
        } finally {
            if (bos != null) {
                try {
                    bos.close();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        }

        return fileURI;
    }


    /**
     * 删除某个文件夹下的所有文件夹和文件
     *
     * @param delpath
     *            String
     * @throws FileNotFoundException
     * @throws IOException
     * @return boolean
     */
    public static boolean deletefile(String delpath) {
        try {
            delpath = DST_DATA_PATH + delpath;
            CacheData.setMsg_info("=========deletefile======update======>" + delpath,4);
            File file = new File(delpath);
            // 当且仅当此抽象路径名表示的文件存在且 是一个目录时，返回 true
            if (!file.isDirectory()) {
                file.delete();
            } else if (file.isDirectory()) {
                String[] filelist = file.list();
                for (int i = 0; i < filelist.length; i++) {
                    File delfile = new File(delpath + "\\" + filelist[i]);
                    if (!delfile.isDirectory()) {
                        delfile.delete();
//                        System.out
//                                .println(delfile.getAbsolutePath() + "删除文件成功");
                    } else if (delfile.isDirectory()) {
                        deletefile(delpath + "\\" + filelist[i]);
//                        System.out.println(file + "ssss");
                    }
                }
                if (!file.toString().equals("D:\\file")) {                    //选择不删除自身文件夹
//                    System.out.println(file.toString() + "lllllll");
                    file.delete();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            LogUtil.e(TAG,"===================deletefile===========================>"+e.getMessage());
        }
        return true;
    }

    /**
     *
     * 获取U盘路径
     * @return
     *
     */
    public static String getExtSDCard(){
        File[] files=new File("/mnt").listFiles();
        String sdcard=Environment.getExternalStorageDirectory().getAbsolutePath().toLowerCase();
        String file;
        for (int i = 0; i < files.length; i++) {
            file=files[i].getAbsolutePath().toLowerCase();
            				CacheData.setMsg_info("======================getExtSDCard============================file===>" + file,0);
           // if(!file.equals(sdcard)&&(file.contains("ext")||file.contains("sdcard"))){
          //      return file;
          //  }
        }
        return null;
    }


    //文件复制
   public void copyFile(String filename,String srcpath,String destpath)throws IOException {
      File source = new File(srcpath+"/"+filename);
      File dest = new File(destpath+"/"+filename);
      FileChannel in = null, out = null;
      try {
           in = new FileInputStream(source).getChannel();
           out = new FileOutputStream(dest).getChannel();
           long size = in.size();
            MappedByteBuffer buf = in.map(FileChannel.MapMode.READ_ONLY, 0, size);
            byte aa [] = buf.array();
            in.close();
            out.close();
            source.delete();//文件复制完成后，删除源文件
        }catch(Exception e){
             e.printStackTrace();
               } finally {
              in.close();
                 out.close();
               }
       }



    /**
     * 递归删除目录下的所有文件及子目录下所有文件
     *
     *            将要删除的文件目录
     * @return
     */
    public static void deleteByMathcerFiles(String str) {
        File file = new File(DST_DATA_PATH);
        if (!file.exists())
            return ;
        if (file.isDirectory()) {
            String[] childrens = file.list();
            // 递归删除目录中的子目录下
            for (String child : childrens) {
                if(child.indexOf(str)>-1) {

                    File file_child = new File(file, child);
                    if(file.exists()) {
                        file_child.delete();
                    }
                }


            }
        }

    }


    /**
     * 递归删除目录下的所有文件及子目录下所有文件
     *
     *            将要删除的文件目录
     * @return
     */
    public static void deleteByMathcerFiles(String path,String str) {
        File file = new File(DST_DATA_PATH + path);
        if (!file.exists())
            return ;
        if (file.isDirectory()) {
            String[] childrens = file.list();
            // 递归删除目录中的子目录下
            for (String child : childrens) {
                if(child.indexOf(str)>-1) {

                    File file_child = new File(file, child);
                    if(file.exists()) {
                        file_child.delete();
                    }
                }


            }
        }

    }


    public static boolean getAllExternalSdcardPath() {

        boolean flag = false;
        try {
            // 运行mount命令，获取命令的输出，得到系统中挂载的所有目录
            Runtime runtime = Runtime.getRuntime();
            Process proc = runtime.exec("mount");
            InputStream is = proc.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            String line;
            BufferedReader br = new BufferedReader(isr);
            while ((line = br.readLine()) != null) {
                // 将常见的linux分区过滤掉
              //  CacheData.setMsg_info("=========getAllExternalSdcardPath=======是否有挂载U盘=========isMount======" + line,IConstant.MESSAGE_INFO_ALL);
                // 下面这些分区是我们需要的
                if (line!=null && line.indexOf("usb0")>0){
                    // 将mount命令获取的列表分割，items[0]为设备名，items[1]为挂载路径
                    flag = true;
                    return flag;
                }
            }
        } catch (Exception e){
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        return flag;

    }











}



