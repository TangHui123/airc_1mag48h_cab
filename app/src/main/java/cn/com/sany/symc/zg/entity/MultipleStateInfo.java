package cn.com.sany.symc.zg.entity;

import java.io.Serializable;

/**
 *
 * 综合信息上传
 *
 * @auther bird
 * Created  2018/1/23 18:21
 */
public class MultipleStateInfo implements Serializable {
    private static final long serialVersionUID = 4995164430613254L;
    private  String turret_angle_negtive;//塔台转角正负

    private String arm_spread_status;        //臂展状态
    private String arm_shrink_status;        //臂收状态

//    泡沫罐液位标志bit[6:3]
//            0000:空罐； 0001:1/8罐；0010:2/8罐
//            0011:3/8罐；0100:4/8罐；0101:5/8罐
//            0110:6/8罐；0111:7/8罐；1000:满罐
    private String foam_level;

    private String  water_pump_status;    //水泵运行状态
    private String  turret_hit_status;    //塔台对中状态
    private String  dx_gn_state;    //倒吸功能状态
    private String  sp_pz_jc;    //水炮碰撞检测   （炮头碰撞预警）

//    水罐水位标志bit[5:2]
//            0000:空罐； 0001:1/8罐；0010:2/8罐
//            0011:3/8罐；0100:4/8罐；0101:5/8罐
//            0110:6/8罐；0111:7/8罐；1000:满罐
    private String  water_level;

//    private String turret_angle_low;   //转台角度L
//    private String turret_angle_high;   //转台角度H
    private float turret_angle;

//    private String engine_speed_low;   //发动机转速L
//    private String engine_speed_high;   //发动机转速H
    private int engine_speed;

    private String hydraulic_press;    //液压系统压力

//    private String pump_vent_press;    //水泵出口压力
    private float pump_vent_press;    //水泵出口压力

    private String err_code;   //错误代码

//    private String arm_angle1_low; //1#臂架角度L
//    private String arm_angle1_high; //1#臂架角度H
    private int arm_angle1;

//    private String arm_angle2_low; //2#臂架角度L
//    private String arm_angle2_high; //2#臂架角度H
    private int arm_angle2;

//    private String arm_angle3_low; //3#臂架角度L
//    private String arm_angle3_high; //3#臂架角度H
    private  int arm_angle3;

//    private String arm_angle4_low; //4#臂架角度L
//    private String arm_angle4_high; //4#臂架角度H
    private int arm_angle4;

//    private String arm_angle5_low; //5#臂架角度L
//    private String arm_angle5_high; //5#臂架角度H
    private int arm_angle5;

//    private String arm_angle6_low; //6#臂架角度L
//    private String arm_angle6_high; //6#臂架角度H
    private int arm_angle6;

//    private String water_flow_low;     //水流量L
//    private String water_flow_high;     //水流量H
    private int water_flow;

//    private String wind_speed_low;     //当前风速L
//    private String wind_speed_high;     //当前风速H
    private float wind_speed;

    private String battery_electricity;    //电池电量

    private int signal_strength;    //信号强度

    private String wireless_link_status;   //无线连接状态

    private int remote_ctrl_status;//遥控器状态

    private  int brightness;//屏幕亮度

    public MultipleStateInfo() {
    }

    public MultipleStateInfo(String turret_angle_negtive, String arm_spread_status, String arm_shrink_status, String foam_level, String water_pump_status, String turret_hit_status, String water_level,
                             float turret_angle, int engine_speed, String hydraulic_press,
                             float pump_vent_press, String err_code, int arm_angle1, int arm_angle2,
                             int arm_angle3, int arm_angle4, int arm_angle5, int arm_angle6, int water_flow, float wind_speed,
                             String battery_electricity, int signal_strength, String wireless_link_status, int remote_ctrl_status,
                             int brightness,String dx_gn_state,String sp_pz_jc) {
        this.turret_angle_negtive = turret_angle_negtive;
        this.arm_spread_status = arm_spread_status;
        this.arm_shrink_status = arm_shrink_status;
        this.foam_level = foam_level;
        this.water_pump_status = water_pump_status;
        this.turret_hit_status = turret_hit_status;
        this.water_level = water_level;
//        this.turret_angle_low = turret_angle_low;
//        this.turret_angle_high = turret_angle_high;
        this.turret_angle = turret_angle;
//        this.engine_speed_low = engine_speed_low;
//        this.engine_speed_high = engine_speed_high;
        this.engine_speed = engine_speed;
        this.hydraulic_press = hydraulic_press;
        this.pump_vent_press = pump_vent_press;
        this.err_code = err_code;
//        this.arm_angle1_low = arm_angle1_low;
//        this.arm_angle1_high = arm_angle1_high;
        this.arm_angle1 = arm_angle1;
//        this.arm_angle2_low = arm_angle2_low;
//        this.arm_angle2_high = arm_angle2_high;
        this.arm_angle2 = arm_angle2;
//        this.arm_angle3_low = arm_angle3_low;
//        this.arm_angle3_high = arm_angle3_high;
        this.arm_angle3 = arm_angle3;
//        this.arm_angle4_low = arm_angle4_low;
//        this.arm_angle4_high = arm_angle4_high;
        this.arm_angle4 = arm_angle4;
//        this.arm_angle5_low = arm_angle5_low;
//        this.arm_angle5_high = arm_angle5_high;
        this.arm_angle5 = arm_angle5;
//        this.arm_angle6_low = arm_angle6_low;
//        this.arm_angle6_high = arm_angle6_high;
        this.arm_angle6 = arm_angle6;
//        this.water_flow_low = water_flow_low;
//        this.water_flow_high = water_flow_high;
        this.water_flow = water_flow;
//        this.wind_speed_low = wind_speed_low;
//        this.wind_speed_high = wind_speed_high;
        this.wind_speed = wind_speed;
        this.battery_electricity = battery_electricity;
        this.signal_strength = signal_strength;
        this.wireless_link_status = wireless_link_status;
        this.remote_ctrl_status = remote_ctrl_status;
        this.brightness = brightness;
        this.dx_gn_state = dx_gn_state;
        this.sp_pz_jc = sp_pz_jc;
    }

    public  String getTurret_angle_negtive() {return  turret_angle_negtive;}

    public void setTurret_angle_negtive(String turret_angle_negtive){
        this.turret_angle_negtive = turret_angle_negtive;
    }

    public String getArm_spread_status() {
        return arm_spread_status;
    }

    public void setArm_spread_status(String arm_spread_status) {
        this.arm_spread_status = arm_spread_status;
    }

    public String getArm_shrink_status() {
        return arm_shrink_status;
    }

    public void setArm_shrink_status(String arm_shrink_status) {
        this.arm_shrink_status = arm_shrink_status;
    }

    public String getFoam_level() {
        return foam_level;
    }

    public void setFoam_level(String foam_level) {
        this.foam_level = foam_level;
    }

    public String getWater_pump_status() {
        return water_pump_status;
    }

    public void setWater_pump_status(String water_pump_status) {
        this.water_pump_status = water_pump_status;
    }

    public String getTurret_hit_status() {
        return turret_hit_status;
    }

    public void setTurret_hit_status(String turret_hit_status) {
        this.turret_hit_status = turret_hit_status;
    }

    public String getWater_level() {
        return water_level;
    }

    public void setWater_level(String water_level) {
        this.water_level = water_level;
    }

//    public String getTurret_angle_low() {
//        return turret_angle_low;
//    }
//
//    public void setTurret_angle_low(String turret_angle_low) {
//        this.turret_angle_low = turret_angle_low;
//    }
//
//    public String getTurret_angle_high() {
//        return turret_angle_high;
//    }
//
//    public void setTurret_angle_high(String turret_angle_high) {
//        this.turret_angle_high = turret_angle_high;
//    }
    public float getTurret_angle() {
        return turret_angle;
    }

    public void setTurret_angle(float turret_angle) {
       this.turret_angle = turret_angle;
    }

//    public String getEngine_speed_low() {
//        return engine_speed_low;
//    }
//
//    public void setEngine_speed_low(String engine_speed_low) {
//        this.engine_speed_low = engine_speed_low;
//    }
//
//    public String getEngine_speed_high() {
//        return engine_speed_high;
//    }
//
//    public void setEngine_speed_high(String engine_speed_high) {
//        this.engine_speed_high = engine_speed_high;
//    }

    public int getEngine_speed() {
        return engine_speed;
    }

    public void setEngine_speed(int engine_speed) {
        this.engine_speed = engine_speed;
    }

    public String getHydraulic_press() {
        return hydraulic_press;
    }

    public void setHydraulic_press(String hydraulic_press) {
        this.hydraulic_press = hydraulic_press;
    }

//    public String getPump_vent_press() {
//        return pump_vent_press;
//    }
//
//    public void setPump_vent_press(String pump_vent_press) {
//        this.pump_vent_press = pump_vent_press;
//    }

    public float getPump_vent_press() {
        return pump_vent_press;
    }

    public void setPump_vent_press(float pump_vent_press) {
        this.pump_vent_press = pump_vent_press;
    }

    public String getErr_code() {
        return err_code;
    }

    public void setErr_code(String err_code) {
        this.err_code = err_code;
    }

//    public String getArm_angle1_low() {
//        return arm_angle1_low;
//    }
//
//    public void setArm_angle1_low(String arm_angle1_low) {
//        this.arm_angle1_low = arm_angle1_low;
//    }
//
//    public String getArm_angle1_high() {
//        return arm_angle1_high;
//    }
//
//    public void setArm_angle1_high(String arm_angle1_high) {
//        this.arm_angle1_high = arm_angle1_high;
//    }
    public int getArm_angle1() {
        return arm_angle1;
    }
    public void setArm_angle1(int arm_angle1) {
        this.arm_angle1 = arm_angle1;
    }

//    public String getArm_angle2_low() {
//        return arm_angle2_low;
//    }
//
//    public void setArm_angle2_low(String arm_angle2_low) {
//        this.arm_angle2_low = arm_angle2_low;
//    }
//
//    public String getArm_angle2_high() {
//        return arm_angle2_high;
//    }
//
//    public void setArm_angle2_high(String arm_angle2_high) {
//        this.arm_angle2_high = arm_angle2_high;
//    }
    public int getArm_angle2() {
        return arm_angle2;
    }
    public void setArm_angle2(int arm_angle2) {
        this.arm_angle2 = arm_angle2;
    }

//    public String getArm_angle3_low() {
//        return arm_angle3_low;
//    }
//
//    public void setArm_angle3_low(String arm_angle3_low) {
//        this.arm_angle3_low = arm_angle3_low;
//    }
//
//    public String getArm_angle3_high() {
//        return arm_angle3_high;
//    }
//
//    public void setArm_angle3_high(String arm_angle3_high) {
//        this.arm_angle3_high = arm_angle3_high;
//    }
    public int getArm_angle3() {
        return arm_angle3;
    }
    public void setArm_angle3(int arm_angle3) {
        this.arm_angle3 = arm_angle3;
    }

//    public String getArm_angle4_low() {
//        return arm_angle4_low;
//    }
//
//    public void setArm_angle4_low(String arm_angle4_low) {
//        this.arm_angle4_low = arm_angle4_low;
//    }
//
//    public String getArm_angle4_high() {
//        return arm_angle4_high;
//    }
//
//    public void setArm_angle4_high(String arm_angle4_high) {
//        this.arm_angle4_high = arm_angle4_high;
//    }
    public int getArm_angle4() {
        return arm_angle4;
    }
    public void setArm_angle4(int arm_angle4) {
        this.arm_angle4 = arm_angle4;
    }

//    public String getArm_angle5_low() {
//        return arm_angle5_low;
//    }
//
//    public void setArm_angle5_low(String arm_angle5_low) {
//        this.arm_angle5_low = arm_angle5_low;
//    }
//
//    public String getArm_angle5_high() {
//        return arm_angle5_high;
//    }
//
//    public void setArm_angle5_high(String arm_angle5_high) {
//        this.arm_angle5_high = arm_angle5_high;
//    }
    public int getArm_angle5() {
        return arm_angle5;
    }
    public void setArm_angle5(int arm_angle5) {
        this.arm_angle5 = arm_angle5;
    }

//    public String getArm_angle6_low() {
//        return arm_angle6_low;
//    }
//
//    public void setArm_angle6_low(String arm_angle6_low) {
//        this.arm_angle6_low = arm_angle6_low;
//    }
//
//    public String getArm_angle6_high() {
//        return arm_angle6_high;
//    }
//
//    public void setArm_angle6_high(String arm_angle6_high) {
//        this.arm_angle6_high = arm_angle6_high;
//    }
    public int getArm_angle6() {
        return arm_angle6;
    }
    public void setArm_angle6(int arm_angle6) {
        this.arm_angle6 = arm_angle6;
    }

//    public String getWater_flow_low() {
//        return water_flow_low;
//    }
//
//    public void setWater_flow_low(String water_flow_low) {
//        this.water_flow_low = water_flow_low;
//    }
//
//    public String getWater_flow_high() {
//        return water_flow_high;
//    }
//
//    public void setWater_flow_high(String water_flow_high) {
//        this.water_flow_high = water_flow_high;
//    }
    public int getWater_flow() {
    return water_flow;
}
    public void setWater_flow(int water_flow) {
        this.water_flow = water_flow;
    }

//    public String getWind_speed_low() {
//        return wind_speed_low;
//    }
//
//    public void setWind_speed_low(String wind_speed_low) {
//        this.wind_speed_low = wind_speed_low;
//    }
//
//    public String getWind_speed_high() {
//        return wind_speed_high;
//    }
//
//    public void setWind_speed_high(String wind_speed_high) {
//        this.wind_speed_high = wind_speed_high;
//    }
    public float getWind_speed() {
    return wind_speed;
}
    public void setWind_speed(float wind_speed) {
        this.wind_speed = wind_speed;
    }

    public String getBattery_electricity() {
        return battery_electricity;
    }

    public void setBattery_electricity(String battery_electricity) {
        this.battery_electricity = battery_electricity;
    }

    public int getSignal_strength() {
        return signal_strength;
    }

    public void setSignal_strength(int signal_strength) {
        this.signal_strength = signal_strength;
    }

    public String getWireless_link_status() {
        return wireless_link_status;
    }

    public void setWireless_link_status(String wireless_link_status) {
        this.wireless_link_status = wireless_link_status;
    }

    public int getRemote_ctrl_status() {
        return remote_ctrl_status;
    }

    public void setRemote_ctrl_status(int remote_ctrl_status) {
        this.remote_ctrl_status = remote_ctrl_status;
    }

    public int getBrightness() {return brightness;}

    public void setBrightness(int brightness) {
        this.brightness = brightness;
    }

    public String getDx_gn_state() {
        return dx_gn_state;
    }

    public void setDx_gn_state(String dx_gn_state) {
        this.dx_gn_state = dx_gn_state;
    }

    public String getSp_pz_jc() {
        return sp_pz_jc;
    }

    public void setSp_pz_jc(String sp_pz_jc) {
        this.sp_pz_jc = sp_pz_jc;
    }

}







