### EasyPush - EasyMessage
# EasyPush makes push notifications easier than ever.

This project is an Android library that manages push notifications with boilerplate syntax that making a use of it easy and clear.
 

## Features:
With this library, all you need to do in order to send push notifications is build an "EasyMessage" object and customize it to your needs.

**Push a notification to "topic" channel and/or targeted notification via the user's token.**


## How to use:
**send a push notification to a topic - **
EasyMessage easyMessage = new EasyMessage();
            easyMessage.setServerKey(BuildConfig.SERVER_AUTH_KEY, this) // Set server key and context
.setIsTopics(true) //Adds "/topic/" to the request
.setIsObjectData(true) //Adds "notification" or "data" as the notification meta data.
.setSendTo(TOPIC_CHANNEL) //Set the target name or token.
.putData("key", "value") //appending data can be used as much as needed.
                    .putData("another_key", "another value")
.sendFirebaseMessage(result -> Log.d(TAG, "onCreate:")); //apply the request, build the object, and send the notification.


## Technologies and libraries

**Volley**
Volley is an HTTP library that makes networking calls for Android apps.
link to the library page
https://google.github.io/volley/

**Java's 8 consumer/supplier patterns**
This library sends the response back to the developer through Java's 8 consumer and supplier patterns in order to boilerplate code and save callback logic.


### Author
Magen Levi

magen.levi5@gmail.com

Israel.


