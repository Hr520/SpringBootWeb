/**
 * Copyright (C) 2018-2019 武汉兼济物联科技有限公司.
 *
 * 物联网云平台接口服务层
 * 公共常数
 *
 * sangwei      2017.10.8
 *
 */
package com.ssm.util;

import org.springframework.http.HttpStatus;

public class BaseConstant {
    public static final int ID_CUSTOMER_COMMON = -1;
    public static final int ID_ROLE_SUPER = 1;
    /**
     * 通用状态码
     */
    public static final int STATE_UNINITED = 0;
    public static final int STATE_AVAILABLE = 1;
    public static final int STATE_ENABLE = STATE_AVAILABLE;
    public static final int STATE_LOCKED = 2;
    public static final int STATE_DISABLE = STATE_LOCKED;
    public static final int STATE_TO_BE_DELETED = 3;

    /**
     * 对象类型编码
     */
    public static final int OBJ_TYPE_UNKNOW = 0;
    public static final int OBJ_TYPE_CUSTOMER = 100;
    public static final int OBJ_TYPE_CUSTOMER_PROFILE = 101;
    public static final int OBJ_TYPE_CUSTOMER_ADMINISTRATOR = 102;
    public static final int OBJ_TYPE_CUSTOMER_CAPABILITY = 103;
    public static final int OBJ_TYPE_USER = 110;
    public static final int OBJ_TYPE_USER_ID3RD = 111;
    public static final int OBJ_TYPE_USER_IDENTITY = 112;
    public static final int OBJ_TYPE_USER_ADDRESS = 113;
    public static final int OBJ_TYPE_CONTROL_UNIT = 120;
    public static final int OBJ_TYPE_CONTROL_UNIT_TYPE = 121;
    public static final int OBJ_TYPE_CONTROL_NODE = 122;
    public static final int OBJ_TYPE_CONTROL_NODE_TYPE = 123;
    public static final int OBJ_TYPE_NODE_PROPERTY = 124;
    public static final int OBJ_TYPE_CONTROL_UNIT_LINK = 125;
    public static final int OBJ_TYPE_CONTROL_UNIT_OTA = 126;
    public static final int OBJ_TYPE_DEVICE = 130;
    public static final int OBJ_TYPE_DEVICE_NODE = 131;
    public static final int OBJ_TYPE_MSGSRV = 140;
    public static final int OBJ_TYPE_MSGSRV_TYPE = 141;
    public static final int OBJ_TYPE_MSGSRV_GATEWAY = 142;
    public static final int OBJ_TYPE_MSGSRV_COMM_LINK_ = 143;
    public static final int OBJ_TYPE_MSGSRV_COMM_CHANNEL = 144;
    public static final int OBJ_TYPE_PERMISSION_SYS_ROLE = 150;
    public static final int OBJ_TYPE_PERMISSION_SYS_RESOURCE = 151;
    public static final int OBJ_TYPE_PERMISSION_OBJECT_ROLE = 152;
    public static final int OBJ_TYPE_PERMISSION_OBJECT_RESOURCE = 153;
    public static final int OBJ_TYPE_PERMISSION_RAW_PERMISSION = 154;
    public static final int OBJ_TYPE_MESSAGE = 160;
    public static final int OBJ_TYPE_EA_EVENTACTION = 170;
    public static final int OBJ_TYPE_EA_EVENT_DEFINITION = 171;
    public static final int OBJ_TYPE_EA_ACTION_COLLECTION = 172;
    public static final int OBJ_TYPE_EA_EVENT = 173;
    public static final int OBJ_TYPE_EA_ACTION = 174;
    public static final int OBJ_TYPE_EA_ACTION_DEFINITION = 175;
    public static final int OBJ_TYPE_RG_CAMEL_ROUTE = 180;
    public static final int OBJ_TYPE_GROUP = 190;
    public static final int OBJ_TYPE_GROUP_TYPE = 191;
    public static final int OBJ_TYPE_GROUP_ADMIN = 192;
    public static final int OBJ_TYPE_GROUP_MEMBER = 193;


    /**
     * 客户默认服务时间（单位：天）
     */
    public static final int CUSTOMER_DEFAULT_SERVE_DAYS = 90;

    /**
     * 消息服务器类型
     */
    public static final int MSGSRV_TYPE_UNKNOW = 0;
    public static final int MSGSRV_TYPE_MQTT = 1;
    public static final int MSGSRV_TYPE_COAP = 2;
    public static final int MSGSRV_TYPE_HTTP = 3;
    public static final int MSGSRV_TYPE_MAX = 4;

    public static boolean isValidMsgSrvType(int type) {
        return (type > MSGSRV_TYPE_UNKNOW && type < MSGSRV_TYPE_MAX);
    }

    /**
     * 通信链路类型
     */
    public static final int COMM_CHANNEL_TYPE_UNKNOW = 0;
    public static final int COMM_CHANNEL_TYPE_UPLINK = 1;                   // 仅上行
    public static final int COMM_CHANNEL_TYPE_DOWNLINK = 2;                 // 仅下行
    public static final int COMM_CHANNEL_TYPE_UPDOWNLINK = 3;               // 双向通信

    /**
     * 消息类型
     */
    public static final int MSG_TYPE_ALL = -1;                              // 所有类型
    public static final int MSG_TYPE_UNKNOW = 0;                            // 未知类型
    public static final int MSG_TYPE_UPLINK_DATA = 1;                       // 上行数据
    public static final int MSG_TYPE_DOWNLINK_DATA = 2;                     // 下行数据
    public static final int MSG_TYPE_UPLINK_OTA = 1001;                     // 上行OTA数据
    public static final int MSG_TYPE_DOWNLINK_OTA = 1002;                   // 下行OTA数据

    /**
     * 默认指令超时时间
     */
    public static final short MSG_DEFAULT_EXPIRED_MS = 10*1000;             // 默认消息超时时间10秒

    /**
     * 消息处理结果
     */
    public static final int MSG_PROCESS_RESULT_TONEXT = 0;                  // 消息继续往下传递
    public static final int MSG_PROCESS_RESULT_ABSORDED = 1;                // 消息不往下传递

    /**
     * 属性的访问模式
     */
    public static final int PROP_ACCESS_MODE_READ = 0x01;                   // 支持读
    public static final int PROP_ACCESS_MODE_WRITE = 0x02;                  // 支持写
    public static final int PROP_ACCESS_MODE_EXEC = 0x04;                   // 支持执行
    public static final int getAccessMode(String amode) {
        String AMODE = amode.toUpperCase();
        int accmode = 0x00;
        if (AMODE.contains("R")) {
            accmode |= PROP_ACCESS_MODE_READ;
        }
        if (AMODE.contains("W")) {
            accmode |= PROP_ACCESS_MODE_WRITE;
        }
        if (AMODE.contains("X")) {
            accmode |= PROP_ACCESS_MODE_EXEC;
        }
        return accmode;
    }

    /**
     * device hub 类型，按照产品来划分
     *   0 --  99 为保留设备类型，一般为公司通用类产品
     * 100 -- 255 为客户自定义设备类型
     */
    public static final int DEVHUB_TYPE_UNKNOW = -1;
    public static final int DEVHUB_TYPE_DESKTOP_SWITCH = 0;                 // 第一代桌面开关，已废弃
    public static final int DEVHUB_TYPE_LIGHT_CONTROL = 1;                  // 第一代灯控制器，已废弃
    public static final int DEVHUB_TYPE_DOOR_LOCK = 2;                      // 门禁控制器
    public static final int DEVHUB_TYPE_AIR_CONDITION_POWER_CONTROL = 3;    // 空调电源控制器
    public static final int DEVHUB_TYPE_IR_REMOTE = 4;                      // 红外控制器
    public static final int DEVHUB_TYPE_SWITCH_CURDET = 5;                  // 带电流检测开关，已废弃
    public static final int DEVHUB_TYPE_CABINET = 6;                        // 储物柜
    public static final int DEVHUB_TYPE_CARD_READER = 7;                    // 读卡器
    public static final int DEVHUB_TYPE_IBEACON = 8;                        // 定位ibeacon
    public static final int DEVHUB_TYPE_POWER_STRIP_II = 9;                 // 第二代智能插座
    public static final int DEVHUB_TYPE_CARD_POWER_STRIP = 10;              // 单孔刷卡电源
    public static final int DEVHUB_TYPE_SMOKING_DETECTOR = 11;              // 烟雾报警器
    public static final int DEVHUB_TYPE_LIGHT_CONTROL_II = 12;              // 第二代灯控制器
    public static final int DEVHUB_TYPE_HIGH_POWER_CTRL = 13;               // 大电流控制器

    /**
     * device node 类型，按照最小表现层单元来划分；
     * 比如对于一个device hub 类型为 2 的门禁控制器，其包含最少两个 device node
     * 一个 device node 为读卡器，一个 device node 为门禁执行机构；
     * 对于一个 device hub 类型为 10 的单孔刷卡电源，其包含最少三个 device node
     * 一个 device node 为读卡器，一个 device node 为电源开关控制器，一个 device node 为电流测量单元
     * 对于一个 device hub 类型为 3 的空调电源控制器，其包含最少两个 device node
     * 一个 device node 为电源开关控制器，一个 device node 为温度检测单元
     */
    public static final int DEVNODE_TYPE_COMMON_FEATURE = -1;               // 公共属性
    public static final int DEVNODE_TYPE_CARD_READER = 0;                   // 读卡器
    public static final int DEVNODE_TYPE_POWER_CONTROLLER = 1;              // 电源开关控制器
    public static final int DEVNODE_TYPE_DOOR_LOCK_EXECUTOR = 2;            // 门禁执行机构
    public static final int DEVNODE_TYPE_IR_TRANSMITTER = 3;                // 红外信号发射器
    public static final int DEVNODE_TYPE_TEMPERATURE_SENSOR = 4;            // 温度检测单元
    public static final int DEVNODE_TYPE_CURRENT_SENSOR = 5;                // 电流检测单元
    public static final int DEVNODE_TYPE_NEAR_DISTANCE_REPORTER = 6;        // 短距位置测量单元
    public static final int DEVNODE_TYPE_FARD_DISTANCE_REPORTER = 7;        // 长距位置测量单元

    /**
     * 组类型
     */
    public static final int GROUP_TYPE_UNKNOW = 0;
    public static final int GROUP_TYPE_ORGANIZATION = 1;
    public static final int GROUP_TYPE_USER = 2;
    public static final int GROUP_TYPE_DEVICE = 3;
    public static final int GROUP_TYPE_MIXED = 4;
    public static final int GROUP_TYPE_MAX = 5;

    public static boolean isValidGroupType(int type) {
        return (type > GROUP_TYPE_UNKNOW && type < GROUP_TYPE_MAX);
    }

    /**
     * 身份认证属性类型
     */
    public static final int USER_IDENTITY_UNKNOW = 0;                       // 未知类型
    public static final int USER_IDENTITY_TYPE_RFID = 1;                    // RFID卡
    public static final int USER_IDENTITY_TYPE_FINGER_PRINT = 2;            // 指纹
    public static final int USER_IDENTITY_TYPE_VOICE_ID = 3;                // 声纹
    public static final int USER_IDENTITY_TYPE_FACE_ID = 4;                 // 人脸ID
    public static final int USER_IDENTITY_TYPE_PLATE_NUMBER = 5;            // 车牌号
    public static final int USER_IDENTITY_TYPE_MAX = 6;

    public static boolean isValidIdentityType(int type) {
        return (type >= USER_IDENTITY_UNKNOW && type < USER_IDENTITY_TYPE_MAX);
    }

    /**
     * RFID卡类型
     */
    public static final int RFID_TYPE_UNKNOW = 0;
    public static final int RFID_TYPE_YIKATONG = 1;
    public static final int RFID_TYPE_GEN2RD_ID = 2;
    public static final int RFID_TYPE_MAX = 3;

    public static boolean isValidRfidType(int type) {
        return (type >= RFID_TYPE_UNKNOW && type < RFID_TYPE_MAX);
    }

    /**
     * 事件发生类型定义
     */
    public static final int EVENT_TYPE_UNKNOW = 0;        // 未知
    public static final int EVENT_TYPE_GT = 1;            // 大于
    public static final int EVENT_TYPE_LT = 2;            // 小于
    public static final int EVENT_TYPE_EQ = 3;            // 等于
    public static final int EVENT_TYPE_NE = 4;            // 不相等
    public static final int EVENT_TYPE_GT_EQ = 5;         // 大于等于
    public static final int EVENT_TYPE_LT_EQ = 6;         // 小于等于
    public static final int EVENT_TYPE_OOR = 7;           // 超出范围
    public static final int EVENT_TYPE_JUST_HAPPENS = 8;  // 发生即产生事件
    public static final int EVENT_TYPE_MAX = 9;

    public static boolean isValidEventType(int type) {
        return (type > EVENT_TYPE_UNKNOW && type < EVENT_TYPE_MAX);
    }

    /**
     * 连接状态定义
     */
    public static final int CC_STATE_UNKNOW = 0;            // 未知状态
    public static final int CC_STATE_CONN_FAILD = 1;        // 连接失败
    public static final int CC_STATE_CONNECTED = 2;         // 已连接
    public static final int CC_STATE_CONN_LOST = 3;         // 连接断开

    /**
     * 权限授权模式
     */
    public static final int PERM_MODE_EXPIRY_DATE = 0;          // 截止日期，到期后权限失效
    public static final int PERM_MODE_SLOT_DATETIME = 1;        // 时间段，从某一个日期开始到某一个日期结束
    public static final int PERM_MODE_SLOT_TIME_PER_DATE = 2;   // 时间段，从某一个日期开始到某一个日期结束，期间只有某一时间段有效
    public static final int PERM_MODE_PERIOD_DATE = 3;          // 周期性的某个时间段

    /**
     * 通用restful返回结果
     */
    public static final HttpStatus RESULT_OK = HttpStatus.OK;
    public static final HttpStatus RESULT_DENIED = HttpStatus.FORBIDDEN;
    public static final HttpStatus RESULT_GENERAL_FAIL = HttpStatus.INTERNAL_SERVER_ERROR;
    public static final HttpStatus RESULT_NOT_FOUND = HttpStatus.NOT_FOUND;
    public static final HttpStatus RESULT_ERR_PARAMETER = HttpStatus.PARTIAL_CONTENT;
    public static final HttpStatus RESULT_CUSTOMER_NOT_FOUND = HttpStatus.NOT_FOUND;
    public static final HttpStatus RESULT_CUSTOMER_PROFILE_NOT_FOUND = HttpStatus.NOT_FOUND;
    public static final HttpStatus RESULT_CUSTOMER_ADMIN_NOT_FOUND = HttpStatus.NOT_FOUND;
    public static final HttpStatus RESULT_ROLE_NOT_FOUND = HttpStatus.NOT_FOUND;
    public static final HttpStatus RESULT_NAME_NOT_SPECIFIED = HttpStatus.PARTIAL_CONTENT;
    public static final HttpStatus RESULT_ALREADY_EXIST = HttpStatus.CONFLICT;
    public static final HttpStatus RESULT_SUPER_NOT_FOUND = HttpStatus.NOT_FOUND;
    public static final HttpStatus RESULT_GROUP_NOT_FOUND = HttpStatus.NOT_FOUND;
    public static final HttpStatus RESULT_GROUP_ADMIN_NOT_FOUND = HttpStatus.NOT_FOUND;
    public static final HttpStatus RESULT_GROUP_MEMBER_NOT_FOUND = HttpStatus.NOT_FOUND;
    public static final HttpStatus RESULT_USER_NOT_FOUND = HttpStatus.NOT_FOUND;
    public static final HttpStatus RESULT_USER_3RDID_NOT_FOUND = HttpStatus.NOT_FOUND;
    public static final HttpStatus RESULT_USER_RFID_NOT_FOUND = HttpStatus.NOT_FOUND;
    public static final HttpStatus RESULT_DEVTYPE_NOT_FOUND = HttpStatus.NOT_FOUND;
    public static final HttpStatus RESULT_DEVHUB_NOT_FOUND = HttpStatus.NOT_FOUND;
    public static final HttpStatus RESULT_DEVNODE_NOT_FOUND = HttpStatus.NOT_FOUND;
    public static final HttpStatus RESULT_DEVLINK_NOT_FOUND = HttpStatus.NOT_FOUND;
    public static final HttpStatus RESULT_DEV_PROPERTY_NOT_FOUND = HttpStatus.NOT_FOUND;
    public static final HttpStatus RESULT_DEV_CONFIG_ITEM_NOT_FOUND = HttpStatus.NOT_FOUND;
    public static final HttpStatus RESULT_DEV_CONTROL_POINT_NOT_FOUND = HttpStatus.NOT_FOUND;
    public static final HttpStatus RESULT_MSGSRV_NOT_FOUND = HttpStatus.NOT_FOUND;
    public static final HttpStatus RESULT_GATEWAY_NOT_FOUND = HttpStatus.NOT_FOUND;
    public static final HttpStatus RESULT_COMMLINK_NOT_FOUND = HttpStatus.NOT_FOUND;
    public static final HttpStatus RESULT_COMMCHANNEL_NOT_FOUND = HttpStatus.NOT_FOUND;
    public static final HttpStatus RESULT_EVENT_DEF_NOT_FOUND = HttpStatus.NOT_FOUND;
    public static final HttpStatus RESULT_EVENT_NOT_FOUND = HttpStatus.NOT_FOUND;
    public static final HttpStatus RESULT_ACTION_COLLECTION_NOT_FOUND = HttpStatus.NOT_FOUND;
    public static final HttpStatus RESULT_ACTION_NOT_FOUND = HttpStatus.NOT_FOUND;
    public static final HttpStatus RESULT_DEVTYPE_SCHEMA_INVALID = HttpStatus.NOT_FOUND;
}
