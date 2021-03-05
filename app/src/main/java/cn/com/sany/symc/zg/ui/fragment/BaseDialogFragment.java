package cn.com.sany.symc.zg.ui.fragment;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.Window;

/**
 * Created by Administrator on 2016/1/6.
 */
public class BaseDialogFragment extends DialogFragment {
    protected boolean mIsCancelable = true;

    protected int mScreenWidth = 0;
    protected int mScreenHeight = 0;

    private DialogInterface.OnCancelListener mListener;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mScreenWidth = getResources().getDisplayMetrics().widthPixels;
        mScreenHeight = getResources().getDisplayMetrics().heightPixels;

    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        /**
         * 你唯一可能会覆盖这个方法的原因就是当使用onCreateView()去修改任意Dialog特点的时候。例如，
         * dialog都有一个默认的标题，但是使用者可能不需要它。因此你可以去掉标题，但是你必须调用父类去获得Dialog。
         */
        setCancelable(mIsCancelable);
        Dialog dialog = super.onCreateDialog(savedInstanceState);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        dialog.setCanceledOnTouchOutside(mIsCancelable);
        dialog.setCancelable(mIsCancelable);
        if(mListener != null) {
            dialog.setOnCancelListener(mListener);
        }
        return dialog;
    }

    @Override
    public void onResume() {
        super.onResume();

        //宽度填满全屏,高度不变
        getDialog().getWindow().setLayout(mScreenWidth-300,
                getDialog().getWindow().getAttributes().height);
    }

    public void setOnCancelListener(final DialogInterface.OnCancelListener listener) {
        mListener = listener;
    }

    @Override
    public void onCancel(DialogInterface dialogInterface) {
        if(mListener != null) {
            mListener.onCancel(dialogInterface);
        }else{
            super.onCancel(dialogInterface);
        }
    }

    @Override
    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
    }
}
