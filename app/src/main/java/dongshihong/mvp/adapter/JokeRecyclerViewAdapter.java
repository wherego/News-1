package dongshihong.mvp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import dongshihong.mvp.R;
import dongshihong.mvp.mvp.view.Bean.JokeTextInfo;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dsh on 2016/12/28
 */

public class JokeRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
  public List<JokeTextInfo> mList = new ArrayList<>();
  Context mContext;
  ItemOnLongClick mItemOnLongClick;

  private static final int TYPE_ITEM = 0;
  private static final int TYPE_FOOTER = 1;

  public interface ItemOnLongClick {
    void ItemOnLongClick(int positinon);
  }

  public void cleanData() {
    mList.clear();
  }

  public void addAllData(List<JokeTextInfo> list) {
    mList.addAll(list);
    notifyDataSetChanged();
  }

  public JokeRecyclerViewAdapter(Context context, ItemOnLongClick itemOnLongClick) {
    this.mContext = context;
    this.mItemOnLongClick = itemOnLongClick;
  }

  @Override public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    if (viewType == TYPE_FOOTER) {
      View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.footviewholder, null);
      return new FooterViewHolder(view);
    } else {
      View view =
          LayoutInflater.from(parent.getContext()).inflate(R.layout.jokeholder, parent, false);
      return new JokeHolder(view);
    }
  }

  @Override public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
    if (holder instanceof JokeHolder) {
      ((JokeHolder) holder).id.setText(mList.get(position).getTitle());
      ((JokeHolder) holder).content.setText(Html.fromHtml(mList.get(position).getText()));
      ((JokeHolder) holder).joke.setOnClickListener(view -> {
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
    TextView id;
    TextView content;
    LinearLayout joke;

    public JokeHolder(View itemView) {
      super(itemView);
      id = (TextView) itemView.findViewById(R.id.id);
      content = (TextView) itemView.findViewById(R.id.content);
      joke = (LinearLayout) itemView.findViewById(R.id.joke);
    }
  }

  public class FooterViewHolder extends RecyclerView.ViewHolder {

    public FooterViewHolder(View itemView) {
      super(itemView);
    }
  }
}
