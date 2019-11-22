package com.lc.clz.service;

/*import com.codingapi.txlcn.tc.annotation.LcnTransaction;*/

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional(readOnly = true)
public class UserService {



}
