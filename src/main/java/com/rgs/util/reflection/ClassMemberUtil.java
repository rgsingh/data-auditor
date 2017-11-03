package com.rgs.util.reflection;

import java.lang.reflect.Field;
import java.util.Collection;

public class ClassMemberUtil
{
    public static void main( String[] args ) throws ClassNotFoundException, IllegalAccessException {

        CustomerVO originalCustomer = new CustomerVO();

        SomeOtherCustomerRelatedVO originalBasicDetails = new SomeOtherCustomerRelatedVO();
        originalBasicDetails.setAddressLine1("BEFORE ADDRESS LINE1");
        originalCustomer.setSomeVO(originalBasicDetails);

        CustomerVO alteredCustomer = new CustomerVO();
        SomeOtherCustomerRelatedVO alteredBasicDetails = new SomeOtherCustomerRelatedVO();
        alteredBasicDetails.setAddressLine1("AFTER ADDRESS LINE1");
        alteredCustomer.setSomeVO(alteredBasicDetails);

        Class original = originalCustomer.getClass();
        Class altered = alteredCustomer.getClass();
        getMembers(original, originalCustomer, alteredCustomer);

    }

    public static void getMembers(Class c, Object originalInstance, Object alteredInstance) throws ClassNotFoundException, IllegalAccessException {
        Field[] fields = c.getDeclaredFields();

        for (Field f : fields)
        {
            if (f.getType().isPrimitive() || f.getType().equals(String.class))
            {
                if (isValidClass(c, f)) {
                    System.out.println(c.getSimpleName() + ": " + f.getName() + " is a " + f.getType().getSimpleName());
                    if (originalInstance != null) {
                        outputFieldValue(c, f, originalInstance, alteredInstance);
                    }
                }
            } else {
                if (Collection.class.isAssignableFrom(f.getType())) {
                    String s = f.toGenericString();
                    String type = s.split("\\<")[1].split("\\>")[0];
                    Class clazz = Class.forName(type);
                    System.out.println(c.getSimpleName()+ ": "+ f.getName()+ " is a collection of "+ clazz.getSimpleName());
                    f.setAccessible(true);
                    if (originalInstance != null) {
                        getMembers(clazz, f.get(originalInstance), f.get(alteredInstance));
                    }
                } else {
                    if (isValidClass(c, f)){
                        System.out.println(c.getSimpleName() + ": " + f.getName() + " is a "+ f.getType().getSimpleName());
                        f.setAccessible(true);
                        if (originalInstance != null) {
                            getMembers(f.getType(), f.get(originalInstance), f.get(alteredInstance));
                        }
                    }
                }
            }
        }
    }

    private static void outputFieldValue(Class c, Field f, Object originalInstance, Object alteredInstance) {
           try {
                if (f != null) {
                    f.setAccessible(true);
                    Object originalValue = f.get(originalInstance);
                    Object alteredValue = f.get(alteredInstance);
                    System.out.println(c.getSimpleName() + ": " + f.getName() + " original value is  " + originalValue);
                    System.out.println(c.getSimpleName() + ": " + f.getName() + " altered value is  " + alteredValue);
                }
           } catch (IllegalAccessException e) {
                e.printStackTrace();
           }

    }

    private static Boolean isValidClass(Class c, Field f) {

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
