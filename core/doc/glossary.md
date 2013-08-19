Glossary
========

* Content Provider
A content provider is a component which implements the content provider interface.
It can be used to retrieve data from a specific source, for example torrents.
An example provider would be put.io

* Storage Provider
A storage provider is a component which implements the storage interface.
It can be used to store retrieved data. The data will be encrypted and distributed
by the storage broker.

* Search Broker
A search broker will handle searches inside verflixt.
Every available search provider will register at the brokers and the broker
will decide how to rate the results.

* Limer
The default search broker implementation of verflixt.