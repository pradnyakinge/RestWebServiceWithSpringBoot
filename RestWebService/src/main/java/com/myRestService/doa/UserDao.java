package com.myRestService.doa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myRestService.bean.UserBean;

@Repository
public interface UserDao  extends JpaRepository<UserBean,Integer>{


}
