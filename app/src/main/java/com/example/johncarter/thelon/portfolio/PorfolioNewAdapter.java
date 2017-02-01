package com.example.johncarter.thelon.portfolio;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.johncarter.thelon.R;
import com.example.johncarter.thelon.models.PortfolioActivity;
import com.ramotion.foldingcell.FoldingCell;

import java.util.HashSet;
import java.util.List;

/**
 * Created by Acer on 29/01/2017.
 */

public class PorfolioNewAdapter extends ArrayAdapter<PortfolioActivity> {
    private HashSet<Integer> unfoldedIndexes = new HashSet<>();
    private View.OnClickListener defaultRequestBtnClickListener;

    public PorfolioNewAdapter(Context context, List<PortfolioActivity> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        PortfolioActivity portfolioActivity = getItem(position);

        FoldingCell cell = (FoldingCell) convertView;
        ViewHolder viewHolder;
        if(cell == null){
            viewHolder = new ViewHolder();
            LayoutInflater vi = LayoutInflater.from(getContext());
            cell = (FoldingCell) vi.inflate(R.layout.portfolio_cell,parent,false);
            viewHolder.price = (ImageView) cell.findViewById(R.id.title_price);
            viewHolder.date = (TextView) cell.findViewById(R.id.title_date_label);
            viewHolder.time = (TextView) cell.findViewById(R.id.title_time_label);
            viewHolder.eventName = (TextView) cell.findViewById(R.id.title_from_address);
            viewHolder.eventHost = (TextView) cell.findViewById(R.id.title_to_address);
            viewHolder.volunteersCount = (TextView) cell.findViewById(R.id.title_volunteers_count);
            viewHolder.points = (TextView) cell.findViewById(R.id.title_points);
            viewHolder.status = (ImageView) cell.findViewById(R.id.status);
            viewHolder.contentRequestBtn = (TextView) cell.findViewById(R.id.content_request_btn);
            cell.setTag(viewHolder);
        } else {
            if (unfoldedIndexes.contains(position)) {
                cell.unfold(true);
            } else {
                cell.fold(true);
            }
            viewHolder = (ViewHolder) cell.getTag();
        }

        viewHolder.price.setImageResource(portfolioActivity.getPhoto());
        viewHolder.time.setText(portfolioActivity.getTime());
        viewHolder.date.setText(portfolioActivity.getDate());
        viewHolder.eventName.setText(portfolioActivity.getEventName());
        viewHolder.eventHost.setText(portfolioActivity.getEventHost());
        viewHolder.volunteersCount.setText(portfolioActivity.getVolunteerCount());
        viewHolder.points.setText(portfolioActivity.getPoints());
        viewHolder.status.setImageResource(portfolioActivity.getEvent_status());

        if (portfolioActivity.getRequestBtnClickListener() != null) {
            viewHolder.contentRequestBtn.setOnClickListener(portfolioActivity.getRequestBtnClickListener());
        } else {
            // (optionally) add "default" handler if no handler found in item
            viewHolder.contentRequestBtn.setOnClickListener(defaultRequestBtnClickListener);
        }
        return cell;
    }

    public void registerToggle(int position) {
        if (unfoldedIndexes.contains(position))
            registerFold(position);
        else
            registerUnfold(position);
    }

    public void registerFold(int position) {
        unfoldedIndexes.remove(position);
    }

    public void registerUnfold(int position) {
        unfoldedIndexes.add(position);
    }

    public View.OnClickListener getDefaultRequestBtnClickListener() {
        return defaultRequestBtnClickListener;
    }

    public void setDefaultRequestBtnClickListener(View.OnClickListener defaultRequestBtnClickListener) {
        this.defaultRequestBtnClickListener = defaultRequestBtnClickListener;
    }

    private static class ViewHolder {
        ImageView price;
        TextView date;
        TextView time;
        TextView eventName;
        TextView eventHost;
        TextView volunteersCount;
        TextView points;
        TextView contentRequestBtn;
        ImageView status;
    }
}
