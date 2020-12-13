package com.manulife.guli.service.impl;

import com.manulife.guli.entity.TUser;
import com.manulife.guli.mapper.TUserMapper;
import com.manulife.guli.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
   private TUserMapper userMapper;
    @Override
    public TUser getById(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }
}
