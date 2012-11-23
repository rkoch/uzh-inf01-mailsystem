/*
 * The MIT License (MIT)
 * Copyright © 2012 Remo Koch, http://rko.mit-license.org/
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
 * associated documentation files (the “Software”), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute,
 * sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial
 * portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED “AS IS”, WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT
 * NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
 * IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
 * WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE
 * SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package io.rko.uzh.mailsys.proc;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import io.rko.uzh.mailsys.base.IMessageSource;
import io.rko.uzh.mailsys.base.IProcessor;
import io.rko.uzh.mailsys.model.Mail;


public class HtmlProcTest {

    private IProcessor mHtmlProc;


    @Before
    public void setUp()
            throws Exception {
        mHtmlProc = new HtmlProc();
    }


    @Test
    public void testRemovedHTML1() {
        String content = "Test Mail <br>Hallo <span>zusammen</span>";
        IMessageSource src = new Mail("test@company.com", "[Stuff] Other Stuff", content);
        mHtmlProc.process(src);

        Assert.assertEquals("Test Mail Hallo zusammen", src.getContent());
    }

    @Test
    public void testRemovedHTML2() {
        String content = "Test Mail <br>Hallo <span>zusammen</span><br>Check this out.";
        IMessageSource src = new Mail("test@company.com", "[Stuff] Other Stuff", content);
        mHtmlProc.process(src);

        Assert.assertEquals("Test Mail Hallo zusammenCheck this out.", src.getContent());
    }

}
