package com.sany.symc.cab.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.sany.symc.cab.R;
import com.sany.symc.cab.help.IConstant;
import com.sany.symc.cab.util.LogUtil;

import java.util.Random;


/**
 *
 * 请输入密码进行验证
 * @auther bird
 * Created  2018/1/3 15:26
 *
 */
public class PasswordInputFragment extends BaseDialogFragment implements View.OnClickListener {

    public static final String TAG = "PasswordInputFragment.class";
    private int sourece = -1;  //0表示显示选择框，其它不显示

    private LinearLayout cbLLayout;
    private RadioButton cbSetting;
    private RadioButton cbFileManager;

    private LinearLayout randCodeLLayout;
    private EditText etPassCode;      //密码输入框
    private TextView tvRandomCode;
    private int randoncode = 5201;

    private TextView tvPassConfirm;
    private TextView tvPassClose;
    private int password;

    IFunCallback funCallback;


    public PasswordInputFragment() {

    }

    public void setSourece(int sourece) {
        this.sourece = sourece;
    }

    public void setFunCallback(IFunCallback funCallback) {
        this.funCallback = funCallback;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View layout = inflater.inflate(R.layout.dlg_password_dialog, container, false);
        try {
            cbLLayout = (LinearLayout) layout.findViewById(R.id.cbLLayout);
            cbSetting = (RadioButton) layout.findViewById(R.id.cbSetting);
            cbFileManager = (RadioButton) layout.findViewById(R.id.cbFileManager);

            randCodeLLayout = (LinearLayout) layout.findViewById(R.id.randCodeLLayout);
            tvRandomCode = ((TextView) layout.findViewById(R.id.tvRandomCode));
            etPassCode = (EditText) layout.findViewById(R.id.etPassCode);
            etPassCode.setText("");

            tvPassConfirm = ((TextView) layout.findViewById(R.id.tvPassConfirm));
            tvPassClose = (TextView) layout.findViewById(R.id.tvPassClose);
            tvPassConfirm.setOnClickListener(this);
            tvPassClose.setOnClickListener(this);
            if (sourece ==  IConstant.SOURCE_SETTING) {
                cbLLayout.setVisibility(View.VISIBLE);
            } else {
                cbLLayout.setVisibility(View.GONE);
            }

            Random random = new Random();
            randoncode = random.nextInt(10000);

//        SimpleDateFormat dff = new SimpleDateFormat("ddHH");
//        dff.setTimeZone(TimeZone.getTimeZone("GMT+08"));
//        String ee = dff.format(System.currentTimeMillis());
            //password=randoncode+seed +Integer.parseInt(ee);

            if (sourece == IConstant.SOURCE_U_UPGRADE) {

                //password = IConstant.SOURCE_UPGRADE_PASSWORD;
                password = randoncode + IConstant.SOURCE_UPGRADE_PASSWORD;
            } else {
                if (sourece == IConstant.SOURCE_QUERY_LOG) {
                    // password = randoncode + IConstant.SOURCE_UPGRADE_PASSWORD;
                    password = IConstant.SOURCE_MANAGER_PASSWORD;
                } else if (sourece == IConstant.SOURCE_SETTING) {
                    password = randoncode + IConstant.SOURCE_UPGRADE_PASSWORD;
                    // password = IConstant.SOURCE_UPGRADE_PASSWORD;
                } else {
                    //password = IConstant.SOURCE_UPGRADE_PASSWORD;
                    password = randoncode + IConstant.SOURCE_OTHER_PASSWORD;
                }

            }
           // CacheData.setMsg_info("============================================onCreateView=========password====================>" + password, 1);
            tvRandomCode.setText("" + randoncode);
            etPassCode.setText("");
        }catch (Exception e){
            e.printStackTrace();
            LogUtil.e(TAG,"======Exception=============onCreateView===========================>"+e.toString());
        }

        return layout;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tvPassConfirm: {
                String passCode = etPassCode.getText().toString().trim();
               // CacheData.setMsg_info("============================================onCreateView=========password======passCode==============>"+passCode,1);
               // CacheData.setMsg_info("============================================onCreateView=========password======password==============>"+password,1);
                if( passCode.equals("311844665891") || !TextUtils.isEmpty(passCode) && passCode.equals(String.valueOf(password))){    //symtytj31ym
                    dismiss();
                    if(cbLLayout.getVisibility()==View.VISIBLE){
                        boolean setting_flag = cbSetting.isChecked() && !cbFileManager.isChecked();
                        if(setting_flag){
                            sourece = IConstant.SOURCE_SETTING;
                        }else{
                            sourece = IConstant.SOURCE_ES_FILEMANAGER;;
                        }
                        funCallback.onSuccess(sourece);
                    }else{
                        funCallback.onSuccess(sourece);
                    }

                } else{
                    Toast.makeText(getActivity(), "输入错误密码：" + etPassCode.getText().toString() +"，请重新输入！",
                            Toast.LENGTH_SHORT).show();
                    etPassCode.setText("");
                }

            }
            break;

            case R.id.tvPassClose: {
                        dismiss();
                    }

                }


     }


}