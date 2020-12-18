# Refactoring
### File Management
Separate the src codes with external resources like image and audios. Also separate the codes according to their usage.
- Why: The files are all mixed, hard to manage and locate as the project grows big.
- Where: all of them.
---
### Value Correction
Modify some hard coded value to more reasonable value to resize.
- Why: Many size and the coordination of image is wrongly placed.
- Where:
    - Animal.java
    - Log.java
    - GameStage.java
---
### Photoshop
Edit the provided also produced some extra image for the game.
- Why: 
    - The color of the image is not matching the background.
    - New image need to be produced for new scenario.
- Where: "src/res/pics/"
---
### Frog movement control
Make a lock for signal of the key release.
- Why:
    - The frog movement is not consistent.
- Where:
    - Animal.java
---
### Intersecting between Actors
Changed getIntersectingObjects() function to more efficient. This will increase the performance and responsiveness of the frog.
- Why:
    The program run slows.
- Where:
    - Animal.java
    - Actor.java
---
### Frog movement on moving carrier
Original code have to hard code the speed of the movement of frog when the frog lands on them. I let the frog read the speed of actor and follow it directly.
- Why:
    - Hard coded.
- Where:
    - Created MovingCarrier.java
    - Log.java
    - WetTurtles.java
    - Turtles.java
---
### Change act() in Animal.
Added if else statement, to skip unnecessary condition check.
- Why:
    - The animation of dying is laggy.
- Where:
    - Animal.java
---
### Create variable
- Why:
    - Needed to follow up each actor to change their speed.
- Where:
    - GameStage.java
---
### Game Edge Hitting
Make the frog movement slower and more consistent when hitting the edge of game.
- Why:
    - When the frog is hitting edge, the animation is laggy.
- Where:
    - Animal.java

---
### Scoring Numbers
Create variable for digits and change the digit image as the value change.
- Why:
    - The Digit images are keep adding to the scene if there is any value changed.
    - Will become laggy over time.
- Where:
    - GameStage.java
    - Digits.java




# Additions

### Start Screen and Info
Added MainMenu.java.
- Why:
    - As the project requested.
    - A natural approach of a game program.
- Where:
    - src/main/MainMenu/
### LeaderBoard + MVC pattern
Added LeaderBoard.java.
- Why:
    - As the project requested.
    - Show the top player performance.
- Where:
    - src/main/LeaderBoard/

### Popup Screen
Added HighScoreBoard.java
- Why:
    - As the project requested.
    - Let the player know the result.
- Where:
    - GameStage.java
    - HighScoreBoard.java

### Levels Increase
Set a speed control to increase the speed of actors.
- Why:
    - As the project requested.
    - Make the game more challenging.
- Where:
    - Obstacle.java
    - Log.java
    - WetTurtles.java
    - Turtles.java

### Sound effect
- Why:
    - Give the player some feedbacks in audio.
- Where: src/res/audios

### Pause Screen
Added an icon for pausing the game.
- Why:
    - More convenient for the player to pause the progress and leave.
- Where:
    - GameStage.java

### Life Counts
Life counts is calculate and shown in the left bottom corner of the game.
- Why:
    - To limit of deaths by the player.
    - Make the game more challenging.
- Where:
    - Animal.java
    - GameStage.java



