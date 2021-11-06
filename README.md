Game of life - TDD

AssignmentImplement the following program using TDD. Your final project should have passing  tests and
clean code. The requirements are well defined for this exercise but the code can be 
implemented in many ways. Put the code under version control using git and make frequent 
commits while you are working. Don’t be afraid of refactoring your code. 
The assignment will be handed in as a link to git repository but also shown and discussed 
during the last course meeting.

Problem Description
This Kata is about calculating the next generation of Conway’s game of life, 
given any starting position. See http://en.wikipedia.org/wiki/Conway
%27s_Game_of_Life for background.

You start with a two dimensional grid of cells, where each cell is either alive or 
dead. In this version of the problem, the grid is finite, and no life can exist off the 
edges. When calculating the next generation of the grid, follow these rules:
   1. Any live cell with fewer than two live neighbors dies, as if caused by 
underpopulation.
   2. Any live cell with more than three live neighbors dies, as if by 
overcrowding.
   3. Any live cell with two or three live neighbors lives on to the next 
generation.
   4. Any dead cell with exactly three live neighbors becomes a live cell.

You should write a program that can accept an arbitrary grid of cells, and will 
output a similar grid showing the next generation.
Try to work with immutable objects and pure functions as much as possible.



Clues
The input starting position could be a text file that looks like this:
Generation 1:
4 8
........
....*...
...**...
........
And the output could look like this:
Generation 2:
4 8
........
...**...
...**...
........


Front End
Make some sort of front end to visualize the grid. Console/JavaFX/Webpage/File
output but that is not the main part of the assignment.
Suggested Test Cases
Make sure you have enough coverage of edge cases, where there are births 
and deaths at the edge of the grid.
