package com.bookmarketsys.databasejob.util;

public class ResultUtil {

    public static Result error(int code, String msg) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(null);
        return result;
    }

    public static Result error(ResultEnum resultEnum) {
        Result result = new Result();
        result.setCode(resultEnum.getCode());
        result.setMsg(resultEnum.getMsg());
        result.setData(null);
        return result;
    }

    public static Result success(Object obj) {
        Result result = new Result();
        result.setCode(200);
        result.setMsg("成功");
        result.setData(obj);
        return result;
    }

    public static Result success(ResultEnum resultEnum) {
        Result result = new Result();
        result.setCode(resultEnum.getCode());
        result.setMsg(resultEnum.getMsg());
        result.setData(null);
        return result;
    }

    public static Result success() {
        Result result = new Result();
        result.setCode(200);
        result.setMsg("成功");
        result.setData(null);
        return result;
    }

    /**
     * 自定义成功信息，且带数据对象
     * @param msg
     * @param obj
     * @return
     */
    public static Result success(String msg, Object obj) {
        Result result = new Result();
        result.setCode(200);
        result.setMsg(msg);
        result.setData(obj);
        return result;
    }

    /**
     * 自定义成功信息，不带数据对象
     * @param msg
     * @return
     */
    public static Result success(String msg) {
        Result result = new Result();
        result.setCode(200);
        result.setMsg(msg);
        result.setData(null);
        return result;
    }

}

