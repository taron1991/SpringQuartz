package org.example.springquartzexample.service;


import org.example.springquartzexample.model.Customer;
import org.example.springquartzexample.repo.CustomerRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import quartzConfig.MyJob;

import java.util.List;

@Service
@Transactional(readOnly = true)
@EnableScheduling
//@EnableAsync //для выделения новых потоков
public class ServiceCustomer {

    private final CustomerRepo customerRepository;
    private static final Logger log = LoggerFactory.getLogger(MyJob.class);


    public ServiceCustomer(CustomerRepo customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Transactional
    public Customer createCustomer(Customer customer) {
       return customerRepository.save(customer);
    }

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

   /*
     fixedDelay = 1000
     заходим в метод,ждем 3 сек,выходим из метода
     ждем 1 секунуду и начинаем все сначала
    */
   @Scheduled(fixedDelayString = "${fixedDelay.time}")
    public void quartzMethod() throws InterruptedException {
        log.info("Job is running");
        Thread.sleep(3000);
        log.info("Job is finishing");

    }

  /* fixedRate = 1000
   заходим в метод,ждем 3 сек,выходим из метода
   сразу начинаем все сначала! не дожидаяс 1 секунды т.к работа метода больше чем время ожидания*/
    @Scheduled(fixedRateString = "${fixedRate.time}")
    public void quartzRateMethod() throws InterruptedException {
        log.info("Job is running");
        Thread.sleep(3000);
        log.info("Job is finishing");

    }


   /* fixedRate = 1000
   нужен для распаралеливания 1 задачи(выполняется в отдельном потоке)
    т.к время ожидания 1 сек а работа 3 сек то он каждую секунду будет создавать новый поток
  */
  /*  @Scheduled(fixedRateString = "${fixedRate.time}",initialDelay = 100)
    @Async
    public void quartzMethod() throws InterruptedException {
        log.info("Job is running");
        Thread.sleep(3000);
        log.info("Job is finishing");

    }*/

    /*
    Распаралелливание нескольких задач
    если есть несколько запланированных задач, которые могут выполняться одновременно,
    Spring сможет запустить до 5 таких задач параллельно.
     Если у вас больше задач, чем потоков в пуле, дополнительные задачи будут поставлены
     в очередь и будут ждать,
     пока один из потоков не освободится для их выполнения.
     Установка размера пула позволяет вам контролировать, сколько задач может
     выполняться одновременно, что может помочь оптимизировать использование ресурсов вашего приложения

    spring:
      task:
        scheduling:
          pool:
           size: 5
     */

}
