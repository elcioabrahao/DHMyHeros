package br.com.doghero.dhmyheros.ui.adapters;

import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import br.com.doghero.dhmyheros.R;
import br.com.doghero.dhmyheros.domain.model.HeroItem;
import br.com.doghero.dhmyheros.ui.fragments.HeroFragment.OnListFragmentInteractionListener;
import butterknife.BindView;
import butterknife.ButterKnife;
import jp.wasabeef.picasso.transformations.CropCircleTransformation;


import java.util.List;


public class HeroRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final List<HeroItem> mValues;
    private final OnListFragmentInteractionListener mListener;
    private Context context;
    public static final int RECENT_HEADER = 0;
    public static final int RECENT = 1;
    public static final int FAVORITE_HEADER = 2;
    public static final int FAVORITE = 3;

    public HeroRecyclerViewAdapter(List<HeroItem> items, OnListFragmentInteractionListener listener, Context context) {
        this.context =context;
        mValues = items;
        mListener = listener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        switch (viewType) {
            case RECENT_HEADER:
                View viewRecentHeader = inflater.inflate(R.layout.fragment_hero_recent_header, parent, false);
                viewHolder = new RecentVH(viewRecentHeader);
                break;
            case RECENT:
                View viewRecent = inflater.inflate(R.layout.fragment_hero_recent, parent, false);
                viewHolder = new RecentVH(viewRecent);
                break;
            case FAVORITE_HEADER:
                View viewFavoriteHeader = inflater.inflate(R.layout.fragment_hero_favorite_header, parent, false);
                viewHolder = new FavoriteVH(viewFavoriteHeader);
                break;
            case FAVORITE:
                View viewFavorite = inflater.inflate(R.layout.fragment_hero_favorite, parent, false);
                viewHolder = new FavoriteVH(viewFavorite);
                break;

        }
        return viewHolder;
    }





    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        HeroItem heroItem = mValues.get(position);

        switch (getItemViewType(position)){
            case RECENT_HEADER:
            case RECENT:
                final RecentVH recentVh = (RecentVH) holder;
                Picasso.get().load(heroItem.getUser().getImageUrl()).transform(new CropCircleTransformation()).placeholder(R.drawable.ic_person).into(recentVh.imageViewUser);
                Log.d("SUPER",heroItem.getUser().getFirstName()+""+heroItem.getIsSuperhero());
                recentVh.textViewName.setText(heroItem.getUser().getFirstName());
                recentVh.textViewNeighborhood.setText(heroItem.getAddressNeighborhood());
                recentVh.textViewPrice.setText(context.getResources().getString(R.string.label_money)+heroItem.getPrice());
                if(!heroItem.getIsSuperhero()) {
                    recentVh.imageViewSuperHero.setVisibility(View.GONE);
                }
                break;
            case FAVORITE_HEADER:
            case FAVORITE:
                final FavoriteVH favoriteVH = (FavoriteVH) holder;
                Log.d("SUPER",heroItem.getUser().getFirstName()+""+heroItem.getIsSuperhero());
                Picasso.get().load(heroItem.getUser().getImageUrl()).transform(new CropCircleTransformation()).placeholder(R.drawable.ic_person).into(favoriteVH.imageViewUser);
                favoriteVH.textViewName.setText(heroItem.getUser().getFirstName());
                favoriteVH.textViewNeighborhood.setText(heroItem.getAddressNeighborhood());
                favoriteVH.textViewPrice.setText(context.getResources().getString(R.string.label_money)+heroItem.getPrice());
                if(!heroItem.getIsSuperhero()) {
                    favoriteVH.imageViewSuperHero.setVisibility(View.GONE);
                }
                break;
        }

    }

    @Override
    public int getItemViewType(int position) {
        HeroItem heroItem = mValues.get(position);
        return heroItem.getViewType();
    }


    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class RecentVH extends RecyclerView.ViewHolder {
        public final View mView;
        @BindView(R.id.imageViewUser)
        ImageView imageViewUser;
        @BindView(R.id.textViewName)
        TextView textViewName;
        @BindView(R.id.textViewNeighborhood)
        TextView textViewNeighborhood;
        @BindView(R.id.ratingBar)
        RatingBar ratingBar;
        @BindView(R.id.textViewPrice)
        TextView textViewPrice;
        @BindView(R.id.textViewPerNight)
        TextView textViewPerNight;
        @BindView(R.id.imageViewSuperHero)
        ImageView imageViewSuperHero;

        public HeroItem mItem;

        public RecentVH(View view) {
            super(view);
            mView = view;
            ButterKnife.bind(this, view);
        }

    }

    public class FavoriteVH extends RecyclerView.ViewHolder {
        public final View mView;
        @BindView(R.id.imageViewUser)
        ImageView imageViewUser;
        @BindView(R.id.textViewName)
        TextView textViewName;
        @BindView(R.id.textViewNeighborhood)
        TextView textViewNeighborhood;
        @BindView(R.id.ratingBar)
        RatingBar ratingBar;
        @BindView(R.id.textViewPrice)
        TextView textViewPrice;
        @BindView(R.id.textViewPerNight)
        TextView textViewPerNight;
        public HeroItem mItem;
        @BindView(R.id.imageViewSuperHero)
        ImageView imageViewSuperHero;


        public FavoriteVH(View view) {
            super(view);
            mView = view;
            ButterKnife.bind(this, view);
        }

    }
}
