package com.rgs.util.reflection;

import org.junit.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class TestReflectionUtils {

    private CustomerVO originalCustomer;
    private CustomerVO alteredCustomer;
    private ReflectionUtils reflectionUtils;


    @BeforeTest
    public void init() {
        originalCustomer = new CustomerVO();
        alteredCustomer = new CustomerVO();
        reflectionUtils = new ReflectionUtils();
    }

    @Test
    public void testWhenPropertiesDiffer() throws ClassNotFoundException, IllegalAccessException{

        SomeOtherCustomerRelatedVO originalBasicDetails = new SomeOtherCustomerRelatedVO();
        originalBasicDetails.setAddressLine1("BEFORE ADDRESS LINE1");
        originalCustomer.setSomeVO(originalBasicDetails);

        ContactDetailsServiceVO originalContactDetailsServiceVO = new ContactDetailsServiceVO();
        ContactDetailsService originalContactDetailsService = new ContactDetailsService();
        originalContactDetailsService.setContactName("JOE SHMOE");
        originalContactDetailsService.setAttention("JANE DOE");
        originalContactDetailsServiceVO.getContactDetailsServiceList().add(originalContactDetailsService);

        originalCustomer.setContactDetailsServiceVO(originalContactDetailsServiceVO);

        ContactDetailsServiceVO alteredContactDetailsServiceVO = new ContactDetailsServiceVO();
        ContactDetailsService alteredContactDetailsService = new ContactDetailsService();
        alteredContactDetailsService.setContactName("JOE SHMOE");
        alteredContactDetailsService.setAttention("JANE DOE");
        alteredContactDetailsServiceVO.getContactDetailsServiceList().add(alteredContactDetailsService);

        alteredCustomer.setContactDetailsServiceVO(alteredContactDetailsServiceVO);

        SomeOtherCustomerRelatedVO alteredBasicDetails = new SomeOtherCustomerRelatedVO();
        alteredBasicDetails.setAddressLine1("AFTER ADDRESS LINE1");
        alteredCustomer.setSomeVO(alteredBasicDetails);

        Class original = originalCustomer.getClass();
        List<ReflectionUtils.FieldState> results = new ArrayList<>();
        reflectionUtils.storeDifferences(original, originalCustomer, alteredCustomer, results);

        Assert.assertTrue(results.size() > 0);

    }





}
