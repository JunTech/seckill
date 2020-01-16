package top.juntech.seckill.exception;

import top.juntech.seckill.common.CodeMsg;

/**
 * @author juntech
 * @version ${version}
 * @date 2020/1/10 11:48
 * @ClassName 类名
 * @Descripe 描述
 */
public class GlobalException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private CodeMsg cm;

    public GlobalException(CodeMsg cm) {
        super(cm.toString());
        this.cm = cm;
    }

    public CodeMsg getCm() {
        return cm;
    }
}
