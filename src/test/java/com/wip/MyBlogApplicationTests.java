package com.wip;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyBlogApplicationTests {

    @Test
    public void contextLoads() throws MQClientException {
        DefaultMQProducer producer = new DefaultMQProducer("SELF_TEST_C_GROUP");

        //设置nameserver的地址
        producer.setNamesrvAddr("192.168.137.128:9876");

        // 启动生产者
        producer.start();

        /**
         * 创建topic，参数分别是：broker的名称，topic的名称，queue的数量
         *
         */
        producer.createTopic("broker_a", "RMQ_SYS_TRANS_HALF_TOPIC", 8);

        System.out.println("topic创建成功!");

        producer.shutdown();
    }

}