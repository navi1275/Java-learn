package com.navi.consumer.config;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * CustomRule Class
 *
 * @author navi
 * @date 2019-04-16
 * @since 1.0.0
 */
public class CustomRule implements IRule {

    private ILoadBalancer lb;

    private List<Integer> excludePorts;

    public CustomRule() {
    }

    public CustomRule(List<Integer> excludePorts) {
        this.excludePorts = excludePorts;
    }

    @Override
    public Server choose(Object key) {
        List<Server> reachableServers = getLoadBalancer().getReachableServers();

        List<Server> availableServers = getAvailableServers(reachableServers);

        return getAvailableRandomServer(availableServers);
    }

    private Server getAvailableRandomServer(List<Server> availableServers) {

        int i = new Random().nextInt(availableServers.size());

        return availableServers.get(i);
    }

    private List<Server> getAvailableServers(List<Server> list) {

        if(excludePorts == null || excludePorts.isEmpty()){
            return list;
        }

        List<Server> availableServers = new ArrayList<>();
        for (Server server: list){
            if(server != null && !excludePorts.contains(server.getPort())){
                availableServers.add(server);
            }
        }

        return availableServers;
    }

    @Override
    public void setLoadBalancer(ILoadBalancer lb){
        this.lb = lb;
    }

    @Override
    public ILoadBalancer getLoadBalancer(){
        return lb;
    }

}
