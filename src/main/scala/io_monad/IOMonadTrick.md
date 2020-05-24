# The IO monad’s trick

The trick of the IO monad is that it lets you write I/O functions as effects.

Philosophically, what happens is that you use IO to describe how an I/O function works.

Then, instead of dealing with the result of the I/O function at the time
when the I/O function appears to be called,

you defer the actual action until some time later when you really want it to be triggered.