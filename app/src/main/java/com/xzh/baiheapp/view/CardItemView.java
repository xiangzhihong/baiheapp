package com.xzh.baiheapp.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.xzh.baiheapp.R;
import com.xzh.baiheapp.entity.CardDataEntity;

@SuppressLint("NewApi")
public class CardItemView extends LinearLayout {

    private Context mContext=null;

    public ImageView imageView;
    private TextView userNameTv;
    private TextView imageNumTv;
    private TextView likeNumTv;

    public CardItemView(Context context) {
        this(context, null);
        this.mContext=context;
    }

    public CardItemView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        this.mContext=context;
    }

    public CardItemView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        inflate(context, R.layout.item_card, this);
        imageView = (ImageView) findViewById(R.id.card_image_view);
        userNameTv = (TextView) findViewById(R.id.card_user_name);
        imageNumTv = (TextView) findViewById(R.id.card_pic_num);
        likeNumTv = (TextView) findViewById(R.id.card_like);
    }

    public void fillData(CardDataEntity itemData) {
        Glide.with(mContext).load(itemData.imagePath).into(imageView);
        userNameTv.setText(itemData.userName);
        imageNumTv.setText(itemData.imageNum + "");
        likeNumTv.setText(itemData.likeNum + "");
    }
}
