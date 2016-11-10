package com.laowu.studypro.Main;

import com.laowu.studypro.AdapterViewFlipper.AdapterViewFilpperActivity;
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
        return items;
    }
}
