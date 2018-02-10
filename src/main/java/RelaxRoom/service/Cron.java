package RelaxRoom.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class Cron {

    @Autowired
    private QueueService queueService;

    @Scheduled(fixedDelay = 5000)
    public void cacheRefresh()
    {
        queueService.endQueueInTime();
    }
}
