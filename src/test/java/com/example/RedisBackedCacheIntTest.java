package com.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;
import redis.clients.jedis.Jedis;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Testcontainers
public class RedisBackedCacheIntTest {

    private Jedis underTest;

    // container {
    @Container
    public GenericContainer redis = new GenericContainer(DockerImageName.parse("redis:5.0.3-alpine"))
            .withExposedPorts(6379);
    // }

    @BeforeEach
    public void setUp() {
        String address = redis.getHost();
        Integer port = redis.getFirstMappedPort();

        // Now we have an address and port for Redis, no matter where it is running
        underTest = new Jedis(address, port);
    }

    @AfterEach
    public void tearDown(){
        underTest.disconnect();
        redis.stop();
    }

    @Test
    public void testSimplePutAndGet() {
        underTest.set("test", "example");

        String retrieved = underTest.get("test");
        assertEquals("example", retrieved);
    }
}