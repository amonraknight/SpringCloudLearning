package com.sheli.loadbalancing;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class LoadBalancer01Impl implements LoadBalancer {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public final int getAndIncrement() {
        int current;
        int next;
        do {
            current = this.atomicInteger.get();
            next = current >= 100 ? 0 : current + 1;
        } while (!this.atomicInteger.compareAndSet(current, next));
        System.out.println("***************** next: " + next);
        return next;
    }

    @Override
    public ServiceInstance instance(List<ServiceInstance> serviceInstanceList) {
        int index = getAndIncrement() % serviceInstanceList.size();
        return serviceInstanceList.get(index);
    }


}
