# 🎨 Swing Color Picker
A simple Java Swing application that allows the user to choose a color and draw on a grid. This application has two windows: "Color Grid" and "Color Picker". Both windows come up when the application starts and stay open when it’s running. If either window is closed, the application terminates.

The color picker maintains the user's chosen color. The currently chosen color is displayed near the top, as text and as a sample of the actual color. Users can enter a value between 0 and 255 for red, green and blue (RGB) by clicking in the corresponding box and using the keyboard. When the user hits a "Confirm" button, it locks in the selected values as the new chosen color, which should update the color preview at the top.

If picking the new color was successful, the program displays a message that tells the user the RGB values of the previous color. If the user enters an invalid color value, such as -5, or some letters, it displays an error message instead. The user can also change the brush size to paint multiple squares.

![image](https://user-images.githubusercontent.com/88569965/213843695-93626f1f-a253-48fa-b628-1941fefcfcc6.png)

![image](https://user-images.githubusercontent.com/88569965/213843705-e483fc95-e4be-4d33-9579-cd6b9beabb41.png)

![image](https://user-images.githubusercontent.com/88569965/213843709-69f77fb1-f3dd-42eb-8ed4-1bfe236136fd.png)
