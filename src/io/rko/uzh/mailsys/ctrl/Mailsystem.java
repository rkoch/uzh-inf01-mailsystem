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
package io.rko.uzh.mailsys.ctrl;

import java.util.ArrayList;
import java.util.List;

import io.rko.uzh.mailsys.base.Category;
import io.rko.uzh.mailsys.base.IFilter;
import io.rko.uzh.mailsys.base.IMessageReceiver;
import io.rko.uzh.mailsys.base.IMessageSource;
import io.rko.uzh.mailsys.base.IProcessor;
import io.rko.uzh.mailsys.filter.OriginFilter;
import io.rko.uzh.mailsys.filter.WordFilter;
import io.rko.uzh.mailsys.proc.CategoryProc;
import io.rko.uzh.mailsys.proc.HtmlProc;


public class Mailsystem {

    private final List<IFilter>    mFilterChain;
    private final List<IProcessor> mProcessorChain;

    private final MessagePool      mMessagePool;


    /**
     * Filters and processors are attached programmatically here. Usually this would be done by external config files
     */
    public Mailsystem() {
        // Filters
        mFilterChain = new ArrayList<IFilter>();
        mFilterChain.add(new OriginFilter("somecompany.com", "rko.io"));
        mFilterChain.add(new WordFilter("Spam", "Nerd"));

        // Processors
        mProcessorChain = new ArrayList<IProcessor>();
        mProcessorChain.add(new CategoryProc());
        mProcessorChain.add(new HtmlProc());

        // Message Pool
        mMessagePool = new MessagePool();
    }


    public void receive(IMessageSource pMessage) {
        // Filter message
        for (IFilter filter : mFilterChain) {
            if (!filter.validate(pMessage)) {
                System.out.println(String.format("Message did not validate this filter (%s). Message dropped.", filter.getClass().getSimpleName()));
                return;
            }
        }

        // Process message
        for (IProcessor proc : mProcessorChain) {
            proc.process(pMessage);
        }

        // Distribute message via message pool
        mMessagePool.distribute(pMessage);
    }

    // Delegate methods
    public void subscribe(Category pCat, IMessageReceiver pRec) {
        mMessagePool.subscribe(pCat, pRec);
    }

}
