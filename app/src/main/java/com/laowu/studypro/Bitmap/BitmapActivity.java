package com.laowu.studypro.Bitmap;

import android.app.Activity;
import android.content.res.AssetManager;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import com.laowu.studypro.R;

import java.io.IOException;
import java.io.InputStream;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by laowu on 2016/11/23.
 */
public class BitmapActivity extends Activity {
    @InjectView(R.id.image)
    ImageView image;
    @InjectView(R.id.next)
    Button next;

    private String[] images;
    private int currentImage = 0;
    private AssetManager asset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bitmap);
        ButterKnife.inject(this);

        init();
    }

    private void init() {
        try {
            asset = getAssets();
            images = asset.list("");
        } catch (IOException e) {
            e.printStackTrace();
            images = null;
        }
    }

    @OnClick(R.id.next)
    public void onClick() {
        if(images == null && images.length == 0) return;
        int length_limit = images.length - 1;
        if (currentImage > length_limit) {
            currentImage = 0;
        }
        while (!images[currentImage].endsWith(".jpg")
                && !images[currentImage].endsWith(".png")
                && !images[currentImage].endsWith(".gif")) {
            currentImage++;
            if(currentImage>length_limit) {
                currentImage = 0;
                break;
            }
        }
        InputStream assetFile = null;
        try {
            assetFile = asset.open(images[currentImage]);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(assetFile == null) {
            return;
        }
        currentImage++;
        BitmapDrawable bitmapDrawable = (BitmapDrawable)image.getDrawable();
        if(bitmapDrawable != null
            && !bitmapDrawable.getBitmap().isRecycled()) {
            bitmapDrawable.getBitmap().recycle();
        }
        image.setImageBitmap(BitmapFactory.decodeStream(assetFile));
    }
}
