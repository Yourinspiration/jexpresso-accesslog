# JExpresso middleware for printing access log messages

## Maven

Latest stable release:

```xml
<dependency>
  <groupId>de.yourinspiration</groupId>
  <artifactId>jexpresso-accesslog</artifactId>
  <version>1.0.0</version>
</dependency>
```

## Usage

```java
final JExpresso app = new JExpresso();
// Format: 12.10.14 2:33:21: GET /path 166.156.23.21 200
// Prints the messages to standard out
app.use(new AccessLog(AccessLogFormat.SMALL, System.out));
```
