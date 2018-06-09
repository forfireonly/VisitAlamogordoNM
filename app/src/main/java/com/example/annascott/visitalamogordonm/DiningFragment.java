package com.example.annascott.visitalamogordonm;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * {@link Fragment} that displays a list of places in Alamogordo.
 */
public class DiningFragment extends Fragment {

    public DiningFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_list_view, container, false);

        // Create a list of places
        final ArrayList<Place> places = new ArrayList<Place>();
        places.add(new Place(getString(R.string.Peppers), getString(R.string.web_peppers),
                R.drawable.peppers));
        places.add(new Place(getString(R.string.Si_Senor), getString(R.string.web_si_senor),
                R.drawable.sisenor));
        places.add(new Place(getString(R.string.Eddies), getString(R.string.web_eddies),
                R.drawable.burrito));
        places.add(new Place(getString(R.string.La_Hacienda), getString(R.string.web_la_hacienda),
                R.drawable.chicken_enchilladas));
        places.add(new Place(getString(R.string.Brown_Bag), getString(R.string.web_brown_bag),
                R.drawable.sandwich));
        places.add(new Place(getString(R.string.BBQ), getString(R.string.web_bbq),
                R.drawable.bbq));
        places.add(new Place(getString(R.string.Bamboo_Garden), getString(R.string.web_bamboo_garden),
                R.drawable.asian));
        places.add(new Place(getString(R.string.Mad_Coffee), getString(R.string.web_mad_coffee),
                R.drawable.drink));

        // Create an {@link PlaceAdapter}, whose data source is a list of {@link Word}s. The
        // adapter knows how to create list items for each item in the list.
        PlaceAdapter adapter = new PlaceAdapter(getActivity(), places, R.color.colorDining);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_list.xml layout file.
        ListView listView = (ListView) rootView.findViewById(R.id.list);

        // Make the {@link ListView} use the {@link PlaceAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Word} in the list.
        listView.setAdapter((ListAdapter) adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Place place = places.get(i);
                String website = place.getPlaceAddress();
                Intent openwebsite = new Intent(Intent.ACTION_VIEW);
                openwebsite.setData(Uri.parse(String.valueOf(website)));
                startActivity(openwebsite);
            }
        });

        return rootView;} }


