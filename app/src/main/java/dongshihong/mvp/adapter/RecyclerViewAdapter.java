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
import dongshihong.mvp.network.Api;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dsh on 2016/12/5
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
  private Context mContext;
  private List<tnogo> dataList = new ArrayList<>();
  private OnClick mOnClick;

  public interface OnClick {
    void OnClick(tnogo list);
  }

  public void addAllData(List<tnogo> dataList) {
    this.dataList.addAll(dataList);
    notifyDataSetChanged();
  }

  public void clearData() {
    this.dataList.clear();
  }

  public RecyclerViewAdapter(Context context,OnClick onClick) {
    mContext = context;
    this.mOnClick=onClick;
  }

  public class ViewHolder extends RecyclerView.ViewHolder {
    public TextView title;
    public ImageView touxiang;
    public TextView dizhi;
    public TextView url;

    public ViewHolder(View itemView) {
      super(itemView);
      title = (TextView) itemView.findViewById(R.id.title);
      touxiang = (ImageView) itemView.findViewById(R.id.avaor);
      dizhi = (TextView) itemView.findViewById(R.id.dizhi);
      url = (TextView) itemView.findViewById(R.id.url);
    }
  }

  @Override public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.tweet, parent, false);
    return new ViewHolder(v);
  }

  @Override public void onBindViewHolder(ViewHolder holder, final int position) {
    holder.title.setText(dataList.get(position).getTitle());
    holder.dizhi.setText(dataList.get(position).getFromname());
    holder.url.setText(dataList.get(position).getFromurl());
    holder.url.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View view) {
        mOnClick.OnClick(dataList.get(position));
      }
    });
    Glide.with(mContext)
        .load(Api.IMAGER_URL + dataList.get(position).getImg())
        .override(600, 600)
        .centerCrop()
        .into(holder.touxiang);
  }

  @Override public int getItemCount() {
    return dataList.size();
  }
}
