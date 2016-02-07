package com.muri.web.client;

import org.elasticsearch.client.Client;

/**
 * Interface for getting client for working with search engine
 * 
 */
public interface SearchClientService
{
    /**
     * Get Search engine client
     * @return
     */
    Client getClient();
}
