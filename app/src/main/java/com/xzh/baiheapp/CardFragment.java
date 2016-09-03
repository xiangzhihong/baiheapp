package com.xzh.baiheapp;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xzh.baiheapp.entity.CardDataEntity;
import com.xzh.baiheapp.utils.CardSlidePanel;


public class CardFragment extends Fragment {

    private CardSlidePanel.CardSwitchListener cardSwitchListener;

    private int imagePaths[] = {R.drawable.wall01,
            R.drawable.wall02, R.drawable.wall03,
            R.drawable.wall04, R.drawable.wall05,
            R.drawable.wall06, R.drawable.wall07,
            R.drawable.wall08, R.drawable.wall09,
            R.drawable.wall10, R.drawable.wall11,
            R.drawable.wall12, R.drawable.wall01,
            R.drawable.wall02, R.drawable.wall03,
            R.drawable.wall04, R.drawable.wall05,
            R.drawable.wall06, R.drawable.wall07,
            R.drawable.wall08, R.drawable.wall09,
            R.drawable.wall10, R.drawable.wall11,
            R.drawable.wall12};

    private String names[] = {"郭富城", "刘德华", "张学友", "李连杰", "成龙", "谢霆锋", "李易峰",
            "霍建华", "胡歌", "曾志伟", "吴孟达", "梁朝伟", "周星驰", "赵本山", "郭德纲", "周润发", "邓超",
            "王祖蓝", "王宝强", "黄晓明", "张卫健", "徐峥", "李亚鹏", "郑伊健"};

    private List<CardDataEntity> dataList = new ArrayList<CardDataEntity>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.card_layout, null);
        initView(rootView);
        return rootView;
    }

    private void initView(View rootView) {
        CardSlidePanel slidePanel = (CardSlidePanel) rootView
                .findViewById(R.id.image_slide_panel);
        cardSwitchListener = new CardSlidePanel.CardSwitchListener() {

            @Override
            public void onShow(int index) {
                Log.d("CardFragment", "正在显示-" + dataList.get(index).userName);
            }

            @Override
            public void onCardVanish(int index, int type) {
                Log.d("CardFragment", "正在消失-" + dataList.get(index).userName + " 消失type=" + type);
            }

            @Override
            public void onItemClick(View cardView, int index) {
                Log.d("CardFragment", "卡片点击-" + dataList.get(index).userName);
            }
        };
        slidePanel.setCardSwitchListener(cardSwitchListener);

        prepareDataList();
        slidePanel.setData(dataList);
    }

    private void prepareDataList() {
        int num = imagePaths.length;

        for (int j = 0; j < 3; j++) {
            for (int i = 0; i < num; i++) {
                CardDataEntity dataItem = new CardDataEntity();
                dataItem.userName = names[i];
                dataItem.imagePath = imagePaths[i];
                dataItem.likeNum = (int) (Math.random() * 10);
                dataItem.imageNum = (int) (Math.random() * 6);
                dataList.add(dataItem);
            }
        }
    }

}
