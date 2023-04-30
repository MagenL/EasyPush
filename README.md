### EasyPush - EasyMessage
# EasyPush makes push notifications easier than ever.

This project is an Android library that manages push notifications with boilerplate syntax that making a use of it easy and clear.
 

## Features:
With this library, all you need to do in order to send push notifications is build an "EasyMessage" object and customize it to your needs.

**Push a notification to "topic" channel and/or targeted notification via the user's token.**


## How to use:
**send a push notification to a topic -**<br><pre>
EasyMessage easyMessage = new EasyMessage();<br>
easyMessage.setServerKey(BuildConfig.SERVER_AUTH_KEY, this) // Set server key and context<br>
&emsp;&emsp;&emsp;&emsp;.setIsTopics(true) //Adds "/topic/" to the request<br>
&emsp;&emsp;&emsp;&emsp;.setIsObjectData(true) //Adds "notification" or "data" as the notification meta data.<br>
&emsp;&emsp;&emsp;&emsp;.setSendTo(TOPIC_CHANNEL) //Set the target name or token.<br>
&emsp;&emsp;&emsp;&emsp;.putData("key", "value") //appending data can be used as much as needed.<br>
&emsp;&emsp;&emsp;&emsp;.putData("another_key", "another value")<br>
&emsp;&emsp;&emsp;&emsp;.sendFirebaseMessage(result -> Log.d(TAG, "result :"+result)); //apply the request, build the object, and send the notification.<br>
</pre>

## Technologies and libraries

**Volley**<br>
Volley is an HTTP library that makes networking calls for Android apps.<br>
link to the library page<br>
https://google.github.io/volley/

**Java's 8 consumer/supplier patterns**<br>
This library sends the response back to the developer through Java's 8 consumer and supplier patterns in order to boilerplate code and save callback logic.


## How to implement -

click the following image to redirect to **jitpack.io :** <br>[![](https://jitpack.io/v/magenl/easypush/month.svg)](https://jitpack.io/#MagenL/EasyPush/0.0.1)


### Author
Magen Levi

magen.levi5@gmail.com

Israel.


