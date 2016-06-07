package vaksys.in.volleyjsondemo;


import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import vaksys.in.volleyjsondemo.pojo.Details;
import vaksys.in.volleyjsondemo.pojo.NewResponse;

/**
 * Created by dell980 on 4/12/2016.
 */
public class InfoAdapter1 extends RecyclerView.Adapter<InfoAdapter1.InfoHolder> {

    List<NewResponse.ActorsBean> details;
    Context context;

    public InfoAdapter1(Context context, List<NewResponse.ActorsBean> details) {
        this.context = context;
        this.details = details;
    }

    @Override
    public InfoHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.raw_list, parent, false);
        InfoHolder infoHolder = new InfoHolder(view);
        return infoHolder;
    }

    @Override
    public void onBindViewHolder(InfoHolder holder, int position) {
        NewResponse.ActorsBean detail = details.get(position);
        holder.name.setText(detail.getName());
        holder.country.setText(detail.getCountry());
        holder.spouse.setText(detail.getSpouse());

        Picasso.with(context)
                .load(detail.getImage())
                .into(holder.ivImage);
    }

    @Override
    public int getItemCount() {
        return (null != details ? details.size() : 0);
    }

    public class InfoHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.iv_image)
        ImageView ivImage;
        @Bind(R.id.name)
        TextView name;
        @Bind(R.id.country)
        TextView country;
        @Bind(R.id.spouse)
        TextView spouse;
        @Bind(R.id.cardView)
        CardView cardView;

        public InfoHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
