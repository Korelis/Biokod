package com.witanowski.biokod.ui.products.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.witanowski.biokod.R;
import com.witanowski.biokod.data.model.ProductResult;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Michal Witanowski on 2017-08-16.
 */

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {
    private List<ProductResult> products;

    public ProductAdapter(List<ProductResult> products){
        this.products = products;
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_products, null);
        ProductViewHolder viewHolder = new ProductViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        final ProductResult product = products.get(position);

        holder.tvProduct.setText(product.getName());
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    class ProductViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tvProduct) TextView tvProduct;

        public ProductViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
