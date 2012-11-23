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
package io.rko.uzh.mailsys.facade.cli;

import io.rko.uzh.mailsys.base.Category;
import io.rko.uzh.mailsys.base.IMessageSource;
import io.rko.uzh.mailsys.ctrl.Mailbox;
import io.rko.uzh.mailsys.ctrl.Mailsystem;
import io.rko.uzh.mailsys.model.Mail;
import io.rko.uzh.mailsys.version.PackageVersion;


public class MailsystemMain {

    public static void main(String[] pArgs) {
        System.out.println(String.format("%s started successfully.", PackageVersion.getPackageVersion()));

        Mailsystem msys = new Mailsystem();

        Mailbox mbox1 = new Mailbox("Mailbox 1");
        Mailbox mbox2 = new Mailbox("Mailbox 2");
        Mailbox mbox3 = new Mailbox("Mailbox 3");

        msys.subscribe(Category.IT, mbox1);
        msys.subscribe(Category.MISC, mbox1);
        msys.subscribe(Category.MISC, mbox2);
        msys.subscribe(Category.BUSINESS, mbox3);

        IMessageSource mail;

        // Mail that should not get through
        System.out.println("Mail 1 ------------");
        mail = new Mail("hello@test.ch", "Whatever", "Message shouldn't get through");
        msys.receive(mail);


        // Mail to MISC
        System.out.println("Mail 2 ------------");
        mail = new Mail("hello@rko.io", "Whatever", "New message");
        msys.receive(mail);

        // Mail to MISC
        System.out.println("Mail 3 ------------");
        mail = new Mail("hello@somecompany.com", "[STUFF] Good news", "This is some boring news stuff");
        msys.receive(mail);

        // Mail that should not get through -> spam
        System.out.println("Mail 4 ------------");
        mail = new Mail("hello@somecompany.com", "[IT] It's spam", "tHizz m3ss4ge is sPAm!!");
        msys.receive(mail);

        System.out.println("Mail 5 ------------");
        mail = new Mail("hello@somecompany.com", "[business] this is a business mail", "We have<br> html tags <b>here!</b>");
        msys.receive(mail);

        System.out.println("Mail 6 ------------");
        mail = new Mail("mi6@somecompany.com", "[secret] eyes only!", "TROLL!");
        msys.receive(mail);

        System.out.println("Mail 7 ------------");
        mail = new Mail("derp@somecompany.com", "[news] derpina cheated on you!", "hehehehe!");
        msys.receive(mail);

        System.out.println("-------------------");
        System.out.println();
        System.out.println("All done, shutting down.");
        System.exit(0);
    }

}
