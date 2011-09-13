Readable Collections
====================

Core Proposal
-------------

Java Collections are great implementations of the core, mutable data structures programmers need in their projects.
To augment this usefulness, we propose adding the notion of "Readable" collections, which would be **statically typed**
read-only "views" of underlying Collections which may or may not be mutable.

Currently, the proposal suggests the addition of six classes:

  * ReadableIterable
  * ReadableIterator
  * ReadableCollection
  * ReadableList
  * ReadableSet
  * ReadableMap

These classes would be super interfaces of the following existing Java Collections interfaces:

  * Iterable
  * Iterator
  * Collection
  * List
  * Set
  * Map

The Readable versions of the Collections contain **no mutators**.  Additionally, certain methods such as
`Collection#iterator()` will return the Readable version of their mutable sub-interfaces, to be covariantly overridden
by the sub-interface.  (This allows for no changes to the existing Collections interfaces, making the change less
traumatic.)

Current Alternatives
--------------------

The current alternatives to the above functionality are:

# Simply return the mutable version of a collection.  Unfortunately this can lead to programming errors, overly defensive
  programming and long drill-downs into functions to determine if a returned collection can be safely mutated.

# Return a version of a collection wrapped via the `Collections#unmodifiable*` methods.  This suffers from the same
  problems as the first approach, except that programming errors due to mutation can no longer occur.  Unfortunately, if
  the owner of the collection wishes to mutate the collection later, they must either maintain two pointers to the
  collection (one to the readable version and one to the unreadable version) or wrap the collection every time it is
  passed out.

# Use java generics to make mutators uncallable.  If you declare a return type of a list to be, say `List<? extends String>`
  then many of the mutators on the list (e.g. `add()`) will not be callable due to generics constraints.  However, many
  mutators are still available, such as `clear()`, so this is an unsatisfying solution.

# Write your own immutable classes or wrappers.  This is a possibility, but one of the great features of the Java Collections
  is that they give everyone in the Java ecosystem a common set of interfaces to work with.  Libraries should communicate
  to their clients whether collections passing in and out of them are mutated or mutable, and a standardized way to do this
  is precisely the point of this proposal.

None of these solutions are satisfying.

Why Readable?
-------------

Why are the proposed interfaces called 'Readable' vs. the more obvious 'Immutable' prefix?  Simply because the idea is
to have the core collection interfaces (e.g. `java.util.List`) extend these interfaces, and most of the implementations
of these collections (e.g. `java.util.ArrayList`) are not, in fact immutable.

These interfaces provide a *read only view* of a collection, and are agnostic as to their actual implementation.

Source
------

A proposed version of the Readable interfaces exist in this project.  Note that some methods that should be mutation safe have been
omitted on the Readable interfaces in the name of simplicity, and to avoid problems with java generics.