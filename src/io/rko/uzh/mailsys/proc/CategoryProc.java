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

import io.rko.uzh.mailsys.base.Category;
import io.rko.uzh.mailsys.base.IMessageSource;
import io.rko.uzh.mailsys.base.IProcessor;


public class CategoryProc
        implements IProcessor {

    @Override
    public void process(IMessageSource pMessage) {
        String subject = pMessage.getSubject();

        // Extract category from subject
        String sCat = null;
        if ((subject != null) && !subject.isEmpty()) {
            String[] split = subject.split("[\\[\\]]", 3);
            if (split.length == 3) {
                sCat = split[1];
            }
        }

        // Determine category from extracted string
        Category cat = Category.MISC;
        if ((sCat != null) && !sCat.isEmpty()) {
            Category c = Category.getByTitleIgnoreCase(sCat);
            if (c != null) {
                cat = c;
            }
        }

        pMessage.setCategory(cat);
    }

}
