package com.example.annascott.visitalamogordonm;

public class Place {
    private String mPlaceName;
    private String mPlaceAddress;
    private int mImageResourceId = NO_IMAGE;

    private static final int NO_IMAGE=-1;

    public Place(String placeName, String placeAddress){
        mPlaceName = placeName;
        mPlaceAddress = placeAddress;
    }

    public Place(String placeName, String placeAddress,int imageId){
        mPlaceName = placeName;
        mPlaceAddress = placeAddress;
        mImageResourceId = imageId;

        //  mIDPicture = IDPicture;
    }

    @Override
    public String toString() {
        return "Word{" +
                "mPlaceName='" + mPlaceName + '\'' +
                ", mPlaceAddress='" + mPlaceAddress + '\'' +
                ", mImageResourceId=" + mImageResourceId +
                '}';
    }

    public String getPlaceName() {
        return mPlaceName;
    }
    public String getPlaceAddress(){
        return mPlaceAddress;
    }
    public int getImageResourceId() {return mImageResourceId;}

    public boolean hasImage(){ return mImageResourceId != NO_IMAGE;}
}