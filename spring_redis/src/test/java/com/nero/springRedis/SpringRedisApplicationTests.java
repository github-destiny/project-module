package com.nero.springRedis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.test.context.SpringBootTest;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.Scanner;

@SpringBootTest
class SpringRedisApplicationTests {

    @Test
    void contextLoads() {
        Jedis jedis = new Jedis("1.15.140.216", 6379);
        String ping = jedis.ping();
        System.out.println(ping);
    }

    @Test
    public void reader(){
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        int[] arr = new int[i];
        for(int j = 0; j < i; j++){
            arr[j] = scanner.nextInt();
        }
        int i1 = firstMissingPositive(arr);
        System.out.println(i1);
    }

    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            if (nums[i] <= 0) {
                nums[i] = n + 1;
            }
        }
        for (int i = 0; i < n; ++i) {
            int num = Math.abs(nums[i]);
            if (num <= n) {
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
        }
        for (int i = 0; i < n; ++i) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return n + 1;
    }

}
