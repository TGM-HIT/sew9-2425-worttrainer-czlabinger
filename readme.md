# Worttrainer

## Dependencies

* Jdk21
* gradle

## Installation
```bash
# Clone Project
git clone https://github.com/TGM-HIT/sew9-2425-worttrainer-czlabinger.git
cd sew9-2425-worttrainer-czlabinger

# Build jar
mvn clean package -DskipTests

# Run jar
java -jar target/worttrainer-1.0-SNAPSHOT.jar
```

## Usage

After starting the jar a window will appear with the picture of a dog or a cat. 
In the given text field either type 'Cat' or 'Dog' depending on what the picture shows. 
In the bottom left are stats for how many inputs you did and how many were correct. 
If you want to add a new word in the text field type: 'wordYouWantToAdd, directLinkToImage' and press 'Add Word'.