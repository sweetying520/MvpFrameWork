package com.dream.mvpframework.common;

import java.io.File;

/**
 *
 * @author Administrator
 * @date 2018/6/9
 */

public class MyConstants {

    /**
     * Path
     */
    public static final String PATH_DATA = MyApplication.getInstance().getCacheDir().getAbsolutePath() + File.separator + "data";

    public static final String PATH_CACHE = PATH_DATA + "/NetCache";

    static final String BUGLY_ID = "16e54f8921";
}
