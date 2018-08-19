/*
 * Copyright (c) 2017, org.smartboot. All rights reserved.
 * project name: smart-socket
 * file name: Filter.java
 * Date: 2017-11-25
 * Author: sandao
 */

package org.smartboot.socket;

import org.smartboot.socket.transport.AioSession;

/**
 * 消息/服务过滤器。
 * <p>
 * smart-socket设计的{@code Filter}与状态机{@link StateMachineEnum}看上去比较类似，但两者是以不同的维度对发生的事件进行Filter处理。
 * </p>
 * <p>
 * <i>现阶段的Filter更像是事件监听器，只能被动接收事件通告，无法改变原定的处理流程。未来可能会重新设计一下，使其成为真正意义上的Filter。目前主要用于服务数据监控。</i>
 * </p>
 * {@code Filter}以系统服务级别实时过滤如下事件：
 * <ol>
 * <li>connected</li>
 * <li>closed</li>
 * <li>processFail</li>
 * <li>processFilter</li>
 * <li>readFilter</li>
 * <li>writeFilter</li>
 * </ol>
 *
 * @author 三刀
 * @version V1.0.0
 */
public interface Filter<T> {


    /**
     * 数据读取过滤,可用于统计流量
     *
     * @param session  当前执行read的AioSession对象
     * @param readSize 本次解码读取的数据长度
     */
    void readFilter(AioSession<T> session, int readSize);

    /**
     * 数据输出过滤,可用于统计流量
     *
     * @param session   本次执行write回调的AIOSession对象
     * @param writeSize 本次输出的数据长度
     */
    void writeFilter(AioSession<T> session, int writeSize);

}
