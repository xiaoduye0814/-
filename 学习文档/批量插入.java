/*
 * @(#)MyBatisBatchBaseDao.java	2017年11月1日 下午7:08:18
 * du-casereview
 * Copyright 2017 Thunisoft, Inc. All rights reserved.
 * THUNISOFT PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.thunisoft.inspection.common.mybatis;

import java.util.Collection;

import org.apache.commons.beanutils.MethodUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

// TODO: Auto-generated Javadoc
/**
 * MyBatisBatchBaseDao
 * 批量执行操作基类.
 *
 * @author xingxm
 * @version 1.0
 */
public class MyBatisBatchBaseDao {

    /** The Constant logger. */
    private static final Logger logger = LoggerFactory.getLogger(MyBatisBatchBaseDao.class);

    /** The sql session factory bean. */
    @Autowired
    private SqlSessionFactoryBean sqlSessionFactoryBean;


    /**
     * 执行批量动作，全部执行完成后提交
     *
     * @param <M> 要调用Mapper类型
     * @param <D> 要处理的Model类型
     * @param mapperClass 要调用的 Mybatis 接口类型
     * @param methodName 要调用的接口方法
     * @param dataCollection 要批处理的数据
     * @throws BatchExecuteException 当执行批处理过程出错
     */
    public <M, D> void batchExec(Class<M> mapperClass, String methodName, Collection<D> dataCollection) throws BatchExecuteException{
        batchExec(mapperClass, methodName, dataCollection, 0);
    }

    /**
     * 执行批量动作，每执行完成<code>commitPeriod<code/>条数据提交
     *
     * @param <M> 要调用Mapper类型
     * @param <D> 要处理的Model类型
     * @param mapperClass 要调用的 Mybatis 接口类型
     * @param methodName 要调用的接口方法
     * @param dataCollection 要批处理的数据
     * @param commitPeriod 提交周期<br>
     *                     <ul>
     *                     <li>commitPeriod > 0时，每commitPeriod条数据提交一次，后续出错将无法回滚。</li>
     *                     <li>否则，全部数据执行完成后提交</li>
     *                     </ul>
     * @throws BatchExecuteException 当执行批处理过程出错
     */
    public <M, D> void batchExec(Class<M> mapperClass, String methodName, Collection<D> dataCollection, int commitPeriod) throws BatchExecuteException{
        if (CollectionUtils.isEmpty(dataCollection)) {
            return;
        }
        try (SqlSession sqlSession = sqlSessionFactoryBean.getObject().openSession(ExecutorType.BATCH)) {
            try {
                M mapper = sqlSession.getMapper(mapperClass);
                int invokeCounter = 0;
                for (D dataItem : dataCollection) {
                    MethodUtils.invokeMethod(mapper, methodName, dataItem);
                    invokeCounter++;
                    if (commitPeriod > 0 && invokeCounter % commitPeriod == 0) {
                        sqlSession.commit();
                        sqlSession.clearCache();
                    }
                }
                sqlSession.commit();
            } catch (Exception e) {
                sqlSession.rollback();
                throw new BatchExecuteException(e);
            }
        } catch (Exception e) {
            logger.error("执行批量操作失败", e);
            throw new BatchExecuteException("执行批量操作失败", e);
        }
    }
}
