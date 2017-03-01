package com.laowu.studypro.Main;

import com.laowu.studypro.ActionBar.ActionBarActivity;
import com.laowu.studypro.AdapterViewFlipper.AdapterViewFilpperActivity;
import com.laowu.studypro.Bitmap.BitmapActivity;
import com.laowu.studypro.Matrix.MatrixActivity;
import com.laowu.studypro.Matrix.MoveBackgroundActivity;
import com.laowu.studypro.StackView.StackViewActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by laowu on 2016/11/10.
 */
public class MainListItemManager {
    public static List<MainListItem> getListItem() {
        List<MainListItem> items = new ArrayList<MainListItem>();
        MainListItem item;
        item = new MainListItem("StackViewActivity", "view切换含有切换动画", StackViewActivity.class);
        items.add(item);

        item = new MainListItem("AdapterViewFlipper", "view切换含有切换动画", AdapterViewFilpperActivity.class);
        items.add(item);

        item = new MainListItem("ActionBar", "ActionBar的显示与隐藏", ActionBarActivity.class);
        items.add(item);

        item = new MainListItem("Bitmap", "bitmap的相关操作", BitmapActivity.class);
        items.add(item);

        item = new MainListItem("Matrix", "图形的平移、旋转、缩放、倾斜", MatrixActivity.class);
        items.add(item);

        item = new MainListItem("Matrix", "背景的移动", MoveBackgroundActivity.class);
        items.add(item);
        return items;
    }
}
