package com.custom.cc.custompieview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by CC on 2018/3/21.
 */

public class PieView extends View {
    // 颜色表 (注意: 此处定义颜色使用的是ARGB，带Alpha通道的)
    private int[] mColors = {0xFFCCFF00, 0xFF6495ED, 0xFFE32636, 0xFF800000, 0xFF808000, 0xFFFF8C69, 0xFF808080,
            0xFFE6B800, 0xFF7CFC00};
    // 饼状图初始绘制角度
    private float mStartAngle = 0;
    // 数据
    private ArrayList<PieData> mData;
    // 宽高
    private int mWidth, mHeight;
    // 画笔
    private Paint mPaint = new Paint();
    private Paint mPaint2;

    public PieView(Context context) {
        this(context, null);
    }

    public PieView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView();

    }

    private void initView() {
        //初始化画笔
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setAntiAlias(true);
    }

//    @Override
//    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
//        setMeasuredDimension(MeasureSpec.getSize(widthMeasureSpec),MeasureSpec.getSize(heightMeasureSpec));
//    }

    //获取初始的view的宽高
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = w;
        mHeight = h;
        Log.d("xxx","mWidth=="+mWidth+"mHeight="+mHeight);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (mData == null) {
            return;
        }
        //获取当前的开始角度
        float currentStartAngle = mStartAngle;
        //把画布的坐标系移动到圆心的位置
        canvas.translate(mWidth / 2, mHeight / 2);
        //设置饼图的半径
        float r = (float) (Math.min(mHeight, mWidth) / 2 * 0.8);
        //设置饼图的外接矩形
        RectF rectF = new RectF(-r, -r, r, r);

        //对传递进来的数据进行取值
        for (PieData datum : mData) {
            mPaint.setColor(datum.getColor());
            //画弧形
            canvas.drawArc(rectF, currentStartAngle, datum.getAngle(), true, mPaint);
            //每次画完一个饼图就把初始角度重新赋值叠加
            currentStartAngle += datum.getAngle();
        }

    }

    public void setData(ArrayList<PieData> data) {
        this.mData = data;
        //对数据进行赋值
        initData();
        invalidate();
    }

    private void initData() {
        if (mData == null) {
            return;
        }
        float sumValue = 0;
        for (int i = 0; i < mData.size(); i++) {
            PieData pieData = mData.get(i);
            //计算饼图总数组
            sumValue += pieData.getValue();
            //给饼图赋值颜色(创建随机的颜色)
            int j = i % mColors.length;
            pieData.setColor(mColors[j]);

        }
        float sumAngle = 0;
        for (int i = 0; i < mData.size(); i++) {
            PieData pieData = mData.get(i);
            //给饼图赋值百分比
            pieData.setPercent(pieData.getValue() / sumValue);
            //计算每个饼图的角度
            pieData.setAngle(pieData.getPercent() * 360);
            //计算所有饼图的角度
            sumAngle += pieData.getAngle();
        }
    }

}
