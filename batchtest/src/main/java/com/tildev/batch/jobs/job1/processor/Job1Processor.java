package com.tildev.batch.jobs.job1.processor;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.tildev.batch.jobs.job1.domain.Data1;

@Component
@Scope("step")
public class Job1Processor implements ItemProcessor<Data1, Data1> {

    private static final Logger logger = LoggerFactory.getLogger(Job1Processor.class);

    @Override
    public Data1 process(Data1 item) throws Exception {

        item.setDate(new Date());

        logger.info("Job1 process: {}", item.toString());
        return item;
    }
}
