package quartzConfig;






import org.example.springquartzexample.repo.CustomerRepo;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyJob {
    private final CustomerRepo customerRepo;


    @Autowired
    public MyJob(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }


}
