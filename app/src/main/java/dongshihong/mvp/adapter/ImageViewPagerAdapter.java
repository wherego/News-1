package dongshihong.mvp.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import dongshihong.mvp.R;
import dongshihong.mvp.mvp.view.Bean.ImageDetailBean;
import dongshihong.mvp.network.Api;
import dongshihong.mvp.utils.SaveImageUtils;
import java.util.List;

/**
 * Created by Dsh on 2016/12/16
 */

public class ImageViewPagerAdapter extends BasePageAdapter<ImageDetailBean> {
  private Context mContext;

  public ImageViewPagerAdapter(List<ImageDetailBean> list, Context context) {
    super(list);
    this.mContext = context;
  }

  @Override protected Object instantiate(ViewGroup viewGroup, int position, ImageDetailBean data) {

    ImageView imageView = new ImageView(mContext);
    Glide.with(mContext)
        .load(Api.IMAGER_URL + data.getSrc())
        .placeholder(R.mipmap.ic_launcher)
        .error(R.drawable.image_error)
        .crossFade()
        .into(imageView);
    viewGroup.addView(imageView);
    imageView.setOnClickListener(view -> initDialog(imageView, data.getId()));
    return imageView;
  }

  private void initDialog(ImageView imageView, int id) {
    AlertDialog.Builder dialog = new AlertDialog.Builder(mContext);
    dialog.setIcon(R.mipmap.ic_launcher)
        .setMessage("保存图片？")
        .setPositiveButton("确定", (dialogInterface, i) -> {
          imageView.setDrawingCacheEnabled(true);
          SaveImageUtils.saveImageView(imageView, id);
        })
        .create()
        .show();
  }
}
