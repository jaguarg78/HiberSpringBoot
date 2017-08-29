package com.solwin.test.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.solwin.test.entity.Site;

@Transactional
@Repository
public class SiteDAO implements ISiteDAO {
	@PersistenceContext
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Site> getAllSites() {
		String hql = "FROM Site AS site ORDER BY site.id";
		return (List<Site>) entityManager.createQuery(hql).getResultList();
	}

	@Override
	public Site getSiteById(int siteId) {
		return entityManager.find(Site.class, siteId);
	}

	@Override
	public void addSite(Site site) {
		entityManager.persist(site);
	}

	@Override
	public void updateSite(Site site) {
		Site sit = getSiteById(site.getId());
		sit.setName(site.getName());
		sit.setDescription(site.getDescription());
		sit.setEmail(site.getEmail());
		sit.setPhone(site.getPhone());
		sit.setAddress(site.getAddress());
		entityManager.flush();
	}

	@Override
	public void deleteSite(int siteId) {
		entityManager.remove(getSiteById(siteId));
	}

	@Override
	public boolean siteExists(Site site) {
		return entityManager
						.createQuery("FROM Site AS site "+
		                            "WHERE site.name = ? ")
							.setParameter(1, site.getName())
								.getResultList().size() > 0;
	}
	
}
