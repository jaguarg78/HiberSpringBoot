package com.solwin.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solwin.test.dao.ISiteDAO;
import com.solwin.test.entity.Site;

@Service
public class SiteService implements ISiteService {
	@Autowired
	private ISiteDAO siteDAO;
	
	@Override
	public List<Site> getAllSites() {
		return siteDAO.getAllSites();
	}

	@Override
	public Site getSiteById(int siteId) {
		return siteDAO.getSiteById(siteId);
	}

	@Override
	public boolean addSite(Site site) {
		if (siteDAO.siteExists(site)) {
            return false;
        }
		
		siteDAO.addSite(site);
        return true;
	}

	@Override
	public void updateSite(Site site) {
		siteDAO.updateSite(site);
	}

	@Override
	public void deleteSite(int siteId) {
		siteDAO.deleteSite(siteId);
	}
}
