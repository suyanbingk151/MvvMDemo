package com.mvvm.gionee.mvvmdemo.adapter;

import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mvvm.gionee.mvvmdemo.BR;
import com.mvvm.gionee.mvvmdemo.R;
import com.mvvm.gionee.mvvmdemo.data.GirlsData;
import com.mvvm.gionee.mvvmdemo.databinding.GirlsItemBinding;
import com.mvvm.gionee.mvvmdemo.interfacemv.GirlItemClickCallback;

import java.util.List;

/**
 * Created by sulc on 2018/1/17.
 */

public class GirlsAdapter extends RecyclerView.Adapter<GirlsAdapter.GirlsViewHolder>{

    private List<GirlsData.ResultsBean> girlsList;
    private  GirlItemClickCallback girlItemClickCallback;

    public GirlsAdapter(@Nullable GirlItemClickCallback itemClickCallback) {
        girlItemClickCallback = itemClickCallback;
    }

    public void setGirlsList(final List<GirlsData.ResultsBean> list){
        girlsList = list;
        this.notifyDataSetChanged();
    }

    @Override
    public GirlsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        GirlsItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.girls_item, parent, false);
        binding.setCallback(girlItemClickCallback);
        return new GirlsViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(GirlsViewHolder holder, int position) {
        holder.binding.setGirlsItem(girlsList.get(position));
       // holder.binding.setVariable(BR.girlsItem, girlsList.get(position));
        holder.binding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return girlsList == null ? 0 : girlsList.size();
    }

    class GirlsViewHolder extends RecyclerView.ViewHolder{
        GirlsItemBinding binding;
        public GirlsViewHolder(GirlsItemBinding binding ) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
