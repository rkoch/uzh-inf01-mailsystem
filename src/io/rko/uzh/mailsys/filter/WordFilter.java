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


public class WordFilter
        implements IFilter {

    private Set<String> mDisallowedWords;


    public WordFilter(String... pDisallowedWords) {
        mDisallowedWords = new HashSet<String>(Arrays.asList(pDisallowedWords));
    }


    @Override
    public boolean validate(IMessageSource pMessage) {
        String content = pMessage.getContent();

        if ((content == null) || content.isEmpty()) {
            return true; // No swear words contained
        }

        String lcContent = content.toLowerCase();
        for (String word : mDisallowedWords) {
            if (lcContent.contains(word.toLowerCase())) {
                return false; // return if one of those words is found
            }
        }
        return true; // if no disallowed word was found
    }

}
