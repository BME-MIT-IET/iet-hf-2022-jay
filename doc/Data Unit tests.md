# Unit testing data propagation classes

Author of the document:

- Balázs Püspök-Kiss

Responsible for the writing unit tests on data classes:

- Balázs Püspök-Kiss

Contributors: 

- Balázs Püspök-Kiss
- Ádám Tran
- Viktor Szabó

For each test, we used 
[MockK](https://github.com/mockk/mockk)
and 
[JUnit5](https://github.com/mannodermaus/android-junit5)
to enhance the testing tools available in
the core Android Studio. Also, we used some
[experimental coroutine testing tools](https://developer.android.com/kotlin/coroutines/test)
, which allowed us to efficiently
test data propagation through flows.

Each test is using dependency injections
with mocks.

Using MockK instead of Mockito was a great time
saver, as well as a better tool for the job, as
it was more suitable for the Kotlin programming
language.

Instead of the basic JUnit4 of Android Studio,
we decided to use a JUnit5 library, which enabled
the test to be written like JUnit5 it was JUnit5.
It is not officially supported yet, but it is
what it is.

## Disk data classes

Contributors:

- Balázs Püspök-Kiss

Disk data classes fill a crucial purpose by
connecting the intermediate Interactor classes
and the real data source implementation.
Data classes act as an interface over
these implementation classes.

All data sources should convert the data from
the implementation data format to a unified
domain data format.

Tests cover getting domain converted data via
flows and saving it.

### Flows

Using the
[coroutine testing api](https://developer.android.com/kotlin/coroutines/test),
I could test flows with ease. Jay is using flows
to propagate data. Room is able to provide
flows to the disk data source, so it can be
passed up to the view to collect the data.

Each test is using an immutable list of elements
to simulate the real database tables.

### Saving, updating data

All data classes currently use the proper Daos
to access rows from the database.

## Session disk data class

Contributors:

- Balázs Püspök-Kiss

Testing Sessions is a crucial thing to
provide the data integrity while the app and
its services are running.

### Stopping-starting sessions

It is crucial not to override values
for the already set values in sessions.
Breaking it can cause unintended consequences,
that is why testing it is so important.
Starting a session creates a session with a
particular starting date and returns an id,
that is no problem. But when stopping the
session, the end date is overridden only
if the end date was null.
It will not be changed if it is not null.

## Data Interactor classes

Contributors:

- Balázs Püspök-Kiss
- Ádám Tran
- Viktor Szabó

These classes provide an interface to view 
classes, mainly presenters for each view.
They can use different data sources, companion
objects (static methods, values, etc.) and their
dependencies are injected, like data source
classes'.

### Getting data via Flows

For typical data providing classes, like
LocationInteractor, data propagation upwards is
the same as in the data sources. It uses a 
predefined immutable list as the data as well
as in the data source classes.

### Saving data

Works just as in data source classes, returns
the same values as data source classes
when saving methods are present.
The classes only provide an interface for the
needed features.

## Session interaction

Contributors:

- Balázs Püspök-Kiss
- Ádám Tran
- Viktor Szabó

Sensor data are provided for sessions.
Sessions has a start and end date.
Proper handling of the sessions are crucial for
data integrity throughout the app's lifecycle.
The tested SessionInteractor class is heavily
depending on the SessionDiskDataSource class.

### Saving session data

Like in data source classes, we have an
immutable list of data to test on.
The SessionInteractor class actually provides
some additional functionality through
methods like ```stopOngoingSessions()```.

Although still, SessionDiskDataSource provides
most of the logic for saving sessions.

## Presenters

Contributors:

- Balázs Püspök-Kiss

For each view, a presenter provides the data.
Presenters are providing custom data to
the view and is an interface for the
ViewModel to access.

### Providing custom data

The data still propagates up as a flow and is
converted into Ui models, so only the data
needed is used. Like with data source
classes, we test the data conversion
to this Ui model data classes from
the domain data classes and we are using
immutable lists to monitor it.

### Custom functionality

Some presenters need custom functionality
which depend on other elements. In some
cases, I decided that a simple mock will 
suffice.
