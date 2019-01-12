package com.example.demo.hadoop_mapred;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MyReducer extends Reducer<Text, Text, Text, Text> {

    private static long count;

    @Override
    protected void setup(Context context) {
        // Get doc line counts
        count = context.getCounter("org.apache.hadoop.mapreduce.TaskCounter", "MAP_INPUT_RECORDS").getValue();
        System.out.println("---count: " + count + "---");
    }

    /**
     * Reduce input, such as:
     *  key: code values: 0, 2, 4, 4, 7
     *  means term "code" occurred once at doc 0, 2, 7, twice at doc 4
     */
    @Override
    public void reduce(Text key, Iterable<Text> values, Context context) {
        /*
         * Match the values as:
         *  <docId, occurred times>:
         *  <0, 1>, <2, 1>, <4, 2>, <7, 1>
         */
        Map<String, Integer> lineOccurs = new HashMap<>();
        for (Text val : values) {
            lineOccurs.put(val.toString(), lineOccurs.get(val.toString()) == null ? 1 : lineOccurs.get(val.toString()) + 1);
        }

        double occurredLines = lineOccurs.size();
        lineOccurs.forEach((docId, occurredTimes) -> {
            System.out.println("---Word: " + key + "---occurred: " + occurredTimes + "---at line: " + docId);
            double result = occurredTimes * Math.log10(count / occurredLines);
            System.out.println("---result: " + result + "---");
            String out = docId + "," + String.valueOf(result);
            try {
                context.write(key, new Text(out));
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}
