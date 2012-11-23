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

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import io.rko.uzh.mailsys.base.Category;
import io.rko.uzh.mailsys.base.IMessageReceiver;
import io.rko.uzh.mailsys.base.IMessageSource;
import io.rko.uzh.mailsys.model.Mail;


public class MessagePool {

    private Map<Category, Set<IMessageReceiver>> mRegistrants;


    public MessagePool() {
        mRegistrants = new HashMap<Category, Set<IMessageReceiver>>();
    }


    public void distribute(IMessageSource pMessage) {
        Set<IMessageReceiver> recv = mRegistrants.get(pMessage.getCategory());
        if ((recv != null) && !recv.isEmpty()) {
            System.out.println(String.format("Distributing a message in category %s to %d receivers.", pMessage.getCategory(), recv.size()));

            for (IMessageReceiver mr : recv) {
                mr.receive(new Mail(pMessage)); // Only send a copy
            }

            System.out.println("Message successfully distributed.");
        } else {
            System.out.println(String.format("There are no subscribers to category %s, message is dropped.", pMessage.getCategory()));
        }

    }

    public void subscribe(Category pCat, IMessageReceiver pRec) {
        Set<IMessageReceiver> recv = mRegistrants.get(pCat);
        if (recv == null) {
            recv = new HashSet<IMessageReceiver>();
            mRegistrants.put(pCat, recv);
        }
        recv.add(pRec);

        System.out.println(String.format("Added %s as subscriber for message category %s", pRec.getName(), pCat.title()));
    }

}
