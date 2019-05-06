package com.tildev.batch.main;

import java.util.UUID;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {

    public static void main(String[] args) {

        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:launch-context.xml");
        ctx.refresh();

        JobLauncher jobLauncher = ctx.getBean("jobLauncher", JobLauncher.class);

        try {
            Job job1 = ctx.getBean("job1", Job.class);

            JobParameters jobParameters = new JobParametersBuilder()
                    .addString("id", UUID.randomUUID().toString())
                    .toJobParameters();

            jobLauncher.run(job1, jobParameters);
        } catch (JobExecutionAlreadyRunningException | JobRestartException | JobInstanceAlreadyCompleteException
                | JobParametersInvalidException e) {

            System.out.println(e.getMessage());
        }
        ctx.close();
    }
}
