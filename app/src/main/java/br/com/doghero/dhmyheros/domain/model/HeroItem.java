package br.com.doghero.dhmyheros.domain.model;


public class HeroItem extends Recent {

    private int viewType;


    public HeroItem(Boolean isSuperhero, User user, String addressNeighborhood, Integer price, Integer id, int viewType) {
        super(isSuperhero, user, addressNeighborhood, price, id);
        this.viewType = viewType;
    }

    public int getViewType() {
        return viewType;
    }

    public void setViewType(int viewType) {
        this.viewType = viewType;
    }
}
