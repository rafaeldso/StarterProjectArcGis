package rafael.com.rodmotos.dominio;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.RequestParams;

import rafael.com.rodmotos.JsonHttpRequest;
import rafael.com.rodmotos.MVP;

public class Model implements MVP.ModelImpl{
    private AsyncHttpClient asyncHttpClient = new AsyncHttpClient();
    private MVP.PresenterImpl presenter;

    public Model(MVP.PresenterImpl presenter){
        this.presenter = presenter;
    }


    @Override
    public void retrieveMotos() {
        RequestParams requestParams = new RequestParams(JsonHttpRequest.METODO_KEY,"get-motos");

        asyncHttpClient.post(presenter.getContext(),JsonHttpRequest.URI,requestParams,new JsonHttpRequest(presenter));
    }

    @Override
    public void updateEhFavoritoMoto(Moto m) {
        RequestParams requestParams = new RequestParams();
        requestParams.put(JsonHttpRequest.METODO_KEY,"update-favorito-moto");
        requestParams.put(Moto.ID_KEY,m.getId());
        requestParams.put(Moto.EH_FAVORITO_KEY,m.isEhFavorito());

        asyncHttpClient.post(presenter.getContext(),JsonHttpRequest.URI,requestParams, new JsonHttpRequest(presenter));
    }
}
