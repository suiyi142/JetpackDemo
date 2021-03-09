package com.example.databindingdemo;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;
import androidx.databinding.ObservableField;

import com.bumptech.glide.Glide;


/**
 * @CreateDate: 2021-3-9 19:55
 * @UpdateDate: 2021-3-9 19:55
 * @Description:
 * @Author: uidq2189
 * @UpdateRemark:
 * @Version: 1.0
 */
public class UserDataAttr {
    private ObservableField<String> name;
    private ObservableField<String> url;

    public UserDataAttr() {
    }

    public ObservableField<String> getName() {
        return name;
    }

    public void setName(ObservableField<String> name) {
        this.name = name;
    }

    public ObservableField<String> getUrl() {
        return url;
    }

    public void setUrl(ObservableField<String> url) {
        this.url = url;
    }

    @BindingAdapter("image_url")
    public static void imageUrl(ImageView imageView, String url) {
        Glide.with(App.context)
                .load(url)
                .placeholder(android.R.drawable.ic_dialog_info)
                .error(android.R.drawable.ic_delete)
                .into(imageView);
    }
}
