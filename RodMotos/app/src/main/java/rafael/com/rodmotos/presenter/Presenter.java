package rafael.com.rodmotos.presenter;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

import rafael.com.rodmotos.MVP;
import rafael.com.rodmotos.dominio.Model;
import rafael.com.rodmotos.dominio.Moto;

public class Presenter implements MVP.PresenterImpl{

    private ArrayList<Moto> motos = new ArrayList<>();
    private MVP.ModelImpl model;
    private MVP.ViewImpl view;

    public Presenter(){
        model = new Model(this);
    }
    @Override
    public void retrieveMotos(Bundle savedInstanceState) {
        if(savedInstanceState != null){
            motos = savedInstanceState.getParcelableArrayList(MVP.ViewImpl.MOTOS_KEY);
            return;
        }
        model.retrieveMotos();
    }

    @Override
    public Context getContext() {
        return (Context) view;
    }

    @Override
    public void showProgressBar(boolean status) {
        int visibilidade = status ? View.VISIBLE : View.GONE;
        view.showProgressBar(visibilidade);
    }

    @Override
    public void showToast(String mensagem) {
        view.showToast(mensagem);
    }

    @Override
    public void updateListaRecycler(ArrayList<Moto> motos) {
        motos.clear();
        motos.addAll(motos);
        view.updateListaRecycler();
    }

    @Override
    public void updateItemRecycler(Moto moto) {
        for (int i = 0; i < motos.size(); i++){
            if (motos.get(i).getId() == moto.getId()){
                motos.get(i).setEhFavorito(moto.isEhFavorito());
                view.updateItemRecycler(i);
            }
        }
    }

    @Override
    public void updateEhFavoritoMoto(Moto moto) {
        moto.setEhFavorito(!moto.isEhFavorito());
        model.updateEhFavoritoMoto(moto);
    }

    @Override
    public ArrayList<Moto> getMotos() {
        return null;
    }

    @Override
    public void setView(MVP.ViewImpl view) {
        this.view = view;
    }
}
