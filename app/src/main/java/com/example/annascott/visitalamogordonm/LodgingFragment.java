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
public class LodgingFragment extends Fragment {

    public LodgingFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_list_view, container, false);

        // Create a list of places
        final ArrayList<Place> places = new ArrayList<Place>();
        places.add(new Place(getString(R.string.hampton), getString(R.string.web_hampton),
                R.drawable.hampton));
        places.add(new Place(getString(R.string.fairfield), getString(R.string.web_fairfield),
                R.drawable.fairfield));
        places.add(new Place(getString(R.string.holiday), getString(R.string.web_holiday),
                R.drawable.holiday));
        places.add(new Place(getString(R.string.magnuson), getString(R.string.web_magnuson),
                R.drawable.magnuson));
        places.add(new Place(getString(R.string.suburban), getString(R.string.web_suburban),
                R.drawable.suburban));
        places.add(new Place(getString(R.string.super8), getString(R.string.web_super8),
                R.drawable.super_8));
        places.add(new Place(getString(R.string.sands), getString(R.string.web_sands),
                R.drawable.sands));
        places.add(new Place(getString(R.string.days), getString(R.string.web_days),
                R.drawable.days));

        // Create an {@link PlaceAdapter}, whose data source is a list of {@link Word}s. The
        // adapter knows how to create list items for each item in the list.
        PlaceAdapter adapter = new PlaceAdapter(getActivity(), places, R.color.colorLodging);

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



