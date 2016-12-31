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
import dongshihong.mvp.mvp.view.Bean.ImageBean;
import dongshihong.mvp.network.Api;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dsh on 2016/12/5
 */

public class ImageRecyclerViewAdapter
    extends RecyclerView.Adapter<ImageRecyclerViewAdapter.ViewHolder> {
  private Context mContext;
  private List<ImageBean> dataList = new ArrayList<>();
  private OnClick mOnClick;

  public interface OnClick {
    void OnClick(ImageBean imageBean);
  }

  public void addAllData(List<ImageBean> dataList,OnClick onClick) {
    this.dataList.addAll(dataList);
    notifyDataSetChanged();
    this.mOnClick=onClick;
  }

  public void clearData() {
    this.dataList.clear();
  }

  public ImageRecyclerViewAdapter(Context context) {
    mContext = context;
  }

  public class ViewHolder extends RecyclerView.ViewHolder {
    ImageView image;
    TextView title;
    TextView size;
    TextView count;

    public ViewHolder(View itemView) {
      super(itemView);
      image = (ImageView) itemView.findViewById(R.id.iamge);
      title = (TextView) itemView.findViewById(R.id.tv_title);
      size = (TextView) itemView.findViewById(R.id.tv_size);
      count = (TextView) itemView.findViewById(R.id.tv_count);
    }
  }

  @Override public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View v =
        LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_image, parent, false);
    return new ViewHolder(v);
  }

  @Override public void onBindViewHolder(ViewHolder holder, final int position) {
    Glide.with(mContext)
        .load(Api.IMAGER_URL + dataList.get(position).getImg())
        .placeholder(R.mipmap.ic_launcher)
        .into(holder.image);
    holder.title.setText(dataList.get(position).getTitle());
    holder.size.setText(dataList.get(position).getSize() + "张");
    holder.count.setText("访问量:" + dataList.get(position).getCount());

    holder.image.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View view) {
        mOnClick.OnClick(dataList.get(position));
      }
    });

  }

  @Override public int getItemCount() {
    return dataList.size();
  }
}
