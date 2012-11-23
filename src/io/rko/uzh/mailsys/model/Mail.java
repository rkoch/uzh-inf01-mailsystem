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
package io.rko.uzh.mailsys.model;

import io.rko.uzh.mailsys.base.Category;
import io.rko.uzh.mailsys.base.IMessageSource;


public class Mail
        implements IMessageSource {

    private String   mSender;
    private String   mSubject;
    private Category mCategory;
    private String   mContent;


    public Mail() {
    }

    public Mail(String pSender, String pSubject, String pContent) {
        mSender = pSender;
        mSubject = pSubject;
        mContent = pContent;
    }

    /**
     * Copy constructor
     */
    public Mail(IMessageSource pOrig) {
        mSender = pOrig.getSender();
        mSubject = pOrig.getSubject();
        mCategory = pOrig.getCategory();
        mContent = pOrig.getContent();
    }


    // Implementation of IMessageSource
    @Override
    public String getSender() {
        return mSender;
    }

    @Override
    public void setSender(String pSender) {
        mSender = pSender;
    }

    @Override
    public String getSubject() {
        return mSubject;
    }

    @Override
    public void setSubject(String pSubject) {
        mSubject = pSubject;
    }

    @Override
    public Category getCategory() {
        return mCategory;
    }

    @Override
    public void setCategory(Category pCategory) {
        mCategory = pCategory;
    }

    @Override
    public String getContent() {
        return mContent;
    }

    @Override
    public void setContent(String pContent) {
        mContent = pContent;
    }

}
