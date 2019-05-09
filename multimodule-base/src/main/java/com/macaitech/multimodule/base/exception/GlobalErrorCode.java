package com.macaitech.multimodule.base.exception;

/**
 * 
 * @author yuhui.tang
 *
 */
public enum GlobalErrorCode implements ErrorCode {

	SUCCESS(1, "OK"),//成功

    FAILURE(-1, "Failure"),//失败
    //public static final String ERROR = "-1";//失败

    BAD_REQUEST(400, "Bad Request"),
    UNAUTHORIZED(401, "Unauthorized"),
    FORBIDDEN(403, "Forbidden"),
    NOT_FOUND(404, "Not Found"),
    METHOD_NOT_ALLOWED(405, "Method Not Allowed"),

    INTERNAL_SERVER_ERROR(500, "Internal Server Error"),
    
    INVALID_PARAM(10101, "参数错误"),
	PARAM_NULL(100001, "参数为空"),
	REQUEST_TOO_MUCH(100002, "请求过于频繁"),
	
	ILLEGAL_PHONE_NUMBER(100003, "非法的手机号格式"),
	PHONENUMBER_IS_NULL(100004, "手机号为空"),
	PASSWORD_IS_NULL(100005, "密码为空"),
	ILLEGAL_PASSWORD(100006, "非法的密码格式"),
	WRONG_PHONENUMBER_OR_PASSWORD(100007, "错误的手机号或密码"),
	USERNAME_IS_NULL(100008, "用户名为空"),
	PHONE_VALIDATE_CODE_IS_NULL(100009, "手机验证码为空"),
	WRONG_PHONE_VALIDATE_CODE(100010, "错误的手机验证码"),
	PHONENUMBER_IS_EXIST(100011, "手机号已经被注册"),
	ILLEGAL_USERNAME(100012, "非法的用户名格式"),
	USERNAME_IS_EXIST(100013, "用户名已存在"),
	OLDPASSWORD_IS_NULL(100014, "旧密码为空"),
	NEWPASSWORD_IS_NULL(100015, "新密码为空"),
	AUTHPASSWORD_IS_NULL(100016, "二次密码为空"),
	TWO_PASSWORD_NOT_MATCH(100017, "两次密码不一致"),
	WRONG_PASSWORD(100018, "密码错误"),
	WRONG_IMAGE_VALIDATE_CODE(100019, "错误的图片验证码"),
	
	USER_NOT_EXSIT(100020, "用户不存在"),
	NOT_ROOMTEACHER(100021, "当前用户不是该直播室老师"),
	CURRENT_NO_LIVE(100022, "当前期刊没有直播"),
	USER_NOT_PERIODICAL_TEACHER(100023, "用户不是当前直播期刊老师"),
	USER_AND_TEACHER_NOT_ROOM(100024, "用户与老师不属于同一个直播室"),
	USER_ALREADY_EXIST_BANNED(100025, "用户已经被禁言"),
	USER_NOT_ALREADY_EXIST_BANNED(100026, "用户尚未被禁言"),
	USER_NOT_PERIODICAL_ACCOUNT(100027, "用户不是当前直播期刊的观众"),
	CURRENT_IN_THE_LIVE(100028, "当前直播有已有期刊正在直播"),
	USER_NOT_GO_INTO_ROOM(100029, "您无法进入该直播间"),
	CURRENT_ROOM_NOT_EXIST(100030, "当前直播室不存在"),
	USER_NOT_BIND_ROOM(100031, "参用户尚未绑定聊天室"),
	
	PARAM_LENGTH(100032, "参数长度太大"),
	
	ENTREPOT_COMMODITY(100033, "建仓商品不存在"),
	ENTREPOT_COMMODITY_ALREADY_CLOSE(100034, "建仓商品已经平仓"),
	USER_IS_TEACHER_NOT_BANNED(100035, "当前用户为老师 不能被禁言"),
	
	UPDATE_FRONTUSERPHOTO(100036, "App前台用户个人资料修改 失败"),
	NIKENAME_DATAIMG_IS_NULL(100037, "App前台用户头像昵称都是空  失败"),
	FRONTUSER_NOT_EXSIT(100038, "App前台获取用户个人资料  失败"),
	DATAIMG_DECODE_FALSE(100039, "App的base64头像解码  失败"),
	CENTRALTOKEN_DECODE_FALSE(100040, "App的centraltoken解码  失败"),
	CENTRALTOKEN_IS_NULL(100041, "App的centraltoken解密的userid为空"),
	CENTRALTOKEN_NOT_EXSIT(100042, "App的centraltoken为空"),
	GETVIEWPOINT_IS_FALSE(100043, "App的获取观点列表接口错误app/appTypeLiveLastedArticle.htm"),
	GETOPIC_IS_FALSE(100044, "App的获取圆桌列表接口错误app/topic.htm"),
	
	NIKENAME_SENSITIVE_WORD(100045, "昵称涉及敏感词汇"),
	NIKENAME_IS_LONG(100046, "昵称过长"),
	SKIPPAGE_IS_NULL(100047, "跳转信息为空"),
	ADSID_IS_NULL(100048, "广告类别为空"),
	AOP_TIME_TOO_LONG(110001, "AOP->等待时间太长"),
	AOP_WAIT_RESULT_ERROR(110002, "AOP->异步超时等待结果异常"),
	AOP_RESULT_ERROR(110003, "AOP->直接处理结果异常"),
	
	TOKEN_IS_NULL(20007, "登录失效"),
	PRODUCTACT_NULL(200001, "无对应的产品或者产品对应价格不存在或不匹配"),
	PRODUCTBUY_IS_NULL(200002, "没有购买此产品"),
	PRODUCTID_IS_NULL(200003, "没有对应的产品"),
	PRODUCTUSER_IS_NULL(200004, "该产品下没有对应的用户"),
	PRODUCTCOLUMN_IS_NULL(200005, "没有对应的栏目"),
	PRODUCTNAME_IS_NULL(200006, "没有对应产品名称"),
	CHARGESTATUS_IS_NULL(200008, "收费状态没传"),
	GETPORT_IS_FALSE(200009, "rpc调取接口失败"),
	USERGETVIPSTRATEGY_IS_FALSE(30009, "vip策略已经领取"),
	
	PARAMETER_IS_NULL(40001, "参数为空"),
	YNHTEACHER_IS_NULL(40016, "约牛号老师不存在"),
	TOKE_ERROR(20010, "TOKEN 错误"),
	PAY_ORDERID_NULL(60004, "订单号为空"),
	PAYSOURCE_NOT_EXSIT(60005, "来源为空"),
	GOODSID_NOT_EXSIT(60006, "商品id为空"),
	GOODSTYPE_NOT_EXSIT(60007, "商品类型为空"),
	TOTALPRICE_NOT_EXSIT(60008, "商品价格为空"),
	TEACHERID_NOT_EXSIT(60009, "老师id为空"),
	CHANNEL_NOT_EXSIT(60010, "频道不存在"),
	
	PAY_ORDER_NULL(60011, "订单不存在"),
	OPTER_FAIL(60012, "操作失败"),
	PAY_SIGN_NULL(60013, "支付结果的签名为空"),
	PAY_MONTY_ERROR(60014, "订单金额错误"),
	PAY_FAILED(60015, "支付失败"),
	PAYORDER_FAILED(60016, "更新订单失败"),
	
	RESULTRPC_IS_NULL(60017, "返回数据为null"),
	BUYNUMBER_NOT_EXSIT(60018, "购买数量为空"),
	ORDERID_IS_NULL(60019, "订单号为空"),
	TRADE_NO_IS_NULL(60020, "TRADE_NO为空"),
	PAYMODE_IS_NULL(60021, "PAYMODE为空"),
	PAY_SOURCE_ERROR(60022, "充值来源错误"),
	PAY_BANLANCE_ERROR(60023, "账户余额不足"),
	PTYPE_IS_NULL(700001, "推送类别为空"),
	PUSHREGISTID_IS_NULL(700002, "获取极光推送的设备id（注册id）为空"),
	ALLREAD_IS_NULL(700003, "获取极光推送的设备id（注册id）为空"),
	ARTICLE_ID_IS_NULL(700004, "资讯的文章id为空"),
	CONTENT_SENSITIVE_WORD(700005, "内容涉嫌感词汇"),
	SYSTEMCODE_IS_NULL(700006, "系统的标识为空"),
	SYSTEMUSERID_IS_NULL(700007, "系统的用户id为空"),
	;


    GlobalErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    private final int code;

    private final String message;


    @Override
    public int getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
