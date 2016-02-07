package com.muri.web.document;

import com.muri.web.client.impl.SearchClientServiceImpl;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.index.query.QueryBuilders;

/**
 * Created by andrei.muresan on 10/2/2015.
 */
public class SearchDocument {
    public static void main(String[] args) {
        SearchClientServiceImpl client = new SearchClientServiceImpl();
        SearchResponse response = client.getClient().prepareSearch("twitter")
                .setTypes("tweet")
                .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
                .setQuery(QueryBuilders.matchQuery("content", "BACKEND-GET"))
                .setFrom(0).setSize(10).setExplain(false)
                .execute()
                .actionGet();
        System.out.println(response.toString());

        client.getClient().close();

    }
}
