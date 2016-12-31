package dongshihong.mvp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import dongshihong.mvp.R;
import dongshihong.mvp.mvp.view.Bean.JokePicInfo;
import dongshihong.mvp.network.Api;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dsh on 2016/12/28
 */

public class JokePicRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

  public List<JokePicInfo> mList = new ArrayList<>();
  Context mContext;
  JokePicRecyclerViewAdapter.ItemOnLongClick mItemOnLongClick;

  private static final int TYPE_ITEM = 0;
  private static final int TYPE_FOOTER = 1;

  public interface ItemOnLongClick {
    void ItemOnLongClick(int positinon);
  }

  public void cleanData() {
    mList.clear();
  }

  public void addAllData(List<JokePicInfo> list) {
    mList.addAll(list);
    notifyDataSetChanged();
  }

  public JokePicRecyclerViewAdapter(Context context,
      JokePicRecyclerViewAdapter.ItemOnLongClick itemOnLongClick) {
    this.mContext = context;
    this.mItemOnLongClick = itemOnLongClick;
  }

  @Override public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    if (viewType == TYPE_FOOTER) {
      View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.footviewholder, null);
      return new JokePicRecyclerViewAdapter.FooterViewHolder(view);
    } else {
      View view = LayoutInflater.from(parent.getContext())
          .inflate(R.layout.jokepicviewholder, parent, false);
      return new JokePicRecyclerViewAdapter.JokeHolder(view);
    }
  }

  @Override public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
    if (holder instanceof JokePicRecyclerViewAdapter.JokeHolder) {
      ((JokePicRecyclerViewAdapter.JokeHolder) holder).time.setText(mList.get(position).getTitle());
      Glide.with(mContext)
          .load(Api.IMAGER_URL + mList.get(position).getImg()).placeholder(R.mipmap.ic_launcher)
          .into(((JokeHolder) holder).mImageView);
      ((JokePicRecyclerViewAdapter.JokeHolder) holder).mLinearLayout.setOnClickListener(view -> {
        mItemOnLongClick.ItemOnLongClick(position);
      });
    }
  }

  @Override public int getItemCount() {
    return mList.size() + 1; //这个1表示footView;
  }

  @Override public int getItemViewType(int position) {
    if (position + 1 == getItemCount()) {
      return TYPE_FOOTER;
    } else {
      return TYPE_ITEM;
    }
  }

  public class JokeHolder extends RecyclerView.ViewHolder {
    TextView time;
    ImageView mImageView;
    LinearLayout mLinearLayout;

    public JokeHolder(View itemView) {
      super(itemView);
      time = (TextView) itemView.findViewById(R.id.tv_time);
      mImageView = (ImageView) itemView.findViewById(R.id.image);
      mLinearLayout = (LinearLayout) itemView.findViewById(R.id.lin);
    }
  }

  public class FooterViewHolder extends RecyclerView.ViewHolder {

    public FooterViewHolder(View itemView) {
      super(itemView);
    }
  }
}
