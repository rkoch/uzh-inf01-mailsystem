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

import io.rko.uzh.mailsys.base.Category;
import io.rko.uzh.mailsys.base.IMessageSource;
import io.rko.uzh.mailsys.base.IProcessor;
import io.rko.uzh.mailsys.model.Mail;


public class CategoryProcTest {

    private IProcessor mCatProc;


    @Before
    public void setUp()
            throws Exception {
        mCatProc = new CategoryProc();
    }


    @Test
    public void testMisc1() {
        IMessageSource src = new Mail("test@company.com", "[Stuff] Other Stuff", "none");
        mCatProc.process(src);

        Assert.assertEquals(Category.MISC, src.getCategory());
    }

    @Test
    public void testMisc2() {
        IMessageSource src = new Mail("test@company.com", "Stuff", "none");
        mCatProc.process(src);

        Assert.assertEquals(Category.MISC, src.getCategory());
    }

    @Test
    public void testMisc3() {
        IMessageSource src = new Mail("test@company.com", "Stuff [Other Stuff] and more stuff", "none");
        mCatProc.process(src);

        Assert.assertEquals(Category.MISC, src.getCategory());
    }

    @Test
    public void testBusiness1() {
        IMessageSource src = new Mail("test@company.com", "Stuff [Business] and more stuff", "none");
        mCatProc.process(src);

        Assert.assertEquals(Category.BUSINESS, src.getCategory());
    }

    @Test
    public void testBusiness2() {
        IMessageSource src = new Mail("test@company.com", "Stuff [bUsiNEss] and more stuff", "none");
        mCatProc.process(src);

        Assert.assertEquals(Category.BUSINESS, src.getCategory());
    }

    @Test
    public void testBusiness3() {
        IMessageSource src = new Mail("test@company.com", "[bUsiNEss] and stuff", "none");
        mCatProc.process(src);

        Assert.assertEquals(Category.BUSINESS, src.getCategory());
    }

}
