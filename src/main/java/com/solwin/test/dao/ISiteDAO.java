package com.solwin.test.dao;

import java.util.List;

import com.solwin.test.entity.Site;

public interface ISiteDAO {
    List<Site> getAllSites();
    Site getSiteById(int siteId);
    void addSite(Site site);
    void updateSite(Site site);
    void deleteSite(int siteId);
    boolean siteExists(Site site);
}
