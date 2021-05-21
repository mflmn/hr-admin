package com.hr.document.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hr.document.entity.Nation;
import com.hr.document.mapper.NationMapper;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author junjie
 * @since 2021-05-21
 */
@Service
public class NationServiceImpl extends ServiceImpl<NationMapper, Nation> implements NationService {

}
