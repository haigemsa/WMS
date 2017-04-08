package com.ken.wms.common.service.Interface;

import com.ken.wms.exception.SystemLogServiceException;

import java.util.Map;

/**
 * 系统操作日志Service接口
 *
 * @author Ken
 * @since 2017/4/7.
 */
public interface SystemLogService {

    String ACCESS_TYPE_LOGIN = "登入";
    String ACCESS_TYPE_LOGOUT = "登出";

    /**
     * 插入用户登入登出记录
     *
     * @param userID     用户ID
     * @param userName   用户名
     * @param accessIP   登陆IP
     * @param accessType 记录类型
     */
    void insertAccessRecord(Integer userID, String userName, String accessIP, String accessType) throws SystemLogServiceException;

    /**
     * 查询指定用户ID、记录类型或日期范围的登入登出记录
     *
     * @param userID       用户ID
     * @param accessType   记录类型
     * @param startDateStr 记录起始日期
     * @param endDateStr   记录结束日期
     * @return 返回一个Map， 其中键值为 data 的值为所有符合条件的记录， 而键值为 total 的值为符合条件的记录总条数
     */
    Map<String, Object> selectAccessRecord(Integer userID, String accessType, String startDateStr, String endDateStr) throws SystemLogServiceException;

    /**
     * 分页查询指定用户ID、记录类型或日期范围的登入登出记录
     *
     * @param userID       用户ID
     * @param accessType   记录类型
     * @param startDateStr 记录起始日期
     * @param endDateStr   记录结束日期
     * @param offset       分页偏移值
     * @param limit        分页大小
     * @return 返回一个Map， 其中键值为 data 的值为所有符合条件的记录， 而键值为 total 的值为符合条件的记录总条数
     */
    Map<String, Object> selectAccessRecord(Integer userID, String accessType, String startDateStr, String endDateStr, int offset, int limit) throws SystemLogServiceException;
}
