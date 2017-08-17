package com.witanowski.biokod.ui.products;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.witanowski.biokod.R;
import com.witanowski.biokod.data.model.Product;
import com.witanowski.biokod.data.model.ProductParams;
import com.witanowski.biokod.data.model.ProductResult;
import com.witanowski.biokod.data.remote.APIService;
import com.witanowski.biokod.data.remote.APIUtils;
import com.witanowski.biokod.ui.products.adapter.ProductAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Michal Witanowski on 2017-08-16.
 */

public class ProductsFragment extends Fragment implements ProductsView {

    @BindView(R.id.rvProducts) RecyclerView rvProducts;
    @BindView(R.id.progressBar) ProgressBar progressBar;

    private ProductsPresenter presenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_products, container, false);

        ButterKnife.bind(this, rootView);

        final LinearLayoutManager lytManager = new LinearLayoutManager(getActivity());
        rvProducts.setLayoutManager(lytManager);

        presenter = new ProductsPresenterImpl(this);
        presenter.showProducts();

        return rootView;
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void setFailure() {
        Toast.makeText(getActivity(), getString(R.string.something_went_wrong), Toast.LENGTH_LONG).show();
    }

    @Override
    public void showProducts(List<ProductResult> products) {
        ProductAdapter productAdapter = new ProductAdapter(products);
        rvProducts.setAdapter(productAdapter);
    }
}
