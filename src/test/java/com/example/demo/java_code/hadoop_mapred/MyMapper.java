package com.example.demo.java_code.hadoop_mapred;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class MyMapper extends Mapper<LongWritable, Text, Text, Text> {
    private Text docId = new Text();
    private Text word = new Text();

    /**
     * Mapped <key, value> is <term, docId>, like "code  3",
     * means that term "code" occurred at line with id 3
     */
    @Override
    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String line = value.toString();
        String[] terms = line.split(" ");
        // Get docId as mapped value
        docId.set(terms[0]);
        for (int i = 1; i < terms.length; i++) {
            // Set current term as mapped key
            word.set(terms[i]);
            context.write(word, docId);
        }
    }
}