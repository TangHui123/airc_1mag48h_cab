package cn.com.sany.symc.zg.help;

/**
 *
 *公共静态常量类
 * @auther bird
 * Created  2017/12/27 09:30
 */

public class IConstant {

    /**
     *
     * 出版本说明
     * symc_version =  0  基础版本,默认没开 倒吸  水炮碰撞检测
     * symc_version =  1  倒吸版本
     * symc_version =  2  版本水炮碰撞
     * symc_version =  3  大罐车版本
     * symc_version =  4  JP20 版本
     *
     */
    public static final int symc_version =  0;

    public static final boolean DX_FLAG = false;   //倒吸默认关闭

    public static final boolean PZ_FLAG = false;   //水炮碰撞检测

    public static final byte RECEIVE_DATA_PROTOCOL_HEAD_1 = (byte)0xAA;      //起始头第一个字节,0xAA

    public static final byte RECEIVE_DATA_PROTOCOL_HEAD_2 = (byte)0x75;      //起始头第二个字节


    public static final byte COMMAND_ANSWER = (byte)0xA1;      //显示屏和linux的通用应答


    public static final byte COMMAND_MULTIPLE_POSTION_INFO = (byte)0x00;      //综合位置信息上传（1S周期）

    public static final byte COMMAND_DOWN_VIDEO = (byte)0xC1;      //显示屏下发视频录制配置信息

    public static final byte COMMAND_DOWN_CAMERA = (byte)0xC2;      //显示屏下发摄像头指定显示指令

    public static final byte COMMAND_DOWN_HISTORY_VIDEO_LOOK = (byte)0xC3;      //显示屏下发视频回放指令（选择时间段和通道）（数据第一位为标志位，标记访问、暂停、继续播放、关闭）

    public static final byte COMMAND_DOWN_DATA_SYNC_ANSWER = (byte)0xAB;   //显示屏下发数据同步指令

    public static final int COMMAND_MESSAGE_START_POSTION = 8;      //消息体开始位置

    public static final byte COMMAND_ANSWER_SUCESS = (byte)0x00;      //上传或下发成功

    public static final int UPDATE_SHOW_INFO = 0x66;      //更新显示消息信息

    public static final byte PROTOCOL_VERSION_1 = (byte)0x00;      //版本号

    public static final byte [] COMMAND_COMMON_ANSWER_LENGTH = {0x00,0x03};  //通用应答三位长度

    public static final int TAKE_PHOTO_REQUEST_CODE = 100;  //相机请求权限参数

    public static final String PERMISSION_CAMERA = "android.permission.CAMERA";



    public static final int SOURCE_SETTING = 0;     //跳转到设置

    public static final int SOURCE_ES_FILEMANAGER = 1;     //跳转到ES文件浏览器

    public static final int SOURCE_QUERY_LOG = 2;     //查看日志

    public static final int SOURCE_U_UPGRADE = 3;     //默认安装U盘根目录升级包

    public static final int SOURCE_CLEAR_RECORD_DEVICE_DATA = 4;     //删除记录仪所有数据

    public static final int SOURCE_UPGRADE_PASSWORD = 0;     //升级和查看日志密码

    public static final int SOURCE_OTHER_PASSWORD = 1001;     //删除记录仪所有数据

    public static final int SOURCE_MANAGER_PASSWORD = 6677;     //升级和查看日志密码


    public static final String RECEIVE_DATA_PROTOCOL_HEAD_3 = "0XAA=0X75=0X00";  //字符串匹配

    public static final int MESSAGE_INFO_ALL = 0;      //查看所有日志

    public static final int UPDATE_LOCATION_INFO = 500;      //查看所有日志

    public static final String WATER_PUMP_START = "1"; //水泵启动
    public static final String WATER_PUMP_STOP = "0"; //水泵停止

    public static final String TURRET_ANGEL_NEGTIVE = "1"; //转塔角度为负

    public static final String DX_STATE_TURN_OFF = "0"; //倒吸：0 关闭  1开启

    public static final String DX_STATE_TURN_ON = "1"; //倒吸：0 关闭  1开启

    public static final String SP_PZ_JC_ON = "1"; //水炮碰撞检测   （炮头碰撞预警） 0：关闭  1：报警

    public static final String ARM_SPREAD_1 = "1";//臂架展开
    public static final String ARM_SPREAD_0 = "0";//臂架未展开
    public static final String ARM_SHRINK_1 = "1";//臂架收缩
    public static final String ARM_SHRINK_0 = "0";//臂架未收缩

    public static final String Turret_Hit_ok = "1"; //塔台对中
    public static final String Turret_Hit_fail = "0"; //塔台未对中

    public static final String FOAM_LEVEL_0000 = "0000";    //空罐
    public static final String FOAM_LEVEL_0001 = "0001";    //1/8罐
    public static final String FOAM_LEVEL_0010 = "0010";    //2/8罐
    public static final String FOAM_LEVEL_0011 = "0011";    //3/8罐
    public static final String FOAM_LEVEL_0100 = "0100";    //4/8罐
    public static final String FOAM_LEVEL_0101 = "0101";    //5/8罐
    public static final String FOAM_LEVEL_0110 = "0110";    //6/8罐
    public static final String FOAM_LEVEL_0111 = "0111";    //7/8罐
    public static final String FOAM_LEVEL_1000 = "1000";    //满罐

    public static final String WATER_LEVEL_0000 = "0000";    //空罐
    public static final String WATER_LEVEL_0001 = "0001";    //1/8罐
    public static final String WATER_LEVEL_0010 = "0010";    //2/8罐
    public static final String WATER_LEVEL_0011 = "0011";    //3/8罐
    public static final String WATER_LEVEL_0100 = "0100";    //4/8罐
    public static final String WATER_LEVEL_0101 = "0101";    //5/8罐
    public static final String WATER_LEVEL_0110 = "0110";    //6/8罐
    public static final String WATER_LEVEL_0111 = "0111";    //7/8罐
    public static final String WATER_LEVEL_1000 = "1000";    //满罐

    public static final String REMOTE_CTRL_STATUS_0 = "0";    //未启动
    public static final String REMOTE_CTRL_STATUS_1 = "1";    //启动
    public static final String REMOTE_CTRL_STATUS_2 = "2";    //急停

    public static final String BATTARY_STATUS_0 = "0";    //电池状态0
    public static final String BATTARY_STATUS_1 = "1";    //电池状态1
    public static final String BATTARY_STATUS_2 = "2";    //电池状态2
    public static final String BATTARY_STATUS_3 = "3";    //电池状态3
    public static final String BATTARY_STATUS_4 = "4";    //电池状态4

    public static final String WIRELESS_LINK_0 = "0"; //断开
    public static final String WIRELESS_LINK_1 = "1"; //无线连接
    public static final String WIRELESS_LINK_2 = "2"; //有线连接

    public static final String STATE_1 = "1";   //状态标志位

    public static final String STATE_0 = "0";   //状态标志位

    public static final String STATE_00 = "00";   //中间位置

    public static final String STATE_10 = "10";   //上面位置

    public static final String STATE_01 = "01";   //下面位置


    public static final String ERR_CODE_0 = "0";    //无
    public static final String ERR_CODE_1 = "1";    //禁止臂架动作
    public static final String ERR_CODE_2 = "2";    //禁止支腿动作
    public static final String ERR_CODE_3 = "3";    //发动机测速故障
    public static final String ERR_CODE_4 = "4";    //机械式编码器故障
    public static final String ERR_CODE_5 = "5";    //旋转左限位
    public static final String ERR_CODE_6 = "6";    //旋转右限位
    public static final String ERR_CODE_7 = "7";    //驾驶室超高干涉
    public static final String ERR_CODE_8 = "8";    //横向角度过大，不能调平
    public static final String ERR_CODE_9 = "9";    //油温过高
    public static final String ERR_CODE_10 = "10";  //液压油位过低
    public static final String ERR_CODE_11 = "11";  //纵向角度过大，不能调平
    public static final String ERR_CODE_12 = "12";  //电子水平仪故障
    public static final String ERR_CODE_13 = "13";  //到达臂架安全边界
    public static final String ERR_CODE_14 = "14";  //没有零点标定
    public static final String ERR_CODE_15 = "15";  //线路故障
    public static final String ERR_CODE_16 = "16";  //臂架倾角传感器故障
    public static final String ERR_CODE_17 = "17";  //2臂臂架干涉
    public static final String ERR_CODE_18 = "18";  //3臂臂架干涉
    public static final String ERR_CODE_19 = "19";  //4臂臂架干涉
    public static final String ERR_CODE_20 = "20";  //5臂臂架干涉
    public static final String ERR_CODE_21 = "21";  //分动箱测速故障
    public static final String ERR_CODE_22 = "22";  //紧急停止
    public static final String ERR_CODE_23 = "23";  //超速故障
    public static final String ERR_CODE_24 = "24";  //臂架达到最远距离
    public static final String ERR_CODE_25 = "25";  //臂架未完全展开
    public static final String ERR_CODE_26 = "26";  //控制器1通信故障
    public static final String ERR_CODE_27 = "27";  //档位挂错
    public static final String ERR_CODE_28 = "28";  //升速故障
    public static final String ERR_CODE_29 = "29";  //压力传感器故障
    public static final String ERR_CODE_30 = "30";  //油位传感器故障
    public static final String ERR_CODE_31 = "31";  //分动箱润滑油压力低
    public static final String ERR_CODE_32 = "32";  //温度传感器故障
    public static final String ERR_CODE_33 = "33";  //控制器2通信故障
    public static final String ERR_CODE_34 = "34";  //控制器3通信故障
    public static final String ERR_CODE_35 = "35";  //显示屏故障
    public static final String ERR_CODE_36 = "36";  //支腿离地故障
    public static final String ERR_CODE_37 = "37";  //稳定受限，谨防倾翻
    public static final String ERR_CODE_38 = "38";  //1臂展开角度偏小，限制旋转角度
    public static final String ERR_CODE_39 = "39";  //偏离零位角度过大，禁止1臂下压
    public static final String ERR_CODE_40 = "40";  //水罐液位传感器故障
    public static final String ERR_CODE_41 = "41";  //请先展开6臂
    public static final String ERR_CODE_42 = "42";  //6臂臂架干涉
    public static final String ERR_CODE_43 = "43";  //自动收臂，请将1臂抬至70度
    public static final String ERR_CODE_44 = "44";  //6臂过收报警
    public static final String ERR_CODE_45 = "45";  //风力过大，请收回臂架，停止作业
    public static final String ERR_CODE_46 = "46";  //风速传感器故障
    public static final String ERR_CODE_47 = "47";  //泡沫罐液位传感器故障
    public static final String ERR_CODE_48 = "48";  //臂架靠近高压线警告
    public static final String ERR_CODE_49 = "49";  //臂架超温警告
    public static final String ERR_CODE_50 = "50";  //超声波传感器故障
    public static final String ERR_CODE_51 = "51";  //红外测温传感器故障

}
