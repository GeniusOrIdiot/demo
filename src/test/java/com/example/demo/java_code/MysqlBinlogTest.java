package com.example.demo.java_code;

import com.github.shyiko.mysql.binlog.BinaryLogClient;
import com.github.shyiko.mysql.binlog.BinaryLogFileReader;
import com.github.shyiko.mysql.binlog.event.Event;

import java.io.File;
import java.io.IOException;

/**
 * @author LiuYJ
 * @since 2018/8/7
 */
public class MysqlBinlogTest {
    public static void main(String[] args) throws IOException {
//        eventListener();
        binLogReader();
    }

    private static void eventListener() throws IOException {
        BinaryLogClient client = new BinaryLogClient("192.168.16.15", 3307,
                "root", "0708");
        client.registerEventListener(System.out::println);
        client.connect();
    }

    private static void binLogReader() throws IOException {
        File binlogFile = new File("/Users/mdmory/Documents/公司资料/BI/mysql-bin.000837");
        try (BinaryLogFileReader reader = new BinaryLogFileReader(binlogFile)) {
            Event event;
            while ((event = reader.readEvent()) != null) {
                System.out.println(event);
            }
        }
    }
}
