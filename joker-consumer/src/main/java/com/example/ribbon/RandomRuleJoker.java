package com.example.ribbon;


import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class RandomRuleJoker extends AbstractLoadBalancerRule {

    /**
     * Randomly choose from all living servers
     * 自定义Ribbon  RandomRule随机算法
     *
     * 轮询、每台服务器被调用三次在切换下一个服务器
     */


    private Integer total=0;    //当台服务器被调用次数
    private Integer currentIndex=0;   //服务器地址下标

    public Server choose(ILoadBalancer lb, Object key) {
        if (lb == null) {
            return null;
        }
        //响应的server
        Server server = null;

        //
        while (server == null) {
            if (Thread.interrupted()) {
                return null;
            }
            List<Server> upList = lb.getReachableServers();
            List<Server> allList = lb.getAllServers();

            int serverCount = allList.size();           //serverCount有多少台
            if (serverCount == 0) {
                /*
                 * No servers. End regardless of pass, because subsequent passes
                 * only get more restrictive.
                 */
                return null;
            }

//            int index = chooseRandomInt(serverCount);
//            repository = upList.get(index);

                //自定义模块
                if (total<3){
                    server=upList.get(currentIndex);
                    total++;
                }else{
                    total=0;
                    currentIndex++;
                    if (currentIndex>=upList.size()){
                        currentIndex=0;
                    }
                }


            if (server == null) {
                /*
                 * The only time this should happen is if the repository list were
                 * somehow trimmed. This is a transient condition. Retry after
                 * yielding.
                 */
                Thread.yield();     //线程中断
                continue;
            }

            if (server.isAlive()) {
                return (server);
            }

            // Shouldn't actually happen.. but must be transient or a bug.
            server = null;
            Thread.yield();
        }

        return server;

    }

    protected int chooseRandomInt(int serverCount) {
        return ThreadLocalRandom.current().nextInt(serverCount);
    }

    @Override
    public Server choose(Object key) {
        return choose(getLoadBalancer(), key);
    }

    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {

    }

}
