/**
 Mule Selenium Module

 Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com

 The software in this package is published under the terms of the CPAL v1.0
 license, a copy of which has been included with this distribution in the
 LICENSE.txt file.
 */
package org.mule.modules.selenium;

import org.mule.api.MuleEvent;
import org.mule.api.processor.MessageProcessor;
import org.mule.tck.junit4.FunctionalTestCase;

import org.junit.Test;

public class SeleniumModuleTest extends FunctionalTestCase {

	protected MessageProcessor flow;
	protected MuleEvent response;
	
    @Override
    protected String getConfigResources() {
        return "mule-config.xml";
    }

    @Test
    public void testQueryGoogle() throws Exception
    {
        runFlowAndExpect("testQueryGoogle", true);
    }

    /**
     * Run the flow specified by name and assert equality on the expected output
     *
     * @param flowName The name of the flow to run
     * @param expect The expected output
     */
     protected <T> void runFlowAndExpect(String flowName, T expect) throws Exception
     {
        flow = (MessageProcessor) muleContext.getRegistry().lookupFlowConstruct(flowName);
         MuleEvent responseEvent = flow.process(getTestEvent(null));
         assert(expect.equals(responseEvent.getMessage().getPayload()));
     }

     /**
     * Run the flow specified by name using the specified payload and assert
     * equality on the expected output
     *
     * @param flowName The name of the flow to run
     * @param expect The expected output
     * @param payload The payload of the input event
     */
     protected <T, U> void runFlowWithPayloadAndExpect(String flowName, T expect, U payload) throws Exception
     {
         flow = (MessageProcessor) muleContext.getRegistry().lookupFlowConstruct(flowName);
         MuleEvent responseEvent = flow.process(getTestEvent(payload));

         assert(expect.equals(responseEvent.getMessage().getPayload()));
     }


     
}