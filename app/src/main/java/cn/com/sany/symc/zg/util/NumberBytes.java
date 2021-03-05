package cn.com.sany.symc.zg.util;


import java.nio.ByteBuffer;
import java.util.ArrayList;

public class NumberBytes {
//2bytes change to char
    public static char bytesToChar(byte[] b) {
        char c = (char) ((b[0] << 8) & 0xFF00L);
        c |= (char) (b[1] & 0xFFL);
        return c;
    }


    public static double bytesToDouble(byte[] b) {
        return Double.longBitsToDouble(bytesToLong(b));
    }


    public static float bytesToFloat(byte[] b) {
        return Float.intBitsToFloat(bytesToInt(b));
    }


    public static int bytesToInt(byte[] b) {
        int i = (b[0] << 24) & 0xFF000000;
        i |= (b[1] << 16) & 0xFF0000;
        i |= (b[2] << 8) & 0xFF00;
        i |= b[3] & 0xFF;
        return i;
    }
    public static int bytesToIntLow(byte[] b) {
        int i = (b[3] << 24) & 0xFF000000;
        i |= (b[2] << 16) & 0xFF0000;
        i |= (b[1] << 8) & 0xFF00;
        i |= b[0] & 0xFF;
        return i;
    }
    public static int TwobytesToInt(byte[] b) {//���ģʽ
        int i = (b[0] << 8) & 0xFF00;
        i |= b[1] & 0xFF;
        return i;
    }

    public static long bytesToLong(byte[] b) {
        long l = ((long) b[0] << 56) & 0xFF00000000000000L;

        l |= ((long) b[1] << 48) & 0xFF000000000000L;
        l |= ((long) b[2] << 40) & 0xFF0000000000L;
        l |= ((long) b[3] << 32) & 0xFF00000000L;
        l |= ((long) b[4] << 24) & 0xFF000000L;
        l |= ((long) b[5] << 16) & 0xFF0000L;
        l |= ((long) b[6] << 8) & 0xFF00L;
        l |= (long) b[7] & 0xFFL;
        return l;
    }


    public static byte[] charToBytes(char c) {
        byte[] b = new byte[8];
        b[0] = (byte) (c >>> 8);
        b[1] = (byte) c;
        return b;
    }


    public static byte[] doubleToBytes(double d) {
        return longToBytes(Double.doubleToLongBits(d));
    }


    public static byte[] floatToBytes(float f) {
        return intToBytes(Float.floatToIntBits(f));
    }


    public static byte[] intToBytes(int i) {
        byte[] b = new byte[4];
        b[0] = (byte) (i >>> 24);
        b[1] = (byte) (i >>> 16);
        b[2] = (byte) (i >>> 8);
        b[3] = (byte) i;
        return b;
    }
    public static byte[] intTo2Bytes(int i) {
        byte[] b = new byte[2];
        b[0] = (byte) (i >>> 8);
        b[1] = (byte) i;
        return b;
    }

    public  static byte[] arrayListToBytes(ArrayList al)
    {
        byte[] b = new byte[al.size()];
        for(int i=0;i<al.size();i++)
        {
            b[i]=(byte)al.get(i);
        }
        return b;
    }
    public static byte[] longToBytes(long l) {
        byte[] b = new byte[8];
        b[0] = (byte) (l >>> 56);
        b[1] = (byte) (l >>> 48);
        b[2] = (byte) (l >>> 40);
        b[3] = (byte) (l >>> 32);
        b[4] = (byte) (l >>> 24);
        b[5] = (byte) (l >>> 16);
        b[6] = (byte) (l >>> 8);
        b[7] = (byte) (l);
        return b;
    }


    private static ByteBuffer buffer = ByteBuffer.allocate(8);

    public static void main(String[] args) {

        //测试 int 转 byte
        int int0 = 234;
        byte byte0 = intToByte(int0);
        System.out.println("byte0=" + byte0);//byte0=-22
        //测试 byte 转 int
        int int1 = byteToInt(byte0);
        System.out.println("int1=" + int1);//int1=234



        //测试 int 转 byte 数组
        int int2 = 1417;
        byte[] bytesInt = intToByteArray(int2);
        System.out.println("bytesInt=" + bytesInt);//bytesInt=[B@de6ced
        //测试 byte 数组转 int
        int int3 = byteArrayToInt(bytesInt);
        System.out.println("int3=" + int3);//int3=1417


        //测试 long 转 byte 数组
        long long1 = 2223;
        byte[] bytesLong = longToBytes(long1);
        System.out.println("bytes=" + bytesLong);//bytes=[B@c17164
        //测试 byte 数组 转 long
        long long2 = bytesToLong(bytesLong);
        System.out.println("long2=" + long2);//long2=2223
    }


    //byte 与 int 的相互转换
    public static byte intToByte(int x) {
        return (byte) x;
    }

    public static int byteToInt(byte b) {
        //Java 总是把 byte 当做有符处理；我们可以通过将其和 0xFF 进行二进制与得到它的无符值
        return b & 0xFF;
    }

    //byte 数组与 int 的相互转换
    public static int byteArrayToInt(byte[] b) {
        return   b[3] & 0xFF |
                (b[2] & 0xFF) << 8 |
                (b[1] & 0xFF) << 16 |
                (b[0] & 0xFF) << 24;
    }

    public static byte[] intToByteArray(int a) {
        return new byte[] {
                (byte) ((a >> 24) & 0xFF),
                (byte) ((a >> 16) & 0xFF),
                (byte) ((a >> 8) & 0xFF),
                (byte) (a & 0xFF)
        };
    }

    /**
     * 二进制字符串转byte
     */
    public static byte decodeBinaryString(String byteStr) {
        int re, len;
        if (null == byteStr) {
            return 0;
        }
        len = byteStr.length();
        if (len != 4 && len != 8) {
            return 0;
        }
        if (len == 8) {// 8 bit处理
            if (byteStr.charAt(0) == '0') {// 正数
                re = Integer.parseInt(byteStr, 2);
            } else {// 负数
                re = Integer.parseInt(byteStr, 2) - 256;
            }
        } else {// 4 bit处理
            re = Integer.parseInt(byteStr, 2);
        }
        return (byte) re;
    }

    /**
     *
     * 日期格式字符串转成BCD[6]的byte[]
     *
     */
    public static byte[] timeToBCD(String time){
        byte[] bcd = ASCII_To_BCD(time.getBytes(), time.length());
        return bcd;
    }

    private static byte[] ASCII_To_BCD(byte[] ascii, int asc_len) {
        byte[] bcd= new byte[asc_len / 2];
        if(asc_len%2==1)
            bcd = new byte[(asc_len+1) / 2];
        int j = 0;
        for (int i = 0; i < bcd.length; i++) {
            bcd[i] = asc_to_bcd(ascii[j++]);
            bcd[i] = (byte) (((j >= asc_len) ? 0x00 : asc_to_bcd(ascii[j++])) + (bcd[i] << 4));
        }
        return bcd;
    }

    private static byte asc_to_bcd(byte asc) {
        byte bcd;

        if ((asc >= '0') && (asc <= '9'))
            bcd = (byte) (asc - '0');
        else if ((asc >= 'A') && (asc <= 'F'))
            bcd = (byte) (asc - 'A' + 10);
        else if ((asc >= 'a') && (asc <= 'f'))
            bcd = (byte) (asc - 'a' + 10);
        else
            bcd = (byte) (asc - 48);
        return bcd;
    }

    
    public static byte getXor(byte[] datas){

        byte temp=datas[0];

        for (int i = 1; i <datas.length -1; i++) {
            temp ^=datas[i];
        }

        return temp;
    }

    /**
     * 不包括校验位的datas里面的实际长度
     * @param datas   里面存储的需要校验的实际数据
     * @param length:datas 里面存储的需要校验的实际数据长度
     * @return
     *
     */
    public static byte getXorByte(byte[] datas,int length){

        byte temp=datas[0];
        if(length<datas.length){
            for (int i = 1; i < length; i++) {
                temp ^=datas[i];
            }
        }

        return temp;
    }



    /**
     *
     * 字节数组节转换成二进制字符串
     * @param byteArray
     * @return
     *
     */
    public static String byteArrayToBinaryString(byte[] byteArray) {
        String str = "";
        for (int i = 0; i < byteArray.length; i++)
        {
            str = str + Integer.toBinaryString(byteArray[i] & 0xFF).toUpperCase() + ",";

        }
        return str.toString();
    }


    /**
     *
     * 字节数组转换成十六进制字符串
     * @param byteArray
     * @return
     *
     */
    public static String byteArrayToHexStr(byte[] byteArray){
        String h = "";
        for(int i = 0; i < byteArray.length; i++){
            String temp = Integer.toHexString(byteArray[i] & 0xFF).toUpperCase();
            if(temp.length() == 1){
                temp = "(byte)0x0" + temp;
            }else{
                temp = "(byte)0x" + temp;
            }
            h = h + ","+ temp;
        }

        return h;
    }

    /**
     *
     * 字节数组转换成十六进制字符串
     * @param byteArray
     * @return
     *
     */
    public static String byteArrayToHexstr(byte[] byteArray,int length){
        String h = "";
        for(int i = 0; i < length; i++){
            String temp = Integer.toHexString(byteArray[i] & 0xFF).toUpperCase();
            if(temp.length() == 1){
                temp = "0x0" + temp;
            }else{
                temp = "0x" + temp;
            }
            h = h + "="+ temp;
        }

        return h.toUpperCase();
    }



}