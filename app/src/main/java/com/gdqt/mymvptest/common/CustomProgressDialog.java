package com.gdqt.mymvptest.common;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.gdqt.mymvptest.R;


public class CustomProgressDialog extends Dialog {
    public CustomProgressDialog(Context context, CancelLoadingListener cancelLoadingListener) {
        super(context, R.style.transparent_dialog);
        createLoadingDialog(context, cancelLoadingListener);
    }

    public void createLoadingDialog(final Context context, final CancelLoadingListener cancelLoadingListener) {

        setContentView(R.layout.layout_progressbar);//loading的xml文件
        final WindowManager.LayoutParams params = getWindow().getAttributes();
        params.width = WindowManager.LayoutParams.WRAP_CONTENT;
        params.height = WindowManager.LayoutParams.WRAP_CONTENT;
        getWindow().setAttributes(params);
        //设置不可通过点击外面区域取消
        setCanceledOnTouchOutside(false);

        //设置监听事件
        setOnCancelListener(new OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
                if (cancelLoadingListener != null)
                    cancelLoadingListener.cancelLoding();
            }
        });


    }

}
