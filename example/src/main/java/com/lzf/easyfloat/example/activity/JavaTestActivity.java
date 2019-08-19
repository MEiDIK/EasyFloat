package com.lzf.easyfloat.example.activity;

import android.app.Activity;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;

import com.lzf.easyfloat.EasyFloat;
import com.lzf.easyfloat.anim.AppFloatDefaultAnimator;
import com.lzf.easyfloat.anim.DefaultAnimator;
import com.lzf.easyfloat.enums.ShowPattern;
import com.lzf.easyfloat.enums.SidePattern;
import com.lzf.easyfloat.example.R;
import com.lzf.easyfloat.interfaces.OnFloatCallbacks;
import com.lzf.easyfloat.permission.PermissionUtils;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * @author: liuzhenfeng
 * @function: Java兼容性测试
 * @date: 2019-08-15  18:38
 */
public class JavaTestActivity extends Activity {

    private void test() {

        EasyFloat.with(this)
                // 设置浮窗xml布局文件
                .setLayout(R.layout.float_app)
                // 设置浮窗显示类型，默认只在当前Activity显示，可选一直显示、仅前台显示
                .setShowPattern(ShowPattern.ALL_TIME)
                // 设置吸附方式，共15种模式，详情参考SidePattern
                .setSidePattern(SidePattern.RESULT_HORIZONTAL)
                // 设置浮窗的标签，用于区分多个浮窗
                .setTag("testFloat")
                // 设置浮窗是否可拖拽
                .setDragEnable(true)
                // 设置浮窗固定坐标，ps：设置固定坐标，Gravity属性和offset属性将无效
                .setLocation(100, 200)
                // 设置浮窗的对齐方式和坐标偏移量
                .setGravity(Gravity.END | Gravity.CENTER_VERTICAL, 0, 200)
                // 设置宽高是否充满父布局，直接在xml设置match_parent属性无效
                .setMatchParent(false, false)
                // 设置Activity浮窗的出入动画，可自定义，实现相应接口即可（策略模式），无需动画直接设置为null
                .setAnimator(new DefaultAnimator())
                // 设置系统浮窗的出入动画，使用同上
                .setAppFloatAnimator(new AppFloatDefaultAnimator())
                // 设置系统浮窗的不需要显示的页面
                .setFilter(MainActivity.class, SecondActivity.class)
                // 设置我们传入xml布局的详细信息
                .invokeView(floatingView -> {

                })
                // 浮窗的一些状态回调，如：创建结果、显示、隐藏、销毁、touchEvent、拖拽过程、拖拽结束。
                .registerCallbacks(new OnFloatCallbacks() {
                    @Override
                    public void createdResult(boolean isCreated, @Nullable String msg, @Nullable View view) {

                    }

                    @Override
                    public void show(@NotNull View view) {

                    }

                    @Override
                    public void hide(@NotNull View view) {

                    }

                    @Override
                    public void dismiss() {

                    }

                    @Override
                    public void touchEvent(@NotNull View view, @NotNull MotionEvent event) {

                    }

                    @Override
                    public void drag(@NotNull View view, @NotNull MotionEvent event) {

                    }

                    @Override
                    public void dragEnd(@NotNull View view) {

                    }
                })
                // 创建浮窗（这是关键哦😂）
                .show();


        // 测试方法重载
        EasyFloat.setDragEnable(this,false);

        PermissionUtils.checkPermission(this);

    }

}
