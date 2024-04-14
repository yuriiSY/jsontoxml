# About

This  application is designed to parse a list of JSON files related to a Book entity and generate statistics based on one of its attributes.

# Setup 

To run this application you need. Navigate to project directory using Terminal

Run this command to build jar file
```
mvn clean package
```

Navigate to target directory.

Run this command to run jar file
### Example
```
java -jar custom-name.jar src/main/resources/files author
```

Where `src/main/resources/files` path to the directory with JSON files

Where `author` attribute name for statistics calculation

### Expected format for JSON files
```json
[
  {
    "title": "1984",
    "author": "George Orwell",
    "year_published": 1949,
    "genre": "Dystopian"
  },
  {
    "title": "Pride and Prejudice",
    "author": "Jane Austen",
    "year_published": 1813,
    "genre": "Romance"
  },
  {
    "title": "Romeo and Juliet",
    "author": "William Shakespeare",
    "year_published": 1597,
    "genre": "Romance"
  }
]

```

### XML statistic result

```xml
<statistics>
  <item>
    <value>George Orwell</value>
    <count>1</count>
  </item>
  <item>
    <value>Jane Austen</value>
    <count>1</count>
  </item>
  <item>
     <value>William Shakespeare</value>
     <count>1</count>
  </item>
  ...
</statistics>
```