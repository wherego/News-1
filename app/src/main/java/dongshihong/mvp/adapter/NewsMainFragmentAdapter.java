package dongshihong.mvp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import dongshihong.mvp.R;
import dongshihong.mvp.mvp.view.Bean.tnogo;
import dongshihong.mvp.utils.UIUtils;

/**
 * Created by Dsh on 2016/12/2
 */

public class NewsMainFragmentAdapter extends ListBaseAdapter<tnogo> {

  private LayoutInflater mLayoutInflater;

  public NewsMainFragmentAdapter(Context context) {
    mLayoutInflater = LayoutInflater.from(context);
    mContext = context;
  }

  @Override public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    return new ViewHolder(mLayoutInflater.inflate(R.layout.tweet, parent, false));
  }

  @Override public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
    tnogo item = mDataList.get(position);
    ViewHolder viewHolder = (ViewHolder) holder;
    viewHolder.dizhi.setText(item.getFromname());
    viewHolder.title.setText(item.getTitle());
    viewHolder.url.setText(item.getFromurl());
    Glide.with(UIUtils.getActivity())
        .load(item.getImg())
        .crossFade()
        .load(item.getImg())
        .into(viewHolder.image);

  }

  private class ViewHolder extends RecyclerView.ViewHolder {
    private TextView dizhi;
    private TextView title;
    private TextView url;
    private ImageView image;
    public ViewHolder(View itemView) {
      super(itemView);
      image= (ImageView) itemView.findViewById(R.id.avaor);
      dizhi = (TextView) itemView.findViewById(R.id.dizhi);
      title = (TextView) itemView.findViewById(R.id.title);
      url = (TextView) itemView.findViewById(R.id.url);
    }
  }
}

