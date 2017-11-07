package com.rgs.util.reflection;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.List;

public class ReflectionUtils {

    public ReflectionUtils() {
    }

    protected class FieldState {
        private String className;
        private String fieldName;
        private Object beforeValue;
        private Object afterValue;

        public FieldState() {

        }

        public FieldState(String className, String fieldName, Object beforeValue, Object afterValue) {
            this.className = className;
            this.fieldName = fieldName;
            this.beforeValue = beforeValue;
            this.afterValue = afterValue;
        }

        public String getClassName() {
            return className;
        }

        public void setClassName(String className) {
            this.className = className;
        }

        public String getFieldName() {
            return fieldName;
        }

        public void setFieldName(String fieldName) {
            this.fieldName = fieldName;
        }

        public Object getBeforeValue() {
            return beforeValue;
        }

        public void setBeforeValue(String beforeValue) {
            this.beforeValue = beforeValue;
        }

        public Object getAfterValue() {
            return afterValue;
        }

        public void setAfterValue(String afterValue) {
            this.afterValue = afterValue;
        }
    }

    public void storeDifferences(Class c, Object originalInstance, Object alteredInstance, List<FieldState> fieldWithState) throws ClassNotFoundException, IllegalAccessException {
        Field[] fields = c.getDeclaredFields();

        for (Field f : fields)
        {
            if (f.getType().isPrimitive() || f.getType().equals(String.class))
            {
                if (isValidClass(c, f)) {
                    System.out.println(c.getSimpleName() + ": " + f.getName() + " is a " + f.getType().getSimpleName());
                    if (originalInstance != null){
                    //if (originalInstance != null && (f.getType().getSimpleName() == originalInstance.getClass().getSimpleName()) ){
                        if (originalInstance instanceof Collection) {
                            ((Collection) originalInstance).forEach(o ->
                            outputFieldValue(c, f, o, ((Collection) alteredInstance).iterator().next(), fieldWithState));
                        } else {
                            outputFieldValue(c, f, originalInstance, alteredInstance, fieldWithState);
                        }
                    }
                }
            } else {
                if (Collection.class.isAssignableFrom(f.getType())) {
                    String s = f.toGenericString();
                    String type = s.split("\\<")[1].split("\\>")[0];
                    Class clazz = Class.forName(type);
                    System.out.println(c.getSimpleName()+ ": "+ f.getName()+ " is a collection of "+ clazz.getSimpleName());
                    f.setAccessible(true);
                    if (originalInstance != null){
                        storeDifferences(clazz, f.get(originalInstance), f.get(alteredInstance), fieldWithState);
                    }
                } else {
                    if (isValidClass(c, f)){
                        System.out.println(c.getSimpleName() + ": " + f.getName() + " is a "+ f.getType().getSimpleName());
                        f.setAccessible(true);
                        if (originalInstance != null){
                            if (originalInstance instanceof Collection) {
                                ((Collection)originalInstance).forEach(o -> {
                                    try {
                                        storeDifferences(f.getType(), f.get(o),
                                                f.get(((Collection) alteredInstance).iterator().next()), fieldWithState);
                                    } catch (ClassNotFoundException e) {
                                        e.printStackTrace();
                                    } catch (IllegalAccessException e) {
                                        e.printStackTrace();
                                    }
                                });
                            } else {
                                storeDifferences(f.getType(), f.get(originalInstance), f.get(alteredInstance), fieldWithState);
                            }
                        }
                    }
                }
            }
        }
    }

    private void outputFieldValue(Class c, Field f, Object originalInstance, Object alteredInstance, List<FieldState> fieldWithState) {
        try {
            if (f != null) {
                f.setAccessible(true);

                Object originalValue = f.get(originalInstance);
                Object alteredValue = f.get(alteredInstance);

                if ((originalValue != null || alteredValue != null) && !originalValue.equals(alteredValue)) {
                    FieldState fieldState = new FieldState(c.getSimpleName(), f.getName(), originalValue, alteredValue);
                    fieldWithState.add(fieldState);
                    System.out.println(fieldWithState);
                }

            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }

    private Boolean isValidClass(Class c, Field f) {

        if(!c.getSimpleName().equalsIgnoreCase("Integer")
                && !c.getSimpleName().equalsIgnoreCase("Long")
                && !c.getSimpleName().equalsIgnoreCase("Boolean")
                && !c.getSimpleName().equalsIgnoreCase("Double")
                && !c.getSimpleName().equalsIgnoreCase("Float")
                && !c.getSimpleName().equalsIgnoreCase("Character")
                && !c.getSimpleName().equalsIgnoreCase("Class")
                && !c.getSimpleName().equalsIgnoreCase("Constructor")){

            return true;
        }
        return false;
    }

}
