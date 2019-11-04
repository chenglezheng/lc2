package com.lc.clz.service.impl;

//import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lc.clz.dao.UserDao;
import com.lc.clz.entities.User;
import com.lc.clz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created by chenglezheng on 2018/12/28.
 */
@Service("userServiceImpl")
@CacheConfig(cacheNames="userCache") // 本类内方法指定使用缓存时，默认的名称就是userCache
@Transactional(readOnly=true)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userMapper;

    private  final  String  PREFIX ="Basic_Provider_UserServiceImpl_";

    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    @Override
    public Map<String,Object> selectUserWithPage(Integer page, Integer limit) {
        PageHelper.startPage(page-1,limit);
        List<User> users=userMapper.selectAll();
        PageInfo<User> pageInfo=new PageInfo<>(users);
        return null/*TableUtils.getTable(pageInfo.getTotal(),users)*/;
    }


    // 因为必须要有返回值，才能保存到数据库中，如果保存的对象的某些字段是需要数据库生成的，那保存对象进数据库的时候，就没必要放到缓存了
    @CachePut(key="#p0.userName.toString()")  //#p0表示第一个参数 (必须要有返回值，否则没数据放到缓存中)
//    @LcnTransaction//分布式事务注解
    @Transactional(rollbackFor = Throwable.class)
    public User addUser(User user) {
        user=new User();
        user.setUserName("com.lc.clz");
        user.setUserPwd("clz1234567");
        user.setUserRole(1);
        userMapper.insertSelective(user);
        return user;
    }


    @CachePut(key="#p0.id")
    public User updateUser(Long userId) {
        User user=this.selectUser(userId);
        user.setUserName("com.lc.clz");
        user.setUserPwd("123");
        userMapper.updateByPrimaryKey(user);
        System.out.println("缓存中取出的数据："+redisTemplate.hasKey(user.getUserId()));
        return this.selectUser(user.getUserId());
    }

    @Cacheable(key="'com.lc.clz.entities.User'+#userId") // @Cacheable 会先查询缓存，如果缓存中存在，则不执行方法
    public User selectUser(Long userId) {
        User user = null;/*(User) redisUtil.get(PREFIX+userId.toString());*/
        if (user!=null){
          return user;
        }
        System.out.println("从数据库中获取用户信息");
        return userMapper.selectByPrimaryKey(userId);
    }

    @Override
    @CacheEvict(key="#p0")  //删除缓存名称为userCache,key等于指定的id对应的缓存
    public String deleteUser(Long userId) {
        return null;
    }

    @Override
    public String deleteAllUser() {
        return null;
    }


}
