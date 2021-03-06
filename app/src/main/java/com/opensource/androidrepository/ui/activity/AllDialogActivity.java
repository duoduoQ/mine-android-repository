package com.opensource.androidrepository.ui.activity;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.opensource.androidrepository.R;
import com.opensource.androidrepository.ui.custom.CommomDialog;
import com.opensource.androidrepository.ui.custom.MenuPopupWindow;
import com.opensource.androidrepository.ui.custom.ShareDialog;
import com.opensource.androidrepository.util.Utils;

public class AllDialogActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_dialog);
        initView();
    }

    private void initView(){
        setTitle("弹窗");

        findViewById(R.id.txt).setOnClickListener(this);
        findViewById(R.id.share).setOnClickListener(this);
        menu =(TextView)findViewById(R.id.menu);
        menu.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.txt:
                //弹出提示框
                new CommomDialog(this, R.style.dialog, "您确定删除此信息？", new CommomDialog.OnCloseListener() {
                    @Override
                    public void onClick(Dialog dialog, boolean confirm) {
                        if(confirm){
                            Toast.makeText(AllDialogActivity.this,"点击确定", Toast.LENGTH_SHORT).show();
                            dialog.dismiss();
                        }

                    }
                })
                        .setTitle("提示").show();
                break;
            case R.id.menu:
                MenuPopupWindow menuPopupWindow = new MenuPopupWindow(this, new MenuPopupWindow.OnItemClickListener() {
                    @Override
                    public void onItemClick(PopupWindow popupWindow, int position) {

                        popupWindow.dismiss();
                    }
                });
                menuPopupWindow.showAsDropDown(menu, -200, 40);
                break;
            case R.id.share:
                new ShareDialog(AllDialogActivity.this, R.style.dialog, new ShareDialog.OnItemClickListener() {
                    @Override
                    public void onClick(Dialog dialog, int position) {
                        dialog.dismiss();
                        switch (position){
                            case 1:
                                Utils.toast(AllDialogActivity.this,"微信好友");
                                break;
                            case 2:
                                Utils.toast(AllDialogActivity.this,"朋友圈");
                                break;
                            case 3:
                                Utils.toast(AllDialogActivity.this,"QQ");
                                break;
                            case 4:
                                Utils.toast(AllDialogActivity.this,"微博");
                                break;
                        }
                    }
                }).show();
                break;
        }
    }



}
