package com.tildev.batch.jobs.job1.writer;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.tildev.batch.jobs.job1.domain.Data1;

@Component
@Scope("step")
public class Job1Writer implements ItemWriter<Data1> {

    private static final Logger logger = LoggerFactory.getLogger(Job1Writer.class);

    @Override
    public void write(List<? extends Data1> items) throws Exception {
        for (Data1 item : items) {
            logger.info("Job1 write: {}", item.toString());
        }
    }
}
