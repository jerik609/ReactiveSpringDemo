reactive applications work with events

a pipeline of events -> a flux

why didn't we use a list? list is bounded ... flux is unbounded, flux is a source of data, events are processed independently

someone has to create the events in a reactive application?

creator of events is a publisher

mono and flux are publishers
- mono - publisher of only one event (zero or one)
- flux - publisher of zero to multiple (unbounded/indefinite potentially)

why we have both? well, if we return one entity - we return a mono, if we return multiple items = flux

we have a publisher and always a subscriber.

subscriber registers to the publisher and consumes the events, it literally asks for events from publisher

the last thing in the puzzle is the subscription

publisher <---(subscription)--- subscriber

My note: it's a bit weird I'd say, simplified perhaps to rx java, but let's roll with it
