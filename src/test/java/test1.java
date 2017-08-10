import org.junit.Test;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by yinlu on 2017/8/2.
 */
public class test1 {

    @Test
    public void test1() throws Exception {
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        Set<HostAndPort> nodes = new HashSet<HostAndPort>();
        HostAndPort hostAndPort1 = new HostAndPort("47.94.252.51", 7001);
        HostAndPort hostAndPort2 = new HostAndPort("47.94.252.51", 7002);
        HostAndPort hostAndPort3 = new HostAndPort("47.94.252.51", 7003);
        HostAndPort hostAndPort4 = new HostAndPort("47.94.252.51", 7004);
        HostAndPort hostAndPort5 = new HostAndPort("47.94.252.51", 7005);
        HostAndPort hostAndPort6 = new HostAndPort("47.94.252.51", 7006);
        nodes.add(hostAndPort1);
        nodes.add(hostAndPort2);
        nodes.add(hostAndPort3);
        nodes.add(hostAndPort4);
        nodes.add(hostAndPort5);
        nodes.add(hostAndPort6);
        JedisCluster jedisCluster = new JedisCluster(nodes, 1000, 10, 5, "********", poolConfig);//JedisCluster中默认分装好了连接池.
        jedisCluster.set("qwer", "32131ewqeqeqewqeqw");
        String s = jedisCluster.get("qwer");
        System.out.println(s);
    }

    @Test
    public void test2() throws Exception {
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        Set<HostAndPort> nodes = new HashSet<HostAndPort>();
        HostAndPort hostAndPort1 = new HostAndPort("192.168.153.21", 7001);
        HostAndPort hostAndPort2 = new HostAndPort("192.168.153.21", 7002);
        HostAndPort hostAndPort3 = new HostAndPort("192.168.153.21", 7003);
        HostAndPort hostAndPort4 = new HostAndPort("192.168.153.21", 7004);
        HostAndPort hostAndPort5 = new HostAndPort("192.168.153.21", 7005);
        HostAndPort hostAndPort6 = new HostAndPort("192.168.153.21", 7006);
        nodes.add(hostAndPort1);
        nodes.add(hostAndPort2);
        nodes.add(hostAndPort3);
        nodes.add(hostAndPort4);
        nodes.add(hostAndPort5);
        nodes.add(hostAndPort6);
        JedisCluster jedisCluster = new JedisCluster(nodes, poolConfig);//JedisCluster中默认分装好了连接池.
        String string = jedisCluster.get("age");
        System.out.println(string);
    }

}
