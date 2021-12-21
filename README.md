# switchmatrix

1.	Recursion – “Switch Matrix”
The “Switch Matrix” is a 6x6 matrix of two-state switches. A switch may be up or down. The state of the switches can be changed by “pressing” a switch. Such a “press” inverts the state of the given switch but also the state of all the adjacent switches as well in the following way (“pressed” switch highlighted):
“Before” state:					“After” state:
110101						000101
010111						110111
110101						110101
000011						000011
100011						100011
100000						100000

“Before” state:					“After” state:
110101						110101
010111						011111
110101						101001
000011						001011
100011						100011
100000						100000

Your task is to write a Console application which does the following:
1.	Logs the initial state of the matrix to the console (initial state can be determined in code)
2.	Logs the actual local time to the console
3.	Starts to find a series of “steps” (where a “step” = a “switch press”) which moves all of the switches to the “down” state in the matrix
4.	In every 10 seconds reports the number of different solutions checked so far till the solution found
5.	When the solution found it reports the series of steps needed to reach the desired state of the matrix
