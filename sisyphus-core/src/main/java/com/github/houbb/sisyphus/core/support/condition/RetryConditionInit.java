package com.github.houbb.sisyphus.core.support.condition;

import com.github.houbb.heaven.annotation.ThreadSafe;
import com.github.houbb.sisyphus.api.support.attempt.RetryAttempt;
import com.github.houbb.sisyphus.api.support.condition.RetryCondition;
import com.github.houbb.sisyphus.api.support.pipeline.Pipeline;
import com.github.houbb.sisyphus.core.support.pipeline.DefaultPipeline;

/**
 * 重试条件初始化类
 * @author binbin.hou
 * @since 1.0.0
 */
@ThreadSafe
public abstract class RetryConditionInit implements RetryCondition {

    @Override
    public boolean condition(RetryAttempt retryAttempt) {
        Pipeline<RetryCondition> pipeline = new DefaultPipeline<>();
        this.init(pipeline, retryAttempt);

        return false;
    }

    /**
     * 初始化列表
     * @param pipeline 当前列表泳道
     * @param retryAttempt 执行信息
     */
    protected abstract void init(final Pipeline<RetryCondition> pipeline,
                        final RetryAttempt retryAttempt);

}
