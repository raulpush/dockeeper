package com.muri.web.client.impl;

import com.muri.web.client.SearchClientService;
import org.apache.log4j.Logger;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.springframework.stereotype.Service;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Service(value="searchClientService")
public class SearchClientServiceImpl implements SearchClientService
{
    static final Logger logger = Logger.getLogger(SearchClientServiceImpl.class);
    
//    private String searchServerClusterNodes = "localhost:9300";
    private String searchServerClusterName = "jaidev";

    private Client client;

    public Client getClient()
    {
        if(client == null)
        {
            client = createClient();
        }
        
        return client;
    }
    
//    @PostConstruct
    protected Client createClient()
    {
        if(client == null)
        {
            try {
                client = TransportClient.builder().build()
                        .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("localhost"), 9300));
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }

        }
        return client;
    }

}
