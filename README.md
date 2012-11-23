mailsystem
==========

University of Zurich, Informatics I, Programming Exercise 10 (Example Implementation)

Execute
-------
Die Main-Klasse ist hier: [io.rko.uzh.mailsys.facade.cli.MailsystemMain](https://github.com/rkoch/mailsystem/blob/master/src/io/rko/uzh/mailsys/facade/cli/MailsystemMain.java) 

Installation/Download
---------------------
Das Projekt ist bereits ein Eclipse Projekt welches nur über die Eclipse-Import Funktion importiert werden muss.

Wer Git nicht installiert hat, kann im obenstehenden Tab Tags das ganze Projekt als Zip downloaden (aktuell v0.1.0).

Console output
--------------
Hier noch der Konsolen-Output:
```
Mailsystem V0.1.0 [23.11.2012 14:12:26] started successfully.

Added Mailbox 1 as subscriber for message category IT
Added Mailbox 1 as subscriber for message category Sonstiges
Added Mailbox 2 as subscriber for message category Sonstiges
Added Mailbox 3 as subscriber for message category Business

Mail 1 ------------
Message did not validate this filter (OriginFilter). Message dropped.

Mail 2 ------------
Distributing a message in category MISC to 2 receivers.
Mailbox 1: Received a message from hello@rko.io with subject Whatever.
Message:
New message
Mailbox 2: Received a message from hello@rko.io with subject Whatever.
Message:
New message
Message successfully distributed.

Mail 3 ------------
Distributing a message in category MISC to 2 receivers.
Mailbox 1: Received a message from hello@somecompany.com with subject [STUFF] Good news.
Message:
This is some boring news stuff
Mailbox 2: Received a message from hello@somecompany.com with subject [STUFF] Good news.
Message:
This is some boring news stuff
Message successfully distributed.

Mail 4 ------------
Message did not validate this filter (WordFilter). Message dropped.

Mail 5 ------------
Distributing a message in category BUSINESS to 1 receivers.
Mailbox 3: Received a message from hello@somecompany.com with subject [business] this is a business mail.
Message:
We have html tags here!
Message successfully distributed.

Mail 6 ------------
Distributing a message in category MISC to 2 receivers.
Mailbox 1: Received a message from mi6@somecompany.com with subject [secret] eyes only!.
Message:
TROLL!
Mailbox 2: Received a message from mi6@somecompany.com with subject [secret] eyes only!.
Message:
TROLL!
Message successfully distributed.

Mail 7 ------------
There are no subscribers to category NEWS, message is dropped.

-------------------

All done, shutting down.
```