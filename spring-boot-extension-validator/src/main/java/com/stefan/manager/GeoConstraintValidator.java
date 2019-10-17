package com.stefan.manager;

import com.stefan.domain.annotation.GeoLonCheck;
import lombok.extern.slf4j.Slf4j;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @Description: 自定义注解逻辑实现 {@link ConstraintValidator}
 * @Author: Stefan
 * @Date: 2019/7/17 8:41 AM
 */
@Slf4j
public class GeoConstraintValidator implements ConstraintValidator<GeoLonCheck, Double> {

    private GeoLonCheck geoLonCheck;

    /** 预加载 */
    @Override
    public void initialize(GeoLonCheck geoLonCheck) {
        this.geoLonCheck = geoLonCheck;
    }

    /** 约束校验逻辑 */
    @Override
    public boolean isValid(Double value, ConstraintValidatorContext context) {
        log.info("GeoLonCheck: " + geoLonCheck);
        /** null不进行验证，配合@NotNull注解控制 */
        if(value == null) {
            return true;
        }
        /** 中国经度范围：73°33′E ～ 135°05′E */
        if(value < 73.33 || value > 135.05) {
            return false;
        }
        return true;
    }
}
