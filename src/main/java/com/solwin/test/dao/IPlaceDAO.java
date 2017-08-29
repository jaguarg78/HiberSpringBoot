package com.solwin.test.dao;

import java.util.List;

import com.solwin.test.entity.Place;

public interface IPlaceDAO {
    List<Place> getAllPlaces();
    Place getPlaceById(int placeId);
    void addPlace(Place place);
    void updatePlace(Place place);
    void deletePlace(int placeId);
    boolean placeExists(Place place);
}
