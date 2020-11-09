package com.thb.utils;

import com.thb.domain.ResultDTO;

public class ResultUtils {

    public static ResultDTO failResult(String msg){

        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setResult(false);
        resultDTO.setMessage(msg);
        return resultDTO;
    }

    public static ResultDTO successResult(String msg){

        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setResult(true);
        resultDTO.setMessage(msg);
        return resultDTO;
    }

    public static <T>ResultDTO<T> successResult(T t,String msg){

        ResultDTO<T> resultDTO = new ResultDTO<>();
        resultDTO.setResult(true);
        resultDTO.setMessage(msg);
        resultDTO.setData(t);
        return resultDTO;
    }

    public static <T>ResultDTO<T> failResult(T t,String msg){

        ResultDTO<T> resultDTO = new ResultDTO<>();
        resultDTO.setResult(false);
        resultDTO.setMessage(msg);
        resultDTO.setData(t);
        return resultDTO;
    }
}
