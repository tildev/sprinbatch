package com.tildev.batch.jobs.job1.reader;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.tildev.batch.jobs.job1.domain.Data1;

@Component
@Scope("step")
public class Job1Reader implements ItemReader<Data1> {

    private static final Logger logger = LoggerFactory.getLogger(Job1Reader.class);

    private String id;

    private int count;

    @Value("#{jobParameters['id']}")
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public Data1 read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        if (count >= 1)
            return null;
        count++;

        Data1 item = new Data1();
        item.setId(this.id);
        item.setName(Thread.currentThread().getName());
        item.setDate(new Date());

        logger.info("Job1 reader: {}", item.toString());
        return item;
    }
}
