package com.example.utils;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.lang.NonNull;

import java.beans.PropertyDescriptor;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public final class NullAwareBeanUtils {

    private NullAwareBeanUtils() {
    }

    /**
     * Copies non-null properties from one object to another.
     *
     * @param source
     * @param destination
     * @param ignoreProperties
     */
    public static void copyNonNullProperties(Object source, Object destination, String... ignoreProperties) {
        final Set<String> ignoreAllProperties = new HashSet<String>();
        ignoreAllProperties.addAll(getPropertyNamesWithNullValue(source));
        ignoreAllProperties.addAll(Arrays.asList(ignoreProperties));

        BeanUtils.copyProperties(source, destination, ignoreAllProperties.toArray(new String[] {}));
    }

    @NonNull
    private static Set<String> getPropertyNamesWithNullValue(Object source) {
        final BeanWrapper sourceBeanWrapper = new BeanWrapperImpl(source);
        final java.beans.PropertyDescriptor[] propertyDescriptors = sourceBeanWrapper.getPropertyDescriptors();
        final Set<String> emptyNames = new HashSet<String>();

        for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
            // Check if value of this property is null then add it to the collection
            Object propertyValue = sourceBeanWrapper.getPropertyValue(propertyDescriptor.getName());
            if (propertyValue != null)
                continue;

            emptyNames.add(propertyDescriptor.getName());
        }

        return emptyNames;
    }
}