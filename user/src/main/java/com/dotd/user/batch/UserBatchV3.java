//package com.dotd.user.batch;
//
//
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.Step;
//import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
//import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.task.TaskExecutor;
//import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
//
//import javax.persistence.EntityManagerFactory;
//
//
///*
//BatchV3 시나리오 :
//
//flow1 :
//모든 유저에 대해 유저 개인마다 적립금을 더하여 총
//
//
// */
//
//@Configuration
//@EnableBatchProcessing
//@RequiredArgsConstructor
//@Slf4j
//public class UserBatchV3 {
//
//    private final JobBuilderFactory jobBuilderFactory;
//    private final StepBuilderFactory stepBuilderFactory;
//    private final EntityManagerFactory entityManagerFactory;
//
//
//
//
//
//
//
//    // 병렬 처리
//    @Bean
//    public TaskExecutor taskExecutor() {
//        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
//        taskExecutor.setCorePoolSize(4); // 코어 스레드 개수 설정
//        taskExecutor.setMaxPoolSize(8); // 최대 스레드 개수 설정
//        taskExecutor.setQueueCapacity(10); // 큐 크기 설정
//        return taskExecutor;
//    }
//
//
//
//}
