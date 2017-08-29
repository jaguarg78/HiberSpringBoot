package com.solwin.test.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.solwin.test.entity.Place;

@Transactional
@Repository
public class PlaceDAO implements IPlaceDAO {
	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<Place> getAllPlaces() {
		String hql = "FROM Place as pla ORDER BY pla.id";
		return (List<Place>) entityManager.createQuery(hql).getResultList();
	}

	@Override
	public Place getPlaceById(int placeId) {
		return entityManager.find(Place.class, placeId);
	}

	@Override
	public void addPlace(Place place) {
		entityManager.persist(place);
	}

	@Override
	public void updatePlace(Place place) {
		Place pla = getPlaceById(place.getId());
		pla.setName(place.getName());
		pla.setOcupation(place.getOcupation());
	
		entityManager.flush();
	}

	@Override
	public void deletePlace(int placeId) {
		entityManager.remove(getPlaceById(placeId));
	}

	@Override
	public boolean placeExists(Place place) {
		return entityManager
				.createQuery("FROM Place AS pla " +
						    "WHERE pla.name = ?")
					.setParameter(1, place.getName())
						.getResultList().size() > 0;
	}


}
