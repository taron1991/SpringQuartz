package quartzConfig;

import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

//@Configuration
public class QuartzConfig {
  /*  @Bean
    public JobDetail myJobDetail() {
        return JobBuilder.newJob(MyJob.class) //class содержит логику, выполняемую при запуске задачи
                .withIdentity("myJob") //Устанавливает уникальный идентификатор для задачи
                .storeDurably() //Указывает, что задача должна быть сохранена в базе данных, даже если она не имеет триггера.
                .build();
    }
    @Bean
    public Trigger myJobTrigger() { //триггер — это механизм, который запускает задачу
        return TriggerBuilder.newTrigger()
                .forJob(myJobDetail()) //этот триггер связан с задачей, созданной в методе myJobDetail()
                .withIdentity("myJobTrigger")
                .withSchedule(CronScheduleBuilder.cronSchedule("0/3 * * * * ?")) //расписание для триггера. В данном случае используется выражение cron, которое запускает задачу каждые 10 секунд.
                .build();
    }
    @Bean
    public SchedulerFactoryBean schedulerFactoryBean() {
        SchedulerFactoryBean factory = new SchedulerFactoryBean();//фабрикой для создания экземпляров Scheduler
        factory.setJobDetails(myJobDetail()); //Устанавливает задачу, которую будет выполнять планировщик
        factory.setTriggers(myJobTrigger());//Устанавливает триггеры, которые будут использоваться для запуска задач
        factory.setAutoStartup(true);
        return factory;
    }
    @Bean
    public Scheduler scheduler(SchedulerFactoryBean factory) throws SchedulerException {
        Scheduler scheduler = factory.getScheduler();
        scheduler.start(); // Явный запуск планировщика
        scheduler.scheduleJob(myJobDetail(),myJobTrigger());
        return scheduler;
    }*/
}
