package br.com.doghero.dhmyheros.ui.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.com.doghero.dhmyheros.R;
import br.com.doghero.dhmyheros.domain.api.ApiAnswer;
import br.com.doghero.dhmyheros.domain.helpers.JsonHelper;
import br.com.doghero.dhmyheros.domain.model.HeroItem;
import br.com.doghero.dhmyheros.ui.adapters.HeroRecyclerViewAdapter;



public class HeroFragment extends Fragment {

    HeroRecyclerViewAdapter adapter;


    private static final String ARG_COLUMN_COUNT = "column-count";

    private int mColumnCount = 1;
    private OnListFragmentInteractionListener mListener;


    public HeroFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static HeroFragment newInstance(int columnCount) {
        HeroFragment fragment = new HeroFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hero_list, container, false);
        LinearLayoutManager llm = new LinearLayoutManager(view.getContext());

        adapter = new HeroRecyclerViewAdapter(JsonHelper.build(ApiAnswer.getMyHeroes()),mListener, getContext());

        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(llm);
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }

            recyclerView.setAdapter(adapter);
        }

        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    public interface OnListFragmentInteractionListener {

        void onListFragmentInteraction(HeroItem item);
    }
}
