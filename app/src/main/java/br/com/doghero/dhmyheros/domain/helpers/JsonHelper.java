package br.com.doghero.dhmyheros.domain.helpers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import br.com.doghero.dhmyheros.domain.model.Favorite;
import br.com.doghero.dhmyheros.domain.model.HeroItem;
import br.com.doghero.dhmyheros.domain.model.MyHeros;
import br.com.doghero.dhmyheros.domain.model.Recent;
import br.com.doghero.dhmyheros.ui.adapters.HeroRecyclerViewAdapter;


public class JsonHelper {

    //you can use Gson lib
    public static List<HeroItem> build(String json) {
        Gson gson = new GsonBuilder().create();
        MyHeros myHeros = gson.fromJson(json, MyHeros.class);
        List<HeroItem> heroItemList = new ArrayList<>();
        HeroItem heroItem;
        int viewType = HeroRecyclerViewAdapter.RECENT_HEADER;
        for(Recent recent: myHeros.getRecents()){
            heroItem = new HeroItem(recent.getIsSuperhero(),recent.getUser(),recent.getAddressNeighborhood(),recent.getPrice(),recent.getId(),viewType);
            viewType = HeroRecyclerViewAdapter.RECENT;
            heroItemList.add(heroItem);
        }
        viewType = HeroRecyclerViewAdapter.FAVORITE_HEADER;
        for(Favorite favorite: myHeros.getFavorites()){
            heroItem = new HeroItem(favorite.getIsSuperhero(),favorite.getUser(),favorite.getAddressNeighborhood(),favorite.getPrice(),0,viewType);
            viewType = HeroRecyclerViewAdapter.FAVORITE;
            heroItemList.add(heroItem);
        }
        return heroItemList;
    }

}
