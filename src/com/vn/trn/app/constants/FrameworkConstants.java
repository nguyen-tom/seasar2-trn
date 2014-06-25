package com.vn.trn.app.constants;

/**
 * ??????????????? ??? JACCS???????????????????????????<BR>
 * ????????????????????? ??? <BR>
 * ????????? ??? ????????????<BR>
 * ???????????? ??? <BR>
 * @version 1.00
 * @author SIS-A.Shinomiya
 */
public final class FrameworkConstants {

	/**
	 * private?????????????????????
	 */
	private FrameworkConstants() {
	}

	/** SLGN010ActionImpl */
	public static final String CLASS_NAME = "jp.co.cacco.app.action.SLGN.impl.SLGN010ActionImpl";
	
	/** SLGN010SsoActionImpl */
	public static final String SSO_CLASS_NAME = "jp.co.cacco.app.action.SLGN.impl.SLGN010SsoActionImpl";

	/** ??????????????????????????????????????????(session?????????) */
	public static final String SESSION_LOGIN_USER_DATA_ATTR_NAME = "USER_DATA";

	/** ?????????????????????????????????????????? LoginUserData */
	public static final String LOGIN_USER_DATA_ATTR_NAME = "jp.co.cacco.app.framework.auth.LoginUserData";

}