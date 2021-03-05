package cn.com.sany.symc.zg.ui.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import java.lang.ref.WeakReference;
import java.util.Timer;
import java.util.TimerTask;

import cn.com.sany.symc.zg.R;
import cn.com.sany.symc.zg.help.IConstant;
import cn.com.sany.symc.zg.util.CacheData;


/**
 *
 * 日志消息
 * @auther bird
 * Created  2018/1/3 15:26
 *
 */
public class MessageShowFragment extends BaseDialogFragment implements View.OnClickListener {

    public static final String TAG = "MessageShowFragment.class";
    private TextView textview1;
    //private String msg = "";
    private TextView tvClose;
    private Timer timer = new Timer();
    private TimerTask timerTask;
    private TextView tvTitle;

    IFunCallback funCallback;

    Handler mHandler = new MyHandler(this);

//    public void setMsg(String receiverData) {
//        if(!TextUtils.isEmpty(msg)){
//            if(msg.length()>20000){
//                msg = msg.substring(msg.length()-18000,msg.length());
//            }
//            msg = msg + "\n" + CommUtil.getData() + "=============>" + receiverData;
//        }else{
//            msg =  receiverData;
//        }
//
//    }

    public void showMsgInfo() {
        if(textview1!=null){
            textview1.setText("   " + CacheData.getMsg_info());
        }

    }

    public MessageShowFragment() {

    }

    public void setFunCallback(IFunCallback funCallback) {
        this.funCallback = funCallback;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.dlg_message_show_dialog, container, false);
        try {
            textview1 = ((TextView) layout.findViewById(R.id.message));
            tvClose = (TextView) layout.findViewById(R.id.tvClose);
            tvTitle = (TextView) layout.findViewById(R.id.tvTitle);
            tvClose.setOnClickListener(this);

            if (timerTask != null) {
                timerTask.cancel();  //将原任务从队列中移除
            }
            timerTask = getTimeTask();
            timer = new Timer();
            timer.schedule(timerTask, 0, 1000);
        }catch (Exception e){
            e.printStackTrace();
           // LogUtil.e(TAG,"===================onCreateView===========================>"+e.toString());
        }

        return layout;
    }

    private TimerTask getTimeTask(){

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                try{
                    Message message = new Message();
                    message.what= IConstant.UPDATE_SHOW_INFO;
                    mHandler.sendMessage(message);

                }catch (Exception e){
                   // LogUtil.e(TAG,"===================TimerTask===========================>"+e.toString());
                    e.printStackTrace();
                }


            }
        };

        return task;

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tvClose: {
                dismiss();
                timer.cancel();
            }
            break;

        }

    }

    class MyHandler extends Handler {
        private WeakReference<MessageShowFragment> ref;

        public MyHandler(MessageShowFragment ac) {
            ref = new WeakReference<>(ac);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (ref.get() == null) {
                return;
            }

            try {

                switch (msg.what) {
                    //日志信息显示70行，超过把之前的写入日志文件
                    case IConstant.UPDATE_SHOW_INFO: {
                        showMsgInfo();
                    }
                    break;
                }
            }catch (Exception e){
                e.printStackTrace();
            }

        }
    }



}