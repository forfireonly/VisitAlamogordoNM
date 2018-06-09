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
public class ExperienceFragment extends Fragment {

    public ExperienceFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_list_view, container, false);

        // Create a list of places
        final ArrayList<Place> places = new ArrayList<Place>();
        places.add(new Place(getString(R.string.White_Sands), getString(R.string.web_White_sands),
                R.drawable.white_sands));
        places.add(new Place(getString(R.string.Space_Museum), getString(R.string.web_Space_Museum),
                R.drawable.space_museum));
        places.add(new Place(getString(R.string.Zoo), getString(R.string.web_Zoo),
                R.drawable.zoo_sign));
        places.add(new Place(getString(R.string.History_museum), getString(R.string.web_History_Museum),
                R.drawable.museum));
        places.add(new Place(getString(R.string.Pistachio_Land), getString(R.string.web_Pistachio_Land),
                R.drawable.pistachio));
        places.add(new Place(getString(R.string.Toy_train_Depot), getString(R.string.web_Toy_Train_Depot),
                R.drawable.toy_train_depot));
        places.add(new Place(getString(R.string.Flickinger_Center), getString(R.string.web_Flickinger_Center),
                R.drawable.flickinger));
        places.add(new Place(getString(R.string.Oliver_Lee_Park), getString(R.string.web_Oliver_Lee_Park),
                R.drawable.oliver_park));

        // Create an {@link PlaceAdapter}, whose data source is a list of {@link Word}s. The
        // adapter knows how to create list items for each item in the list.
        PlaceAdapter adapter = new PlaceAdapter(getActivity(), places, R.color.colorExperience);

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



