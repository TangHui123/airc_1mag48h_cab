package cn.com.sany.symc.zg.util;

import android.text.TextUtils;


import java.util.HashMap;
import java.util.Map;


/**
 *
 * 缓存内容
 * @auther bird
 * Created  2018/1/25 17:11
 */

public class CacheData {
    public static String record_channel = "11110000";      //录制通道
    public static String record_time = "";         //录制时长
    public static byte [] content_record = {(byte)0xF0,(byte)0x24};//new byte[2];  0x80
    public static byte [] content_record_len = {(byte)0x00,(byte)0x02};//new byte[2];


    public static String display_channel = "11110000";     //显示的通道
    public static byte [] content_display = {(byte)0xF0};
    public static byte [] content_display_len = {(byte)0x00,(byte)0x01};//new byte[2];
    public static byte [] content_display_real = new byte[1];


    public static String display_channel_control = "1000000";       //倒车、左转和右转等显示的通道
    public static byte [] content_display_control = {(byte)0x80};
    public static byte [] content_display_len_control = {(byte)0x00,(byte)0x01};//new byte[2];
    public static byte [] content_display_real_control = new byte[1];


    public static byte look_flag = (byte) 0x01;    //回看标志位
    public static String look_channel = "";        //回看的通道
    public static String start_time = "";          //回看的开始时间
    public static String end_time = "";            //回看的结束时间
    public static byte [] content_look = new byte[14];
    public static byte [] content_look_len = {(byte)0x00,(byte)0x0E};//new byte[2];

    private static int serial_id = 1;  //初始化值为1   //同linux进行数据同步的流水号

    private static String msg_info = "";  //日志信息

    private static int msg_info_flag = 0;  //显示全部日志

    //最近上传整个升级包的版本号
    public static String version_code = "";
    public static String version_name = "symt1.01.15";
    public static byte [] version_name_byte = new byte[12];
    public static byte [] version_name_len = {(byte)0x00,(byte)0x0C};

    public static int currentPkg = 0;
    public static int countPkg = 0;
    public static String update_pkg_id = "0";
    public static String md5 = "6e8fe9c5fe10fca47db77268709c34a0";

    public static String updateFilePath = "";          //升级包文件路径
    public static String  update_pkg_ids = "";         //升级包的集合update_pkg_id + "," + currentPkg ，每包以=隔开
    public static int update_num = 10001;              //升级流水号，依次递增
    public static String  old_path = "";              //上次升级和之前升级的保存的文件路径;
    public static int update_state_flag = 0;           //0：表示从未升级  1：表示升级完成，2：表示升级中

    public static String versioCode_current = "";
    public static String versionName_current = "";

    private static int thread_flag = 0;


    public static String getMsg_info() {
        return msg_info;
    }

    public static String setMsg_info() {
        return msg_info = "";
    }


    /**
     *
     * 获取流水号
     * @return
     */
    public synchronized static int getSerial_id() {
        return ++serial_id;
    }

    /**
     * 输出日志类别
     * @param msg_info
     * @param type
     */
    public static void setMsg_info(String msg_info,int type) {
      //  if(msg_info_flag == 0 || msg_info_flag == type){
            if(!TextUtils.isEmpty(msg_info)){
                if(CacheData.msg_info.length()>30000){
                    CacheData.msg_info = CacheData.msg_info.substring(CacheData.msg_info.length()-15000,CacheData.msg_info.length());
                }
                CacheData.msg_info = CacheData.msg_info + "\n" + CommUtil.getData() + "=============>" + msg_info;
            }
    //    }

    }

    public synchronized static int getThread_flag() {
        return thread_flag;
    }

    public synchronized static void setThread_flag(int thread_flag) {
        CacheData.thread_flag = thread_flag;
    }
}
