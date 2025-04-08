package com.atguigu.lease.web.admin.custom.converter;

import com.atguigu.lease.model.enums.ItemType;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToItemTypeConverter implements Converter<String, ItemType> {
    @Override
    public ItemType convert(String itemTypeCode) { // 1 or 2, showing Apartment and room respectively
        ItemType[] itemTypes = ItemType.values();
        for (ItemType itemType : itemTypes) {
            // getCode returns Integer, parse String to Integer (Object)
            if (itemType.getCode().equals(Integer.valueOf(itemTypeCode))) {
                return itemType;
            }
        }
        throw new IllegalArgumentException("Code " + itemTypeCode + " not exist");

    }
}
