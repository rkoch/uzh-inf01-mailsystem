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
package io.rko.uzh.mailsys.filter;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import io.rko.uzh.mailsys.base.IFilter;
import io.rko.uzh.mailsys.base.IMessageSource;


public class OriginFilter
        implements IFilter {

    private Set<String> mAllowedDomains;


    public OriginFilter(String... pAllowedDomains) {
        mAllowedDomains = new HashSet<String>(Arrays.asList(pAllowedDomains));
    }


    @Override
    public boolean validate(IMessageSource pMessage) {
        String sender = pMessage.getSender();
        if ((sender == null) || sender.isEmpty()) {
            return false; // Sender must not be empty
        }

        int domainIdx = sender.lastIndexOf("@");
        if (domainIdx < 0) {
            return false; // Sender must be a "valid" email address - only checks for an [at] here due to simplicity
        }

        String domain = sender.substring(domainIdx + 1);

        if (mAllowedDomains.contains(domain)) {
            return true; // Domain is in list
        }
        return false; // if domain was not found
    }

}
