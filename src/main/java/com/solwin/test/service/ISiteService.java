package com.solwin.test.service;

import java.util.List;

import com.solwin.test.entity.Site;

public interface ISiteService {
    List<Site> getAllSites();
    Site getSiteById(int siteId);
    boolean addSite(Site site);
    void updateSite(Site site);
    void deleteSite(int siteId);
}
