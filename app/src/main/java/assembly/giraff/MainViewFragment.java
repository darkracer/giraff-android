package assembly.giraff;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import assembly.giraff.andtinder.model.CardModel;
import assembly.giraff.andtinder.view.CardContainer;


import java.util.ArrayList;
import java.util.List;

import assembly.giraff.model.CustomCardModel;


public class MainViewFragment extends Fragment {

    private CardContainer mCardContainer;
    private static final String TAG = "MainActivity";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.activity_main, container, false);

        mCardContainer = (CardContainer) rootView.findViewById(R.id.layoutview);

        Resources r = getResources();

        ArrayList<Byte[]> mGifDataList = new ArrayList<>();


        CustomAdapter adapter = new CustomAdapter(getActivity(),mGifDataList);

        adapter.add(new CustomCardModel("Title1", "Descripti0on goes her0e  1", "http://gifs.joelglovier.com/accidents/wheelbarrel-dump.gif"));
        adapter.add(new CustomCardModel("Title2", "Descr0iption goes her0e 2","http://gifs.joelglovier.com/fail/cat-fail.gif"));
        adapter.add(new CustomCardModel("Title3", "Descripti0on goes here 3", "http://gifs.joelglovier.com/aha/aha.gif"));

        CustomCardModel cardModel = new CustomCardModel("Title3", "Descripti0on goes here 3", "http://gifs.joelglovier.com/big-lebowski/no-huh-uh.gif");
        cardModel.setOnClickListener(new CardModel.OnClickListener() {
            @Override
            public void OnClickListener() {
                Log.i("Swipeable Cards","I am pressing the card");
            }
        });

        cardModel.setOnCardDimissedListener(new CardModel.OnCardDimissedListener() {
            @Override
            public void onLike() {
                Log.i("Swipeable Cards","I like the card");
            }

            @Override
            public void onDislike() {
                Log.i("Swipeable Cards","I dislike the card");
            }
        });

        adapter.add(cardModel);

        mCardContainer.setAdapter(adapter);

        return rootView;
    }

}