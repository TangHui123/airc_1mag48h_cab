package cn.com.sany.symc.zg.entity;

import java.io.Serializable;
import java.util.Date;


/**
 *
 * 接口下发数据备份、同步接口、视频接口、不成功再下发一次
 * @auther bird
 * Created  2018/1/23 18:43
 *
 */
public class DownDataEntity implements Serializable {
    private static final long serialVersionUID = 234936221212254L;
    private byte command;              //命令字
    private byte serial_id;            //流水号
    private Date time;                   //发送时间

    public DownDataEntity() {

    }

    public DownDataEntity(byte command, byte serial_id, Date time) {
        this.command = command;
        this.serial_id = serial_id;
        this.time = time;
    }

    public byte getCommand() {
        return command;
    }

    public void setCommand(byte command) {
        this.command = command;
    }

    public byte getSerial_id() {
        return serial_id;
    }

    public void setSerial_id(byte serial_id) {
        this.serial_id = serial_id;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

}

